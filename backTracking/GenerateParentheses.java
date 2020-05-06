package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
    public static void main(String[] args) {
        int input = 3;

        List<String> answer = solve(input);
        for (String a : answer){
            System.out.println(a);
        }
    }

    public static List<String> solve(int input) {
        List<String> result = new ArrayList<>();

        backTracking(result, "", input, input);

        return result;
    }

    public static void backTracking(List<String> result, String parentheses, int left, int right){
        // 1
        if (left < 0 || left > right) return;

        // 2
        if (left==0 && right==0) {
            result.add(parentheses);
            return;
        }

        backTracking(result, parentheses+'(', left-1, right);
        backTracking(result, parentheses+')', left, right-1);

    }
}
