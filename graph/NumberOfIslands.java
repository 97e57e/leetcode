package leetcode.graph;

public class NumberOfIslands {

    static boolean[][] visited;
    static int[][] input = {
            {1, 1, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1}
    };

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {

        int answer = solve(input);
        System.out.println(answer);
    }

    public static int solve(int[][] input) {
        if (input == null) return 0;

        visited = new boolean[input.length][input[0].length];
        int answer = 0;

        for (int i=0; i<input.length; i++) {

            for (int j=0; j<input[i].length; j++) {
                if (!visited[i][j] && input[i][j] == 1) {
                    dfs(i, j);
                    answer++;
                }
            }
        }

        return answer;
    }

    public static void dfs(int i, int j) {
        visited[i][j] = true;

        for (int z=0; z<dir.length; z++) {
            int newY = i + dir[z][0];
            int newX = j + dir[z][1];

            if (newY>=0 && newY<input.length && newX>=0 && newX<input[0].length) {
                if (!visited[newY][newX] && input[newY][newX] == 1) {
                    dfs(newY, newX);
                }
            }
        }
    }
}
