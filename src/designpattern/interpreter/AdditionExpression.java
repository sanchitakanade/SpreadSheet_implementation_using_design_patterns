/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:AdditionExpression.java
 */
package designpattern.interpreter;

public class AdditionExpression implements Interpreter {
    Interpreter leftOperand;
    Interpreter rightOperand;

    public AdditionExpression(Interpreter leftOperand, Interpreter rightOperand) {
        this.leftOperand  = leftOperand;
        this.rightOperand = rightOperand;
    }

    public int interpret() {
        return (int) add(leftOperand.interpret(), rightOperand.interpret());
    }

    private <T extends Number> double add (T number1, T number2)
    {
        return number1.doubleValue() + number2.doubleValue();
    }

}
