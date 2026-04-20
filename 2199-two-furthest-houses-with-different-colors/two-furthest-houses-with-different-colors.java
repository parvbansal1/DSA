class Solution {
    public int maxDistance(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int j = n - 1; j >= 0; j--) {
            if (nums[j] != nums[0]) {
                max = Math.max(max, j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (nums[i] != nums[n - 1]) {
                max = Math.max(max, n - 1 - i);
            }
        }
        return max;
    }
}