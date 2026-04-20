class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        arr[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            arr[i] = Math.max(nums[i], arr[i + 1]);
        }
        int min = nums[0];

        for (int i = 1; i < n - 1; i++) {
            if (min < nums[i] && nums[i] < arr[i + 1])
                return true;

            min = Math.min(min,nums[i]);
        }
        return false;
    }
}