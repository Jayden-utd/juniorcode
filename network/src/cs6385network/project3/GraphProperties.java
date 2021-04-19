package cs6385network.project3;

import java.util.*;

public class GraphProperties {
    //Checks if the diameter of the graph is at most 4

    public static boolean isDiameterFour(GenerateGraph graph, int hops) {
        int[][] adj = graph.getAdjMatrix();
        for (int i = 0; i < adj.length; i++) {
            if (!bfs(i, adj)) {
                return false;
            }
        }
        return true;
    }
    public static boolean bfs(int source, int[][] matrix) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(source);
        queue.add(source);
        int count = 0;
        while (!queue.isEmpty() && count < 4) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                for (int j = 0; j < matrix[temp].length; j++) {
                    if (matrix[temp][j] == 1) {
                        if (!visited.contains(j)) {
                            visited.add(j);
                            queue.add(j);
                        }
                    }
                }
            }
            count++;
        }
        if (visited.size() == matrix.length) {
            return true;
        }
        return false;
    }


    //Checks if each node is connected to at least 3 other nodes
    public static boolean isDegreeThree(GenerateGraph g, int n) {
        for (int i = 0; i < g.nVertices(); i++) {
            if (g.degree(i) < 3) {
                return false;
            }
        }
        return true;
    }

    //Generates a connected graph for the given nodes and points
    public static GenerateGraph generateFullyConnectedGraph(int n, HashMap<Integer, Point> points) {
        GenerateGraph graph = new GenerateGraph(n, points);
        int[][] adj = new int[n][n];
        for (int i = 0; i < adj.length; i++) {
            for (int j = 0; j < adj.length; j++) {
                if (i != j) {
                    adj[i][j] = 1;
                }
            }
        }
        graph.setAdjMatrix(adj);
        return graph;
    }

    //Gives the cost of the graph
    public static double getCost(GenerateGraph graph) {
        double wt = 0.0;
        for (Edge e : graph.edges()) {
            wt = wt + e.getWeight();
        }
        return wt;
    }

    //Generates an empty graph for the given nodes and points
    public static GenerateGraph generateEmptyGraph(int n, HashMap<Integer, Point> points) {
        GenerateGraph graph = new GenerateGraph(n, points);
        int[][] adj = new int[n][n];
        graph.setAdjMatrix(adj);
        return graph;
    }

    //Get the edge weight between points
    public static Double getEdgeWeight(int i, int j, HashMap<Integer, Point> points) {
        Point p1 = points.get(i);
        Point p2 = points.get(j);
        double x1 = p1.getX();
        double x2 = p2.getX();
        double y1 = p1.getY();
        double y2 = p2.getY();
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}