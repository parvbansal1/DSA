class Solution {
    public int islandPerimeter(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(arr[i][j]==1){
                    if(i==0) count++;
                    if(i==n-1) count++;
                    if(j==0) count++;
                    if(j==m-1) count++;
                    if(j<m-1 && arr[i][j+1]==0) count++;
                    if(i<n-1 && arr[i+1][j]==0) count++;
                    if(j>0 && arr[i][j-1]==0) count++;
                    if(i>0 && arr[i-1][j]==0) count++;
                }
            }
        }
        return count;
    }
}