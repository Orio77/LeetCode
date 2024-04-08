class Solution {
    public int maxArea(int[] height) {

        // Create two pointers
        int left = 0;
        int right = height.length - 1;
        // Keep track of the max water
        int max = 0;
        // In a while loop decrease the smaller side of container until a bigger one is found
        while (left < right) {
            int valLeft = height[left];
            int valRight = height[right];
            int curContainer = (right - left) * Math.min(valLeft, valRight);

            if (curContainer > max) {
                max = curContainer;
            }

            if (valRight < valLeft) {
                while (height[right] <= valRight && left < right) {
                    right--;
                }
            }
            else {
                while (height[left] <= valLeft && left < right) {
                    left++;
                }
            }
        }
        return max;
    }
}
