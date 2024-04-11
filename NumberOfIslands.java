

class Solution {
    public int numIslands(char[][] grid) {
        
        // Create boolean[][] visited
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        // Creat island count
        int count = 0;
        // Start at the first position 1 ??? add to visited and search the nearby fields ::: go to the next position 
        for (int i = 0; i < visited.length; i++) {
            for (int j = 0; j < visited[0].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    search(grid, i, j, visited);
                    count++;
                }
                visited[i][j] = true;
            }
        }
        return count;
    }

    private void search(char[][] grid, int rowIndex, int colIndex, boolean[][] visited) {
        if (rowIndex < 0 || rowIndex >= grid.length || colIndex < 0 || colIndex >= grid[0].length || visited[rowIndex][colIndex] || grid[rowIndex][colIndex] == '0') {
            return;
        }
        if (grid[rowIndex][colIndex] == '1') {
            visited[rowIndex][colIndex] = true;
        }

        search(grid, rowIndex+1, colIndex, visited);
        search(grid, rowIndex-1, colIndex, visited);
        search(grid, rowIndex, colIndex+1, visited);
        search(grid, rowIndex, colIndex-1, visited);
    }
}