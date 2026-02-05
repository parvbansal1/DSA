class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        for(int i=0;i<n;i++){
            if(nums[i]>0){
                ans[i] = nums[ (i + nums[i]) % n];
            }
            else if(nums[i] == 0){
                ans[i] = nums[i];
            }
            else{
                int a = (i - Math.abs(nums[i])) % n;
                if(a<0) a = n + a; 
                ans[i] = nums[a];
            }
        }
        return ans;
    }
}