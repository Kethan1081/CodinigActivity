class Solution {
    public int lengthOfLongestSubstring(String ss) {
        char[] c = ss.toCharArray();
        int n = c.length;
        int s=0;
        int i=0;
        int res=0;
        Map<Character, Integer> m = new HashMap();
        while(i<n) {
            if(!m.containsKey(c[i])) {
                m.put(c[i], i);
                res = Math.max(res, (i-s+1));
                i++;
                continue;
            }
            else {
                s = Math.max(s,m.get(c[i])+1);
                m.put(c[i], i);
                res = Math.max(res, (i-s+1));
                i++;
                continue;
            }
        }
        return res;
    }
}