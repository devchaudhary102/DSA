class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int[] e : dp) {
            Arrays.fill(e, -1);
        }

        return longest(s, 0, n - 1, dp);
    }

    public int longest(String s, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }
        if (i == j) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s.charAt(i) == s.charAt(j)) {
            int count = longest(s, i + 1, j - 1, dp);
            return dp[i][j] = count;
        } else {
            int first = longest(s, i + 1, j, dp);
            int sec = longest(s, i, j - 1, dp);
            return dp[i][j] = Math.min(first, sec) + 1;
        }
    }
}