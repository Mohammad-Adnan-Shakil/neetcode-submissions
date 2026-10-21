class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        // add all rotten oranges, count fresh
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 2) queue.add(new int[]{i, j});
                if(grid[i][j] == 1) fresh++;
            }

        if(fresh == 0) return 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int minutes = 0;

        while(!queue.isEmpty() && fresh > 0){
            minutes++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                int[] cell = queue.poll();
                for(int[] dir : dirs){
                    int r = cell[0] + dir[0];
                    int c = cell[1] + dir[1];
                    if(r < 0 || r >= m || c < 0 || c >= n) continue;
                    if(grid[r][c] != 1) continue;
                    grid[r][c] = 2;
                    fresh--;
                    queue.add(new int[]{r, c});
                }
            }
        }

        return fresh == 0 ? minutes : -1;
    }
}