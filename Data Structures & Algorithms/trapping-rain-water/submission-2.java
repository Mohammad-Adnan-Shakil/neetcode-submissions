class Solution {
    public int trap(int[] height) {
        if(height.length == 0) return 0;
        
        int left = 0;
        int right = height.length - 1;
        int maxLeft = height[0];
        int maxRight = height[height.length - 1];
        int water = 0;

        while(left < right){
            if(maxLeft <= maxRight){
                left++;
                maxLeft = Math.max(maxLeft, height[left]);
                water += maxLeft - height[left];
            } else {
                right--;
                maxRight = Math.max(maxRight, height[right]);
                water += maxRight - height[right];
            }
        }
        return water;
    }
}