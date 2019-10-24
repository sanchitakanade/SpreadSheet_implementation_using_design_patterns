/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:RestorePreviousState.java
 */
package designpattern.memento;
import spreadsheet.EquationViewGUI;
import spreadsheet.ValueViewGUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestorePreviousState implements ActionListener {
    private ValueViewGUI valueView;
    private EquationViewGUI equationView;

    public RestorePreviousState(EquationViewGUI equationView) {
        this.equationView = equationView;
    }

    public RestorePreviousState(ValueViewGUI valueView) {
        this.valueView = valueView;
    }

    public void actionPerformed(ActionEvent e) {
        if(equationView != null && e.getSource() == equationView.getjButton1()) {
            equationView.restoreState();
        } else if(e.getSource() == valueView.getjButton1()) {
            valueView.restoreState();
        }
    }
}
