class Solution {
    public int maxDistance(int[] nums) {
        int n = nums.length;
        int max = 0;
        int i = 0, j = n - 1;
        while(i < j){
            if(nums[i] != nums[j]) {
                max = Math.max(max,j-i);
                i++;
                j = n - 1;
            }
            else j--;
        }
        return max;
    }
}