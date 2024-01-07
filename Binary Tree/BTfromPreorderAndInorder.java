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
    public TreeNode buildTree(int[] preorder, int psi, int pei, int[] inorder, int isi, int iei){
        if(isi > iei){
            return null;
        }

        int idx = isi;
        while(inorder[idx] != preorder[psi]) idx++;
        int countOfLeftSubtreeElem = idx-isi;

        TreeNode root = new TreeNode(preorder[psi]);

        TreeNode leftsubtree = buildTree(preorder, psi+1, psi+countOfLeftSubtreeElem, inorder, isi, idx-1);
        TreeNode rightsubtree = buildTree(preorder, psi+countOfLeftSubtreeElem+1, pei, inorder, idx+1, iei);

        root.left = leftsubtree;
        root.right = rightsubtree;

        return root;
    }


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        return buildTree(preorder,0,n-1,inorder,0,n-1);

    }
}