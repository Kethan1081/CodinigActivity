class P{
  int val;
  int idx;
  P(int val, int idx) {
    this.val = val;
    this.idx = idx;
  }
}
class Solution {
    public int sumSubarrayMins(int[] A) {
        int mod = (int)1e9 + 7;
    int n = A.length;
    // Map<Integer, Integer> tm = new HashMap();
    // for(int i=0; i<n; ++i) {
    //   tm.put
    // }
    Stack<P> sk = new Stack<>();
    int[] dp = new int[n];
    dp[n-1] = A[n-1];
    int res = 0;
    // tm.put(A[n-1], n-1);
    sk.push(new P(A[n-1], n-1));
    for(int i=n-2; i>=0; --i) {
      int val = A[i];
      while(!sk.isEmpty() && sk.peek().val > A[i]) sk.pop();
      if(A[i] >= A[i+1]) {
        val = (val + dp[i+1]) % mod;
        dp[i] = val;
      }
      else {
        int idx = i+1;
        // while(idx <n && A[i] < A[idx]) {
        //   val = (val + A[i])% mod;
        //   idx++;
        // }
        // int x = tm.
        idx = (sk.isEmpty() ? n: sk.peek().idx);
        val = (val + (idx-i-1)*A[i]) % mod;
        if(idx< n) val = (val + dp[idx])%mod;
        dp[i] = val;
      }
      sk.push(new P(A[i], i));
    }
    for(int i: dp) res = (res + i)% mod;
    return res;
    }
}