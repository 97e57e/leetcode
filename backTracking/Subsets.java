package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};

        System.out.println(solve(input));
    }

    public static List<List<Integer>> solve(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        if (input == null || input.length == 0) return result;

        dfs(input, result, cur, 0);

        return result;
    }

    public static void dfs(int[] input, List<List<Integer>> lists, List<Integer> cur, int idx) {
        //1
        List<Integer> list = new ArrayList<>(cur);
        lists.add(list);

        //2
        for (int i=idx; i<input.length; i++) {
            cur.add(input[i]);
            dfs(input, lists, cur, i+1);
            cur.remove(cur.size() - 1);
        }
    }
}
