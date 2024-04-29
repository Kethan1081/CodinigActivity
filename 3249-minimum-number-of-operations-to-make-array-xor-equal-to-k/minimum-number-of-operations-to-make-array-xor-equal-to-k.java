class Solution {
    public int minOperations(int[] nums, int k) {
        int res = nums[0];
        for(int i=1; i<nums.length; ++i) {
            res = res ^ nums[i];
        }
        int ress=0;
        while(res >0 || k>0) {
            int v1 = res%2;
            int v2 = k%2;
            res = res/2;
            k = k/2;
            if(v1 != v2) ress++;
        }
        return ress++;
    }
}