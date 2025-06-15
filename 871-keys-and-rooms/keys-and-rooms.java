class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(0, rooms, visited);
        
        for (boolean v : visited) {
            if (!v) return false;
        }
        return true;
    }

    private void dfs(int s , List<List<Integer>>  rooms , boolean[] visited){
        visited[s] = true;
        for(int key : rooms.get(s)){
            if(!visited[key]){
                dfs(key,rooms,visited);
            }
        }
    }
}