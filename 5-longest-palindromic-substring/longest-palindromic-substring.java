class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        for(int i=n;i>0;i--){
            for(int j=0;j<=n-i;j++){
                if(isPalin(j,j+i-1,s)){
                    return s.substring(j, i+j);
                }
            }
        }
        return "";
    }
    public boolean isPalin(int st, int end, String s){
        while(st<end){
            if (s.charAt(st) != s.charAt(end)) return false;
            st++;
            end--;
        }
        return true;
    }
}