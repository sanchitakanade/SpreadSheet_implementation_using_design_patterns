/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:NumberExpression.java
 */

package designpattern.interpreter;

public class NumberExpression implements Interpreter {
    int number;

    public NumberExpression(Number integer) {
        number = (int)integer;
    }

    public NumberExpression(String string) throws Exception {
        if(string.equals("")) {
            throw new Exception("Empty string is not a valid input." +
                    "\nPlease enter either a postfix expression or an integer value.");
        }else {
            number = Integer.parseInt(string);
        }
    }

    public int interpret() {
        return number;
    }
}
