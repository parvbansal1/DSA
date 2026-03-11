class Solution {
    public int thirdMax(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int i : nums)
            hs.add(i);
        List<Integer> ans = new ArrayList<>();
        for (int i : hs)
            ans.add(i);
        Collections.sort(ans);
        if (ans.size() == 1)
            return ans.get(0);
        if (ans.size() == 2)
            return ans.get(1);
        return ans.get(ans.size() - 3);
    }
}