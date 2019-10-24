/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:TextFieldListenerC.java
 */
package designpattern.observer;

import designpattern.interpreter.InterpreterDesignPattern;
import spreadsheet.EquationViewGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListenerC implements ActionListener {
    private EquationViewGUI equationView;
    private ActionListener listenerC = null;

    public TextFieldListenerC(EquationViewGUI equationView) {
        this.equationView = equationView;
    }

    //This method gets called when state in subject(jTextField) changes
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField inputCell = (JTextField) e.getSource();
        String[] operands = inputCell.getText().split(" ");
        InterpreterDesignPattern interpreter = new InterpreterDesignPattern();

        if (listenerC == null) {
            listenerC = new ValueViewObserverC(equationView.getValView());
        }
        //following line fetches current expression from the jTextField where user made changes
        ((ValueViewObserverC) listenerC).setExpression(inputCell.getText());

        //This line unregisters listenerC from unwanted subjects
        equationView.getValView().removeObserver(listenerC);

        //This line dynamically registers listenerC object in jTextFields according to cell labels in operands
        equationView.getValView().registerObserver(listenerC, operands);

        //Following line evaluates an expression entered by user and displays that result in value view
        equationView.getValView().getjTextField3().setText(interpreter.interpretPostfixExpression(
                equationView.getInputString(operands)));

        //Following line will store a state of the Equation View GUI, after a user changes an expression.
        equationView.createMemento();
    }
}
