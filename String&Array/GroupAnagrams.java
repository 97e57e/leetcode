package leetcode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] input = {
                "eat",
                "tea",
                "tan",
                "ate",
                "nat",
                "bat",
        };

        System.out.println(solve(input));
    }

    public static List<List<String>> solve(String[] input) {
        List<List<String>> answer = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i=0; i<input.length; i++) {
            String key = createKey(input[i]);
            if (map.containsKey(key)){
                map.get(key).add(input[i]);
            } else {
                List<String> newList = new ArrayList<>();
                newList.add(input[i]);
                map.put(key, newList);
            }
        }

        for (String key : map.keySet()) {
            answer.add(map.get(key));
        }

        return answer;
    }

    public static String createKey(String a) {
        char[] words = a.toCharArray();
        Arrays.sort(words);
        String sortStr = new String(words);

        return sortStr;
    }
}
