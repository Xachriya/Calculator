package CIS2206.Unit_13;

import java.util.Stack;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Calculator {

    public static void main(String[] args) {
        // Input string to be processed
        String input = "4 5 + 1 2 * - 5 /";

        // Create a StringTokenizer object to separate the input into tokens
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        // String variable to hold the current token
        String token;
        // Create a stack to store the operands
        Stack<String> s = new Stack<>();

        // Process input tokens
        while (tokenizer.hasMoreElements()) {
            // Get the next token
            token = tokenizer.nextToken();

            // Check if the token is numeric
            String tmpDouble = (token);
            // If it is numeric, push it onto the stack
            s.push(token);
            System.out.println("push("+token+") | return value "+token+" | STACK Content"+s+"");

            // If the token is an operator, perform the appropriate operation
            if (tmpDouble.equals("+") || tmpDouble.equals("-") || tmpDouble.equals("*") || tmpDouble.equals("/")) {

                // Switch statement to determine which operation to perform
                switch ((token)) {
                    case "+":
                        // Pop the two operands off the stack and perform the addition
                        s.pop();
                        System.out.println("pop()   | return value "+token+" | STACK Content "+s+"");
                        int b = parseInt(s.pop());
                        System.out.println("pop()   | return value "+b+" | STACK Content "+s+"");
                        int a = parseInt( s.pop());
                        System.out.println("pop()   | return value "+a+" | STACK Content "+s+"");
                        int value = a + b;
                        // Push the result back onto the stack
                        s.push(String.valueOf(value));
                        System.out.println("push("+value+") | return value "+value+" | STACK Content "+s+"");
                        break;
                    case "-":
                        // Pop the two operands off the stack and perform the subtraction
                        s.pop();
                        System.out.println("pop()   | return value "+token+" | STACK Content "+s+"");
                        b = parseInt(s.pop());
                        System.out.println("pop()   | return value "+b+" | STACK Content "+s+"");
                        a = parseInt( s.pop());
                        System.out.println("pop()   | return value "+a+" | STACK Content "+s+"");
                        value = a - b;
                        // Push the result back onto the stack
                        s.push(String.valueOf(value));
                        System.out.println("push("+value+") | return value "+value+" | STACK Content "+s+"");
                        break;
                    case "*":
                        // Pop the two operands off the stack and perform the subtraction
                        s.pop();
                        System.out.println("pop()   |  return value "+token+"| STACK Content"+s+"");

                        b = parseInt(s.pop());
                        System.out.println("pop()   |  return value "+b+"| STACK Content"+s+"");

                        a = parseInt( s.pop());
                        System.out.println("pop()   |  return value "+a+"| STACK Content"+s+"");

                        value = a * b;
                        // Push the result back onto the stack
                        s.push(String.valueOf(value));
                        System.out.println("push("+value+") |  return value "+value+"| STACK Content"+s+"");
                        break;
                    case "/":
                        // Pop the two operands off the stack and perform the subtraction
                        s.pop();
                        System.out.println("pop()   |  return value "+token+"| STACK Content"+s+"");

                        b = parseInt(s.pop());
                        System.out.println("pop()   |  return value "+b+"| STACK Content"+s+"");

                        a = parseInt( s.pop());
                        System.out.println("pop()   |  return value "+a+"| STACK Content"+s+"");

                        float c =(float) a / b;
                        // Push the result back onto the stack
                        s.push(String.valueOf(c));
                        System.out.println("push("+c+") |  return value "+c+"| STACK Content"+s+"");
                        break;
                    /*
                       the default case is used to throw an IllegalStateException if the is not  one of the four supported operators (+, -, *, /).
                     */
                    default:
                        throw new IllegalStateException("Unexpected value: " + (token));
                }



            }
        }
    }
}





