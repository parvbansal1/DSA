class Solution {
    public int[][] floodFill(int[][] arr, int sr, int sc, int color) {
        int n = arr.length;
        int m = arr[0].length;

        int oldColor = arr[sr][sc];
        if (oldColor == color) return arr;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { sr, sc });
        boolean vis[][] = new boolean[n][m];
        vis[sr][sc] = true;
        arr[sr][sc] = color;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int temp[] = q.remove();
                int x = temp[0], y = temp[1];

                if (x > 0 && arr[x - 1][y] == oldColor && !vis[x-1][y] ) {
                    arr[x - 1][y] = color;
                    q.add(new int[] { x - 1, y });
                    vis[x-1][y] = true;
                }
                if (y > 0 && arr[x][y - 1] == oldColor && !vis[x][y-1] ) {
                    arr[x][y - 1] = color;
                    q.add(new int[] { x, y - 1 });
                    vis[x][y-1] = true;
                }
                if (x < n - 1 && arr[x + 1][y] == oldColor && !vis[x+1][y] ) {
                    arr[x + 1][y] = color;
                    q.add(new int[] { x + 1, y });
                    vis[x+1][y] = true;
                }
                if (y < m - 1 && arr[x][y + 1] == oldColor && !vis[x][y+1] ) {
                    arr[x][y + 1] = color;
                    q.add(new int[] { x, y + 1 });
                    vis[x][y+1] = true;
                }

            }
             
        }
        return arr;
    }
}