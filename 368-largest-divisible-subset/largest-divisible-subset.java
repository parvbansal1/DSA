class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int len[] = new int[n]; // For Storing max len
        int prev[] = new int[n]; // Help to print longest seq
        int last = 0; // Stores last index of max seq
        for (int i = 0; i < n; i++) {
            len[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && len[i] < len[j] + 1) {
                    len[i] = len[j] + 1;
                    prev[i] = j;
                }
            }
            if (len[i] > len[last])
                last = i;
        }
        List<Integer> ans = new ArrayList<>();
        while (last != -1) {
            ans.add(0, nums[last]);
            last = prev[last];
        }
        return ans;
    }
}