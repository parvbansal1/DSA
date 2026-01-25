class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];
        for (int b[] : dp) Arrays.fill(b, -1);
        return profit(0, 1, prices, dp);
    }

    public int profit(int i, int buy, int arr[], int dp[][]) {
        // Cooldown is used static condition 
        int n = arr.length;
        if (i >= n) return 0;
        if (dp[i][buy] != -1)
            return dp[i][buy];
        if (buy == 1) {
            return dp[i][buy] = Math.max(-arr[i] + profit(i + 1, 0, arr, dp),
                    profit(i + 1, 1, arr, dp));
        } else
            return dp[i][buy] = Math.max(+arr[i] + profit(i + 2, 1, arr, dp),
                    profit(i + 1, 0, arr, dp));
    }
}