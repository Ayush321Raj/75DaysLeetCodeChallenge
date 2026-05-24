import java.util.*;

class Solution {

    public String decodeString(String s) {

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder current = new StringBuilder();

        int k = 0;

        for (char ch : s.toCharArray()) {

            // Build number
            if (Character.isDigit(ch)) {

                k = k * 10 + (ch - '0');
            }

            // Start new bracket
            else if (ch == '[') {

                countStack.push(k);
                stringStack.push(current);

                k = 0;
                current = new StringBuilder();
            }

            // End bracket
            else if (ch == ']') {

                int repeat = countStack.pop();

                StringBuilder previous = stringStack.pop();

                for (int i = 0; i < repeat; i++) {

                    previous.append(current);
                }

                current = previous;
            }

            // Normal character
            else {

                current.append(ch);
            }
        }

        return current.toString();
    }
}