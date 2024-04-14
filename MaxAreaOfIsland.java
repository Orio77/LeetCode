class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int explored = explore(grid, i, j, new int[]{0})[0];
                    if (explored > maxArea) {
                        maxArea = explored;
                    }
                }
            }
        }
        return maxArea;
    }

    private int[] explore(int grid[][], int i, int j, int[] exploredArea) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == 0) {
            return exploredArea;
        }

        exploredArea[0]++;
        grid[i][j] = 0;

        explore(grid, i+1, j, exploredArea);
        explore(grid, i-1, j, exploredArea);
        explore(grid, i, j+1, exploredArea);
        explore(grid, i, j-1, exploredArea);

        return exploredArea;
    }
}