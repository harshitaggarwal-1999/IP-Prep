package Graphs.lecture5;

import java.util.*;

public class EvaluateDivision {
    class Node {
        String key;
        double val;

        public Node(String s, double val) {
            this.key = s;
            this.val = val;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Node>> g = BuildGraph(equations, values);
        double[] result = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), new HashSet<>(), g);
        }
        return result;

    }

    private double dfs(String s, String d, HashSet<String> visited, Map<String, List<Node>> g) {
        if (!(g.containsKey(s) && g.containsKey(d))) {
            return -1.0;
        }
        if (s.equals(d))
            return 1.0;

        visited.add(s);
        for (Node ng : g.get(s)) {
            if (visited.contains(ng.key) == false) {
                double ans = dfs(ng.key, d, visited, g);
                if (ans != -1.0) {
                    return ans * ng.val;
                }
            }
        }
        return -1.0;
    }

    public Map<String, List<Node>> BuildGraph(List<List<String>> equations, double[] values) {
        Map<String, List<Node>> g = new HashMap<>();
        for (int i = 0; i < values.length; i++) {
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            g.putIfAbsent(src, new ArrayList<>());
            g.putIfAbsent(dest, new ArrayList<>());
            g.get(src).add(new Node(dest, values[i]));
            g.get(dest).add(new Node(src, values[i]));
        }
        return g;
    }
}
