class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0 ; i<n ; i++){
            graph.add(new ArrayList<>());
        } 
        for(int[] ni : connections){
            int u = ni[0] , v = ni[1];
            graph.get(u).add(new int[]{v,1});
            graph.get(v).add(new int[]{u,0});
        }
        boolean[] v = new boolean[n];
        return dfs(0,graph,v);
    }

    int dfs(int n ,List<List<int[]>> graph,boolean[] v){
        int c = 0;
        v[n] = true;
        for(int[] ne : graph.get(n)){
            int e = ne[0] ,  needC = ne[1];
            if(!v[e]){
                c += needC + dfs(e,graph,v);
            }
        }
        return c;
    }
}