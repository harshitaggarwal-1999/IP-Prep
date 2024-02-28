/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> q = new ArrayDeque<>();
        q.add(root);

        // this code has to be done iterative because otherwise hum jo ek subtree ka rightmost and doosre subtree ka ussi level par leftmost ko connect karna hi bhul jaenge
        // issiliye issi code ko iterative hona bahut jaruri hai
        while(q.size() > 0){
            int size = q.size();
            // rem ko pehle define issiliye kiya hai kyuki baadme iski jarurt padegi
            Node rem = null;

            while(size-- > 0) {
                rem = q.remove();

                if(rem.left != null){
                    q.add(rem.left);
                }

                if(rem.right != null){
                    q.add(rem.right);
                }
                // ensure karega ki saare bonds perfect tareeke se ml rhe hai ya nahi
                if(size > 0) rem.next = q.peek();
            }
            // jaise hi ek level process ho jaeag vaise hi uss level ke last vaale me null daalne ka kaam ye vaka piece of code karega
            rem.next = null;
        }
        return root;

    }
}