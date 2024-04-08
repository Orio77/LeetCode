

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) 
            return false;
        if (matrix.length == 1) {
            return bSearch(matrix[0], target);
        }

        int start = 0;
        int end = matrix.length;
        
        // search for the array
        while (start <= end) {
            int mid = start + (end-start) / 2;
            if (mid >= matrix.length) 
                return false;
            if (target <= matrix[mid][matrix[mid].length-1] && target >= matrix[mid][0]) {
                return bSearch(matrix[mid], target);
            }
            else if (matrix[mid][0] > target) 
                end = --mid;
            else if (matrix[mid][matrix[mid].length-1] < target)  {
                start = ++mid;
            }
        }

        return false;
    }

    public boolean bSearch(int[] array, int target) {

        int start = 0;
        int end = array.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid >= array.length) 
                return false;
            if (array[mid] == target) {
                return true;
            }
            else if (array[mid] > target) {
                end = --mid;
            } 
            else if (array[mid] < target) {
                start = ++mid;
            }
        }

        return false;
    }
}