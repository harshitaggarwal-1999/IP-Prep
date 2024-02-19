//User function Template for Java

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

    //Function to return a list containing the bottom view of the given tree.
    public ArrayList <Integer> bottomView(Node root)
    {
        // Code here
        if(root == null){
            return new ArrayList<>();
        }

        Queue<Pair> q = new ArrayDeque<>();

        q.add(new Pair(root, 0));
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxlevel = Integer.MIN_VALUE;
        int minlevel = Integer.MAX_VALUE;

        while(q.size() > 0){
            int size = q.size();
            while(size-- > 0){

                Pair currpair = q.remove();
                int currlevel = currpair.level;
                maxlevel = Math.max(maxlevel, currlevel);
                minlevel = Math.min(minlevel, currlevel);

                map.put(currlevel, currpair.node.data);

                if(currpair.node.left != null){
                    q.add(new Pair(currpair.node.left, currlevel-1));
                }

                if(currpair.node.right != null){
                    q.add(new Pair(currpair.node.right, currlevel+1));
                }
            }
        }

        //step 2 printing the values;
        // for (int name: map.keySet()) {
        //     int key = name;
        //     int value = map.get(name);
        //     System.out.println(key + " -> " + value);
        // }

        ArrayList<Integer> ansarr = new ArrayList<>();

        // System.out.println(minlevel +" , "+ maxlevel);

        for(int i = minlevel; i <= maxlevel; i++){
            int levelvalue = map.get(i);
            ansarr.add(levelvalue);
        }

        return ansarr;

    }
}