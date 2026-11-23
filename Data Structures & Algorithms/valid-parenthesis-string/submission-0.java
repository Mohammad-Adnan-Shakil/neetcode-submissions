class Solution {
    public boolean checkValidString(String s) {
        int lo = 0, hi = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                lo++;
                hi++;
            } else if (ch == ')') {
                lo--;
                hi--;
            } else {
                lo--;
                hi++;
            }
            if (hi < 0) return false;
            lo = Math.max(lo, 0);
        }
        return lo == 0;
    }
}