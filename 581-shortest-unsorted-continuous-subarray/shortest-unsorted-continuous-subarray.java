class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int[] min = new int[n];
        int[] max = new int[n];
        min[n-1] = nums[n-1];
        max[0] = nums[0];
        for(int i=n-2; i>=0; --i) {
            min[i] = Math.min(nums[i], min[i+1]);
        }
        for(int i=1; i<n; ++i) {
            max[i] = Math.max(nums[i], max[i-1]);
        }
        int s=0;

        while(s<n) {
            if(nums[s] == min[s]) s++;
            else break;
        }
        int e=n-1;
        while(e>=0) {
            if(nums[e] == max[e]) e--;
            else break;
        }
        return (e >=s) ? e-s+1: 0;
    }
}