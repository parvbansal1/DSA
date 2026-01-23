class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int min = arr[0];
        for(int i=0;i<n;i++){        
            ans = Math.max(ans,arr[i]-min);
            min = Math.min(min,arr[i]);    
        }
        return ans;
    }
}