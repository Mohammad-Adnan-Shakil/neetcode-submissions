class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for(int[] pre : prerequisites) adj.get(pre[0]).add(pre[1]);

        int[] state = new int[numCourses];
        List<Integer> order = new ArrayList<>();

        for(int i = 0; i < numCourses; i++){
            if(hasCycle(adj, state, i, order)) return new int[]{};
        }

        int[] result = new int[numCourses];
        for(int i = 0; i < numCourses; i++) result[i] = order.get(i);
        return result;
    }

    private boolean hasCycle(List<List<Integer>> adj, int[] state, int node, List<Integer> order){
        if(state[node] == 1) return true;
        if(state[node] == 2) return false;

        state[node] = 1;
        for(int neighbor : adj.get(node)){
            if(hasCycle(adj, state, neighbor, order)) return true;
        }
        state[node] = 2;
        order.add(node); // add after all neighbors processed
        return false;
    }
}