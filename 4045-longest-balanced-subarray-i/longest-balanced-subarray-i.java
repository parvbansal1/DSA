class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n ; i++) {
            HashSet<Integer> hs = new HashSet<>();
            int even = 0, odd = 0;
            for (int j = i; j < n; j++) {
                boolean evenFind = (nums[j] % 2 == 0) ? true : false;
                if (!hs.contains(nums[j])) {
                    hs.add(nums[j]);
                    if (evenFind) even++;
                    else odd++;
                }
                if (even == odd)
                    max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }
}
