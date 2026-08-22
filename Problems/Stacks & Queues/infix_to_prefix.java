import java.util.*;

class Solution {

    static Map<Character, Integer> precedence = Map.of(
        '+', 1,
        '-', 1,
        '*', 2,
        '/', 2,
        '^', 3
    );

    static boolean isOperator(char ch) {
        return ch == '+' ||
               ch == '-' ||
               ch == '*' ||
               ch == '/' ||
               ch == '^';
    }

    static String infixToPostfix(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(ch == '(') {
                st.push(ch);
            }

            else if(isOperator(ch)) {

                while(
                    !st.isEmpty() &&
                    st.peek() != '(' &&
                    precedence.get(st.peek()) >= precedence.get(ch)
                ) {
                    ans.append(st.pop());
                }

                st.push(ch);
            }

            else if(ch == ')') {

                while(st.peek() != '(') {
                    ans.append(st.pop());
                }

                st.pop();
            }

            else {
                ans.append(ch);
            }
        }

        while(!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.toString();
    }

    static String infixToPrefix(String s) {

        // Step 1: Reverse
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        // Step 2: Swap brackets
        for(int i = 0; i < sb.length(); i++) {

            if(sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            }

            else if(sb.charAt(i) == ')') {
                sb.setCharAt(i, '(');
            }
        }

        // Step 3: Infix -> Postfix
        String postfix = infixToPostfix(sb.toString());

        // Step 4: Reverse postfix
        String prefix =
            new StringBuilder(postfix)
                .reverse()
                .toString();

        return prefix;
    }
}

class Main {

    public static void main(String[] args) {

        String s = "(A+B)*(C-D)";

        String prefix =
            Solution.infixToPrefix(s);

        System.out.println(prefix);
    }
}