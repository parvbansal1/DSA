class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int min[] = new int[n];
        int min0 = nums[n-1];
        for(int i=n-1;i>=0;i--){
            min0 = Math.min(min0,nums[i]);
            min[i] = min0;
        }

        int max = 0;
        int ans = Integer.MAX_VALUE;
        int ind = -1;
        for(int i=0;i<n;i++){
            max = Math.max(max,nums[i]);
            int inst = max - min[i];
            if(inst <= k){
                return i;
            }
        }
        return ind;
    }
}