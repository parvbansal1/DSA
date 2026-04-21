class Solution {
    int n;
    int dp[][][];
    public int maxProfit(int[] prices) {
        n = prices.length;
        dp = new int[n][2][3];
        for(int i[][]:dp){
            for(int j[] : i) Arrays.fill(j,-1);
        }
        return func(prices, 0, 1, 2);
    }
    public int func(int arr[], int i, int buy, int day){
        if(i == n || day == 0) return 0;
        if(dp[i][buy][day] != -1) return dp[i][buy][day];

        if(buy == 1){
            int take = -arr[i] + func(arr,i+1,0, day);
            int skip = func(arr,i+1,buy,day);
            return dp[i][buy][day] = Math.max(take,skip);
        }
        else{
            int take = arr[i] + func(arr,i+1,1, day-1);
            int skip = func(arr,i+1,buy,day);
            return dp[i][buy][day] = Math.max(take,skip);
        }
    }
}