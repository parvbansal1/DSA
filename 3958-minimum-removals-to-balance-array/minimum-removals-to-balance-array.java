class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int i = 0, j = 0;
        int max = 0;
        while (j < n) {
            if ((long) nums[i] * k >= nums[j]) {
                max = Math.max(max, j - i + 1);
                j++;
            }
            else i++;
        }
        return n - max;
    }
}