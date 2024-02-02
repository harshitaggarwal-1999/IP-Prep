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
    public TreeNode merge(TreeNode r1, TreeNode r2){
        if(r1==null && r2==null) return null;
        int value = (r1==null?0:r1.val) + (r2==null?0:r2.val);
        TreeNode node = new TreeNode(value);
        node.left = merge(r1==null?null:r1.left,r2==null?null:r2.left);
        node.right = merge(r1==null?null:r1.right,r2==null?null:r2.right);
        return node;
    }
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return merge(root1,root2);
    }
}