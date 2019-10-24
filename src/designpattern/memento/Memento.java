/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:Memento.java
 */
package designpattern.memento;

import java.util.ArrayList;

public class Memento {
    private ArrayList<String> state;

    protected Memento() {
        this.state = new ArrayList<>();
    }

    protected void setState(String textFiledValue) {
        state.add(textFiledValue);
    }

    //returns first element from state
    protected String getState() {
        return state.get(0);
    }

    protected String getState(int index) {
        return state.get(index);
    }
}
