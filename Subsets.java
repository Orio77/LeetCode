import java.util.ArrayList;
import java.util.List;


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        helper(result, new ArrayList<>(), 0, nums);
        return result;
    }

    public void helper(List<List<Integer>> answer, List<Integer> curSet, int index, int[] nums) {
        if (index == nums.length) {
            answer.add(new ArrayList<>(curSet));
            return;
        }
        
        int num = nums[index];

        curSet.add(num);
        helper(answer, curSet, index+1, nums);
        curSet.remove(Integer.valueOf(num));
        

        helper(answer, curSet, index+1, nums);
    }
}