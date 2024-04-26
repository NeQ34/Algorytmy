import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Stack;

public class ONP {
    private static final int precedence(char operator) {
        if (operator == '+' || operator == '-') {
            return 1;
        } else if (operator == '*' || operator == '/' || operator == '%') {
            return 2;
        } else {
            return 0;
        }
    }

    private static String infixToPostfix(String expression) {
        StringBuilder output = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char token : expression.toCharArray()) {
            if (Character.isDigit(token)) {
                output.append(token).append(' ');
            } else if (token == '(') {
                stack.push(token);
            } else if (token == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    output.append(stack.pop()).append(' ');
                }
                stack.pop(); // Discard '('
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(token)) {
                    output.append(stack.pop()).append(' ');
                }
                stack.push(token);
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(' ');
        }

        return output.toString().trim();
    }

    private static double evaluatePostfix(String expression) {
        Stack<Double> stack = new Stack<>();

        for (String token : expression.split("\\s+")) {
            if (token.matches("\\d+")) {
                stack.push(Double.parseDouble(token));
            } else {
                double operand2 = stack.pop();
                double operand1 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(operand1 + operand2);
                        break;
                    case "-":
                        stack.push(operand1 - operand2);
                        break;
                    case "*":
                        stack.push(operand1 * operand2);
                        break;
                    case "/":
                        stack.push(operand1 / operand2);
                        break;
                    case "%":
                        stack.push(operand1 % operand2);
                        break;
                }
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("F:\\studia\\semestr-IV\\Algorytmy\\AlgorytmyGr1\\Lab4-22.03.24\\src\\expression01.txt"))) {
            String expression = reader.readLine().trim();
            String postfixExpression = infixToPostfix(expression);
            System.out.println("ONP: " + postfixExpression);
            double result = evaluatePostfix(postfixExpression);
            System.out.println("Wynik: " + result);
        } catch (FileNotFoundException e) {
            System.err.println("Nie można znaleźć pliku wyrazenie.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
