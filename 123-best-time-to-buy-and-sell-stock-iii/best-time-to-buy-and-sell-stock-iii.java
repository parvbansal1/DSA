class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][][] = new int[n + 1][3][2];
        for (int a[][] : dp) {
            for (int b[] : a)
                Arrays.fill(b, -1);
        }
        return ans(0, 2, 1, n, prices, dp);
    }

    public int ans(int day, int trans, int buy, int n, int arr[],
            int dp[][][]) {
        if (day == n || trans == 0)
            return 0;
        if (dp[day][trans][buy] != -1)
            return dp[day][trans][buy];
        if (buy == 1) {
            return dp[day][trans][buy] = 
            Math.max(-arr[day] + ans(day + 1, trans, 0, n, arr, dp),
                    ans(day + 1, trans, 1, n, arr, dp));
        } else {
            return dp[day][trans][buy] = 
            Math.max(arr[day] + ans(day + 1, trans - 1, 1, n, arr, dp),
                    ans(day + 1, trans, 0, n, arr, dp));
        }
    }
}