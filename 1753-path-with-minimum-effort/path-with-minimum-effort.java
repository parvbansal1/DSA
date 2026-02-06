class Solution {
    public int minimumEffortPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans[][] = new int[n][m];
        for (int[] i : ans) {
            Arrays.fill(i, Integer.MAX_VALUE);
        }
        ans[0][0] = 0;

        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        q.add(new int[] { 0, 0, 0 });

        int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int arr[] = q.remove();
            int r = arr[0], c = arr[1], val = arr[2];
            
            // 🔥 Optimization 2
            if (val > ans[r][c]) continue;

            // 🔥 Optimization 1
            if (r == n - 1 && c == m - 1) return val;

            for (int a[] : dir) {
                int nr = r + a[0], nc = c + a[1];
                if (nr >= 0 && nr <= n - 1 && nc >= 0 && nc <= m - 1) {
                    int effort = Math.max(val, Math.abs(grid[nr][nc] - grid[r][c]));
                    if (effort < ans[nr][nc]) {
                        q.add(new int[] { nr, nc, effort });
                        ans[nr][nc] = effort;
                    }
                }
            }
        }
        return ans[n - 1][m - 1];
    }
}