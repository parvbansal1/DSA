class Solution {
    public int[] shuffle(int[] nums, int n) {
        int j = n;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(nums[i]);
            ans.add(nums[j]);
            j++;
        }
        for(int i=0;i<2*n;i++){
            nums[i] = ans.get(i);
        }
        return nums;
    }
}