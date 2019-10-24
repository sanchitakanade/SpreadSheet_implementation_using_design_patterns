/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:MultiplicationExpression.java
 */
package designpattern.interpreter;

public class MultiplicationExpression implements Interpreter {
    Interpreter leftOperand;
    Interpreter rightOperand;

    public MultiplicationExpression(Interpreter leftOperand, Interpreter rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public int interpret() {
        return (int) multiply(leftOperand.interpret(), rightOperand.interpret());
    }

    private <T extends Number> double multiply (T number1, T number2)
    {
        return number1.doubleValue() * number2.doubleValue();
    }

}
