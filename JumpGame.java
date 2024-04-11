

class Solution {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) 
            return true;

        boolean[] reachableFields = new boolean[nums.length];
        reachableFields[0] = true;

        int i = 0;
        int j = 1;

        while (i < nums.length && j < nums.length) {
            
            while (i < nums.length && reachableFields[i] == false) {
                i++;
            }

            if (i == nums.length || j == nums.length) {
                break;
            }

            for (int i2 = i+1; i2 < nums.length && i2 <= (i+nums[i]); i2++) {
                reachableFields[i2] = true;
            }
            i++;

            if (i == nums.length || j == nums.length) {
                break;
            }

            while (j < nums.length && reachableFields[j] == false) {
                j++;
            }

            if (i == nums.length || j == nums.length) {
                break;
            }

            for (int j2 = j+1; j2 <= (j+nums[j]) && j2 < nums.length; j2++) {
                reachableFields[j2] = true;
            }
            j++;
        }
        return reachableFields[reachableFields.length-1];
    }
}