import java.util.*;

class Solution {
    public static String prefixToInfix(String s) {
        Stack<String> st = new Stack<>();

        for(int i = s.length()-1; i >= 0; i--) {
            char ch = s.charAt(i);

            if(ch == '+' || ch == '-' || ch == '*' || ch == '/' || ch == '^') {
                String op1 = st.pop();
                String op2 = st.pop();

                String newEquation = "(" + op1 + ch + op2 + ")";
                st.push(newEquation);
            } else if(ch == ' ') {
                continue;
            } else {
                st.push(Character.toString(ch));
            }
        }

        return st.pop();
    }
}

class Main {
    public static void main(String[] args) {
        String s = "+ab";
        String infix = Solution.prefixToInfix(s);

        System.out.println(infix);
    }
}