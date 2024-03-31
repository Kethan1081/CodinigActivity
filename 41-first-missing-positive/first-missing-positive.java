class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; ++i) {
            if(nums[i] == -1) nums[i] = -2;
        }
        for(int i=0; i<n; ++i) {
            if(nums[i] >0 && nums[i]<=n) {
                int v1 = nums[i];
                while(v1 > 0) {
                    int tmp = nums[v1-1];
                    nums[v1 -1] = -1;
                    if(tmp >0 && tmp <= n) v1 = tmp;
                    else v1 = -1;
                }
            }
        }
        // System.out.println(Arrays.toString(nums));
        for(int i=1; i<=n; ++i) {
            if(nums[i-1] != -1) return i;
        }
        return n+1;
    }
}