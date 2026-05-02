class Solution {
    public int rotatedDigits(int n) {
        int ans = 0;
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int d = i;
            if (d < 10) {
                if (d == 2 || d == 5 || d == 6 || d == 9) {
                    dp[i] = 2;
                    ans++;
                } else if (d == 0 || d == 1 || d == 8) {
                    dp[i] = 1;
                } else
                    dp[i] = 0;
            } else {
                int last = d % 10;
                int rest = d / 10;
                if (dp[last] == 0 || dp[rest] == 0) {
                    dp[i] = 0;
                } else if (dp[last] == 1 && dp[rest] == 1) {
                    dp[i] = 1;
                } else {
                    dp[i] = 2;
                    ans++;
                }
            }
        }
        return ans;
    }
}