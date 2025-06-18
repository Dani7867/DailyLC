class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];
        boolean[] safe = new boolean[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph, visited, recStack, safe)) {
                // If dfs returns true, it's a safe node
                result.add(i);
            }
        }

        return result;
    }

    private boolean dfs(int node, int[][] graph, boolean[] visited, boolean[] recStack, boolean[] safe) {
        if (visited[node]) {
            return safe[node];  // If already visited, return its safeness
        }

        visited[node] = true;
        recStack[node] = true;

        for (int neighbor : graph[node]) {
            if (recStack[neighbor] || !dfs(neighbor, graph, visited, recStack, safe)) {
                // If cycle is found or neighbor leads to cycle
                recStack[node] = false;
                safe[node] = false;
                return false;
            }
        }

        recStack[node] = false;
        safe[node] = true;  // No cycle from this node
        return true;
    }
}
