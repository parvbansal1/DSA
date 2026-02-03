class Solution {
    public int[] findOrder(int n, int[][] arr) {
        int m = arr.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int deg[] = new int[n];
        for(int i=0;i<m;i++){
            int x = arr[i][0];
            int y = arr[i][1];
            adj.get(y).add(x);
            deg[x]++;
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(deg[i]==0) q.add(i);
        }
        while(!q.isEmpty()){
            int temp = q.remove();
            res.add(temp);
            for(int i:adj.get(temp)){
                deg[i]--;
                if(deg[i]==0) q.add(i);
            }
        }
        if(res.size()!=n) return new int[]{};
        int ans[] = new int[res.size()];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}