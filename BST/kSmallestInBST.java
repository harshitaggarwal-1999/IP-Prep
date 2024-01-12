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
    // ArrayList<Integer> arr =  new ArrayList<>();
    int ans = -1;
    int count = 0;
    public void inordertraversal(TreeNode root, int k){
        if(root == null) return;

        inordertraversal(root.left, k);
        count++;
        if(count == k){
            ans = root.val;
        }
        inordertraversal(root.right, k);


    }
    public int kthSmallest(TreeNode root, int k) {
        inordertraversal(root, k);
        // int ans = arr.get(k-1);
        return ans;
    }
}