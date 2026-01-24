class Solution {
    public int exp(int n, int pos, int k, int nums[]) {
        if (n == 0) {
            if (k == 0) return 1;
            else return 0;
        }
        return exp(n - 1, 0, k - nums[n - 1], nums) +
         exp(n - 1, 1, k + nums[n - 1], nums);

    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        return exp(n, 1, target, nums);
    }
}