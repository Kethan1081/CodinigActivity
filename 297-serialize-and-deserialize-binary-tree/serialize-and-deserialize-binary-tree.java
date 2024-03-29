/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
        StringBuilder sb = new StringBuilder();
        // sb.append("[");
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode tmp = q.poll();
            if(tmp != null) {
                q.offer(tmp.left);
                q.offer(tmp.right);
                sb.append(String.valueOf(tmp.val));
            }
            else {
                sb.append("null");
            }
            if(!q.isEmpty()) sb.append(",");
        }
        // sb.append("]");
        // System.out.println(sb.toString());
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // return null;
        TreeNode root = null;
        if(data == null) return root;
        String[] p = data.split(",");
        int i=0;
        int n = p.length;
        if(p[0].equals("null")) return root;
        root = new TreeNode(Integer.valueOf(p[0]));
        i++;
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        while(!q.isEmpty()) {
            TreeNode x = q.poll();
            TreeNode l = p[i].equals("null") ? null: new TreeNode(Integer.valueOf(p[i]));
            TreeNode r = p[i+1].equals("null") ? null: new TreeNode(Integer.valueOf(p[i+1]));
            i += 2;
            x.left = l;
            x.right = r;
            if(l != null) q.offer(l);
            if(r != null) q.offer(r);
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));