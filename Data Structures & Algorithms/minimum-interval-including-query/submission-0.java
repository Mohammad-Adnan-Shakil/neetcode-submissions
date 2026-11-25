class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int q = queries.length;
        Integer[] order = new Integer[q];
        for (int k = 0; k < q; k++) order[k] = k;
        Arrays.sort(order, (a, b) -> Integer.compare(queries[a], queries[b]));

        // heap entries: {length, right end}
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[q];
        int j = 0;

        for (int idx : order) {
            int query = queries[idx];
            while (j < intervals.length && intervals[j][0] <= query) {
                heap.add(new int[]{intervals[j][1] - intervals[j][0] + 1, intervals[j][1]});
                j++;
            }
            while (!heap.isEmpty() && heap.peek()[1] < query) {
                heap.poll();
            }
            result[idx] = heap.isEmpty() ? -1 : heap.peek()[0];
        }
        return result;
    }
}