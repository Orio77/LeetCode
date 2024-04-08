import java.util.HashMap;
import java.util.Map;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        Map<Integer, Integer> backward = new HashMap<>();
        Map<Integer, Integer> forward = new HashMap<>();
        backward.put(0, nums[0]);
        forward.put(nums.length-1, nums[nums.length-1]);

        int i = 1;
        int j = nums.length - 2;

        while (i < nums.length) {
            backward.put(i, nums[i]*backward.get(i-1));
            forward.put(j, nums[j]*forward.get(j+1));

            i++;
            j--;
        }

        int[] result = new int[nums.length];
        result[0] = forward.get(1);
        result[nums.length - 1] = backward.get(nums.length - 2);
        for (int k = 1; k < result.length-1; k++) {
            result[k] = backward.get(k-1) * forward.get(k+1);
        }

        return result;
    }
}