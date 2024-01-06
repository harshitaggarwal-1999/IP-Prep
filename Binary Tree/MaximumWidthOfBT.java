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
class Pair {
    TreeNode node;
    int idx;

    public Pair(TreeNode node, int idx){
        this.node = node;
        this.idx = idx;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(root, 0));
        int maxwidth = 0;

        while(q.size() > 0){
            int size = q.size();
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;

            while(size-- > 0){
                Pair rem = q.remove();
                int remidx = rem.idx;
                min = Math.min(min, remidx);
                max = Math.max(max, remidx);

                if(rem.node.left != null){
                    q.add(new Pair(rem.node.left, (2*remidx)+1));
                }

                if(rem.node.right != null){
                    q.add(new Pair(rem.node.right, (2*remidx)+2));
                }

            }

            maxwidth = Math.max(maxwidth, max-min + 1);
        }

        return maxwidth;
    }
}