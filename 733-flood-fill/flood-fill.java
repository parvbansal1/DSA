class Solution {
    public int[][] floodFill(int[][] arr, int sr, int sc, int color) {
        int n = arr.length;
        int m = arr[0].length;

        int oldColor = arr[sr][sc];
        if (oldColor == color) return arr;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{sr, sc});
        arr[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] temp = q.remove();
            int x = temp[0], y = temp[1];

            if (x > 0 && arr[x-1][y] == oldColor) {
                arr[x-1][y] = color;
                q.add(new int[]{x-1, y});
            }
            if (y > 0 && arr[x][y-1] == oldColor) {
                arr[x][y-1] = color;
                q.add(new int[]{x, y-1});
            }
            if (x < n-1 && arr[x+1][y] == oldColor) {
                arr[x+1][y] = color;
                q.add(new int[]{x+1, y});
            }
            if (y < m-1 && arr[x][y+1] == oldColor) {
                arr[x][y+1] = color;
                q.add(new int[]{x, y+1});
            }
        }
        return arr;
    }
}
