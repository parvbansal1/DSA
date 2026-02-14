class Solution {
    public double champagneTower(int poured, int row, int glass) {
        double[][] dp = new double[row + 2][row + 2];
        dp[0][0] = poured;

        for (int i = 0; i <= row; i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] > 1) {
                    double extra = (dp[i][j] - 1) / 2.0;
                    dp[i + 1][j] += extra;
                    dp[i + 1][j + 1] += extra;
                    dp[i][j] = 1;
                }
            }
        }
        return dp[row][glass];
    }
}
