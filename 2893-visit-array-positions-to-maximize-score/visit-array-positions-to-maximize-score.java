class Solution {
    public long maxScore(int[] nums, int x) {
        int n = nums.length;
        long dp[][] = new long[n+1][2];
        for(long a[]:dp) Arrays.fill(a,-1);
        return score(0, x, nums[0] % 2, nums, dp);
    }

    public long score(int i, int x, int prev, int nums[], long dp[][]) {
        int n = nums.length;
        if (i == n) return 0;
        if(dp[i][prev]!=-1) return dp[i][prev];
        int curr = nums[i];
        if (curr % 2 == 0)
            curr = 0;
        else
            curr = 1;
        
        long take = nums[i] + score(i + 1, x, curr, nums, dp);
        long skip = score(i + 1, x, prev, nums, dp);
        if (curr != prev)
            take -= x;
        return dp[i][prev] = Math.max(take, skip);
    }
}