class MyJumpGameII {
    public int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        
        int i = 0;
        int j = 1;

        int iCounter = 0;
        int jCounter = 1;

        outer:
        while (i < nums.length && j < nums.length) {
            int iNum = nums[i];
            for (int k = 0; k < iNum; k++) {
                i++;
                if (i == nums.length-1) {
                    iCounter++;
                    break outer;
                }
            }
            if (iNum != 0) {
                iCounter++;
            }

            int jNum = nums[j];
            for (int k = 0; k < jNum; k++) {
                j++;
                if (j == nums.length-1) {
                    jCounter++;
                    break outer;
                }
            }
            if (jNum > 0) {
                jCounter++;
            }

            if (j < nums.length && i >= j) {
                jCounter = iCounter;
                j++; jCounter++;
            }
            else if (j < nums.length && i < j) {
                i = j;
                iCounter = jCounter; 
                jCounter++;
                j++; 
            }
        }
        if (j >= nums.length-1) {
            return jCounter;
        }
        else
            return iCounter;
    }
}


class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }

        int count = 0;
        int maxReach = 0;
        int nextReach = 0;

        for (int i = 0; i < n - 1; i++) {
            nextReach = Math.max(nextReach, i + nums[i]);

            if (i == maxReach) {
                count++;
                maxReach = nextReach;
            }
        }

        return count;
    }
}



class MySolutionII {
    public int jump(int[] nums) {

        int left = 0;
        int right = 0;
        int count = 0;
        int maxReach = 0;

        while (right < nums.length) {
            maxReach = 0;
            for (int i = left; i < right + 1; i++) {
                maxReach = Math.max(maxReach, i + nums[i]);
            }
            left = right + 1;
            right = maxReach;
            count += 1;
        }
        return count;
    }
}