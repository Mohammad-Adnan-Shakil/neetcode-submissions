class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for(int[] pre : prerequisites) adj.get(pre[0]).add(pre[1]);

        int[] state = new int[numCourses]; // 0=unvisited, 1=visiting, 2=done

        for(int i = 0; i < numCourses; i++){
            if(hasCycle(adj, state, i)) return false;
        }
        return true;
    }

    private boolean hasCycle(List<List<Integer>> adj, int[] state, int node){
        if(state[node] == 1) return true;  // cycle
        if(state[node] == 2) return false; // already safe

        state[node] = 1; // mark visiting
        for(int neighbor : adj.get(node)){
            if(hasCycle(adj, state, neighbor)) return true;
        }
        state[node] = 2; // mark done
        return false;
    }
}