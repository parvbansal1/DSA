class Solution {
    public int countPaths(int n, int[][] roads) {
        // int n = roads.length;
        int mod = 1000000007;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];
            int c = roads[i][2];
            adj.get(a).add(new int[] { b, c });
            adj.get(b).add(new int[] { a, c });
        }

        long time[] = new long[n];
        Arrays.fill(time, Long.MAX_VALUE);
        time[0] = 0;

        int path[] = new int[n];
        path[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>(
                Comparator.comparingLong(a -> a[0]));

        pq.offer(new long[] { 0, 0 });

        while (!pq.isEmpty()) {
            long arr[] = pq.remove();
            long currTime = arr[0];
            int currNode = (int) arr[1];
            if (currTime > time[currNode]) continue;

            for (int[] neighbor : adj.get(currNode)) {
                int node = neighbor[0], roadTime = neighbor[1];

                // Found a new shortest path → Update shortest time and reset path count
                if (currTime + roadTime < time[node]) {
                    time[node] = currTime + roadTime;
                    path[node] = path[currNode];
                    pq.offer( new long[] { time[node], node });
                }

                // Found another way with the same shortest time → Add to path count
                else if (currTime + roadTime == time[node]) {
                    path[node] = (path[node] + path[currNode]) % mod;
                }
            }
        }
        return path[n-1];

    }
}