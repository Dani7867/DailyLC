class Solution {
    private int[] parent;
    private int[] rank;
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length+1];
        rank = new int[edges.length+1];
        
        for(int i = 1 ; i <= edges.length ; i++){
            parent[i] = i;
            rank[i] = 0;
        }

        for(int[] ed : edges){
            int u = ed[0] , v =ed[1];
            if(find(u) == find(v)){
                return ed;
            }
            union(u,v);
        }
        return new int[0];
    }
    private int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

    private void union(int u , int v){
        int x = find(u);
        int y = find(v);

        if(x==y) return;

        if(rank[x]<rank[y]){
            parent[x] = y;
        }else if(rank[x]>rank[y]){
            parent[y] = x;
        }else{
            parent[y] = x;
            rank[x]++;
        }
    }
}