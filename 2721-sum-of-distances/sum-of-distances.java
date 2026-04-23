class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Long> hm1 = new HashMap<>();
        HashMap<Integer, Long> hm2 = new HashMap<>();
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            long c = hm1.getOrDefault(val, 0L);
            long s = hm2.getOrDefault(val, 0L);
            ans[i] += c * i - s;
            hm1.put(val, c + 1);
            hm2.put(val, s + i);
        }
        hm1.clear();
        hm2.clear();
        for (int i = n - 1; i >= 0; i--) {
            int val = nums[i];
            long c = hm1.getOrDefault(val, 0L);
            long s = hm2.getOrDefault(val, 0L);
            ans[i] += s - c * i;
            hm1.put(val, c + 1);
            hm2.put(val, s + i);
        }
        return ans;
    }
}