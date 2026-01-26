class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int prev[] = new int[n];
        int gsize[] = new int [n];
        int max = 0;
        for(int i=0;i<n;i++){
            prev[i] = -1;
            gsize[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[i]%nums[j]==0){
                    if(gsize[i]<1+gsize[j]){
                        gsize[i] = 1 + gsize[j];
                        prev[i] = j;
                    }
                }
            }
            if(gsize[max]<gsize[i]) max = i;
        }
        List<Integer> ans = new ArrayList<>();
        while(max!=-1){
            ans.add(0 ,nums[max]);
            max = prev[max];
        }
        return ans;
    }
}