class Solution {
    List<String> result = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0, "");
        return result;
    }

    private void backtrack(int n, int open, int close, String current){
        if(current.length() == n * 2){
            result.add(current);
            return;
        }
        if(open < n) backtrack(n, open + 1, close, current + "(");
        if(close < open) backtrack(n, open, close + 1, current + ")");
    }
}