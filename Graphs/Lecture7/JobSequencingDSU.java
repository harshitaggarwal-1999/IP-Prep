package Graphs.Lecture7;

import java.util.*;
class Job {
    int id, profit, deadline;

    Job(int x, int y, int z) {
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}
public class JobSequencingDSU
{
    //Function to find the maximum profit and the number of jobs done.
    // dsu application with just path compression not union by rank
    int[] par;

    int[] JobScheduling(Job arr[], int n) {
        // Your code here
        Arrays.sort(arr, new Comparator<Job>() {
            @Override
            public int compare(Job o1, Job o2) {
                return o2.profit - o1.profit;
            }
        });
        int maxdays = 0;
        for(int i = 0; i < n; i++){
            maxdays = Math.max(maxdays, arr[i].deadline);
        }

        par = new int[maxdays+1];
        // System.out.println("maxdays: " +maxdays);

        // initialize the parent array
        for (int i = 0; i < par.length; i++) {
            par[i] = i;
        }

        // now we will check if par[x] == x then that particular day has not been mapped
        // and if par[x] == x we are gonna union it and also we will add the profit but otherwise we won't
        int profitmax = 0;
        int jobcount = 0;
        for(int i = 0; i < n; i++){
            Job currjob = arr[i];
            int day = currjob.deadline;
            int id = currjob.id;
            int profit = currjob.profit;
            // System.out.println("outer id : " +id);

            // find the parent of day if day is mapped and parofday is not equal to 0 then it's parent will be diffrent otherwise par of x will be equal to x
            int parofday = find(day);
            // System.out.println("parofdaythen : "+parofday);
            if(parofday == 0){
                continue;
            }else{
                profitmax+=profit;
                jobcount++;
                // System.out.println(id);
                // System.out.println(profitmax);
                union(parofday, parofday-1);
                parofday = find(day);
                // System.out.println("parofdaynow : "+parofday);
                // System.out.println("---------------------- ");
            }


        }
        int[] ansarr = new int[2];
        ansarr[0] = jobcount;
        ansarr[1] = profitmax;
        return ansarr;
    }

    public int find(int x){
        if(par[x] == x){
            return x;
        }

        int temp = find(par[x]);
        return par[x] = temp;
    }

    public void union(int x,int y){
        int lx = find(x);
        int ly = find(y);

        if(lx != ly){
            par[lx] = ly;
        }
    }
}
