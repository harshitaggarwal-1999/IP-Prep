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
    public TreeNode sortedarrtobst(int[] arr, int si, int ei){
        if(si > ei){
            return null;
        }
        int mid = (si+ei)/2;
        TreeNode left = sortedarrtobst(arr,si, mid-1);
        TreeNode right = sortedarrtobst(arr, mid+1, ei);

        TreeNode curr = new TreeNode(arr[mid]);
        curr.left = left;
        curr.right = right;

        return curr;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        TreeNode ans = sortedarrtobst(nums, 0 , nums.length-1);
        return ans;
    }
}
