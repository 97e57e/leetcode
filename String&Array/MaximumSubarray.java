public class MaximumSubarray {
    public static void main(String[] args) {
                int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] input = {-1, -1};

        int answer = solve(input);
        System.out.println(answer);
    }

    public static int solve(int[] input) {
        //1
        int newSum = input[0];
        int max = input[0];

        //2
        for(int i=1; i<input.length; i++){
            newSum = Math.max(input[i], newSum + input[i]);
            max = Math.max(newSum, max);
        }

        return max;
    }
}
