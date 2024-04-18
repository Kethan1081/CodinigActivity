class Solution {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList();
        // boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(grid[i][j] == 1) {
                    q.offer(new int[]{i,j});
                    // break;
                }
            }
        }
        
        // int[] d1 = {-1, 0, 1, 0};
        // int[] d2 = {0, 1, 0, -1};
        int res=0;
        while(!q.isEmpty()) {
            int[] p = q.poll();
            int r = p[0];
            int c = p[1];
            // System.out.println(r + " - " + c);
            // if(vis[r][c]) continue;
            // vis[r][c] = true;
            if(c-1 < 0 || grid[r][c-1] == 0) res++;
            if(c+1 >= n || grid[r][c+1] == 0) res++;
            if(r-1 < 0 || grid[r-1][c] == 0) res++;
            if(r+1 >= m || grid[r+1][c] == 0) res++;
        }
        return res;
    }
}