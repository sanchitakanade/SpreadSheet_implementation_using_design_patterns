/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:LogExpression.java
 */
package designpattern.interpreter;

public class LogExpression implements Interpreter {
    Interpreter number;
    int base;

    public LogExpression(Interpreter number, int base) {
        this.number = number;
        this.base = base;
    }

    public int interpret() {
        return (int) log(number.interpret(),base);
    }

    private double log(Number num, int base) {
        return (Math.log(num.doubleValue())/Math.log(base));
    }

}
