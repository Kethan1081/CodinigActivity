class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0] = nums[0];
        dp1[1] = Math.max(nums[0], nums[1]);
        for(int i=2;i<n; ++i) {
            if(i== n-1) dp1[i] = dp1[i-1];
            else{
                int val = dp1[i-2] + nums[i];
                val = Math.max(val, dp1[i-1]);
                dp1[i] = val;
            }
        }
        dp2[n-1] = nums[n-1];
        dp2[0] = Math.max(nums[0], nums[n-1]);
        for(int i=1; i<n-1; ++i) {
            int val = (i-2 < 0) ? n+i-2: i-2;
            if(i == n-2) dp2[i] = dp2[i-1];
            else dp2[i] = Math.max(dp2[i-1], nums[i] + dp2[val]);
        }
        return Math.max(dp1[n-1], dp2[n-2]);

    }
}