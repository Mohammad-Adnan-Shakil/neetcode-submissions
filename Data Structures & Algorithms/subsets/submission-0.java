class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> current){
        result.add(new ArrayList<>(current)); // add current subset

        for(int i = start; i < nums.length; i++){
            current.add(nums[i]);           // include
            backtrack(nums, i + 1, current);
            current.remove(current.size() - 1); // exclude (backtrack)
        }
    }
}