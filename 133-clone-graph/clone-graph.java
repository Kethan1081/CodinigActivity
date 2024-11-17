/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;

        Map<Node, Node> map = new HashMap();
        return cloneGraphUtil(node, map);
    }

    public Node cloneGraphUtil(Node node, Map<Node, Node> map) {
        if(node == null) return null;
        if(map.containsKey(node)) return map.get(node);
        
        Node res = new Node(node.val);
        map.put(node, res);
        for(Node n: node.neighbors) {
            Node t1 = cloneGraphUtil(n, map);
            res.neighbors.add(t1);
        }
        
        return res;
    }
}