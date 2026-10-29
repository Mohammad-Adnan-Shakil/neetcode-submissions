class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // build adjacency list
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] time : times){
            adj.computeIfAbsent(time[0], x -> new ArrayList<>())
               .add(new int[]{time[1], time[2]});
        }

        // min heap: [distance, node]
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        heap.add(new int[]{0, k});

        Map<Integer, Integer> visited = new HashMap<>();

        while(!heap.isEmpty()){
            int[] curr = heap.poll();
            int dist = curr[0], node = curr[1];

            if(visited.containsKey(node)) continue;
            visited.put(node, dist);

            if(adj.containsKey(node)){
                for(int[] neighbor : adj.get(node)){
                    if(!visited.containsKey(neighbor[0])){
                        heap.add(new int[]{dist + neighbor[1], neighbor[0]});
                    }
                }
            }
        }

        if(visited.size() != n) return -1;
        return Collections.max(visited.values()); // max = last node to receive
    }
}