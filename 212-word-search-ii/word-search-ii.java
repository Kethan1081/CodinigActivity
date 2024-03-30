class Tire{
  char c;
  Map<Character, Tire> map;
  boolean end;
  Tire(char c) {
    this.c = c;
    this.map = new HashMap<>();
    this.end = false;
  }
}

class Solution {
    Set<String> set;
    public List<String> findWords(char[][] A, String[] dict) {
List<String> res = new ArrayList<>();
    set = new HashSet<>();
    int m = A.length;
    int n = A[0].length;
    Map<Character, Tire> smap = new HashMap<>();
    for(String s: dict) {
      char[] c = s.toCharArray();
      Tire tn = smap.getOrDefault(c[0], new Tire(c[0]));
      int i=1;
      smap.put(c[0], tn);
      while(i<c.length) {
        if(tn.map.containsKey(c[i])) {
          tn = tn.map.get(c[i]);
        }
        else {
          Tire tmp = new Tire(c[i]);
          tn.map.put(c[i], tmp);
          tn = tmp;
        }
        // if(i == c.length-1) tn.end = true;
        i++;
      }
      tn.end = true;
    }
    for(int j=0; j<m; ++j) {
      for(int k=0; k<n; ++k) {
        if(smap.containsKey(A[j][k])) {
          boolean[][] vis = new boolean[m][n];
          StringBuilder sb = new StringBuilder();
          dfs(A, j, k, vis, smap.get(A[j][k]), sb, res);
        }
      }
    }
    return res;
  }

  
  public void dfs(char[][] A, int r, int c, boolean[][] vis, Tire t, StringBuilder sb, List<String> res) {
    // if(A[r][c] == 'o') {
    //   System.out.print(t.c);
    //   System.out.print(t.map.get('a').c);
    //   System.out.print(t.map.get('a').map.get('t').c);
    //   System.out.print(t.map.get('a').map.get('t').map.get('h').c);
    //   System.out.print(" " + t.map.get('a').map.get('t').map.get('h').end);
    // }

    int[] rc = new int[] {-1, 0, 1, 0};
    int[] cc = new int[] {0, 1, 0, -1};

    vis[r][c] = true;
    sb.append(A[r][c]);
    if(t.end && !set.contains(sb.toString())) {
      set.add(sb.toString());
      res.add(sb.toString());
      System.out.println(res.toString());
    }
    for(int i=0; i<4; ++i) {
      int r1 = r + rc[i];
      int c1 = c + cc[i];
      if(r1 >=0 && c1 >= 0 && r1 < A.length && c1 < A[0].length && !vis[r1][c1] && t.map.containsKey(A[r1][c1])) dfs(A, r1, c1, vis, t.map.get(A[r1][c1]), sb, res); 
    }
    vis[r][c] = false;
    sb.deleteCharAt(sb.length() - 1);
  }
}