package cs6385network.project1.calculatecost;
import cs6385network.project1.dijkstra.Graph;
import cs6385network.project1.dijkstra.Node;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @Description:
 * @author: Jayden
 * @date:3/6/21 11:50 AM
 */
public class CalculateCost {
    public static void main(String[] args) throws IOException {
//        @SuppressWarnings("resource")
//        Scanner sc = new Scanner(System.in);
//
//        System.out.println("Please enter number of nodes N: ");
//        int numberOfNodes = sc.nextInt();
//
//        System.out.println("Please enter k: ");
//        int w = sc.nextInt();

        int numberOfNodes = 25;
        float[] density = new float[25];
        int[] totalCost = new int[25];
        for (int para = 3; para <= 13; para++) {
            int k = para;
            //Create Graph
            Graph graph = new Graph();
            Node v[] = new Node[numberOfNodes];
            for(int i =0; i < v.length; i++){
                v[i] = new Node(i);
                graph.addNode(v[i]);
            }

            NetworkDesignInit networkParam = new NetworkDesignInit(numberOfNodes, k);

            //Initialize aij
            networkParam.initializeUnitCost();

            for(int i = 0; i < numberOfNodes; i++)
                for(int j = 0; j < numberOfNodes; j++){

                    graph.add_Edge(v[i].nodeValue, v[j].nodeValue, networkParam.a[i][j]);
                }
            System.out.println();
            System.out.println("Adjacency List representation of graph with:	aij");
            graph.printGraph();
            //Initialize bij
            networkParam.initializeTrafficDemand();
            System.out.println();
            System.out.println("Dijkstra's Algorithm Results:");
            //Calculate cost of each link
            for(int i = 0; i < v.length; i++){
                networkParam.calculateLinkCost(graph, v[i].nodeValue);
            }
            /*
             * Following function prints the matrix which stores the minimum cost from the source.
             */
            System.out.println("Minimum Unit Path Cost");
            networkParam.printUnitMinPathCostMatrix();

            BufferedWriter fw = new BufferedWriter(new FileWriter("/Users/wangjiacheng/Angie/network/k"+k+"_graph.csv"));
            for(int i=0;i<25;i++){
                //System.out.println();
                for(int j=0;j<25;j++){
                    //System.out.print(networkCostFinder.capacity[i][j]+" ");
                    if(i!=j && networkParam.unitMinPathCost[i][j] == 1){
                        fw.write(i+","+j);
                        fw.newLine();
                    }
                }
            }
            fw.close();





            //Calculate the network density.

            /*
             *  Network Density = (No of directed Edges) / (Possible number of directed edges)
             */
            float networkDensity = 0;

            /*
             *  Unused links can be: (1) A link having no direct edge
             *                       (2) A link having zero capacity.
             */
            int unUsedLinks = networkParam.calculateNetworkDensity();

            /*
             * Total links  = Possible number of directed edges
             */
            int totalLinks = (numberOfNodes)*(numberOfNodes - 1);

            /*
             * No of directed edges = Edges with non-zero assigned capacity
             */
            networkDensity = (float)(totalLinks - unUsedLinks)/(totalLinks);

            System.out.println("Total Links = " + totalLinks);
            System.out.println("Unused Links = " + unUsedLinks);
            System.out.println("Used Links = " + (totalLinks - unUsedLinks));
            System.out.println("Network Density = " + networkDensity);
            System.out.println("Optimal Cost of the network = " + networkParam.z_opt);
            density[para] = networkDensity;
            totalCost[para] = networkParam.z_opt;
        }


        System.out.println("how to depends");
        for (int tmp : totalCost) {
            if (tmp == 0) continue;
            System.out.print(tmp + " ");
        }
        System.out.println();
        for (float tmp : density) {
            if (tmp == 0.0) continue;
            System.out.print(tmp + " ");
        }
    }

}
