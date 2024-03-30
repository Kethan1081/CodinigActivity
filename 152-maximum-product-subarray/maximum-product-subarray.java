class Solution {
    public int maxProduct(int[] A) {
        int n = A.length;
    int[][] dp = new int[n][2];
    for(int i=0; i<n; ++i) {
      dp[i][0] = (dp[i][1] = A[i]);
    }
    int res = A[0];
    for(int i=1; i<n ;++i) {
      int p = Math.max(dp[i][0], dp[i-1][0] * A[i]);
      p = Math.max(p, dp[i-1][1] * A[i]);
      int neg = Math.min(dp[i][1], dp[i-1][0] * A[i]);
      neg = Math.min(neg, dp[i-1][1] * A[i]);

      dp[i][0] = p;
      dp[i][1] = neg;
      res = Math.max(res, p);
    }
    return res;
    }
}