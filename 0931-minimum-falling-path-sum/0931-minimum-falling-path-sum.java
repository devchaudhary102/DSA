class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        int[][] dp = new int[n][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        int minSum = Integer.MAX_VALUE;
        
        for (int col = 0; col < n; col++) {
            minSum = Math.min(minSum, solve(0, col, matrix, dp, n));
        }
        
        return minSum;
    }
    
    private int solve(int row, int col, int[][] matrix, int[][] dp, int n) {
        if (col < 0 || col >= n) {
            return (int) 1e9;
        }
        
        
        if (row == n - 1) {
            return matrix[row][col];
        }
        
        if (dp[row][col] != Integer.MAX_VALUE) {
            return dp[row][col];
        }
        
        int leftDiagonal = solve(row + 1, col - 1, matrix, dp, n);
        int down = solve(row + 1, col, matrix, dp, n);
        int rightDiagonal = solve(row + 1, col + 1, matrix, dp, n);
        
        dp[row][col] = matrix[row][col] + Math.min(leftDiagonal, Math.min(down, rightDiagonal));
        
        return dp[row][col];
    }
}