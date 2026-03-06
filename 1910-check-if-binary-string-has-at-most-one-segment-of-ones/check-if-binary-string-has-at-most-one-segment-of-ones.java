class Solution {
    public boolean checkOnesSegment(String s) {
        int n = s.length();
        int count = 0;
        if(n > 0 && s.charAt(0) == '1') count++;
        int j = 0;
        for(int i=1;i<n;i++){
            if(s.charAt(i) == '1' && s.charAt(i-1) == '1'){
                continue;
            }
            else if(s.charAt(i) == '1' ){
                count++;
            }
        }
        if(count == 1) return true;
        return false;
    }
}