package Graphs.Lecture8;

import java.util.*;

public class SlidingPuzzles {
    // BFS (brute force saaari possiblity check karenge)
    // isme hum ek queue of strings le lenge and saari 2-d array ki values ko ek
    // string me store karva denge and phir uss string me swapping karnge according
    // to our hard coded dirs modified and visited ke liye har string ko hashset me
    // store kar lenge taaki pata chal sake ki ye pehle ban chuka hai isey queue me
    // add karne ka koi fayda nahi
    public int slidingPuzzle(int[][] board) {
        List<List<Integer>> dirs = new ArrayList<>();
        dirs.add(Arrays.asList(1, 3));
        dirs.add(Arrays.asList(0, 2, 4));
        dirs.add(Arrays.asList(1, 5));
        dirs.add(Arrays.asList(0, 4));
        dirs.add(Arrays.asList(3, 1, 5));
        dirs.add(Arrays.asList(2, 4));

        HashSet<String> set = new HashSet<>();
        ArrayDeque<String> q = new ArrayDeque<>();
        int ans = 0;
        // adding first string to q by converting it into string first
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(board[i][j]);
            }
        }

        String answerString = "123450";
        if (answerString.equals(sb.toString()))
            return 0;

        q.add(sb.toString());
        set.add(sb.toString());

        while (q.size() > 0) {
            ans++;
            int size = q.size();
            while (size-- > 0) {
                String currstring = q.remove();
                // System.out.println("currSTring: " + currstring);
                // so that we can make swap and also to find the dirs(ki kaha kaha swapping
                // karni hai i mean kaunse indexes par
                int idxofzero = positionOfZero(currstring);
                // int idxofzero = currstring.indexOf('0');

                // dirs check and add
                List<Integer> currdirs = dirs.get(idxofzero);
                // System.out.println(currdirs);

                for (int i = 0; i < currdirs.size(); i++) {
                    // agar iss for vale loop ke bahar banaya to error aa jaega kyuki hum same string builder me hi change kar rhe honge
                    sb = new StringBuilder(currstring);

                    // har ek idx jo uss dirs me hoga usse swap karo and har shuffling ko add karte
                    // jao check karke kahi vo pehle se to occur nahi hochuke and also agar vo hmare
                    // answerString se match ho gyi directly vahi bhej do
                    int idx = currdirs.get(i);
                    // System.out.println("idx: " + idx + " idxofZero: " + idxofzero);
                    sb.setCharAt(idx, currstring.charAt(idxofzero));
                    sb.setCharAt(idxofzero, currstring.charAt(idx));
                    String newstring = sb.toString();
                    // System.out.println("newString: " + sb.toString());
                    if (set.contains(newstring) == false) {
                        q.add(newstring);
                        set.add(newstring);
                    }
                    if (newstring.equals(answerString)) {
                        return ans;
                    }
                }
            }
        }

        // agar kahi bhi answer nahi mila to -1 return karna hia kyuki tabhi hum saari
        // iterations karke loop se bahar aaye honge
        return -1;
    }

    public int positionOfZero(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                return i;
            }
        }
        return 0;
    }
}
