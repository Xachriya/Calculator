package CIS2206.Unit_13;

import java.util.Stack;
import java.util.StringTokenizer;

/**
 * An HTML syntax checker
 *
 * @author Ilias Tachmazidis
 * @version September 2022
 */
public class HTMLChecker {

    public static void main(String[] args) {

        // HTML input text
        String htmlInput = "<html>\n" +
                "<body>\n" +
                "<h1>My First Heading</h1>\n" +
                "<p>My first paragraph.\n" +
                "</body>\n" +
                "</html>\n";

        // Separate tokens
        StringTokenizer tokenizer = new StringTokenizer(htmlInput, "\n");
        String token;

        // Create a stack of Strings
        Stack<String> stack = new Stack();

        // Process input line by line
        while (tokenizer.hasMoreElements()) {
            // Extract and print next line
            token = tokenizer.nextToken();
            System.out.println("token: " + token);

            // find first '<' character (if any)
            int startIndex = token.indexOf('<');
            while (startIndex != -1) {
                // find next '>' character
                int endIndex = token.indexOf('>', startIndex + 1);

                // check if '>' character is missing (syntax error)
                if (endIndex == -1) {
                    System.err.println("Syntax error, invalid in line: <" + token);
                    return;
                }

                // strip away < >
                String tag = token.substring(startIndex + 1, endIndex);

                // This is an opening tag
                if (!tag.startsWith("/")) {
                    // Opening tags are pushed into the stack
                    stack.push(tag);
                }
                // This is a closing tag
                else {
                    // Stack contains tags
                    if (!stack.isEmpty()) {
                        String openingTag = stack.pop();
                        if (!tag.substring(1).equals(openingTag)) {
                            System.err.println("Syntax error, mismatch in opening/closing " +
                                    "tags for tags: <" + openingTag + "> and " + tag);
                            return;
                        }
                    }
                    // Stack is empty (syntax error)
                    else {
                        System.err.println("Syntax error, no tags to match for tag: <" + tag + ">");
                        return;
                    }
                }
                // find next '<' character (if any)
                startIndex = token.indexOf('<', endIndex + 1);
            }
        }

        // Check if all opening tags have been matched
        if (!stack.isEmpty()) {
            System.err.println("Syntax error, unmatched tags remain." + stack);
        } else {
            System.out.println("Valid HTML text");
        }
    }
}