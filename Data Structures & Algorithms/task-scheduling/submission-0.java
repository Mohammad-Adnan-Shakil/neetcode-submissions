class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(char t : tasks) freq[t - 'A']++;

        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int f : freq) if(f > 0) heap.add(f);

        Queue<int[]> queue = new LinkedList<>(); // [remaining count, available at time]
        int time = 0;

        while(!heap.isEmpty() || !queue.isEmpty()){
            time++;

            if(!heap.isEmpty()){
                int count = heap.poll() - 1;
                if(count > 0) queue.add(new int[]{count, time + n});
            }

            if(!queue.isEmpty() && queue.peek()[1] == time){
                heap.add(queue.poll()[0]);
            }
        }
        return time;
    }
}