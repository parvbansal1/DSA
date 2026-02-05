class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int ind[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j:graph[i]){
                adj.get(j).add(i);
                ind[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(ind[i]==0) q.add(i);
        }
        // q.add(graph[0]);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int temp = q.remove();
            ans.add(temp);
            for(int i:adj.get(temp)){
                ind[i]--;
                if(ind[i]==0) q.add(i);
            }
        }
        Collections.sort(ans);
        return ans;
    }
}