class Solution {
    public List<Boolean> checkIfPrerequisite(int n, int[][] arr, int[][] queries) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int ind[] = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int u = arr[i][0];
            int v = arr[i][1];
            adj.get(u).add(v);
            ind[v]++;
        }
        boolean[][] pre = new boolean[n][n];

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (ind[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int top = q.remove();
            for (int v : adj.get(top)) {
                pre[top][v] = true;

                for (int i = 0; i < n; i++) {
                    if (pre[i][top]) pre[i][v] = true;
                }

                ind[v]--;
                if (ind[v] == 0) q.add(v);
            }
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] q1 : queries) {
            ans.add(pre[q1[0]][q1[1]]);
        }

        return ans;
    }
}