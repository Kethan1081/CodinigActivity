class Solution {
    public int uniquePathsWithObstacles(int[][] og) {
        int m = og.length;
        int n = og[0].length;
        int[][] dp = new int[m][n];
        if(og[0][0] == 1 || og[m-1][n-1] == 1) return 0;
        dp[0][0] = 1;
        for(int i=0; i<m; ++i) {
            for(int j=0; j<n; ++j) {
                if(i==0 && j==0 )continue;
                int val=0;
                if(i-1 >=0 && og[i-1][j] != 1) val += dp[i-1][j];
                if(j-1 >=0 && og[i][j-1] != 1) val += dp[i][j-1];
                dp[i][j] = val;
            }
        }
        return dp[m-1][n-1];
        // Queue<int[]> q = new LinkedList();
        // if(og[0][0] != 1) {
        //     q.offer(new int[]{0,0});
        // }
        // while(!q.isEmpty()) {
        //     int[] p = q.poll();
        //     dp[p[0]][p[1]]++;
        //     if(p[0]+1<m && og[p[0]+1][p[1]] != 1) q.offer(new int[]{p[0]+1, p[1]});
        //     if(p[1]+1<n && og[p[0]][p[1]+1] != 1) q.offer(new int[]{p[0], p[1]+1});
        // }
        // return dp[m-1][n-1];
    }
}