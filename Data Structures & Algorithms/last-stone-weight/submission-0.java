class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int stone : stones) heap.add(stone);
        
        while(heap.size() > 1){
            int y = heap.poll(); // heaviest
            int x = heap.poll(); // second heaviest
            if(x != y) heap.add(y - x);
        }
        
        return heap.isEmpty() ? 0 : heap.peek();
    }
}