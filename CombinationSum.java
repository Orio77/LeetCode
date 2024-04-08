import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    
}


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), 0,0, answer);
        return answer;
    }

    public void helper(int[] candidates, int target, List<Integer> curNums, int curIndex, int curSum, List<List<Integer>> answer) {
        if (curSum == target) {
            answer.add(new ArrayList<>(curNums));
            return;
        }
        if (curIndex == candidates.length || curSum + candidates[curIndex] > target) {
            return;
        }

        curNums.add(candidates[curIndex]);
        curSum += candidates[curIndex];
        helper(candidates, target, curNums, curIndex, curSum, answer);
        curNums.remove(curNums.size()-1);
        curSum -= candidates[curIndex];
        helper(candidates, target, curNums, curIndex+1, curSum, answer);
    }
}