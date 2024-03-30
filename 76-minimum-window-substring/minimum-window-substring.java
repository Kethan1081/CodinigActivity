class Solution {
    public String minWindow(String s, String t) {
        int[] m = new int[256];
    char[] tc = t.toCharArray();
    char[] sc = s.toCharArray();
    for(char c: tc) {
      // int val = m.getOrDefault(c, 0);
      // m.put(c, val+1);
      m[c]++;
    }
    int tot = tc.length;
    int st=0;
    int end=0;
    int ol = Integer.MAX_VALUE;
    int r1 = 0;
    int r2 = 0;
    while(end < s.length()) {
      if(m[sc[end]] > 0) {
        tot--;
      }
      m[sc[end]]--;
      end++;
      while(tot == 0) {
        if((end - st) < ol) {
          ol = end-st;
          r1 = st;
          r2 = end;
        }
        // while(st < end) {
        m[sc[st]]++;
        if(m[sc[st]] > 0) tot++;
        st++;
        // }
      }
    }
    return (ol == Integer.MAX_VALUE) ? "" : s.substring(r1, r2);
    }
}