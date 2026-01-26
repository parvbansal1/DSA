class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int n = s.length(), m = t.length();
        int dp[][] = new int[n+1][m+1];
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                char a = s.charAt(i-1);
                char b = t.charAt(j-1);
                if(a==b){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[n][m];
    }
}