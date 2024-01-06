import java.io.*;
import java.util.*;

class Node
{
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}

public class BoundaryLeveltraversal
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");

        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);

        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
            // Get and remove the front of the queue
            Node currNode = q.remove();

            // Get the current node's value from the string
            String currVal = s[i];

            // If the left child is not null
            if(!currVal.equals("N"))
            {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.left);
            }

            // For the right child
            i++;
            if(i >= s.length)
                break;
            currVal = s[i];

            // If the right child is not null
            if(!currVal.equals("N"))
            {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                q.add(currNode.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);

            Solution T = new Solution();

            ArrayList <Integer> res = T.boundary(root);
            for (Integer num : res) System.out.print (num + " ");
            System.out.println();
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node
// {
//     int data;
//     Node left, right;

//     public Node(int d)
//     {
//         data = d;
//         left = right = null;
//     }
// }

class Solution
{
    ArrayList<Integer> ansarr = new ArrayList<>();

    void addLeftNodes(Node root){

        if(root == null) return;

        if(root.left != null){

            if(isLeafNode(root) == false) ansarr.add(root.data);
            addLeftNodes(root.left);

        } else if(root.right != null) {

            if(isLeafNode(root) == false) ansarr.add(root.data);
            addLeftNodes(root.right);

        }

    }

    void addLeavesNodes(Node root){
        if(root == null) return;

        addLeavesNodes(root.left);

        if(isLeafNode(root))ansarr.add(root.data);

        addLeavesNodes(root.right);

    }

    void addRightNodes(Node root){

        if(root == null) return;

        if(root.right != null) {

            addRightNodes(root.right);
            if(!isLeafNode(root)) ansarr.add(root.data);


        } else if(root.left != null) {
            addRightNodes(root.left);
            if(isLeafNode(root) == false) ansarr.add(root.data);

        }

    }



    boolean isLeafNode(Node node){

        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }


    ArrayList <Integer> boundary(Node root)
    {
        if(root == null) return new ArrayList<>();

        // add root
        ansarr.add(root.data);

        // left view
        addLeftNodes(root.left);

        // add leaves

        addLeavesNodes(root.left);
        addLeavesNodes(root.right);

        // right view in reverse order excluding leaves and root
        addRightNodes(root.right);

        return ansarr;


    }
}
