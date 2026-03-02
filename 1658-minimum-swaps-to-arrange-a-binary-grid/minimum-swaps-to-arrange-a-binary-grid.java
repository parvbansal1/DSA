class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = -1;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    arr[i] = j;
                    break;
                }
            }
        }

        int swaps = 0;

        for (int i = 0; i < n; i++) {
            int row = i;

            while (row < n && arr[row] > i) row++;

            if (row == n) {
                return -1;  // Not possible
            }

            while (row > i) {
                int temp = arr[row];
                arr[row] = arr[row - 1];
                arr[row - 1] = temp;

                row--;
                swaps++;
            }
        }

        return swaps;
    }
}