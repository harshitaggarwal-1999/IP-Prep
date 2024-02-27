package Graphs.lecture5;

import java.util.HashMap;

public class SatisfiabilityOfEqualityEquations {
    HashMap<Character, Character> par;
    HashMap<Character, Integer> rank;

    public boolean equationsPossible(String[] equations) {
        par = new HashMap<>();
        rank = new HashMap<>();

        // initialize the parent array
        for (String currstring : equations) {
            char ch1 = currstring.charAt(0);
            char ch2 = currstring.charAt(3);

            par.put(ch1, ch1);
            par.put(ch2, ch2);
            rank.put(ch1, 1);
            rank.put(ch2, 1);
        }

        // for the similarity symbols unite the both character having similarity sign
        for (String currstring : equations) {
            char ch1 = currstring.charAt(0);
            char ch2 = currstring.charAt(3);

            char symbol = currstring.charAt(1);
            if (symbol == '=') {
                union(ch1, ch2);
            }
        }

        // now checnk the answer and check for the != signs
        for (String currstring : equations) {
            char ch1 = currstring.charAt(0);
            char ch2 = currstring.charAt(3);

            char symbol = currstring.charAt(1);
            if (symbol == '!') {
                char parch1 = find(ch1);
                char parch2 = find(ch2);

                if (parch1 == parch2) {
                    return false;
                }
            }
        }
        return true;
    }

    public char find(char x) {
        // base case
        if (par.get(x) == x) {
            return x;
        }

        // recursive calls
        char temp = find(par.get(x));
        par.put(x, temp);
        // return ans
        return temp;
    }

    public void union(char x, char y) {
        char lx = find(x);
        char ly = find(y);

        if (lx != ly) {
            if (rank.get(lx) > rank.get(ly)) {
                par.put(lx, ly);
            } else if (rank.get(lx) < rank.get(ly)) {
                par.put(ly, lx);
            } else {
                par.put(ly, lx);
                rank.put(lx, rank.get(lx) + 1);
            }
        }
    }
}