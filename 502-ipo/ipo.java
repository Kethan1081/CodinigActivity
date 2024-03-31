class P{
    int c;
    int p;
    P(int c,int p) {
        this.c = c;
        this.p = p;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        PriorityQueue<P> pq = new PriorityQueue<>((a,b) -> Integer.compare(b.p, a.p));
        List<P> src = new ArrayList<>();
        for(int i=0; i<n; ++i) {
            src.add(new P(capital[i], profits[i]));
        }
        Collections.sort(src, (a,b) -> (a.c == b.c)? Integer.compare(b.p, a.p): Integer.compare(a.c, b.c));
        int i=0;
        while(i<n && src.get(i).c <= w) {
            pq.offer(src.get(i));
            i++;
        }
        int res=0;
        while(k > 0 && !pq.isEmpty()) {
            P p = pq.poll();
            w += p.p;
            while(i<n && src.get(i).c <= w){
                pq.offer(src.get(i));
                i++;
            }
            k--;
        }
        return w;
    }
}