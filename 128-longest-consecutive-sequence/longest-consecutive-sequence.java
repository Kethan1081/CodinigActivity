class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int res=0;
        int tmp=nums.length >0 ? 1:0;
        int i=1;
        while(i<nums.length) {
            while(i<nums.length && nums[i] == nums[i-1] ) i++;
            if(i>=nums.length) continue;
            if(nums[i]-nums[i-1] == 1) {
                tmp++;
            }
            else {
                res = Math.max(res, tmp);
                tmp=1;
            }
            i++;
        }
        res = Math.max(res, tmp);
        return res;
    }
}