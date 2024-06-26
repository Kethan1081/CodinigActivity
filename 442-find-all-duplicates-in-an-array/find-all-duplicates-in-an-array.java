class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList();
        // Set<Integer> set = new HashSet();
        for(int i=0; i<n; ++i) {
            if(nums[i] == -1 || nums[i] == -2) continue;
            while(nums[i] != -1 && nums[i] != -2) {
                int val = nums[i]-1;
                if(i == val) {
                    nums[i] = -1;
                    break;
                }
                if(nums[val] == -1) {
                    res.add(val+1);
                    nums[i] = -2;
                    break;
                }
                int x = nums[val];
                nums[val] = -1;
                nums[i] = x;
            }
        }
        return res;   
    }
}