package cs6385network.project3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;


public class Algorithm1_Constructive {
    public static void init(int n, HashMap<Integer, Point> points, int ex) throws IOException {
        int[][] adjmatrix = new int[n][n];
        List<Edge> edge = new ArrayList<>();

        /*Generates an empty graph for the components*/
        GenerateGraph graph = GraphProperties.generateEmptyGraph(n, points);
        graph.setAdjMatrix(adjmatrix);

        /*Generates edges for points i & j*/
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i < j) {
                    edge.add(new Edge(i, j, GraphProperties.getEdgeWeight(i, j, points)));
                }
            }
        }

        /*Sort the edge cost in ascending order*/
        Collections.sort(edge);

        /*Check the conditions (1),(2) and (3) of pdf i.e all the nodes are connected, degree is at least 3 and diameter is at most 4*/
        boolean isNodeConnected = new CheckConnectedNodes(graph).isNodeConnected();
        boolean isAtLeastDegreeThree = GraphProperties.isDegreeThree(graph, 3);
        boolean isAtMostDiameterFour = GraphProperties.isDiameterFour(graph, 4);
        boolean allThreeConditionsSatisfied = isNodeConnected && isAtLeastDegreeThree && isAtMostDiameterFour;
        double currCost = Double.POSITIVE_INFINITY;
        System.out.println("Constructive Current Cost [fully disconnected]: " + currCost);

        for (Edge edg : edge) {
            int i = edg.getNodei();
            int j = edg.getNodej();
            graph.getAdjMatrix()[i][j] = 1;
            graph.getAdjMatrix()[j][i] = 1;

            isNodeConnected = new CheckConnectedNodes(graph).isNodeConnected();
            isAtLeastDegreeThree = GraphProperties.isDegreeThree(graph, 3);
            isAtMostDiameterFour = GraphProperties.isDiameterFour(graph, 4);
            allThreeConditionsSatisfied = isNodeConnected && isAtLeastDegreeThree && isAtMostDiameterFour;

            if (allThreeConditionsSatisfied) {
                currCost = GraphProperties.getCost(graph);
                System.out.println("Constructive Current Cost [max] -> " + currCost);
                int[][] result = graph.getAdjMatrix();
                BufferedWriter fw = new BufferedWriter(new FileWriter("/Users/wangjiacheng/Angie/network/a1_" + ex + "_graph.csv"));
                for (int k = 0; k < result.length; k++) {
                    //System.out.println();
                    for (int p = 0; p < result[0].length; p++) {
                        //System.out.print(networkCostFinder.capacity[i][j]+" ");
                        if (k != p && result[k][p] == 1) {
                            fw.write(k + "," + p);
                            fw.newLine();
                        }
                    }
                }
                fw.close();
                break;
            }
        }
    }
}