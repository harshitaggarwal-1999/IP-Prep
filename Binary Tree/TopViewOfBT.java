

//User function Template for Java

/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
*/

class Pair{
    Node node;
    int level;


    Pair(Node node, int level){
        this.node = node;
        this.level = level;
    }
}

class Solution
{
    //Function to return a list of nodes visible from the top view 
    //from left to right in Binary Tree.
    static ArrayList<Integer> topView(Node root)
    {

        if(root == null) return new ArrayList<>();
        // add your code
        Queue<Pair> q = new ArrayDeque<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        q.add(new Pair(root,0));

        int maxlevel = Integer.MIN_VALUE;
        int minlevel = Integer.MAX_VALUE;

        while(q.size() > 0){
            int size = q.size();

            while(size-- > 0){
                Pair currpair = q.remove();
                int currnodelevel = currpair.level;
                maxlevel = Math.max(maxlevel, currnodelevel);
                minlevel = Math.min(minlevel, currnodelevel);
                if(map.containsKey(currnodelevel) == false){
                    map.put(currnodelevel, currpair.node.data);
                }

                if(currpair.node.left != null){
                    q.add(new Pair(currpair.node.left, currnodelevel-1));
                }
                if(currpair.node.right != null){
                    q.add(new Pair(currpair.node.right, currnodelevel+1));
                }
            }
        }


        // step 2 -  print the answer

        ArrayList<Integer> ans = new ArrayList<>();

        for(int i = minlevel; i <= maxlevel; i++){
            int levelvalue = map.get(i);

            ans.add(levelvalue);

        }

        return ans;







    }
}