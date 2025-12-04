public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "N";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                sb.append("N,");
                continue;
            }

            sb.append(curr.val).append(",");
            q.offer(curr.left);
            q.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("N")) return null;

        String[] vals = data.split(",");
        int i = 0;

        TreeNode root = new TreeNode(Integer.parseInt(vals[i++]));
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            // left child
            if (!vals[i].equals("N")) {
                curr.left = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(curr.left);
            }
            i++;

            // right child
            if (!vals[i].equals("N")) {
                curr.right = new TreeNode(Integer.parseInt(vals[i]));
                q.offer(curr.right);
            }
            i++;
        }

        return root;
    }
}
