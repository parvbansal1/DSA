class Solution {
    public int[][] highestPeak(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int ans[][] = new int[n][m];
        for (int[] row : ans)
            Arrays.fill(row, -1);
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    ans[i][j] = 0;
                    q.add(new int[]{i,j});
                }
            }
        }
        
      int pairs[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        while (q.size() > 0) {
            int[] temp = q.remove();
            int x = temp[0];
            int y = temp[1];

            for (int[] p : pairs) {
                int row = x + p[0], col = y + p[1];
                if (row >= 0 && col >= 0 && row < n 
                           && col < m && ans[row][col] == -1) {
                    ans[row][col] = ans[x][y] + 1;
                    q.add(new int[] { row, col });
                }
            }
        }
        return ans;
    }
}