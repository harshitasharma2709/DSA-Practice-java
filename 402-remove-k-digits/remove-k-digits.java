
import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            char current = num.charAt(i);

            while (!stack.isEmpty() && k > 0 && stack.peek() > current) {
                stack.pop();
                k--;
            }

            stack.push(current);
        }

        // Remove remaining digits from the end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Convert stack into String
        StringBuilder rs = new StringBuilder();

        for (char c : stack) {
            rs.append(c);
        }

        // Remove leading zeros
        while (rs.length() > 0 && rs.charAt(0) == '0') {
            rs.deleteCharAt(0);
        }

        if (rs.length() == 0) {
            return "0";
        }
        return rs.toString();
    }
}
