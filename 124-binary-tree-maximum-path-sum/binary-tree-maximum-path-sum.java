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
class Solution {
    int ans= Integer.MIN_VALUE;
    int dfs(TreeNode curr){
        if(curr==null)return 0;
        int leftVal= dfs(curr.left);
        int rightVal = dfs(curr.right);
        int currAns = curr.val + leftVal + rightVal;
        ans =Math.max(currAns, ans);
        currAns= Math.max(leftVal,rightVal)+curr.val;
        return currAns<0 ? 0 : currAns;
    }
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
}