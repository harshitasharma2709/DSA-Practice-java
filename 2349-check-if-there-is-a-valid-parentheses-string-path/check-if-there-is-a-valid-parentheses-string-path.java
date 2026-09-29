class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Odd length can never be valid
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        boolean[][][] dp = new boolean[m][n][m + n];

        int first = grid[0][0] == '(' ? 1 : -1;

        if (first < 0) {
            return false;
        }

        dp[0][0][first] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int bal = 0; bal < m + n; bal++) {

                    if (!dp[i][j][bal]) {
                        continue;
                    }

                    if (i + 1 < m) {
                        int newBal = bal +
                            (grid[i + 1][j] == '(' ? 1 : -1);

                        if (newBal >= 0) {
                            dp[i + 1][j][newBal] = true;
                        }
                    }

                    if (j + 1 < n) {
                        int newBal = bal +
                            (grid[i][j + 1] == '(' ? 1 : -1);

                        if (newBal >= 0) {
                            dp[i][j + 1][newBal] = true;
                        }
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}