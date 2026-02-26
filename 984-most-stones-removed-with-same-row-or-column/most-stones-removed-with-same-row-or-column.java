class Solution {
    public int removeStones(int[][] arr) {
         int n = arr.length;
        boolean vis[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                bfs(i, arr, vis);
                count++;
            }
        }
        return n - count;
    }

    public void bfs(int idx, int arr[][], boolean vis[]) {
        vis[idx] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(idx);
        while (!q.isEmpty()) {
            int curr = q.poll();
            for (int i = 0; i < arr.length; i++) {
                if (!vis[i] && (arr[curr][0] == arr[i][0] ||
                        arr[curr][1] == arr[i][1])) {
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
    }
}