package Graphs.lecture6;

import java.util.*;

class Pair implements Comparable<Pair> {
    int u;
    int v;
    int wt;

    Pair(int u, int v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;

    }

    public int compareTo(Pair o) {
        return this.wt - o.wt;
    }
}


public class KruskalAlgo {
    static int[] par;
    static int[] rank;

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int vtcs = scn.nextInt();
        int edges = scn.nextInt();

        par = new int[vtcs + 1];
        rank = new int[vtcs + 1];

        ArrayList<Pair> arr = new ArrayList<>();
        for (int i = 0; i < edges; i++) {
            int u = scn.nextInt();
            int v = scn.nextInt();
            int wt = scn.nextInt();

            Pair p = new Pair(u, v, wt);
            arr.add(p);
        }

        Collections.sort(arr);

        //initialize the parent array and rank array
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }

        // iterate over the pairs and find the answer
        int ans = 0;
        for (int i = 0; i < arr.size(); i++) {
            Pair p = arr.get(i);
            int parofu = find(p.u);
            int parofv = find(p.v);
            if (parofu != parofv) {
                ans += p.wt;
                union(p.u, p.v);
            }
        }
        System.out.println(ans);
    }

    public static int find(int x) {
        if (par[x] == x) {
            return x;
        }
        int temp = find(par[x]);
        return par[x] = temp;
    }

    public static void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                par[ly] = lx;
            } else if (rank[ly] > rank[lx]) {
                par[lx] = ly;
            } else {
                par[lx] = ly;
                rank[ly]++;
            }
        }
    }

}

