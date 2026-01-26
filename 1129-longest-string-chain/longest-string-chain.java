class Solution {
    public int longestStrChain(String[] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> a.length() - b.length());
        int dp[] = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i].length() == arr[j].length() + 1) {
                    if (isPredecessor(arr[j], arr[i])) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public boolean isPredecessor(String x, String y) {
        int i = 0, j = 0;
        boolean skip = false;
        while (x.length() > i && y.length() > j) {
            if (x.charAt(i) == y.charAt(j)) {
                i++;
                j++;
            } else {
                if (skip)
                    return false;
                skip = true;
                j++;
            }
        }
        return true;
    }
}