class Solution {
    public int subs(int n, int k, int arr[], int dp[][]){
        if(n==0){
            if(k==0) return 0;
            else return Integer.MIN_VALUE;
        }
        if(dp[n][k]!=-1) return dp[n][k];
        if(arr[n-1]<=k){
            int take = 1 + subs(n-1,k-arr[n-1],arr,dp);
            int skip = subs(n-1,k,arr,dp);
            return dp[n][k] = Math.max(take,skip);
        }
        else return dp[n][k] = subs(n-1,k,arr,dp);
    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        int n = nums.size();
        int arr[] = new int[n];
        for(int i=0;i<n;i++) arr[i] = nums.get(i);
        int dp[][] = new int[n+1][target+1];
        for(int a[]:dp) Arrays.fill(a,-1);
        int ans = subs(n,target,arr,dp);
        return ans < 0 ? -1 : ans;
    }
}