/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:TextFieldListenerD.java
 */
package designpattern.observer;

import designpattern.interpreter.InterpreterDesignPattern;
import spreadsheet.EquationViewGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListenerD implements ActionListener {
    private ActionListener listenerD = null;
    private EquationViewGUI equationView;

    public TextFieldListenerD(EquationViewGUI equationView) {
        this.equationView = equationView;
    }

    //This method gets called when state in subject(jTextField) changes
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField inputCell = (JTextField) e.getSource();
        String[] operands = inputCell.getText().split(" ");
        InterpreterDesignPattern interpreter = new InterpreterDesignPattern();

        if (listenerD == null) {
            listenerD = new ValueViewObserverD(equationView.getValView());
        }

        //following line fetches current expression from the jTextField where user made changes
        ((ValueViewObserverD) listenerD).setExpression(inputCell.getText());

        //This line unregisters listenerD from unwanted subjects
        equationView.getValView().removeObserver(listenerD);

        //This line dynamically registers listenerD object in jTextFields according to cell labels in operands
        equationView.getValView().registerObserver(listenerD, operands);

        //Following line evaluates an expression entered by user and displays that result in value view
        equationView.getValView().getjTextField4().setText(interpreter.interpretPostfixExpression(
                equationView.getInputString(operands)));

        //Following line will store a state of the Equation View GUI, after the user changes an expression.
        equationView.createMemento();
    }
}
