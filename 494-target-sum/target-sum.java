class Solution {
    static int sum;
    public int exp(int n, int res,int k, int nums[], int dp[][]) {
        if (n == 0) {
            if (res == k) return 1;
            else return 0;
        }
        if(dp[n][res+sum]!=-1) return dp[n][res+sum];
        return dp[n][res+sum] = exp(n - 1, res - nums[n - 1], k, nums, dp) +
         exp(n - 1, res + nums[n - 1], k, nums, dp);

    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        sum = 0;
        for(int a:nums) sum += a;
        int dp[][] = new int[n+1][2*sum+1];
        for(int a[]:dp) Arrays.fill(a,-1);
        return exp(n, 0, target, nums, dp);
    }
}