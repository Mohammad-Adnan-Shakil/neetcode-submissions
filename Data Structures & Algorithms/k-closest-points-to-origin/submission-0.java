class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // max heap by distance
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a, b) -> (b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])
        );

        for(int[] point : points){
            heap.add(point);
            if(heap.size() > k) heap.poll(); // remove farthest
        }

        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            result[i] = heap.poll();
        }
        return result;
    }
}