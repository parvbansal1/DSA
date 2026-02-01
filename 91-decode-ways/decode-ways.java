class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') return 0;
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return find(0, s, dp);
    }

    public int find(int i, String s, int dp[]) {
        int n = s.length();
        if (i == n) return 1;
        if(s.charAt(i)=='0') return 0;
        
        if(dp[i]!=-1) return dp[i];
        int res = find(i+1, s, dp);
        if(i+1<n){
            int x = Integer.parseInt(s.substring(i,i+2));
            if(x>=10 && x<=26){
                res += find(i+2,s,dp);
            }
        }
        return dp[i] = res;
    }
}