class Solution {
    Map<String, PriorityQueue<String>> adj = new HashMap<>();
    List<String> result = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // build adjacency list with min heap (lexicographic order)
        for(List<String> ticket : tickets){
            adj.computeIfAbsent(ticket.get(0), x -> new PriorityQueue<>())
               .add(ticket.get(1));
        }

        dfs("JFK");
        return result;
    }

    private void dfs(String airport){
        PriorityQueue<String> neighbors = adj.get(airport);
        while(neighbors != null && !neighbors.isEmpty()){
            dfs(neighbors.poll());
        }
        ((LinkedList<String>) result).addFirst(airport); // add to front (postorder)
    }
}