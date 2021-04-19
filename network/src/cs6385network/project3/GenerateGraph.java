package cs6385network.project3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GenerateGraph {
    private int nVertices;
    private int[][] adjMatrix;
    private HashMap<Integer, Point> points;

    //Generates a graph of n vertices
    public GenerateGraph(int nVertices, HashMap<Integer, Point> points) {
        this.nVertices = nVertices;
        this.adjMatrix = new int[nVertices][nVertices];
        this.points = points;
    }

    public int nVertices() {
        return nVertices;
    }

    public void setAdjMatrix(int[][] adj) {
        this.adjMatrix = adj;
    }

    public int[][] getAdjMatrix() {
        return adjMatrix;
    }

    public HashMap<Integer, Point> getPoints() {
        return this.points;
    }

    //Get all the edges of the graph
    public List<Edge> edges() {
        List<Edge> edges = new ArrayList<Edge>();
        for (int i = 0; i < nVertices; i++) {
            for (int j = 0; j < nVertices; j++) {
                if (i < j && adjMatrix[i][j] == 1) {
                    edges.add(new Edge(i, j, getWt(i, j)));
                }
            }
        }
        return edges;
    }

    //Gets all the adjacent edges
    public List<Edge> adjacentEdges(int i) {
        List<Edge> edges = new ArrayList<Edge>();
        for (int j = 0; j < nVertices; j++) {
            if (adjMatrix[i][j] == 1) {
                edges.add(new Edge(i, j, getWt(i, j)));
            }
        }
        //System.out.println("edges: "+edges.stream().map(NodeEdge::getNodei).collect(Collectors.toList()));
        return edges;
    }

    //Returns edge weight
    private Double getWt(int i, int j) {
        if (this.points == null)
            return 1.0;
        Point p1 = points.get(i);
        Point p2 = points.get(j);
        double x1 = p1.getX();
        double x2 = p2.getX();
        double y1 = p1.getY();
        double y2 = p2.getY();
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    //Returns vertex degree
    public int degree(int i) {
        int sum = 0;
        for (int j = 0; j < nVertices; j++) {
            sum = sum + adjMatrix[i][j];
        }
        return sum;
    }

    //Returns the adjacent vertex
    public List<Integer> adjacent(int i) {
        List<Integer> list = new ArrayList<Integer>();
        for (int j = 0; j < this.nVertices; j++) {
            if (adjMatrix[i][j] == 1) {
                list.add(j);
            }
        }
        return list;
    }
}