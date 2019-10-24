/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:ValueViewObserverI.java
 */
package designpattern.observer;

import designpattern.interpreter.InterpreterDesignPattern;
import spreadsheet.ValueViewGUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ValueViewObserverI implements ActionListener {
    private ValueViewGUI valueView;
    private String expression;

    public ValueViewObserverI(ValueViewGUI valueView) {
        this.valueView = valueView;
        valueView.getjTextField8().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        InterpreterDesignPattern interpreter = new InterpreterDesignPattern();
        JTextField inputCell = (JTextField)e.getSource();
        String[] variables;
        if(expression != null) {
            variables  = this.expression.split(" ");
        } else {
            variables = inputCell.getText().split(" ");
        }
        valueView.getjTextField8().setText(interpreter.interpretPostfixExpression(valueView.getInputString(variables)));
        valueView.createMemento();
    }

    public void setExpression(String expression) {
        this.expression = expression;
    }

}
