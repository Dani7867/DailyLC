class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> g = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            g.add(new ArrayList<>());
        }
        //direction: 1 = original, 0 = reversed
        for(int[] x : connections){
            int u = x[0] , v = x[1];
            g.get(u).add(new int[]{v, 1}); // original direction u -> v
            g.get(v).add(new int[]{u, 0}); // reverse edge added to allow DFS traversal
        }
        boolean[] v = new boolean[n];
        return dfs(0,g,v);
    }

    int dfs(int s , List<List<int[]>> g , boolean[] v){
        int changes = 0;

        v[s] = true;
        for(int[] n : g.get(s)){
            int next = n[0] , needCng = n[1];
            if(!v[next]){
                v[next] = true;
                changes += needCng + dfs(next,g,v);
            }
        }
        return changes;
    }
}