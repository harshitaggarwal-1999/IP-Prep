package BinaryTree;

class countCompleteBinaryTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int leftheight = leftheight(root);
        int rightheight = rightheight(root);

        if (leftheight == rightheight) {
            return ((1 << leftheight) - 1);
        }

        int leftnodes = countNodes(root.left);
        int rightnodes = countNodes(root.right);

        return rightnodes + leftnodes + 1;
    }

    public int leftheight(TreeNode root) {
        int count = 1;
        if (root != null) {
            root = root.left;
            count++;
        }
        return count;
    }

    public int rightheight(TreeNode root) {
        int count = 1;
        if (root != null) {
            root = root.right;
            count++;
        }
        return count;
    }
}