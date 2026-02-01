class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int sum = nums[0];
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            if(nums[i]<min1){
                min2 = min1;
                min1 = nums[i];
            }
            else if(nums[i]<min2) min2 = nums[i];
        }
        sum += (min1+min2);
        return sum;
    }
}