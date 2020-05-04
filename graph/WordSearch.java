package leetcode.graph;

import java.util.Stack;

public class WordSearch {

    static int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public static void main(String[] args) {
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'},
        };

        String givenWord = "ABCCFSADEE";

        boolean answer = solve(board, givenWord);
        System.out.println(answer);
    }

    public static boolean solve(char[][] board, String givenWord) {
        if (board == null || board.length == 0) return false;
        if (board[0].length == 0) return false;

        boolean[][] visited = new boolean[board.length][board[0].length];

        for (int i=0; i<board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == givenWord.charAt(0))
                    if(dfs(board, visited, givenWord, 0, i, j)) return true;
            }
        }

        return false;
    }

    public static boolean dfs(char[][] board, boolean[][] visited, String givenWord, int wordIdx, int y, int x) {
        if (wordIdx == givenWord.length() - 1) return true;
        if (board[y][x] != givenWord.charAt(wordIdx)) return false;
        visited[y][x] = true;

        for (int z=0; z<4; z++) {
            int newY = y + dir[z][0];
            int newX = x + dir[z][1];
            if (newY>=0 && newY<board.length && newX>=0 && newX<board[0].length
                    && board[newY][newX] == givenWord.charAt(wordIdx+1) && !visited[newY][newX]) {
                if (dfs(board, visited, givenWord, wordIdx+1, newY, newX)) return true;
            }
        }
        return false;
    }
}
