class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;
        for (int n : nums) total += n;
        if (Math.abs(target) > total || (total + target) % 2 != 0) return 0;
        int p = (total + target) / 2;
        int[] dp = new int[p + 1];
        dp[0] = 1;
        for (int n : nums) {
            for (int s = p; s >= n; s--) {
                dp[s] += dp[s - n];
            }
        }
        return dp[p];
    }
}
