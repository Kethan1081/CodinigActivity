class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        for(int i=0; i<n; ++i) {
            if(nums[i] == -1) continue;
            // if(i == nums[i]-1) {
            //     nums[i] = -1;
            // }
            // int val = nums[i]-1;
            while(nums[i] != -1) {
                int val = nums[i] -1;
                if(i == val) {
                    nums[i] = -1;
                    break;
                }
                if(nums[val] == -1) return val+1;
                
                int x = nums[val];
                nums[val] = -1;
                nums[i] = x;
            }
        }
        return 0;
    }
}