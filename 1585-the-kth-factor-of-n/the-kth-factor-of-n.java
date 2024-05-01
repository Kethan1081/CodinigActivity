class Solution {
    public int kthFactor(int n, int k) {
        int i=1;
        int c=0;
        while(i<=n) {
            if(c == k) return i;
            if(n%i == 0) {
                c++;
            }
            if(c == k) return i;
            i++;
        }
        if(c == k) return i;
        return -1; 
    }
}