class Solution {
    public int orangesRotting(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 2) q.add(new int[] { i, j });
                if (arr[i][j] == 1) fresh++;
            }
        }
        if(fresh==0) return 0;

        int count = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            count++;
            for (int i = 0; i < size; i++) {
                int temp[] = q.remove();
                int x = temp[0], y = temp[1];
                if (x > 0 && arr[x - 1][y] == 1) {
                    arr[x - 1][y] = 2;
                    q.add(new int[] { x - 1, y });
                    fresh--;
                }
                if (y > 0 && arr[x][y - 1] == 1) {
                    arr[x][y - 1] = 2;
                    q.add(new int[] { x, y - 1 });
                    fresh--;
                }
                if (x < n - 1 && arr[x + 1][y] == 1) {
                    arr[x + 1][y] = 2;
                    q.add(new int[] { x + 1, y });
                    fresh--;
                }
                if (y < m - 1 && arr[x][y + 1] == 1) {
                    arr[x][y + 1] = 2;
                    q.add(new int[] { x, y + 1 });
                    fresh--;
                }

            }
        }
        if (fresh != 0) return -1;
        return count;
    }
}