import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int start;
        int index;
        int height;
        int[] element;
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) {
            start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) {
                element = stack.pop();
                index = element[0];
                height = element[1];
                maxArea = Math.max(maxArea, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        while (!stack.isEmpty()) {
            element = stack.pop();
            index = element[0];
            height = element[1];
            maxArea = Math.max(maxArea, height * (heights.length - index));
        }
        return maxArea;
    }
}