class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int ans1[] = new int[n];
        int ans2[] = new int[n];
        ans1[0] = nums[0];
        ans2[n-1] = nums[n-1];

        for(int i=1;i<n;i++){
            ans1[i] = ans1[i-1] * nums[i];
        }

        for(int i=n-2;i>=0;i--){
            ans2[i] = ans2[i+1] * nums[i];
        }

        for(int i=0;i<n;i++){
            if(i==0) nums[i] = ans2[i+1];
            else if(i==n-1) nums[i] = ans1[i-1];
            else nums[i] = ans1[i-1] * ans2[i+1];
        }
        return nums;
    }
}