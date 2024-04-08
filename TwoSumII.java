class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int i = 1;
        int j = numbers.length -1;

        while (i <= j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) 
                return new int[]{i, j};
            if (target > sum) 
                j--;
            if (target < sum) 
                i++;
        }
        return new int[0];
    }
}