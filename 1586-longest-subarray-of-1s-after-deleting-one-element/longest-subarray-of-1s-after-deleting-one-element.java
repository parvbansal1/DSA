class Solution {
    public int longestSubarray(int[] nums) {
        int max = 0;
        int last_pos = 0;
        int zero = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zero++;
                if (zero > 1) left = last_pos + 1;
                last_pos = right;
            }
            max = Math.max(max, right - left);
        }
        return max;
    }
}