/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:SineExpression.java
 */
package designpattern.interpreter;

public class SineExpression implements Interpreter {
    Interpreter number;

    public SineExpression(Interpreter number) {
        this.number = number;
    }

    public int interpret() {
        return (int) sin(number.interpret());
    }

    private <T extends Number> double sin(T num) {
        double x;
        x = Math.toRadians(num.doubleValue());
        return Math.sin(x);
    }
}
