class MedianFinder {
    PriorityQueue<Integer> left;  // max heap
    PriorityQueue<Integer> right; // min heap

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        left.add(num);
        // balance: move largest of left to right
        if(!right.isEmpty() && left.peek() > right.peek()){
            right.add(left.poll());
        }
        // keep sizes balanced
        if(left.size() > right.size() + 1){
            right.add(left.poll());
        }
        if(right.size() > left.size()){
            left.add(right.poll());
        }
    }

    public double findMedian() {
        if(left.size() > right.size()) return left.peek();
        return (left.peek() + right.peek()) / 2.0;
    }
}