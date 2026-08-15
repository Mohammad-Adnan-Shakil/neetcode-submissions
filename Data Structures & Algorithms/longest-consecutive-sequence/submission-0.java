class Solution {
    public int longestConsecutive(int[] nums) {
        // step 1 - put everything in HashSet
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }

        int longest = 0;

        for(int num : nums){
            // step 2 - only start counting if num is a sequence start
            if(!set.contains(num - 1)){
                int length = 1;
                // step 3 - count upward
                while(set.contains(num + length)){
                    length++;
                }
                // step 4 - update longest
                longest = Math.max(longest, length);
            }
        }

        return longest;
    }
}