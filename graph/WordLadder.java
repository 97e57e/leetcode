package leetcode.graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.asList(words);

        int answer = solve(beginWord, endWord, wordList);
        System.out.println(answer);
    }

    public static int solve(String beginWord, String endWord, List<String> wordList){
        if (wordList == null) return 0;

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>(wordList);
        set.add(endWord);
        set.remove(beginWord);

        queue.offer(beginWord);
        int level = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for (int i=0; i<size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) return level;
                for(int wordIdx = 0; wordIdx<word.length(); wordIdx++) {
                    char[] charList = word.toCharArray();
                    for(char ch = 'a'; ch<='z'; ch++) {
                        charList[wordIdx] = ch;
                        String str = new String(charList);
                        if (set.contains(str)) {
                            System.out.println(str);
                            set.remove(str);
                            queue.offer(str);
                        }
                    }
                }
            }
            level ++;
        }

        return 0;
    }
}
