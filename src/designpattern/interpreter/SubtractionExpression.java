/* Author: Sanchita Kanade
   Class:Advanced Object-Oriented Design & Programming (Fall 2019)
   File:SubtractionExpression.java
 */
package designpattern.interpreter;

public class SubtractionExpression implements Interpreter {
    Interpreter leftOperand;
    Interpreter rightOperand;

    public SubtractionExpression(Interpreter leftOperand, Interpreter rightOperand) {
        this.leftOperand = leftOperand;
        this.rightOperand = rightOperand;
    }

    public int interpret() {
        return (int) subtract(leftOperand.interpret(), rightOperand.interpret());
    }

    private <T extends Number> double subtract (T number1, T number2)
    {
        return number1.doubleValue() - number2.doubleValue();
    }

}
