import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
    public static void main(String[] args) {
        int[][] arr = {
                {7,15},
                {0, 2},
                {5, 10}
        };
        System.out.println(solution(arr));
    }

    public static boolean solution(int[][] time) {
        // 1 2차원 배열 정렬
        Arrays.sort(time, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 이른 시간의 end time과 다음 시간의 start time 비교
        for(int i=1; i<time.length; i++) {
            if(time[i-1][1] > time[i][0]) return false;
        }
        return true;
    }
}
