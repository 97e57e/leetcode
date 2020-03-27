package leetcode;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] spiral = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] answer = solve(spiral);
        for(int i=0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] solve(int[][] spiral){
        int[] answer = new int[spiral[0].length * spiral.length];

        int position = 0;
        int rowStart = 0, rowEnd = spiral.length-1, colStart = 0, colEnd = spiral[0].length-1;

        while (rowStart <= rowEnd && colStart <= colEnd){
            //right
            for (int i=colStart; i<=colEnd; i++){
                answer[position++] = spiral[rowStart][i];
            }
            rowStart++;

            //down
            for (int i=rowStart; i<=rowEnd; i++) {
                answer[position++] = spiral[i][colEnd];
            }
            colEnd--;

            //left
            if (rowStart <= rowEnd) {
                for (int i = colEnd; i >= 0; i--) {
                    answer[position++] = spiral[rowEnd][i];
                }
            }
            rowEnd--;

            //up
            if (colStart <= colEnd) {
                for (int i = rowEnd; i >= rowStart; i--) {
                    answer[position++] = spiral[i][colStart];
                }
            }
            colStart++;
        }

        return answer;
    }
}
