/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File: SpreadSheetTest.java
 */
package test;

import designpattern.interpreter.InterpreterDesignPattern;
import designpattern.interpreter.NumberExpression;
import designpattern.observer.TextFieldListenerA;
import org.junit.Before;
import org.junit.Test;
import spreadsheet.EquationViewGUI;
import spreadsheet.ValueViewGUI;

import static org.junit.Assert.assertEquals;

public class SpreadSheetTest {
    ValueViewGUI valueView;
    EquationViewGUI equationView;
    TextFieldListenerA observer;
    InterpreterDesignPattern interpreterDesignPattern;
    @Before
    public void setUP() {
        valueView = new ValueViewGUI();
        equationView = new EquationViewGUI(valueView);
        observer = new TextFieldListenerA(equationView);
        interpreterDesignPattern = new InterpreterDesignPattern();

    }

    @Test
    public void testMemento() {
        equationView.getjTextField1().setText("$A $B +");
        equationView.createMemento();
        equationView.getjTextField1().setText("$C $D +");
        equationView.createMemento();
        equationView.getjTextField1().setText("1 2 +");
        equationView.restoreState();
        assertEquals("$C $D +", equationView.getjTextField1().getText());

        valueView.getjTextField2().setText("20");
        valueView.createMemento();
        valueView.getjTextField2().setText("40");
        valueView.restoreState();
        assertEquals("20", valueView.getjTextField2().getText());
    }

    @Test
    public void testNumberExpression() {
        Exception ex = null;
        try {
            NumberExpression expression = new NumberExpression("");
        } catch (Exception e) {
            ex = e;
        }
        assertEquals("Empty string is not a valid input." +
                "\nPlease enter either a postfix expression or an integer value.",ex.getMessage());
    }

    @Test
    public void testObserverA() {
        equationView.getjTextField1().addActionListener(observer);
        equationView.getjTextField1().setText("10");
        observer.actionPerformed(new java.awt.event.ActionEvent(equationView.getjTextField1(), java.awt.event.ActionEvent.ACTION_PERFORMED, "10"));
        assertEquals("10",equationView.getValView().getjTextField1().getText());
    }

@Test
    public void testInterpretPostfixExpression() {
        String result;
        valueView.getjTextField1().setText("10");
        valueView.getjTextField2().setText("20");
        String expression = "$A $B +";
        String[] operands = expression.split(" ");

        result = interpreterDesignPattern.interpretPostfixExpression(valueView.getInputString(operands));
        assertEquals("30",result);

        expression = "$A $B *";
        operands = expression.split(" ");
        result = interpreterDesignPattern.interpretPostfixExpression(valueView.getInputString(operands));
        assertEquals("200",result);

        result = interpreterDesignPattern.interpretPostfixExpression("4 lg");
        assertEquals("2",result);

        assertEquals("1", interpreterDesignPattern.interpretPostfixExpression("90 sin"));
    }

}
