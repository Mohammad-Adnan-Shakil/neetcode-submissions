class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Stack<int[]> stack = new Stack<>(); // [index, height]

        for(int i = 0; i < heights.length; i++){
            int start = i;
            while(!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                int idx = top[0];
                int height = top[1];
                maxArea = Math.max(maxArea, height * (i - idx));
                start = idx; // extend start back
            }
            stack.push(new int[]{start, heights[i]});
        }

        // remaining bars in stack extend to end
        while(!stack.isEmpty()){
            int[] top = stack.pop();
            maxArea = Math.max(maxArea, top[1] * (heights.length - top[0]));
        }

        return maxArea;
    }
}