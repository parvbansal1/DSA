class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int ans = 0 , ans2 = 0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i) == 'L') {
                ans++;
                ans2--;
            }
            else if(moves.charAt(i) == 'R') {
                ans--;
                ans2++;
            }
            else{
                ans++;
                ans2++;
            }
        }
        return Math.max(ans,ans2);
    }
}