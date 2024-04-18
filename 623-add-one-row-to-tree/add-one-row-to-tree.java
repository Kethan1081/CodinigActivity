/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class P{
    TreeNode t;
    int dep;
    P(TreeNode t, int dep) {
        this.t = t;
        this.dep = dep;
    }
}
class Solution {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            TreeNode tmp = new TreeNode(val);
            tmp.left = root;
            root = tmp;
            return root;
        }
        Queue<P> q = new LinkedList();
        q.offer(new P(root, 1));
        while(!q.isEmpty()) {
            P p = q.poll();
            if(p.dep == depth-1) {
                TreeNode t1 = p.t.left;
                TreeNode t2 = p.t.right;
                p.t.left = new TreeNode(val);
                p.t.right = new TreeNode(val);
                p.t.left.left = t1;
                p.t.right.right = t2;
            }
            else if(p.dep < depth-1) {
                if(p.t.left != null) q.offer(new P(p.t.left, p.dep+1));
                if(p.t.right != null) q.offer(new P(p.t.right, p.dep+1));
            }
        }
        return root;
    }
}