class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int max = 0, j = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==1) j++;
            else j = 0;
            max = Math.max(j,max);
        }
        return max;
    }
}