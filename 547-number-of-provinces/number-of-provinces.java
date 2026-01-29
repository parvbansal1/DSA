class Solution {
    public int findCircleNum(int[][] arr) {
        int n = arr.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i==j) continue;
                if (arr[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean vis[] = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!vis[i]){
                dfs(i,vis,adj);
                count++;
            }
        }
        return count;
    }
    public void dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj){
        vis[i] = true;
        for(int x:adj.get(i)){
            if(!vis[x]){
                dfs(x,vis,adj);
            }
        }
    }
}