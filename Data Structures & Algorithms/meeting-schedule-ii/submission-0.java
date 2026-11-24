class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        intervals.sort((a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Integer> ends = new PriorityQueue<>();
        for (Interval iv : intervals) {
            if (!ends.isEmpty() && ends.peek() <= iv.start) {
                ends.poll();
            }
            ends.add(iv.end);
        }
        return ends.size();
    }
}