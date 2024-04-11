import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(answer, new ArrayList<>(), nums, 0);
        return answer;
    }

    private void backtrack(List<List<Integer>> answer, List<Integer> currSet, int[] nums, int index) {
        answer.add(new ArrayList<>(currSet));
        
        for (int i = 0; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }    

            currSet.add(nums[i]);
            backtrack(answer, currSet, nums, index+1);
            currSet.remove(currSet.size()-1);
        }
    }
}