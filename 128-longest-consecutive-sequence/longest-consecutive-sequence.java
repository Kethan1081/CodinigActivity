class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet();
        for(int i: nums) {
            s.add(i);
        }
        int res=0;

        for(int i: nums) {
            if(!s.contains(i-1)) {
                int tmp=0;
                int j=i;
                while(s.contains(j)) {
                    j++;
                    tmp++;
                }
                res = Math.max(res, tmp);
            }
        }
        return res;
    }
}