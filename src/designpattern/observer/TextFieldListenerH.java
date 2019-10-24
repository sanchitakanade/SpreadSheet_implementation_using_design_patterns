/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:TextFieldListenerH.java
 */
package designpattern.observer;

import designpattern.interpreter.InterpreterDesignPattern;
import spreadsheet.EquationViewGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextFieldListenerH implements ActionListener {
    private EquationViewGUI equationView;
    private ActionListener listenerH = null;

    public TextFieldListenerH(EquationViewGUI equationView) {
        this.equationView = equationView;
    }

    //This method gets called when state in subject(jTextField) changes
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField inputCell = (JTextField) e.getSource();
        String[] operands = inputCell.getText().split(" ");
        InterpreterDesignPattern interpreter = new InterpreterDesignPattern();

        if (listenerH == null) {
            listenerH = new ValueViewObserverH(equationView.getValView());
        }

        //following line fetches current expression from the jTextField where user made changes
        ((ValueViewObserverH) listenerH).setExpression(inputCell.getText());

        //This line unregisters listenerH from unwanted subjects or jTextFields in value view
        equationView.getValView().removeObserver(listenerH);

        //This line dynamically registers listenerH object in jTextFields of value view,
        // according to cell labels in operands
        equationView.getValView().registerObserver(listenerH, operands);

        //Following line evaluates an expression entered by user and displays that result in value view
        equationView.getValView().getjTextField9().setText(interpreter.interpretPostfixExpression(
                equationView.getInputString(operands)));

        //Following line will store a state of the Equation View GUI, after the user changes an expression.
        equationView.createMemento();

    }
}
