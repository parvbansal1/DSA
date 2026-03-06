class Solution {
    public boolean exist(char[][] arr, String word) {
        int n = arr.length;
        int m = arr[0].length;

        int freq[] = new int[128];
        for (char i[] : arr) {
            for (char c : i) {
                freq[c]++;
            }
        }
        for (char c : word.toCharArray()) {
            if (--freq[c] < 0)
                return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == word.charAt(0) && dfs(i, j, arr, word, 0))
                    return true;
            }
        }
        return false;
    }

    public boolean dfs(int i, int j, char[][] arr, String word, int k) {
        int n = arr.length;
        int m = arr[0].length;

        if (k == word.length())
            return true;

        if (i < 0 || j < 0 || i >= n || j >= m || arr[i][j] != word.charAt(k))
            return false;

        char temp = arr[i][j];
        arr[i][j] = '.';

        boolean ans = dfs(i + 1, j, arr, word, k + 1) || dfs(i - 1, j, arr, word, k + 1)
                || dfs(i, j + 1, arr, word, k + 1) || dfs(i, j - 1, arr, word, k + 1);

        arr[i][j] = temp;

        return ans;
    }
}