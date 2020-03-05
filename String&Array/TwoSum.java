import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {-1, -2, 2, 9, 11, 8};
        int target = 10;

        TwoSum a = new TwoSum();
        int[] result = a.solve(nums, target);

        for(int i=0; i<result.length; i++){
            System.out.println(result[i]);
        }
    }

    public int[] solve(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<nums.length; i++) {
            if(map.containsKey(nums[i])){
                int val = map.get(nums[i]);

                result[0] = val;
                result[1] = i;
            } else {
                map.put(target-nums[i], i);
            }
        }

        return result;
    }
}
