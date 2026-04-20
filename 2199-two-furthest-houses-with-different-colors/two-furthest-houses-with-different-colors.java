class Solution {
    public int maxDistance(int[] nums) {
        int max = 0;
        int i = 0, j = nums.length - 1;
        
        for (int k = 0; k <= j; k++) {
            for (int m = i; m <= j; m++) {
                if (nums[k] != nums[m])
                    max = Math.max(max, m - k);
            }
        }
        return max;
    }
}