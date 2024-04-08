import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


class MySolutionSolution {
    public List<List<Integer>> threeSum(int[] nums) {

        // Create solution list
        List<List<Integer>> solutionList = new ArrayList<>();
        // Sort nums
        Arrays.sort(nums);
        // Create 3 pointers
        int i = 0;
        int j = nums.length - 1;
        int k = 0;
        // Iterate over all elements
        while (i < j) {
            if (nums[i] + nums[j] > 0) {
                k = i+1;
                while (k < j && nums[i] + nums[j] + nums[k] <= 0) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(nums[j]);
                        sol.add(nums[k]);
                        solutionList.add(sol);
                        break;
                    }
                    k++;
                }
            }
            else if (nums[i] + nums[j] < 0) {
                k = j-1;
                while (k > i && nums[i] + nums[j] + nums[k] >= 0) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(nums[j]);
                        sol.add(nums[k]);
                        solutionList.add(sol);
                        break;
                    }
                    k--;
                }
            }
            else if (nums[i] + nums[j] == 0) {
                k = i+1;
                while (k < j && nums[k] <=0) {
                    if (nums[k] == 0) {
                        List<Integer> sol = new ArrayList<>();
                        sol.add(nums[i]);
                        sol.add(nums[j]);
                        sol.add(nums[k]);
                        solutionList.add(sol);
                        break;
                    }
                    k++;
                }
            }

            if (i % 2 == 0) {
                i++;
            }
            else {
                j--;
            }
        }


        // Make Soulutions distinct
        Set<String> set = new HashSet<>();
        List<List<Integer>> toRemove = new ArrayList<>();
        for (List<Integer> list : solutionList) {
            list.sort(Comparator.naturalOrder());
            String curNumSeq = list.get(0) + ";" + list.get(1) + ";" +  list.get(2);
            if (!set.add(curNumSeq)) {
                toRemove.add(list);
            }
        }
        for (List<Integer> list : toRemove) {
            solutionList.remove(list);
        }
        return solutionList;
    }
}


class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        List<List<Integer>> solution = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    set.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                }
                else if (sum < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        solution.addAll(set);
        return solution;
    }
}