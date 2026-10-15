class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> partition(String s) {
        backtrack(s, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(String s, int start, List<String> current){
        if(start == s.length()){
            result.add(new ArrayList<>(current));
            return;
        }

        for(int end = start + 1; end <= s.length(); end++){
            String sub = s.substring(start, end);
            if(isPalindrome(sub)){
                current.add(sub);
                backtrack(s, end, current);
                current.remove(current.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        int left = 0, right = s.length() - 1;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }
}