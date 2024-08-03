package Day16;

class Solution {
    private int n, m;
    private boolean[][] visited;
    
    // Directions arrays for 8 possible movements (horizontally, vertically, diagonally)
    private static final int[] rowDir = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] colDir = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        n = grid.length;
        m = grid[0].length;
        visited = new boolean[n][m];
        int islandCount = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // Start a new island
                    dfs(grid, i, j);
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
    
    private void dfs(char[][] grid, int row, int col) {
        // Base case: If out of bounds or already visited or water
        if (row < 0 || row >= n || col < 0 || col >= m || grid[row][col] == '0' || visited[row][col]) {
            return;
        }
        
        visited[row][col] = true; // Mark the cell as visited
        
        // Explore all 8 directions
        for (int d = 0; d < 8; d++) {
            int newRow = row + rowDir[d];
            int newCol = col + colDir[d];
            dfs(grid, newRow, newCol);
        }
    }

}