package leetcode.graph;

public class MaxOfIslands {
    static boolean[][] visited;
    static int[][] input = {
            {1, 1, 1, 0, 1},
            {1, 1, 0, 1, 0},
            {1, 1, 0, 0, 1},
            {0, 0, 0, 0, 1}
    };

    static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) {
        int answer = solve();
        System.out.println(answer);
    }

    public static int solve() {
        if (input== null || input.length == 0) return 0;
        int max = 0;

        visited = new boolean[input.length][input[0].length];

        for (int i=0; i<input.length; i++) {
            for (int j=0; j<input[0].length; j++) {
                int area;
                if (input[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    area = getArea(i, j);
                    max = Math.max(max, area);
                }
            }
        }

        return max;
    }

    public static int getArea(int y, int x) {
        int area = 1;
        visited[y][x] = true;

        for (int i=0; i<dir.length; i++) {
            int newY = y + dir[i][0];
            int newX = x + dir[i][1];

            if (newY>=0 && newY < input.length && newX>=0 && newX < input[0].length) {
                if (!visited[newY][newX] && input[newY][newX] == 1) area += getArea(newY, newX);
            }
        }

        return area;
    }
}
