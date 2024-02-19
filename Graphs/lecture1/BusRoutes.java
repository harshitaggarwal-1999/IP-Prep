package Graphs.lecture1;

import java.util.*;

public class BusRoutes {
    class Pair {
        int busStopNo;
        int buscount;

        Pair(int x, int y) {
            this.busStopNo = x;
            this.buscount = y;
        }
    }

    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) return 0;
        HashMap<Integer, ArrayList<Integer>> stopsVsBusesMap = new HashMap<>();
        int n = routes.length;

        // prepare a map of stops versus buses
        boolean sourcepresent = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                int busStop = routes[i][j];
                if (busStop == source) sourcepresent = true;
                ArrayList<Integer> buses = stopsVsBusesMap.getOrDefault(busStop, new ArrayList<>());
                buses.add(i);
                stopsVsBusesMap.put(busStop, buses);
            }
        }
        if (sourcepresent == false) {
            return -1;
        }

        ArrayDeque<Pair> queue = new ArrayDeque<>();
        HashSet<Integer> busnovis = new HashSet<>();
        HashSet<Integer> stopvis = new HashSet<>();
        queue.add(new Pair(source, 0));
        stopvis.add(source);

        while (queue.size() > 0) {
            Pair rem = queue.remove();

            // if rem == target just return rem.buscount
            if (rem.busStopNo == target) return rem.buscount;

            ArrayList<Integer> buses = stopsVsBusesMap.get(rem.busStopNo);
            for (int bus : buses) {
                if (busnovis.contains(bus)) {
                    continue;
                }

                // fetch the stops for the bus
                int[] stopsarr = routes[bus];
                for (int stop : stopsarr) {
                    if (stopvis.contains(stop)) {
                        continue;
                    }

                    queue.add(new Pair(stop, rem.buscount + 1));
                    stopvis.add(stop);
                }
                busnovis.add(bus);
            }
        }
        return -1;
    }
}