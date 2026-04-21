class Solution {
    public int maxVowels(String s, int k) {
        int j = 0;
        int max = 0;
        int v = 0;
        for(int i=0;i<s.length();i++){
            int c1 = s.charAt(i);
            int c2 = s.charAt(j);
            if(i - j == k){
                if(c2 == 'a' || c2 == 'e' || c2 == 'i' || c2 == 'o' || c2 == 'u') v--;
                j++;
            }
            if(c1 == 'a' || c1 == 'e' || c1 == 'i' || c1 == 'o' || c1 == 'u') 
            v++;
            max = Math.max(max,v);
        }
        return max;
    }
}