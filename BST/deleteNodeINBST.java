package BST;

public class deleteNodeINBST {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (root.val > key) {
            // jo jo answer hmara recursion vaapis karta jaega vaha vaha usey root.left ya root.right me add karte jao code ke hissab se
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            // jab delete karenge to vo node delete ho jaega to uss particualr stack value ke liye vo node joki iss delete function se aaya hoga vo deleteNode vaale function ke liye root hoga aur phir ussey return karenge taaki von upar codes me aapne hissab se uss stack ke root ke right ya left me jud jae
            root = delete(root, key);
        }
        return root;
    }

    public TreeNode delete(TreeNode root, int key) {
        // agar dono hi null hai to leaf node hai top directly null bhej do
        if (root.left == null && root.right == null) {
            return null;

            // agar left null hai to right ka pehla node yani kli root.right bhej do
        } else if (root.left == null) {
            return root.right;

            // agar right null hai to left ka pehle node yani ki root.left bhej do
        } else if (root.right == null) {
            return root.left;
        } else {
            // agar dono null nahi hai to uss root.right child ko root.left ke sabse bade eleement ke aage laga do and return kardo uss root.left ko
            TreeNode leftc = root.left;
            TreeNode rightc = root.right;
            TreeNode leftctobereturned = root.left;

            while (leftc.right != null) {
                leftc = leftc.right;
            }

            leftc.right = rightc;
            return leftctobereturned;
        }
    }
}
