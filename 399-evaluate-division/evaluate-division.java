class P{
    String d;
    double val;
    P(String d, double val) {
        this.d = d;
        this.val = val;
    }
}

class Solution {
    public double[] calcEquation(List<List<String>> eq, double[] val, List<List<String>> q) {
        Map<String, Map<String, Double>> mem = new HashMap();
        int n = eq.size();
        // Set<String> dict = new HashSet();
        for(int i=0; i<n; ++i) {
            List<String> s = eq.get(i);
            double v = val[i];
            double v1 = 1/v;
            // v1 = Math.round(v1 * 100000) / 100000.0;
            Map<String, Double> tmp = mem.getOrDefault(s.get(0), new HashMap());
            tmp.put(s.get(1), v);
            mem.put(s.get(0), tmp);

            Map<String, Double> tmp1 = mem.getOrDefault(s.get(1), new HashMap());
            tmp1.put(s.get(0), v1);
            mem.put(s.get(1), tmp1);
            // System.out.println(s.get(0) + " - " + s.get(1) + " - " + v);
            // System.out.println(s.get(1) + " - " + s.get(0) + " - " + v1);
        }
        int len = q.size();
        double[] res = new double[len];
        for(int i=0; i<len; ++i) {
            String src = q.get(i).get(0);
            String dst = q.get(i).get(1);
            if(!mem.containsKey(src) || !mem.containsKey(dst)) {
                res[i] = -1.00000;
                continue;
            }
            // System.out.println(src + " - " + dst);
            Queue<P> qq = new LinkedList();
            qq.offer(new P(src,1));
            boolean f = false;
            Set<String> set = new HashSet();
            while(!qq.isEmpty()) {
                P p = qq.poll();
                if(p.d.equals(dst)) {
                    res[i] = p.val;
                    f = true;
                    break;
                }
                else {
                    
                    set.add(p.d);
                    // System.out.println(p.d);
                    if(mem.containsKey(p.d)) {
                        if(mem.get(p.d).containsKey(dst)) {
                            res[i] = p.val * mem.get(p.d).get(dst);
                            System.out.println(p.val + " - " + mem.get(p.d).get(dst) + " - " + res[i]);
                            f = true;
                            break;
                        }
                        for(String ii: mem.get(p.d).keySet()) {
                            if(!set.contains(ii)) {
                                // System.out.println(ii);
                                double vv = p.val * mem.get(p.d).get(ii);
                                qq.offer(new P(ii, vv));
                            }
                        }
                    }
                }
            }
            if(!f) {
                res[i] = -1.00000;
            }
        }
        return res;
    }
}