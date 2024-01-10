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

class BSTPair{
    boolean isBST;
    long min;
    long max;
}
class Solution {

    public BSTPair isValidBSTHelp(TreeNode root){
        // base condition
        if(root == null){

            BSTPair cp = new BSTPair();
            cp.isBST = true;
            cp.min = Long.MAX_VALUE;
            cp.max = Long.MIN_VALUE;
            return cp;
        }

        BSTPair lp = isValidBSTHelp(root.left);
        BSTPair rp = isValidBSTHelp(root.right);

        BSTPair mp = new BSTPair();

        mp.isBST = lp.isBST && rp.isBST && (root.val < rp.min && root.val > lp.max);

        mp.min = Math.min(root.val , Math.min(lp.min, rp.min));
        mp.max = Math.max(root.val, Math.max(lp.max, rp.max));

        return mp;
    }

    public boolean isValidBST(TreeNode root) {
        BSTPair ansPair = isValidBSTHelp(root);

        return ansPair.isBST;
    }
}