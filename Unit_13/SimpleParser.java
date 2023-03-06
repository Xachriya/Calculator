package CIS2206.Unit_13;

import java.util.StringTokenizer;

/**
 * A simple parser
 *
 * @author Ilias Tachmazidis
 * @version September 2022
 */
public class SimpleParser {

    public static void main(String[] args) {
        String input = "Word 4 5.2 &";

        // Separate tokens
        StringTokenizer tokenizer = new StringTokenizer(input, " ");
        String token;

        // Process input
        while (tokenizer.hasMoreElements()) {
            token = tokenizer.nextToken();

            try {
                // Check if token is numeric
                Double tmpDouble = Double.parseDouble(token);
                System.out.println("Double: " + tmpDouble);
            } catch (NumberFormatException nfe) {
                // Process token at text
                System.out.println("String: " + token);
            }
        }
    }
}
