class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for(int i:nums) hs.add(i);
        if(nums.length != hs.size()) return true;
        return false;
    }
}