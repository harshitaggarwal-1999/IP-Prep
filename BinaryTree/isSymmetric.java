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
    public boolean isSymmetricHelp(TreeNode leftsubtree, TreeNode rightsubtree){

        if(leftsubtree == null || rightsubtree == null){
            if(leftsubtree == rightsubtree){
                return true;
            }
            return false;
        }

        if(leftsubtree.val != rightsubtree.val) return false;
        boolean leftcheck = isSymmetricHelp(leftsubtree.left, rightsubtree.right);
        boolean rightcheck = isSymmetricHelp(leftsubtree.right, rightsubtree.left);

        return leftcheck && rightcheck;

    }
    public boolean isSymmetric(TreeNode root) {

        if(root == null){
            return true;
        }


        return isSymmetricHelp(root.left, root.right);
    }
}