class Node {
    int val;
    List<Integer> adj;
    Node(int val) {
        this.val = val;
        this.adj = new ArrayList();
    }
}
class Solution {
    public boolean canFinish(int n, int[][] p) {
        int[] dg = new int[n];
        Map<Integer, Node> map = new HashMap();
        for(int i=0; i<n; ++i) {
            map.put(i, new Node(i));
        }
        for(int[] i: p) {
            int src = i[1];
            int dst = i[0];
            Node sn = map.get(src);
            sn.adj.add(dst);
            map.put(src, sn);
            dg[dst]++;
        }
        Queue<Integer> q = new LinkedList();
        Set<Integer> set = new HashSet();
        for(int k=0; k<n; ++k) {
            if(dg[k] == 0) {
                set.add(k);
                q.offer(k);
            }
        }

        while(!q.isEmpty()) {
            int val = q.poll();
            for(int i: map.get(val).adj) {
                dg[i]--;
                if(dg[i] == 0 && !set.contains(i)) {
                    set.add(i);
                    q.offer(i);
                }
            }
        }
        return (set.size() == n);
    }
}