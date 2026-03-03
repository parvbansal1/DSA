class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums) hs.add(i);

        List<Integer> ans = new ArrayList<>();
        for (int i = 1; i <= nums.length; i++) {
            if (!hs.contains(i)) ans.add(i);
        }
        return ans;
    }
}