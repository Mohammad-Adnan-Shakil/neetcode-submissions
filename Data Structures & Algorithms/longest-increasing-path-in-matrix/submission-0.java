class Solution {
    private int[][] memo;
    private int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        memo = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, i, j));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int i, int j) {
        if (memo[i][j] != 0) return memo[i][j];
        int best = 1;
        for (int[] d : dirs) {
            int r = i + d[0], c = j + d[1];
            if (r >= 0 && r < matrix.length && c >= 0 && c < matrix[0].length
                    && matrix[r][c] > matrix[i][j]) {
                best = Math.max(best, 1 + dfs(matrix, r, c));
            }
        }
        memo[i][j] = best;
        return best;
    }
}