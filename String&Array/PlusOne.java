public class PlusOne {
    public static void main(String[] args) {
//        int[] input = {9,9,9};
        int[] input = {1,2,3};

        int[] answer = solve(input);

        for(int i=0; i<answer.length; i++){
            System.out.println(answer[i]);
        }
    }

    public static int[] solve(int[] input) {
        for(int i=input.length-1; i>=0; i--) {
            if (input[i] == 9) {
                input[i] =0;
            } else {
                input[i] ++;
                break;
            }
        }

        if (input[0] == 0) {
            int[] result = new int[input.length + 1];
            result[0]=1;
            return result;
        }

        return input;
    }
}
