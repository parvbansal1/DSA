class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for(int a:nums) hs.add(a);
        for(int i=0;i<=n;i++){
            if(!hs.contains(i)) return i;
        }
        return 0;
    }
}