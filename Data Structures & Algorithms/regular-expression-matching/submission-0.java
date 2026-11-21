class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 0; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    dp[i][j] = dp[i][j - 2];
                    if (i > 0) {
                        char prev = p.charAt(j - 2);
                        if (prev == '.' || prev == s.charAt(i - 1)) {
                            dp[i][j] = dp[i][j] || dp[i - 1][j];
                        }
                    }
                } else if (i > 0 && (pc == '.' || pc == s.charAt(i - 1))) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }
}