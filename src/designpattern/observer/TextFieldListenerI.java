/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:TextFieldListenerI.java
 */
package designpattern.observer;

import designpattern.interpreter.InterpreterDesignPattern;
import spreadsheet.EquationViewGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListenerI implements ActionListener {
    private EquationViewGUI equationView;
    private ActionListener listenerI = null;

    public TextFieldListenerI(EquationViewGUI equationView) {
        this.equationView = equationView;
    }

    //This method gets called when state in subject(jTextField) changes
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField inputCell = (JTextField) e.getSource();
        String[] variables = inputCell.getText().split(" ");
        InterpreterDesignPattern interpreter = new InterpreterDesignPattern();

        if (listenerI == null) {
            listenerI = new ValueViewObserverI(equationView.getValView());
        }

        //following line fetches current expression from the jTextField where user made changes
        ((ValueViewObserverI) listenerI).setExpression(inputCell.getText());

        //This line unregisters listenerI from unwanted subjects
        equationView.getValView().removeObserver(listenerI);

        //This line dynamically registers listenerA object in jTextFields according to cell labels in operands
        equationView.getValView().registerObserver(listenerI, variables);

        //Following line evaluates an expression entered by user and displays that result in value view
        equationView.getValView().getjTextField8().setText(interpreter.interpretPostfixExpression(
                equationView.getInputString(variables)));

        //Following line will store a state of the Equation View GUI, after the user changes an expression.
        equationView.createMemento();
    }
}
