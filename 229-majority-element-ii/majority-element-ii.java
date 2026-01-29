class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int m = n / 3;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> h : hm.entrySet()) {
            if (h.getValue() > m) ans.add(h.getKey());
        }
        return ans;
    }
}