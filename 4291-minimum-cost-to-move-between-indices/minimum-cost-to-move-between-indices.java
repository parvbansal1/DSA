class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int ans[] = new int[m];

        int[] close = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0)
                close[i] = 1;
            else if (i == n - 1)
                close[i] = n - 2;
            else {
                int left = nums[i] - nums[i - 1];
                int right = nums[i + 1] - nums[i];

                if (left <= right)
                    close[i] = i - 1;
                else
                    close[i] = i + 1;
            }
        }

        long sum1[] = new long[n];
        for (int i = 1; i < n; i++) {
            if (close[i - 1] == i)
                sum1[i] = sum1[i - 1] + 1;
            else
                sum1[i] = sum1[i - 1] + (nums[i] - nums[i - 1]);
        }

        long sum2[] = new long[n];
        for (int i = n - 2; i >= 0; i--) {
            if (close[i + 1] == i)
                sum2[i] = sum2[i + 1] + 1;
            else
                sum2[i] = sum2[i + 1] + (nums[i + 1] - nums[i]);
        }

        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l < r)
                ans[i] = (int) Math.abs(sum1[r] - sum1[l]);
            else
                ans[i] = (int) Math.abs(sum2[l] - sum2[r]);
        }

        return ans;
    }
}