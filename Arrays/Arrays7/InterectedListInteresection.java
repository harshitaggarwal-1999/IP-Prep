package Arrays.Arrays7;

import java.util.*;

public class InterectedListInteresection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        ArrayList<int[]> ans = new ArrayList<>();

        int i = 0, j = 0;

        while (i < firstList.length && j < secondList.length) {
            int flsp = firstList[i][0];
            int flep = firstList[i][1];
            int slsp = secondList[j][0];
            int slep = secondList[j][1];

            // System.out.println("flsp: "+ flsp +" flep: " + flep + " slsp: " + slsp + " slep: "+ slep);
            if ((flsp <= slep) && (slsp <= flep)) {
                int ansendpoint = 0;
                int ansstartingpoint = 0;
                if (flep >= slep) {
                    // first list is ending late
                    ansstartingpoint = Math.max(flsp, slsp);
                    ansendpoint = Math.min(flep, slep);
                    if (flep == slep) i++;
                    j++;

                } else if (flep < slep) {
                    // second list is ending late
                    ansstartingpoint = Math.max(flsp, slsp);
                    ansendpoint = Math.min(flep, slep);
                    i++;
                }

                int[] arr = new int[2];
                arr[0] = ansstartingpoint;
                arr[1] = ansendpoint;

                ans.add(arr);
            } else {
                // the list whose end point is ending first needs to be moved forward
                // this case arrises when there is no intersection
                if (flep < slep) {
                    i++;
                } else {
                    j++;
                }
            }
        }

        return ans.toArray(new int[ans.size()][2]);
    }
}