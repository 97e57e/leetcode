package leetcode.backTracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        int[] input = {1, 2, 3};

        System.out.println(solve(input));
    }

    public static List<List<Integer>> solve(int[] input) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        if (input == null || input.length == 0) return result;

        dfs(input, result, list);

        return result;
    }

    public static void dfs(int[] input, List<List<Integer>> lists, List<Integer> list) {
        // 1
        if (list.size() == input.length) {
            List<Integer> newList = new ArrayList<>(list);
            lists.add(newList);
        }

        // 2
        for (int i=0; i<input.length; i++) {
//            if (list.size()==input.length) continue;
            if (list.contains(input[i])) continue;

            list.add(input[i]);
            dfs(input, lists, list);
            list.remove(list.size() - 1);
        }
    }
}
