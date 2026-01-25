class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int dp[][] = new int[n + 1][2];
        for (int a[] : dp)
            Arrays.fill(a, -1);
        return profit(0, 1, fee, prices, dp);
    }

    public int profit(int i, int buy, int fee, int arr[], int dp[][]) {
        if (i == arr.length)
            return 0;
        if (dp[i][buy] != -1)
            return dp[i][buy];
        if (buy == 1) {
            return dp[i][buy] = Math.max(-arr[i] + profit(i + 1, 0, fee, arr, dp),
                    profit(i + 1, buy, fee, arr, dp));
        } else {
            return dp[i][buy] = Math.max(+arr[i] + profit(i + 1, 1, fee, arr, dp) - fee,
                    profit(i + 1, buy, fee, arr, dp));
        }
    }
}