class Solution {
    int[][] dp ;
    public boolean canCross(int[] stones) {
        int n = stones.length;
        dp = new int[n+1][4000];
        for(int i=0; i<=n; ++i) Arrays.fill(dp[i], -1);
        if(n==1) return true;
        if(stones[0] + 1 != stones[1]) return false;
        return fun(stones, 1, 1);
    }
    public boolean fun(int[] stones, int idx, int k) {
        // System.out.println(idx + " - "+ k);
        if(idx == stones.length-1) {
            dp[idx][k] = 1;
            return true;
        }
        // if(stones[idx] + k < stones[idx+1]) {
        //     dp[idx][k] = 0;
        //     return false;
        // }
        if(dp[idx][k] != -1) return (dp[idx][k] == 0)? false:true;
        boolean res = false;
        for(int i=idx+1; i<stones.length; ++i) {
            if(res) break;
            if(stones[i] <= stones[idx] + k+1) {
                if(stones[i] == stones[idx] + k+1) res = res || fun(stones, i, k+1);
                else if(stones[i] == stones[idx] + k) res = res || fun(stones, i, k);
                else if(stones[i] == stones[idx] + k-1) res = res || fun(stones, i, k-1);
            }
            else break;
        }
        dp[idx][k] = (res) ? 1:0;
        return res;
    }
}