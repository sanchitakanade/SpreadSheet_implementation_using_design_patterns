/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:TextFieldListenerB.java
 */
package designpattern.observer;

import designpattern.interpreter.InterpreterDesignPattern;
import spreadsheet.EquationViewGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class TextFieldListenerB implements ActionListener {
    private EquationViewGUI equationView;
    private ActionListener listenerB = null;

    public TextFieldListenerB(EquationViewGUI equationView) { this.equationView = equationView; }

    //This method gets called when state in subject(jTextField) changes
    @Override
    public void actionPerformed(ActionEvent e) {
        JTextField inputCell = (JTextField)e.getSource();
        String[] operands = inputCell.getText().split(" ");
        InterpreterDesignPattern interpreter = new InterpreterDesignPattern();

        if(listenerB == null) {
            listenerB = new ValueViewObserverB(equationView.getValView());
        }
        //following line fetches current expression from the jTextField where user made changes
        ((ValueViewObserverB) listenerB).setExpression(inputCell.getText());

        //This line unregisters listenerB from unwanted subjects
        equationView.getValView().removeObserver(listenerB);

        //This line dynamically registers listenerB object in jTextFields according to cell labels in operands
        equationView.getValView().registerObserver(listenerB, operands);

        //Following line evaluates an expression entered by user and displays that result in value view
        equationView.getValView().getjTextField2().setText(interpreter.interpretPostfixExpression(
                equationView.getInputString(operands)));

        //Following line will store a state of the Equation View GUI, after each change made by user
        equationView.createMemento();
    }
}
