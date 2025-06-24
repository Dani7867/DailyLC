class Solution {
    public int[][] generateMatrix(int n) {
        int[][] mat = new int[n][n];
        int l = 0 , r = n-1 , top = 0 , bottom = n-1;
        int num = 1;
        while(num <= n*n){
            // left to right
            for(int i = l ; i<=r && num <= n*n  ; i++){
                mat[top][i] = num++;
            }
            top++;
            //top to bottom
            for(int i = top ; i<=bottom && num <= n*n ; i++){
                mat[i][r] = num++;
            }
            r--;
            // right to left
            for(int i = r ; i>=l && num <= n*n  ; i--){
                mat[bottom][i] = num++;
            }
            bottom--;
            // bottom to top
            for(int i = bottom ; i>=top && num <= n*n ; i--){
                mat[i][l] = num++;
            }
            l++;
        }
        return mat;
    }
}