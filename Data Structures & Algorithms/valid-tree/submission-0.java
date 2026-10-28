class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1) return false; // must have exactly n-1 edges

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        dfs(adj, visited, 0);

        for(boolean v : visited) if(!v) return false; // not all connected
        return true;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, int node){
        visited[node] = true;
        for(int neighbor : adj.get(node)){
            if(!visited[neighbor]) dfs(adj, visited, neighbor);
        }
    }
}