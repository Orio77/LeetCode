import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(answer, new ArrayList<>(), candidates, 0, target, 0);
        return answer;
    }

    private void backtrack(List<List<Integer>> answer, List<Integer> currSet, int[] candidates, int index, int target, int curSum) {
        if (curSum == target) {
            answer.add(new ArrayList<>(currSet));
            return;
        }
        else if (curSum > target) {
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            currSet.add(candidates[i]);
            curSum += candidates[i];
            backtrack(answer, currSet, candidates, i+1, target, curSum);
            currSet.remove(currSet.size()-1);
            curSum -= candidates[i];
        }
    }
}