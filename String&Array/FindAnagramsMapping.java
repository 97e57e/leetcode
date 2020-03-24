import java.util.HashMap;
import java.util.Map;

public class FindAnagramsMapping {
    public static void main(String[] args) {
        int[] A = {11, 27, 45, 31, 50};
        int[] B = {50, 11, 31, 45, 27};

        // answer = 1, 4, 3, 2, 0
        int[] answer = solve(A, B);
        for(int i = 0; i<answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] solve(int[] A, int[]B){
        int[] answer = new int[A.length];

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i<A.length; i ++){
            map.put(B[i], i);
        }

        for(int i= 0; i<A.length; i ++){
            answer[i] = map.get(A[i]);
        }



        return answer;
    }
}
