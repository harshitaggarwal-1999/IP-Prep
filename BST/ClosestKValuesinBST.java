package BST;

import java.util.LinkedList;
import java.util.List;

public class ClosestKValuesinBST {
    public List<Integer> closestKValues(TreeNode root, int k, double target) {
        LinkedList<Integer> ans = new LinkedList<>();

        traversal(root, k, target, ans);
        return ans;
    }

    public void traversal(TreeNode root, int k, double target, LinkedList<Integer> ans) {
        if (root == null) {
            return;
        }

        // agar size chota hai to bas directly add kar dene ka , nah to pahle check karo ki kya vo add karne layak hai ya nahi if haan to pehle ans list ke pehle vaale ko remove karo and phir naye vaale ko daalo last me
        if (ans.size() < k) {
            ans.addLast(root.val);
        } else {
            if (Math.abs(root.val - target) < Math.abs(target - ans.peekFirst())) {
                ans.removeFirst();
                ans.addLast(root.val);
            }
        }
        traversal(root.right, k, target, ans);
    }
}
