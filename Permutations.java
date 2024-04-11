import java.util.ArrayList;
import java.util.List;

class MySolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            helper(result, new ArrayList<>(), nums, i);
        }
        return result;
    }

    public void helper(List<List<Integer>> result, List<Integer> currPermutation, int[] nums, int index) {
        if (currPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currPermutation));
            return;
        }
        if (index == nums.length) {
            return;
        }

        currPermutation.add(nums[index]);
        helper(result, currPermutation, nums, index+1);
        currPermutation.remove(currPermutation.size()-1);
        helper(result, currPermutation, nums, index+1);
    }
}


class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrack(answer, new ArrayList<>(), nums);
        return answer;
    }

    public void backtrack(List<List<Integer>> answer, List<Integer> currPermutation, int[] nums) {
        if (currPermutation.size() == nums.length) {
            answer.add(new ArrayList<>(currPermutation));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (currPermutation.contains(nums[i])) 
                    continue;

                currPermutation.add(nums[i]);
                backtrack(answer, currPermutation, nums);
                currPermutation.remove(currPermutation.size() - 1);
            }
        }
    }
}