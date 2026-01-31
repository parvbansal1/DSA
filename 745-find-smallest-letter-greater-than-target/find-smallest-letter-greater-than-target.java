class Solution {
    public char nextGreatestLetter(char[] arr, char target) {
        int n = arr.length;
        int a = target - '0';
        char min =  Character.MAX_VALUE;
        for(int i=0;i<n;i++){
            char b = arr[i];
            if( b-'0' > a && min-'0' > b-'0' ){
                min = b;
            }
        }
        if(min==Character.MAX_VALUE) return arr[0];
        return min;
    }
}