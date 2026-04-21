class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int max = 0;
        int pos = 0;
        int zero = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                zero++;
                if (zero > 1) {
                    j = pos + 1;
                    pos = i;
                }
                pos = i;
            }
            max = Math.max(max, i - j);
        }
        return max;
    }
}