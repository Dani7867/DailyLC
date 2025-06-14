class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int numR = grid.length;
        int numC = grid[0].length;
        int numIs = 0;

        for(int i = 0 ; i< numR ; i++){
            for(int j = 0 ; j< numC ; j++){
                if(grid[i][j] == '1'){
                    numIs++;
                    dfs(grid,i,j);
                }
            }
        }

        return numIs;
    }

    private void dfs(char[][] grid , int r , int c){
        int numR = grid.length;
        int numC = grid[0].length;
        if(r<0 || r>=numR || c<0 ||c >= numC || grid[r][c] == '0'){
            return;
        } 

        grid[r][c] = '0';
        dfs(grid,r+1,c);
        dfs(grid,r-1,c);
        dfs(grid,r,c+1);
        dfs(grid,r,c-1);
    }
}