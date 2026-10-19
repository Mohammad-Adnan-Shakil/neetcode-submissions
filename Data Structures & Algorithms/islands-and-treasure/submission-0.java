class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        // add all treasure chests to queue first
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(grid[i][j] == 0) queue.add(new int[]{i, j});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            int row = cell[0], col = cell[1];

            for(int[] dir : dirs){
                int r = row + dir[0];
                int c = col + dir[1];
                if(r < 0 || r >= m || c < 0 || c >= n) continue;
                if(grid[r][c] != Integer.MAX_VALUE) continue; // skip walls and visited

                grid[r][c] = grid[row][col] + 1; // distance = parent + 1
                queue.add(new int[]{r, c});
            }
        }
    }
}