class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] t = new boolean[n+1];
        int[] c = new int[n+1];
        for(int[] i: trust) {
            t[i[0]] = true;
            c[i[1]]++;
        }
        for(int i=1; i<=n; ++i) {
            if(!t[i] && c[i] == n-1) return i;
        }
        return -1;
    }
}