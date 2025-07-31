class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int[][][] dp = new int[m+1][n+1][target+1];
        for(int[][] b : dp){
            for(int[] a:b){
                Arrays.fill(a,-1);
            }
        }
        int res = dfs(0,0,0,houses,cost,m,n,target,dp);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int dfs(int i,int pcolor,int neighborH , int[] houses, int[][] cost, int m, int n, int target,int[][][] dp){
            if(neighborH > target) return Integer.MAX_VALUE;

            if(i == m) return neighborH == target ? 0 : Integer.MAX_VALUE;

            if(dp[i][pcolor][neighborH] != -1) return dp[i][pcolor][neighborH] ;

              int minCost = Integer.MAX_VALUE;

              if(houses[i] != 0){
                int newNeighborH = neighborH + (houses[i] != pcolor ? 1 : 0);
                minCost = dfs(i+1,houses[i],newNeighborH,houses,cost,m,n,target,dp);
              }else{
                for(int l = 1 ; l<=n ;l++){
                    int newNeighborH = neighborH + (l != pcolor ? 1 : 0);
                    int currCost = cost[i][l - 1];
                    int temp = dfs(i + 1, l, newNeighborH, houses, cost, m, n, target, dp);

                    if(temp != Integer.MAX_VALUE){
                        minCost = Math.min(minCost,temp+currCost);
                        }
                    }
                }
        return dp[i][pcolor][neighborH] = minCost;
    }
    
}