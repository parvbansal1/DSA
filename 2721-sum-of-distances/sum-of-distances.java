class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (!hm.containsKey(nums[i])) {
                hm.put(nums[i], new ArrayList<>());
            }
            hm.get(nums[i]).add(i);
        }
        long arr[] = new long[n];
        for (List<Integer> temp : hm.values()) {
            int size = temp.size();

            long total = 0;
            for (int x : temp) total += x;

            long leftSum = 0;

            for (int j = 0; j < size; j++) {
                int idx = temp.get(j);
                long left = (long) j * idx - leftSum;
                long right = (total - leftSum - idx) - (long)
                 (size - j - 1) * idx;

                arr[idx] = left + right;
                leftSum += idx;
            }
        }

        return arr;
    }
}