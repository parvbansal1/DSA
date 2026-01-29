class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        if (n <= 1)
            return nums;
        int ans[] = new int[n];
        int j = 0, k = 0;
        while(nums[j]<0) j++;
        while(nums[k]>0) k++;

        for (int i = 0; i < n; i++) {
           if(i%2==0){
            ans[i] = nums[j++];
            while(j<n && nums[j]<0) j++;
           }
           else{
            ans[i] = nums[k++];
            while(k<n && nums[k]>0) k++;
           }
        }
        return ans;
    }
}