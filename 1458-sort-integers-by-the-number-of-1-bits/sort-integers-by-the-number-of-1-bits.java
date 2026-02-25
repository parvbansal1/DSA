class Solution {
    public int[] sortByBits(int[] arr) {
        int n = arr.length;
        
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int x = Integer.bitCount(arr[i]);
                int y = Integer.bitCount(arr[j]);
                if(x > y){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                else if(x == y && arr[i] > arr[j] ){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}