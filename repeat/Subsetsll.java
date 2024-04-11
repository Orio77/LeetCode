package repeat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsetsll {
    public List<List<Integer>> generate(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums, 0);
        return result;
    }

    public void backtrack(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
        result.add(new ArrayList<>(current));

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i-1]) {
                continue;
            }

            current.add(nums[i]);
            backtrack(result, current, nums, i+1);
            current.remove(current.size()-1);
        }
    }
}
