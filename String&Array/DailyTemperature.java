import java.util.Stack;

public class DailyTemperature {
    public static void main(String[] args) {
        int[] nums = {73, 74, 75, 71, 69, 72, 76, 73};

        DailyTemperature dt = new DailyTemperature();
        int[] result = dt.solve(nums);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    public int[] solve(int[] nums) {
        //1
        Stack<Integer> st = new Stack<>();
        int[] result = new int[nums.length];

        //2
        for(int i=0; i<nums.length; i ++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                int index = st.pop();
                result[index] = i - index;
            }

            st.push(i);
        }

        return result;
    }
}
