class Solution {
    public void solve(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean arr[][] = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 'O' && arr[i][j] == false) {
                        q.add(new int[] { i, j });
                        arr[i][j] = true;
                    }
                }
            }
        }

        int pos[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int[] tmp = q.remove();
            int row = tmp[0], col = tmp[1];
            for (int[] a : pos) {
                int nr = row + a[0];
                int nc = col + a[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && grid[nr][nc] == 'O' && arr[nr][nc] == false) {
                    q.add(new int[] { nr, nc });
                    arr[nr][nc] = true;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O' && arr[i][j] == false) {
                    grid[i][j] = 'X';
                }
            }
        }
    }
}