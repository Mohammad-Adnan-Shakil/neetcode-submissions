class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // sort to handle duplicates
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, int start, List<Integer> current){
        if(target == 0){
            result.add(new ArrayList<>(current));
            return;
        }
        if(target < 0) return;

        for(int i = start; i < candidates.length; i++){
            // skip duplicates at same level
            if(i > start && candidates[i] == candidates[i-1]) continue;
            current.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i + 1, current); // i+1 not i
            current.remove(current.size() - 1);
        }
    }
}