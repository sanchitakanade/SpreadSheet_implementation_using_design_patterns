/* Author: Sanchita Kanade
   Class: Advanced Object-Oriented Design & Programming (Fall 2019)
   File:InterpreterDesignPattern.java
 */
package designpattern.interpreter;

import java.util.Stack;

public class InterpreterDesignPattern {

    //This method interprets postfix expression and evaluates result
    public String interpretPostfixExpression(String input) {
        Stack<Interpreter> stack = new Stack<>();
        int calculatedResult = 0;
        String[] operands = input.split(" ");
        for (String string : operands) {
            if (isOperator(string)) {
                Interpreter operator;
                if (string.equals("sin") || string.equals("lg")) {
                    Interpreter number = stack.pop();
                    operator = getOperator(string, number);
                } else {
                    Interpreter rightOperand = stack.pop();
                    Interpreter leftOperand = stack.pop();
                    operator = getOperator(string, leftOperand,
                            rightOperand);
                }
                if (operator != null) {
                    calculatedResult = operator.interpret();
                }
                stack.push(new NumberExpression(calculatedResult));
            } else {
                try {
                    Interpreter number = new NumberExpression(string);
                    stack.push(number);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        if (stack.empty()) {
            return "";
        } else {
            return String.valueOf(stack.pop().interpret());
        }
    }

    private boolean isOperator(String string) {
        if (string.equals("+") || string.equals("-") || string.equals("*") || string.equals("/") || string.equals("lg") ||
                string.equals("sin"))
            return true;
        else
            return false;
    }

    private Interpreter getOperator(String string, Interpreter number) {
        if (string.equals("sin")) {
            return new SineExpression(number);
        } else return new LogExpression(number, 2);

    }

    private Interpreter getOperator(String string, Interpreter leftOperand,
                                    Interpreter rightOperand) {
        switch (string) {
            case "+":
                return new AdditionExpression(leftOperand, rightOperand);
            case "-":
                return new SubtractionExpression(leftOperand, rightOperand);
            case "*":
                return new MultiplicationExpression(leftOperand, rightOperand);
            case "/":
                return new DivisionExpression(leftOperand, rightOperand);
        }
        return null;
    }
}
