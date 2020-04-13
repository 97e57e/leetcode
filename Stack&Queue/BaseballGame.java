package leetcode.stackQueue;

import java.util.Stack;

public class BaseballGame {
    public static void main(String[] args) {
        String[] input= {"5", "-2", "4", "C", "D", "9", "+", "+"};

        int answer = solve(input);
        System.out.println(answer);
    }

    public static int solve(String[] input) {
        int answer = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i=0; i<input.length; i++) {
            String str = input[i];

            if (str.equals("C")) {
                stack.pop();
            } else if (str.equals("D")) {
                stack.add(stack.peek()*2);
            } else if (str.equals("+")) {
                int x, y;
                x = stack.pop();
                y = stack.peek();
                stack.add(x);
                stack.add(x+y);
            } else {
                stack.add(Integer.parseInt(input[i]));
            }
        }

        while(!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}
