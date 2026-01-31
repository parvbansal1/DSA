class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j]=='1'){
                    bfs(i,j,vis,grid);
                    count++;
                }
            }
        }
        return count;
    }
    public void bfs(int i, int j, boolean vis[][], char[][] arr){
        int n = arr.length;
        int m = arr[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int pos[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while(!q.isEmpty()){
            int[] tmp = q.remove();
            int row = tmp[0], col = tmp[1];
            for (int[] a : pos) {
                int nr = row + a[0];
                int nc = col + a[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < m &&
                        vis[nr][nc] == false && arr[nr][nc] == '1') {
                    q.add(new int[]{nr, nc});
                    vis[nr][nc] = true;
                }
            }
        }
    }
}