class Solution {
    public int minCost(int n, int[] arr) {
        int x = arr.length;
        int nums[] = new int[x+2];
        nums[x] = 0; nums[x+1] = n;
        for(int i=0;i<x;i++) nums[i] = arr[i];
        Arrays.sort(nums);
        int m = nums.length;
        int[][] dp = new int[m][m];

        for (int i = m - 2; i >= 0; i--) {
            for (int j = i + 1; j < m; j++) {

                if (j - i <= 1) {
                    dp[i][j] = 0;
                    continue;
                }

                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + (nums[j] - nums[i]);
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        return dp[0][m-1];

    }
}