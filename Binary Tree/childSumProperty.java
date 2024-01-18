
class childSumProperty {
    boolean ans = true;

    public boolean childSumPropertyHelp(TreeNode root) {
        if (root == null) return true;

        boolean leftcheck = childSumPropertyHelp(root.left);
        boolean rightcheck = childSumPropertyHelp(root.right);

        int sum = 0;
        if (root.right != null) sum = root.right.val;
        if (root.left != null) sum = sum + root.left.val;
        if (root.val != sum && root.left != null && root.right != null) ans = false;

        return true;
    }

    public boolean childSumProperty(TreeNode root) {
        childSumPropertyHelp(root);
        return ans;
    }
}