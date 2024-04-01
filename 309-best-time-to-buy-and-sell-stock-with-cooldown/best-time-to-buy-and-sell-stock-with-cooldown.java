class Solution {
    int[][] dp;
    public int maxProfit(int[] prices) {
        int n = prices.length;
        dp = new int[n][2];
        for(int i=0; i<n; ++i) {
            Arrays.fill(dp[i], -1);
        }
        return fun(prices, 0, 0);
    }
    public int fun(int[] prices, int idx, int buy) {
        if(idx>= prices.length) return 0;
        if(dp[idx][buy] != -1) return dp[idx][buy];
        if(buy == 0) {
            int b = -prices[idx] + fun(prices, idx+1, 1);
            int b1 = fun(prices, idx+1, buy);
            dp[idx][buy] = Math.max(b, b1);
        }
        else if(buy == 1) {
            int sell = prices[idx] + fun(prices, idx+2, 0);
            int sell1 = fun(prices, idx+1, buy);
            dp[idx][buy] = Math.max(sell, sell1);
        }
        return dp[idx][buy];
    }
}