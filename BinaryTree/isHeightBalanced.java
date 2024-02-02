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
    boolean isBalanced = true;

    public int helperfuncn(TreeNode root){
        if(root == null) return 0;

        int leftHeight = helperfuncn(root.left);
        int rightHeight = helperfuncn(root.right);

        // calculate lh - rh
        int heightdiff = Math.abs(leftHeight-rightHeight);

        // if curr tree is unbalanced the mark global isbalanced false
        if(heightdiff > 1)isBalanced = false;

        //  return height
        return Math.max(leftHeight, rightHeight)+1;
    }

    public boolean isBalanced(TreeNode root) {
        int ans = helperfuncn(root);
        return isBalanced;
    }
}