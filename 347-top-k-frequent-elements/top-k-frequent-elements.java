class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i : nums){
            hm.put(i, hm.getOrDefault(i,0) + 1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[1] - a[1]
        );
        for(int i : nums){
            if(hm.containsKey(i)){
                pq.add(new int[]{i, hm.get(i)} );
                hm.remove(i);
            }
        }
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            int temp[] = pq.remove();
            ans[i] = temp[0];
        }
        return ans;
    }
}