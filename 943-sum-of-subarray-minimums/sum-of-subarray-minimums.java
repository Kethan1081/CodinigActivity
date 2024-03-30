class Solution {
    public int sumSubarrayMins(int[] A) {
        int mod = (int)1e9 + 7;
    int n = A.length;
    int[] dp = new int[n];
    dp[n-1] = A[n-1];
    int res = 0;
    for(int i=n-2; i>=0; --i) {
      int val = A[i];
      if(A[i] >= A[i+1]) {
        val = (val + dp[i+1]) % mod;
        dp[i] = val;
      }
      else {
        int idx = i+1;
        while(idx <n && A[i] < A[idx]) {
          val = (val + A[i])% mod;
          idx++;
        }
        if(idx< n) val = (val + dp[idx])%mod;
        dp[i] = val;
      }
    }
    for(int i: dp) res = (res + i)% mod;
    return res;
    }
}