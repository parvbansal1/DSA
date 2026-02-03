class Solution {
    public boolean canFinish(int n, int[][] arr) {
        int m = arr.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int deg[] = new int[n];
        for(int i=0;i<m;i++){
            int a = arr[i][0];
            int b = arr[i][1];
            adj.get(b).add(a);
            deg[a]++;
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
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
        return res.size()==n;
    }
}