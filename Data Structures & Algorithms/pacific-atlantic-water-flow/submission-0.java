class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        Queue<int[]> pacQueue = new LinkedList<>();
        Queue<int[]> atlQueue = new LinkedList<>();

        for(int i = 0; i < m; i++){
            pacQueue.add(new int[]{i, 0});      // left column
            atlQueue.add(new int[]{i, n-1});    // right column
            pacific[i][0] = true;
            atlantic[i][n-1] = true;
        }
        for(int j = 0; j < n; j++){
            pacQueue.add(new int[]{0, j});      // top row
            atlQueue.add(new int[]{m-1, j});    // bottom row
            pacific[0][j] = true;
            atlantic[m-1][j] = true;
        }

        bfs(heights, pacQueue, pacific);
        bfs(heights, atlQueue, atlantic);

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                if(pacific[i][j] && atlantic[i][j])
                    result.add(Arrays.asList(i, j));

        return result;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] visited){
        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        while(!queue.isEmpty()){
            int[] cell = queue.poll();
            for(int[] dir : dirs){
                int r = cell[0] + dir[0];
                int c = cell[1] + dir[1];
                if(r < 0 || r >= heights.length || c < 0 || c >= heights[0].length) continue;
                if(visited[r][c]) continue;
                if(heights[r][c] < heights[cell[0]][cell[1]]) continue; // must go uphill
                visited[r][c] = true;
                queue.add(new int[]{r, c});
            }
        }
    }
}