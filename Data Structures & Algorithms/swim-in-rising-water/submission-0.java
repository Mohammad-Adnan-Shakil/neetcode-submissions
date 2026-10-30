class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        heap.add(new int[]{grid[0][0], 0, 0});

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        while(!heap.isEmpty()){
            int[] curr = heap.poll();
            int t = curr[0], r = curr[1], c = curr[2];

            if(visited[r][c]) continue;
            visited[r][c] = true;

            if(r == n-1 && c == n-1) return t;

            for(int[] dir : dirs){
                int nr = r + dir[0], nc = c + dir[1];
                if(nr < 0 || nr >= n || nc < 0 || nc >= n) continue;
                if(visited[nr][nc]) continue;
                heap.add(new int[]{Math.max(t, grid[nr][nc]), nr, nc});
            }
        }
        return -1;
    }
}