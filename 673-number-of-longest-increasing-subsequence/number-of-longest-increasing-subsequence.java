class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, 1);
        Arrays.fill(dp2, 1);
        for(int i=1; i<n; ++i) {
            for(int j=0; j<i; ++j) {
                if(nums[j] < nums[i]) {
                    if(dp1[i] < dp1[j]+1) {
                        dp1[i] = dp1[j]+1;
                        dp2[i] = dp2[j];
                    }
                    else if(dp1[i] == dp1[j] +1) {
                        dp2[i] += dp2[j];
                    }
                }
            }
        }
        int mx=0;
        int mc=0;
        for(int i=0;i<n; ++i) {
            if(dp1[i] == mx) mc+=dp2[i];
            else if(dp1[i] > mx) {
                mx = dp1[i];
                mc = dp2[i];
            }
        }
        return mc;

    }
}