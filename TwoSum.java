import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[]{i, numMap.get(complement)};
            }
            numMap.put(nums[i], i);
        }
        return new int[0];
    }
}

class Solution2 {
    public int[] twoSum(int[] nums, int target) {

        int[] sorted = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sorted);

        int i = 0;
        int j = nums.length - 1;
       
        while (i < j) {
            int sum = sorted[i] + sorted[j];
            if (sum == target) {
                
            }
            else if (sum > target) {
                j--;
            }
            else if (sum < target) {
                i++;
            }
            else
                break;
       }
       return new int[0];
    }
}