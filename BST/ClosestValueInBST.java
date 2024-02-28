package BST;

public class ClosestValueInBST {

    static int minDiff(Node root, int K) {
        Result result = new Result(Integer.MAX_VALUE);
        findMinDiff(root, K, result);
        return result.minDiff;
    }

    private static void findMinDiff(Node node, int K, Result result) {
        if (node == null) {
            return;
        }

        // Update the minimum absolute difference
        result.minDiff = Math.min(result.minDiff, Math.abs(node.data - K));

        // Traverse left or right based on the value of K
        if (K < node.data) {
            findMinDiff(node.left, K, result);
        } else if (K > node.data) {
            findMinDiff(node.right, K, result);
        } else {
            // If the current node's value is equal to K, no need to continue searching
            return;
        }
    }

    // Helper class to store the minimum absolute difference
    static class Result {
        int minDiff;

        Result(int minDiff) {
            this.minDiff = minDiff;
        }
    }
}