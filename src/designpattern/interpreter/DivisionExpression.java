/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:DivisionExpression.java
 */

package designpattern.interpreter;

public class DivisionExpression implements Interpreter {
    Interpreter leftOperand;
    Interpreter rightOperand;

    public DivisionExpression(Interpreter leftOperand, Interpreter rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public int interpret() {
        return (int) divide(leftOperand.interpret() , rightOperand.interpret());
    }

    private <T extends Number> double divide (T num1, T num2)
    {
        return num1.doubleValue() / num2.doubleValue();
    }

}
