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

    public TreeNode bstfrompreorder(int[] preorder, int si, int ei){
        //base case
        if(si > ei) return null;

        // collect si and find the node whi is 'just bigger than root idx'(jbtri) by traversing;
        int jbtri = si;
        // for(jbtri = si; jbtri <= ei; jbtri++){
        //     if(preorder[jbtri] > preorder[si]){
        //         break;
        //     }
        // }

        while(jbtri <= ei && preorder[jbtri] <= preorder[si]){
            jbtri++;
        }

        // left and right recursion to make left and right

        TreeNode left = bstfrompreorder(preorder, si+1, jbtri-1);
        TreeNode right = bstfrompreorder(preorder, jbtri, ei);

        // now recursion has prepared the tree we just need it to be attached to the root node
        TreeNode curr = new TreeNode(preorder[si]);

        curr.left = left;
        curr.right = right;

        // return the TreeNode
        return curr;

    }

    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder.length == 0)
            return null;

        TreeNode root = bstfrompreorder(preorder, 0, preorder.length-1);

        return root;
    }
}