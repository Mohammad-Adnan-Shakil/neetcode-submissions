class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Outer loop goes from the first element to the second-to-last
        for (int i = 0; i < nums.length - 1; i++) {
            // Inner loop checks every element after 'i'
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j}; // Returns immediately if found
                }
            }
        }
        
        // Fallback return statement if no pair matches the target
        return new int[]{}; 
    }
}
