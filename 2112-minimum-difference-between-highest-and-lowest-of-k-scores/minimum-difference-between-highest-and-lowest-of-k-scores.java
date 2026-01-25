class Solution {
    public int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = n - 1; i >= k - 1; i--) {
            ans = Math.min(ans, nums[i] - nums[i - k + 1]);
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}