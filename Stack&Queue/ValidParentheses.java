package leetcode.stackQueue;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String input = "([)]";

        boolean answer = solve(input);
        System.out.println(answer);
    }

    public static boolean solve(String input) {
        boolean answer = true;
        Stack<Character> st = new Stack<>();
        char[] charArr = input.toCharArray();

        for (Character c : charArr) {
            switch (c){
                case ')':
                    if(st.isEmpty()) return false;
                    if (st.pop() != '(') answer = false;
                    break;

                case '}':
                    if(st.isEmpty()) return false;
                    if (st.pop() != '{') answer = false;
                    break;

                case ']':
                    if(st.isEmpty()) return false;
                    if (st.pop() != '[') answer = false;
                    break;

                default:
                    st.add(c);
                    break;
            }
            if (answer == false) {
                break;
            }
        }

        if (!st.isEmpty()) answer = false;

        return answer;
    }
}
