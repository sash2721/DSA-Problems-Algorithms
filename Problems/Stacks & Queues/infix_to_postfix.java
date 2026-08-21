import java.util.*;

class Solution {
    static Map<Character, Integer> precedence = Map.of(
        '+', 1,
        '-', 1,
        '*', 2,
        '/', 2,
        '^', 3
    );

    public static String infixToPostfix(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                st.push(ch);
            } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                while(
                    !st.isEmpty() && 
                    st.peek() != '(' &&
                    precedence.get(st.peek()) >= precedence.get(ch)
                ) {
                    char sign = st.pop();
                    sb.append(sign);
                }
                st.push(ch);
            } else if (ch == ')') {
                while(st.peek() != '(') {
                    sb.append(st.pop());
                }
                st.pop();
            } else if (ch == ' ') {
                continue;
            } else {
                sb.append(ch);
            }
        }

        while(!st.isEmpty()) {
            char rem = st.pop();
            sb.append(rem);
        }

        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        String s = "(p + q) * (m - n)";
        String postfix = Solution.infixToPostfix(s);

        System.out.println(postfix);
    }
}