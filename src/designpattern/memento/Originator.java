/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File: Originator.java
 */
package designpattern.memento;
import spreadsheet.EquationViewGUI;
import spreadsheet.ValueViewGUI;

import java.util.Stack;

public class Originator {
    private Stack<Memento> history;

    public Originator (Stack<Memento> stack) {
        this.history = stack;
    }

    public void createMemento(TextFieldGUI spreadSheet) {
        Memento currentState = new Memento();
        currentState.setState(spreadSheet.getjTextField1().getText());
        currentState.setState(spreadSheet.getjTextField2().getText());
        currentState.setState(spreadSheet.getjTextField3().getText());
        currentState.setState(spreadSheet.getjTextField4().getText());
        currentState.setState(spreadSheet.getjTextField5().getText());
        currentState.setState(spreadSheet.getjTextField6().getText());
        currentState.setState(spreadSheet.getjTextField7().getText());
        currentState.setState(spreadSheet.getjTextField8().getText());
        currentState.setState(spreadSheet.getjTextField9().getText());
        history.push(currentState);
    }

    public void restoreState(TextFieldGUI spreadSheet) {
        if(history.empty() && spreadSheet instanceof EquationViewGUI) {
            spreadSheet.getjTextField1().setText("");
            spreadSheet.getjTextField2().setText("");
            spreadSheet.getjTextField3().setText("");
            spreadSheet.getjTextField4().setText("");
            spreadSheet.getjTextField5().setText("");
            spreadSheet.getjTextField6().setText("");
            spreadSheet.getjTextField7().setText("");
            spreadSheet.getjTextField8().setText("");
            spreadSheet.getjTextField9().setText("");
        } else if(history.empty() && spreadSheet instanceof ValueViewGUI){
            spreadSheet.getjTextField1().setText("0");
            spreadSheet.getjTextField2().setText("0");
            spreadSheet.getjTextField3().setText("0");
            spreadSheet.getjTextField4().setText("0");
            spreadSheet.getjTextField5().setText("0");
            spreadSheet.getjTextField6().setText("0");
            spreadSheet.getjTextField7().setText("0");
            spreadSheet.getjTextField8().setText("0");
            spreadSheet.getjTextField9().setText("0");
        } else
            {
            Memento oldState = history.pop();
            spreadSheet.getjTextField1().setText(oldState.getState());
            spreadSheet.getjTextField2().setText(oldState.getState(1));
            spreadSheet.getjTextField3().setText(oldState.getState(2));
            spreadSheet.getjTextField4().setText(oldState.getState(3));
            spreadSheet.getjTextField5().setText(oldState.getState(4));
            spreadSheet.getjTextField6().setText(oldState.getState(5));
            spreadSheet.getjTextField7().setText(oldState.getState(6));
            spreadSheet.getjTextField8().setText(oldState.getState(7));
            spreadSheet.getjTextField9().setText(oldState.getState(8));
        }
    }
}
