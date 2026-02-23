class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        // Arrays.sort(nums);
        int ans = Integer.MAX_VALUE;
        int min = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(nums[i] + nums[j] + nums[k] - target) < ans) {
                        ans = Math.abs(nums[i] + nums[j] + nums[k] - target );
                        min = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return min;
    }
}