class Solution {
    int n;
    int dp[][];
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2];
        for(int i[]:dp){
            Arrays.fill(i,-1);
        }
        return func(prices, 0, 1);
    }
    public int func(int arr[], int i, int buy){
        if(i == n) return 0;
        if(dp[i][buy] != -1) return dp[i][buy];

        if(buy == 1){
            int take = -arr[i] + func(arr,i+1,0);
            int skip = func(arr,i+1,buy);
            return dp[i][buy] = Math.max(take,skip);
        }
        else{
            int take = arr[i] + func(arr,i+1,1);
            int skip = func(arr,i+1,buy);
            return dp[i][buy] = Math.max(take,skip);
        }
    }
}