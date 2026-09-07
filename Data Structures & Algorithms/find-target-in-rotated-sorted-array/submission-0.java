class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(nums[mid] == target) return mid;

            // left half is sorted
            if(nums[mid] >= nums[left]){
                if(target >= nums[left] && target < nums[mid]){
                    right = mid - 1;  // target in left half
                } else {
                    left = mid + 1;   // target in right half
                }
            }
            // right half is sorted
            else {
                if(target > nums[mid] && target <= nums[right]){
                    left = mid + 1;   // target in right half
                } else {
                    right = mid - 1;  // target in left half
                }
            }
        }
        return -1;
    }
}