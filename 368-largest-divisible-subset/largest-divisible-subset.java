class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int prev[] = new int[n];
        int group[] = new int[n];
        int maxIn = 0;
        for (int i = 0; i < n; i++) {
            group[i] = 1;
            prev[i] = -1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0) {
                    if (group[i] < 1 + group[j]) {
                        group[i] = 1 + group[j];
                        prev[i] = j;
                    }
                }
            }
            if (group[i] > group[maxIn])
                maxIn = i;
        }

        List<Integer> ans = new ArrayList<>();
        while (maxIn != -1) {
            ans.add(0, nums[maxIn]);
            maxIn = prev[maxIn];
        }
        return ans;
    }
}