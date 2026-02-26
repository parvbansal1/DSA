class Solution {
    public int findTheCity(int n, int[][] edges, int thr) {
        int arr[][] = new int[n][n];
        for (int a[] : arr)
            Arrays.fill(a, Integer.MAX_VALUE);
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            arr[u][v] = wt;
            arr[v][u] = wt;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                if (i == k) continue;
                for (int j = 0; j < n; j++) {
                    if (j == k) continue;
                    if (arr[i][k] != Integer.MAX_VALUE &&
                            arr[j][k] != Integer.MAX_VALUE) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[j][k]);
                    }
                }
            }
        }

        int minCity = -1;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (arr[i][j] <= thr) count++;
            }
            if (count <= minCount) {
                minCount = count;
                minCity = i;
            }
        }
        return minCity;
    }
}