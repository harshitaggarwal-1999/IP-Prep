package Graphs.Lecture9;

import java.util.*;

public class ReconstructIternary {
    LinkedList<String> list = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        HashMap<String, PriorityQueue<String>> graph = new HashMap<>();

        for (List<String> edge : tickets) {
            if (graph.containsKey(edge.get(0)) == false) {
                graph.put(edge.get(0), new PriorityQueue<>());
            }
            PriorityQueue<String> currpq = graph.get(edge.get(0));
            currpq.add(edge.get(1));
            graph.put(edge.get(0), currpq);

            if (graph.containsKey(edge.get(1)) == false) {
                graph.put(edge.get(1), new PriorityQueue<>());
            }
            currpq = graph.get(edge.get(1));
            currpq.add(edge.get(0));
            graph.put(edge.get(1), currpq);
        }

        dfs(graph, "jfk");
        return list;
    }

    public void dfs(HashMap<String, PriorityQueue<String>> graph, String src) {
        String currnbr = null;
        if (graph.get(src).size() > 0) {
            currnbr = graph.get(src).remove();
        }

        if (currnbr != null)
            dfs(graph, currnbr);

        list.addFirst(src);
    }
}