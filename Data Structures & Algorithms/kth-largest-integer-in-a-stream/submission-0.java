class KthLargest {
    PriorityQueue<Integer> heap;
    int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        heap = new PriorityQueue<>(); // min heap
        for(int num : nums) add(num);
    }

    public int add(int val) {
        heap.add(val);
        if(heap.size() > k) heap.poll();
        return heap.peek();
    }
}