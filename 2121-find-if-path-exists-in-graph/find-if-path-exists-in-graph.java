class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0] , v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] isVisited = new boolean[n];
        return dfs(source,destination,graph,isVisited);
    }
    boolean dfs(int current,int dest,List<List<Integer>> graph,boolean[] visited){
        if(current == dest) return true;
        visited[current] = true;
        for (int neighbor : graph.get(current)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, dest, graph, visited)) return true;
            }
        }
        return false;
    }

}