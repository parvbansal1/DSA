class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean vis[][] = new boolean[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    max = Math.max( max, bfs(i, j, grid, vis) );
                }
            }
        }
        return max;
    }

    public int bfs(int i, int j, int arr[][], boolean vis[][]) {
        int n = arr.length;
        int m = arr[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        vis[i][j] = true;
        int dir[][] = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
        int count = 1;
        while (!q.isEmpty()) {
            int[] tmp = q.remove();
            int r = tmp[0], c = tmp[1];
            for(int a[]:dir){
                int nr = a[0] + r, nc = a[1] + c;
                if(nr>=0 && nc>=0 && nr<=n-1 && nc<=m-1 && arr[nr][nc]==1 && !vis[nr][nc]){
                    count++;
                    q.add(new int[]{nr,nc});
                    vis[nr][nc] = true;
                }
            }
        }
        return count;
    }
}