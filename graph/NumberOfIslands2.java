package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands2 {
    static boolean[][] visited;
    static int[][] input = {
            {1, 1, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1}
    };

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        int answer = solve();
        System.out.println(answer);
    }

    public static int solve(){
        int answer = 0;

        for (int i=0; i<input.length; i++) {
            for (int j=0; j<input[0].length; j++) {
                if (input[i][j]==1) {
                    answer++;
                    bfs(i, j);
                }
            }
        }
        return answer;
    }

    public static void bfs(int y, int x) {
        input[y][x] = 0;
        queue.offer(new int[] {y, x});
        while(!queue.isEmpty()){
            int size = queue.size();
            int[] point = queue.poll();
            for (int i=0; i<size; i++) {
                for (int j=0; j<dir.length; j++) {
                    int newY = dir[j][0] + point[0];
                    int newX = dir[j][1] + point[1];
                    if (newY>=0 && newY<input.length && newX>=0 && newX<input[0].length && input[newY][newX]==1) {
                        input[newY][newX] = 0;
                        queue.offer(new int[] {newY, newX});
                    }
                }
            }
        }
    }
}
