class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> deque = new ArrayDeque<>(); // stores indices
        int left = 0, right = 0;

        while(right < nums.length){
            // remove smaller elements from back
            while(!deque.isEmpty() && nums[deque.peekLast()] < nums[right]){
                deque.pollLast();
            }
            deque.addLast(right);

            // remove left element if outside window
            if(deque.peekFirst() < left){
                deque.pollFirst();
            }

            // window is fully formed
            if(right + 1 >= k){
                result[left] = nums[deque.peekFirst()];
                left++;
            }
            right++;
        }
        return result;
    }
}