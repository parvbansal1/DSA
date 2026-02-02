class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int land = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1)
                    land++;
            }
        }
        int count = 0;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1 ) {
                    if(grid[i][j] == 1){
                    count++;
                    grid[i][j] = 0;
                    q.add(new int[] { i, j });
                    }
                }
            }
        }
        int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int a = temp[0], b = temp[1];
            for (int x[] : dir) {
                int row = a + x[0];
                int col = b + x[1];
                if (row >= 0 && col >= 0 && row < n
                 && col < m && grid[row][col] == 1) {
                    count++;
                    grid[row][col] = 0;
                    q.add(new int[]{row,col});
                }
            }
        }
        return land - count;
    }
}