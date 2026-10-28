class Solution {
    int[] parent, rank;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];
        rank = new int[n + 1];
        for(int i = 0; i <= n; i++) parent[i] = i;

        for(int[] edge : edges){
            if(!union(edge[0], edge[1])) return edge;
        }
        return new int[]{};
    }

    private int find(int x){
        if(parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    private boolean union(int x, int y){
        int px = find(x), py = find(y);
        if(px == py) return false; // already connected → cycle
        if(rank[px] > rank[py]) parent[py] = px;
        else if(rank[px] < rank[py]) parent[px] = py;
        else { parent[py] = px; rank[px]++; }
        return true;
    }
}