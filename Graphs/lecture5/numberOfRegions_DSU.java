package Graphs.lecture5;
import java.util.*;

public class numberOfRegions_DSU {
}

class Solution {
    int ans;
    int[] par;
    int[] rank;

    // we are going to visualize this question in form of dots which are in n+1 numbers in each row
    // and then find the numbers of cycle in undirected graph
    // if two elements are passed in union if both of elements are having same leaders this mean that both elements are somehow connected and hum ek aur edge add karke usey aur join kar rhe hai
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        // as mentioned number of dots will be one more than number of elements in the grid
        int dots = (n + 1);
        ans = 0;
        par = new int[dots * dots];
        Arrays.fill(par, -1);
        rank = new int[dots * dots];

        // first we will initialise all ther eleements with themselves as the leader and put there rank as 1
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
            rank[i] = 1;
        }
        // answer = 1 ka matlab hai ki humne saare boundary elements add kardiye hai vo khud apna ek region bana rhe hai issiliye humne usey 1 se initialise kiya hai yaha
        ans = 1;

        // now here we will add all the boundary dots to point towards the same leader which is going to be the one
        for (int i = 0; i < dots; i++) {
            for (int j = 0; j < dots; j++) {
                // checking for the boundary elements
                if (i == 0 || j == 0 || i == n || j == n) {
                    int cellnumber = (i * (dots)) + j;
                    // if that cell number is not equal to the 0 then just perform the step of union it with 0
                    if (cellnumber != 0) {
                        union(cellnumber, 0);
                    }
                }
            }
        }

        // TRAVELING ON THE GIVEN GRID

        for (int i = 0; i < n; i++) {
            String currstr = grid[i];
            //breaking the grid into the char array
            char[] chararr = currstr.toCharArray();
            for (int j = 0; j < chararr.length; j++) {
                // if currchar element is '/' to vo i+1, j and i , j+1 vaale ko connect karega
                if (chararr[j] == '/') {
                    int cellnumber1 = (i + 1) * (dots) + j;
                    int cellnumber2 = (i * dots) + (j + 1);

                    union(cellnumber1, cellnumber2);

                    // if currchar element is '\' to phir vo i,j and i+1, j+1 vale ko connect karega
                } else if (chararr[j] == '\\') {

                    int cellnumber1 = i * (dots) + j;
                    int cellnumber2 = (i + 1) * (dots) + (j + 1);

                    union(cellnumber1, cellnumber2);
                }
            }
        }
        return ans;
    }

    public int find(int x) {
        if (par[x] == x) {
            return x;
        }
        int temp = find(par[x]);
        return par[x] = temp;
    }

    public void union(int x, int y) {
        int lx = find(x);
        int ly = find(y);

        if (lx != ly) {
            if (rank[lx] > rank[ly]) {
                par[ly] = lx;
            } else if (rank[x] < rank[y]) {
                par[lx] = ly;
            } else {
                par[lx] = ly;
                rank[ly]++;
            }
            // ab agar usey dono elment jo union me pass hue hai agar vo usey samne me mile to iska matlab hai ki cycle bani hai and cycle banne ka matlab hai hmare answer me ek aur + karna vahi humen else me kiya hai
        } else {
            ans++;
        }
    }
}
