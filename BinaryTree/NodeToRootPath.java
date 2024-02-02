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
    List<String> ansarr = new ArrayList<>();

    public void BTPath(TreeNode root, String answer){
        if(root == null){
            return;
        }

        if(answer == ""){


            answer = root.val +"";
            // System.out.println("first Answer : " + answer);
        }else {
            answer = answer + "->" + root.val;
            // System.out.println("other Answer : " + answer);
        }
        BTPath(root.left, answer);
        BTPath(root.right,  answer);

        if(root.right == null && root.left == null) ansarr.add(answer);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        BTPath(root, "");
        return ansarr;

    }
}