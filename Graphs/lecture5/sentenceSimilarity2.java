package Graphs.lecture5;

import java.util.*;

public class sentenceSimilarity2 {
    HashMap<String, String> par = new HashMap<>();
    HashMap<String, Integer> rank = new HashMap<>();

    public void sentenceSimilarity(String[] words1, String[] words2, String[][] pairs) {
        int n = pairs.length;

        // initialisation of parent map and rank map
        for (String[] pair : pairs) {
            for (int j = 0; j < 2; j++) {
                String currstring = pair[j];
                par.put(currstring, currstring);
                rank.put(currstring, 1);
            }
        }

        // now match each value in each pair to itself and unite them
        for (String[] pair : pairs) {
            String currstring1 = pair[0];
            String currstring2 = pair[1];

            union(currstring1, currstring2);
        }

        for (int i = 0; i < words1.length; i++) {
            String currstring1 = words1[i];
            String currstring2 = words2[i];

            if (find(currstring1) != find(currstring2)) {
                System.out.println("FALSE");
                return;
            }
        }

        System.out.println("TRUE");
    }

    // find the leader
    public String find(String x) {
        if (par.get(x) == x) {
            return x;
        }
        String temp = find(par.get(x));
        par.put(x, temp);
        return temp;
    }

    // find the leaders of both and if they are different it will unite them on the basis of rank array
    public void union(String x, String y) {
        String lx = find(x);
        String ly = find(y);
        if (lx != ly) {
            if (rank.get(lx) > rank.get(ly)) {
                par.put(ly, lx);
            } else if (rank.get(lx) < rank.get(ly)) {
                par.put(lx, ly);
            } else {
                par.put(lx, ly);
                rank.put(ly, rank.get(ly) + 1);
            }
        }
    }
}

