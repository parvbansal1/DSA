class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(max, bfs(i, j, grid));
                }
            }
        }
        return max;
    }

    public int bfs(int i, int j, int[][] grid) {
        int n = grid.length, m = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        grid[i][j] = 0;  

        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        int count = 1;

        while (!q.isEmpty()) {
            int[] cur = q.remove();
            for (int[] d : dir) {
                int nr = cur[0] + d[0];
                int nc = cur[1] + d[1];

                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 1) {
                    count++;
                    grid[nr][nc] = 0;
                    q.add(new int[]{nr, nc});
                }
            }
        }
        return count;
    }
}