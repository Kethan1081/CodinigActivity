class Solution {
    int res=0;
    int dp[][];
    public int change(int amount, int[] coins) {
        Arrays.sort(coins);
        int n = coins.length;
        dp = new int[amount+1][n+1];
        
        for(int i = 0; i < amount+1; i++) {
            for(int j = 0; j < n+1; j++) {
                dp[i][j] = -1;
            }
        }
        dp[amount][n-1] = check(amount, coins, n-1);
        return dp[amount][n-1];
    }

    public int check(int a, int[] c, int idx) {
        if(a<0) {
            return 0;
        }

        if(dp[a][idx] != -1) {
            return dp[a][idx];
        }
        if(a == 0) {
            dp[a][idx] = 1;
            return dp[a][idx];
        }
        
        int pos =0;
        for(int i=idx; i>=0; --i) {
            pos += check(a-c[i], c, i);
        }
        dp[a][idx] = pos;
        return dp[a][idx];
    }
}