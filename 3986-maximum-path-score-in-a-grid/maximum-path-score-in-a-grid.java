class Solution {
    int n;
    int m;
    int dp[][][];
    private static final int[] cost = { 0, 1, 1 };

    public int maxPathScore(int[][] grid, int k) {
        n = grid.length;
        m = grid[0].length;
        dp = new int[n][m][k + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                Arrays.fill(dp[i][j], -1);
        }
        int ans = func(grid, 0, 0, k);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }

    public int func(int grid[][], int i, int j, int k) {
        if (k < 0 || i > n - 1 || j > m - 1) {
            return Integer.MIN_VALUE;
        }
        int val = cost[grid[i][j]];
        if (i == n - 1 && j == m - 1) {
            return (k - val >= 0) ? grid[i][j] : Integer.MIN_VALUE;
        }
        if (dp[i][j][k] != -1)
            return dp[i][j][k];

        int down = func(grid, i + 1, j, k - val);
        int right = func(grid, i, j + 1, k - val);

        int res = Math.max(down, right);

        if (res == Integer.MIN_VALUE)
            return dp[i][j][k] = Integer.MIN_VALUE;
        return dp[i][j][k] = grid[i][j] + res;
    }
}