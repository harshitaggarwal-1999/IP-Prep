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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        List<List<Integer>> ansarr = new ArrayList<>();

        Stack<TreeNode> pst = new Stack<>();
        pst.push(root);
        boolean reverse = true;

        while(pst.size()> 0){
            int size = pst.size();

            Stack<TreeNode> cst = new Stack<>();
            List<Integer> currans = new ArrayList<>();

            while(size-- > 0){
                TreeNode rem = pst.pop();
                currans.add(rem.val);

                if(reverse){
                    if(rem.left != null){
                        cst.push(rem.left);
                    }

                    if(rem.right != null){
                        cst.push(rem.right);
                    }
                }else{

                    if(rem.right != null){
                        cst.push(rem.right);
                    }
                    if(rem.left != null){
                        cst.push(rem.left);
                    }
                }

            }
            reverse = !reverse;
            ansarr.add(currans);
            pst = cst;
        }
        return ansarr;
    }
}