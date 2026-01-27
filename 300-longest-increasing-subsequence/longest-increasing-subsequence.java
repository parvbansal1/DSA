class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int len[] = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int h = nums[i];
            int lo = 0, hi = max - 1;
            while (lo <= hi) {
                int mid = lo + (hi - lo) / 2;
                if (len[mid] >= h) hi = mid - 1;
                else lo = mid + 1;
            }

            len[lo] = h;
            if (lo == max) max++;
        }
        return max;
    }
}