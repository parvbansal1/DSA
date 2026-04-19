class Solution {
    public int[][] colorGrid(int n, int m, int[][] num) {
        int arr[][] = new int[n][m];
        PriorityQueue<int[]> q = new PriorityQueue<>(
            (a,b) ->
            {
                if(a[3] == b[3]) return b[2] - a[2];
            return a[3] - b[3];
    });
        for (int i = 0; i < num.length; i++) {
            int a = num[i][0];
            int b = num[i][1];
            int c = num[i][2];
            arr[a][b] = c;
            q.add(new int[] { a, b, c, 0 });
        }

        int dir[][] = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

        while(!q.isEmpty()) {
            int temp[] = q.remove();
            int r = temp[0];
            int c = temp[1];
            int val = temp[2];
            int step = temp[3];
            for (int i[] : dir) {
                int nr = i[0] + r;
                int nc = i[1] + c;
                if (nr >= 0 && nc >= 0 && nr < n && nc < m && arr[nr][nc] == 0) {
                    arr[nr][nc] = val;
                    q.add(new int[] { nr, nc, val, step + 1 });
                }
            }
        }
        return arr;
    }
}