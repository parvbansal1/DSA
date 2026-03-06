class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i : nums) hm.put(i, hm.getOrDefault(i, 0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int key : hm.keySet()) {
            pq.add(new int[] { key, hm.get(key) });
            if (pq.size() > k) pq.remove();
        }

        int[] ans = new int[k];
        int i = 0;
        while (pq.size() > 0) {
            ans[i++] = pq.remove()[0];
        }
        return ans;
    }
}