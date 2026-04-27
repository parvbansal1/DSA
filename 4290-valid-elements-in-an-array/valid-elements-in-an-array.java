class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        int max = 0;
        for(int i=1;i<n;i++){
            left[i] = Math.max(left[i-1],max);
            max = Math.max(left[i-1],nums[i]);
        }
        right[n-1] = nums[n-1];
        max = 0;
        for(int i=n-2;i>=0;i--){
            right[i] = Math.max(right[i+1],max);
            max = Math.max(right[i+1],nums[i]);
        }

        for(int i=0;i<n;i++){
            if(i==0 || i==n-1) ans.add(nums[i]);
            else if(nums[i] > left[i] || nums[i] > right[i]) ans.add(nums[i]);
        }
        return ans;
    }
}