class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i=0; i<n; ++i) {
            int val = nums[i];
            if(i-1 >=0) val = val * nums[i-1];
            if(i+1 <n) val = val * nums[i+1];
            dp[i][i] = val;
        }
        for(int c=1; c<n; ++c) {
            for(int i=0; i<n-c; ++i){
                int lo = i;
                int hi = i+c;
                int val = 1;
                if(lo-1 >=0) val = val * nums[lo-1];
                if(hi+1 <n) val = val * nums[hi+1];
                for(int k = lo; k<= hi; ++k) {
                    int cmp = 0;
                    if(k-1 >= lo) cmp += dp[lo][k-1];
                    if(k+1 <= hi) cmp += dp[k+1][hi];
                    cmp += (val * nums[k]);
                    dp[lo][hi] = Math.max(dp[lo][hi], cmp);
                }
            }
        }
        return dp[0][n-1];
    }
}