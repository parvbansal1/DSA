class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int len[] = new int[n];
        int max = -1;
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && 1 + len[j] > len[i]) {
                    len[i] = 1 + len[j];
                }
            }
            max = Math.max(max, len[i]);
        }
        return max;
    }
}