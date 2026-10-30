class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean[] visited = new boolean[n];
        // min heap: [cost, point_index]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        heap.add(new int[]{0, 0}); // start from point 0
        int total = 0, count = 0;

        while(count < n){
            int[] curr = heap.poll();
            int cost = curr[0], node = curr[1];

            if(visited[node]) continue;
            visited[node] = true;
            total += cost;
            count++;

            // add all unvisited neighbors with their manhattan distance
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    int dist = Math.abs(points[node][0] - points[i][0])
                             + Math.abs(points[node][1] - points[i][1]);
                    heap.add(new int[]{dist, i});
                }
            }
        }
        return total;
    }
}