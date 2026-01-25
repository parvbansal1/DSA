class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int dp[][] = new int[n+1][n+1];
        for(int i[]:dp) Arrays.fill(i,-1);
        return LIS(0, -1, nums, dp);
    }

    public int LIS(int i, int prev, int arr[], int dp[][]) {
        int n = arr.length;
        if (i == n) return 0;
        if(dp[n][prev+1]!=-1) return dp[n][prev+1];
        int skip = LIS(i + 1, prev, arr, dp);
        int take = 0;
        if (prev == -1 || arr[i] > arr[prev]) {
            take = 1 + LIS(i + 1, i, arr, dp);
        }
        return dp[n][prev+1] = Math.max(take, skip);
    }
}