class Solution {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][k + 1][2];
        for (int a[][] : dp) {
            for (int b[] : a)
                Arrays.fill(b, -1);
        }
        return profit(0, k, 1, prices, dp);
    }

    public int profit(int i, int trans, int buy, int arr[], int dp[][][]) {
        int n = arr.length;
        if (i == n || trans == 0)
            return 0;
        if (dp[i][trans][buy] != -1)
            return dp[i][trans][buy];
        if (buy == 1) {
            return dp[i][trans][buy] = 
            Math.max(-arr[i] + profit(i + 1, trans, 0, arr, dp),
                    profit(i + 1, trans, 1, arr, dp));
        } else
            return dp[i][trans][buy] = 
            Math.max(+arr[i] + profit(i + 1, trans - 1, 1, arr, dp),
                    profit(i + 1, trans, 0, arr, dp));
    }
}