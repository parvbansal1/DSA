class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]==1) return -1;
        if(n==1) return 1;
        Queue<int[]> q = new LinkedList<>();
        boolean vis[][] = new boolean[n][m];
        vis[0][0] = true;
        q.add(new int[]{0,0,1});

        int dir[][] = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};

        while(!q.isEmpty()){
            int arr[] = q.remove();
            int r = arr[0], c = arr[1], val = arr[2];
            for(int a[]:dir){
                int nr = r + a[0], nc = c + a[1];
            if(nr>=0 && nr<=n-1 && nc>=0 && nc<=m-1 && !vis[nr][nc] && grid[nr][nc] == 0){
                if(nr == n-1 && nc == m-1) return val + 1;
                q.add(new int[]{nr,nc,val+1});
                vis[nr][nc] = true;
            }
            }
        }
        return -1;

    }
}