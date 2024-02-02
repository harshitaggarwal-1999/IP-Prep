package BinaryTree;

public class childSumProperty {
    boolean ans = true;

    public int childSumPropertyHelp(TreeNode root) {
        if(root == null || root.left == null && root.right == null){
            return 1;
        }

        int leftsum = 0, rightsum = 0;

        if(root.left != null){
            leftsum += root.left.val;
        }
        if(root.right != null){
            rightsum += root.right.val;
        }

        int leftcheck = childSumPropertyHelp(root.left);
        int rightcheck = childSumPropertyHelp(root.right);

        if(root.val == (leftsum+rightsum) && leftcheck != 0 && rightcheck != 0){
            return 1;
        }
        return 0;
    }

    public boolean childSumProperty(TreeNode root) {
        boolean ans = (childSumPropertyHelp(root) == 1)?true:false;
        return ans;
    }
}