class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int s = find(nums2, nums1[i], i);
            max = Math.max(max, s - i);
        }
        return max;
    }

    public int find(int arr[], int num, int i) {
        int j = arr.length - 1;
        while (i <= j) {
            int mid = i + (j - i) / 2;
            if (arr[mid] < num) {
                j = mid - 1;
            } else
                i = mid + 1;
        }
        return i - 1;
    }
}