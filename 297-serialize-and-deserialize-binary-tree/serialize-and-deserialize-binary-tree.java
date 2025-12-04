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

    StringBuilder make(StringBuilder sb, TreeNode curr, Queue<TreeNode> q){
        sb.append("#");
        if(curr.left != null){
            sb.append(curr.left.val);
            q.offer(curr.left);
        }
        else sb.append('N');

        sb.append("#");
        if(curr.right != null){
            sb.append(curr.right.val);
            q.offer(curr.right);
        }
        else sb.append('N');

        return sb;
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "#N";
        StringBuilder sb = new StringBuilder();
        sb.append("#"+root.val);
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            make(sb,curr,q);
        }
        System.out.println(sb);
        return sb.toString();
    }

    TreeNode makeNode(String s){
        TreeNode newNode ;
        System.out.println(s);
        if(s.equals("N"))newNode = null;
        else newNode = new TreeNode(Integer.parseInt(s));
        return newNode;
    }
    int getIndex(String s, int index){
        while(index<s.length() && s.charAt(index)!='#'){
            index++;
        }
        return index;
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if(s.charAt(1)=='N')return null;
        int left= getIndex(s, 1);
        TreeNode root = makeNode(s.substring(1,left));
        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            left++;
            int right= getIndex(s, left);
            curr.left = makeNode(s.substring(left, right));
            if(curr.left != null) q.offer(curr.left);

            left= right+1;

            right= getIndex(s, left);
            curr.right = makeNode(s.substring(left, right));
            if(curr.right != null) q.offer(curr.right);

            left= right; 
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));