class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        health -= grid.get(0).get(0);
        if(health <= 0) return false;
        
        int[][] vis = new int[n][m];
        for(int i = 0; i < n; i++){
            Arrays.fill(vis[i], -1);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, health});
        vis[0][0] = health;
        
        int[][] dir = {{1,0},{0,1},{-1,0},{0,-1}};
        
        while(!q.isEmpty()){
            int[] arr = q.poll();
            int row = arr[0];
            int col = arr[1];
            int currHealth = arr[2];
            
            if(row == n-1 && col == m-1 && currHealth >= 0)
                return true;
            
            for(int[] d : dir){
                int nr = row + d[0];
                int nc = col + d[1];
                
                if(nr >= 0 && nr < n && nc >= 0 && nc < m){
                    
                    int newHealth = currHealth;
                    if(grid.get(nr).get(nc) == 1){
                        newHealth--;
                    }
                    
                    if(newHealth > 0 && newHealth > vis[nr][nc]){
                        vis[nr][nc] = newHealth;
                        q.add(new int[]{nr, nc, newHealth});
                    }
                }
            }
        }
        return false;
    }
}