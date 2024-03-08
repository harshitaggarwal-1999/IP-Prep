package Graphs.Lecture7;

import java.util.HashMap;
import java.util.HashSet;

public class SimilarStringsGroup {
    // application of DSU - clear reference as the transitive relation between strings is discussed and similar words is used
    HashMap<String, String> par;
    HashMap<String, Integer> rank;

    public int numSimilarGroups(String[] strs) {
        par = new HashMap<>();
        rank = new HashMap<>();

        // initialise the parent and rank array
        for (int i = 0; i < strs.length; i++) {
            String currstring = strs[i];
            par.put(currstring, currstring);
            rank.put(currstring, 1);
        }

        // double looping in the string to check all pairs
        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                String currstring1 = strs[i];
                String currstring2 = strs[j];

                int lettersdiff = helperfunction(currstring1, currstring2);
                if (lettersdiff > 2) {
                    continue;
                } else {
                    union(currstring1, currstring2);
                }
            }
        }

        // check how many groups are there so for that if find of each word is equal to that word that means that it is the same group but if not then it shouldn't be counted
        HashSet<String> ans = new HashSet<>();
        for (int i = 0; i < strs.length; i++) {
            String currstring = strs[i];
            String parofcurrstring = find(currstring);
            System.out.println(currstring + " " + parofcurrstring);

            if (currstring == parofcurrstring) {
                ans.add(currstring);
            }
        }

        return ans.size();
    }

    public int helperfunction(String s1, String s2) {
        int lettersdiff = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                lettersdiff++;
            }
        }
        return lettersdiff;
    }

    public String find(String x) {
        if (par.get(x).equals(x)) {
            return x;
        }
        String temp = find(par.get(x));
        par.put(x, temp);
        return temp;
    }

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