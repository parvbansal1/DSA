class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[2], b[2]));
        pq.add(new int[] { 0, -1, 0 });
        boolean vis[] = new boolean[n];
        int ans = 0;

        while (!pq.isEmpty()) {
            int arr[] = pq.remove();
            int node = arr[0], parent = arr[1], dist = arr[2];
            if (vis[node] == true)
                continue;
            ans += dist;
            vis[node] = true;

            for (int i = 0; i < n; i++) {
                if (i == node || i == parent)
                    continue;
                if (vis[i] == true)
                    continue;
                int x1 = points[node][0], x2 = points[node][1];
                int y1 = points[i][0], y2 = points[i][1];
                int mdis = Math.abs(x1 - y1) + Math.abs(x2 - y2);
                pq.add(new int[] { i, node, mdis });
            }
        }
        return ans;
    }
}