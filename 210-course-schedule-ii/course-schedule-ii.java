class Node {
    int val;
    List<Integer> adj;
    Node(int val) {
        this.val = val;
        this.adj = new ArrayList();
    }
}
class Solution {
    public int[] findOrder(int n, int[][] p) {
        Map<Integer, Node> m = new HashMap();
        for(int i=0; i<n; ++i) {
            m.put(i, new Node(i));
        }
        int[] topo = new int[n];
        for(int[] i: p) {
            int s = i[1];
            int d = i[0];
            topo[d] = topo[d] + 1;
            Node ss = m.get(s);
            ss.adj.add(d);
        }
        int[] res = new int[n];
        int c=0;
        Queue<Integer> q = new LinkedList();
        for(int i=0; i<n; ++i) {
            if(topo[i] == 0) {
                q.offer(i);
                topo[i] = -1;
            }
        }
        while(!q.isEmpty()) {
            int x = q.poll();
            // topo[x] = -1;
            res[c] = x;
            c++;
            for(int i: m.get(x).adj) {
                topo[i] = topo[i]-1;
                if(topo[i] == 0) {
                    q.offer(i);
                    topo[i] = -1;
                }
            }
            // if(q.isEmpty()) {
            //     for(int i=0; i<n; ++i) {
            //         if(topo[i] == 0) {
            //             q.offer(i);
            //             topo[i] = -1;
            //         }
            //     }
            // }
        }
        if(c == n) return res;
        return new int[0];
    }
}