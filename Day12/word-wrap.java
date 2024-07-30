package Day12;

class Solution {
    public int solveWordWrap(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int[][] cost = new int[n][n];
        
       
        for (int i = 0; i < n; i++) {
            int currentLineLength = -1;
            for (int j = i; j < n; j++) {
                currentLineLength += (nums[j] + 1); 
                if (currentLineLength > k) {
                    cost[i][j] = Integer.MAX_VALUE; 
                } else if (j == n - 1) {
                    cost[i][j] = 0; 
                } else {
                    cost[i][j] = (k - currentLineLength) * (k - currentLineLength);
                }
            }
        }
        
        // Initialize dp array with max value
        for (int i = 0; i < n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        
        // Fill the dp array
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (cost[i][j] == Integer.MAX_VALUE) continue;
                if (j + 1 < n) {
                    dp[i] = Math.min(dp[i], cost[i][j] + dp[j + 1]);
                } else {
                    dp[i] = Math.min(dp[i], cost[i][j]);
                }
            }
        }
        
        return dp[0];
    }
}
