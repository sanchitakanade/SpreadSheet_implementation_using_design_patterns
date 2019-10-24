/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:TextFieldListenerA.java
 */
package designpattern.observer;

import designpattern.interpreter.InterpreterDesignPattern;
import spreadsheet.EquationViewGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TextFieldListenerA implements ActionListener {
    private EquationViewGUI equationView;
    private ActionListener listenerA = null;

    public TextFieldListenerA(EquationViewGUI equationView) {
        this.equationView = equationView;
    }

    //This method gets called when state in subject(jTextField) changes
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField inputCell = (JTextField) e.getSource();
        String[] operands = inputCell.getText().split(" ");
        InterpreterDesignPattern interpreter = new InterpreterDesignPattern();

        if (listenerA == null) {
            listenerA = new ValueViewObserverA(equationView.getValView());
        }

        //following line fetches current expression from the jTextField where user made changes
        ((ValueViewObserverA) listenerA).setExpression(inputCell.getText());

        //This line unregisters listenerA from unwanted subjects
        equationView.getValView().removeObserver(listenerA);

        //This line dynamically registers listenerA object in jTextFields according to cell labels in operands
        equationView.getValView().registerObserver(listenerA, operands);

        //Following line evaluates an expression entered by user and displays that result in value view
        equationView.getValView().getjTextField1().setText(interpreter.interpretPostfixExpression(
                equationView.getInputString(operands)));

        //Following line will store a state of the Equation View GUI, after the user changes an expression.
        equationView.createMemento();

    }
}
