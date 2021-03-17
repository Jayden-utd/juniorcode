package cs6385network.project1.calculatecost;
import cs6385network.project1.dijkstra.Graph;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Description:
 * @author: Jayden
 * @date:3/6/21 11:50 AM
 */
public class NetworkDesignInit {
    /*
     * Unit Cost Matrix
     */
    int a[][];

    /*
     * Traffic Demand Matrix
     */
    int b[][];

    /*
     * Unit cost of each link via shortest path
     */
    int unitMinPathCost[][];

    /*
     * Cost of each link via shortest path
     */
    int minPathCost[][];

    /*
     * Optimum cost of network
     */
    int z_opt = 0;

    //for finding random k
    ArrayList<Integer> list = new ArrayList<>();;
    ArrayList<Integer> pickNodes;

    static int k;

    /*
     * Number of nodes
     */
    static int numberOfNodes;

    public NetworkDesignInit(int numberOfNodes, int k) {

        NetworkDesignInit.numberOfNodes = numberOfNodes;
        NetworkDesignInit.k = k;

        unitMinPathCost = new int[numberOfNodes][numberOfNodes];
        minPathCost = new int[numberOfNodes][numberOfNodes];

    }

    /*
     * Initializes unit cost for each link
     */
    public void initializeUnitCost() {
        init();
        for (int i = 0; i < 25; i++) {
            List<Integer> tmp = setPickNodes(i, k);
            for (int j = 0; j < k; j++) {
                //For any given i, pick k random indices j1, j2, . . . , jk, all different from each
                //other and from i. Then set
                a[i][tmp.get(j)] = 1;
            }
        }
    }
    public void init() {
        a = new int[numberOfNodes][numberOfNodes];
        for (int i = 0; i <= 24; i++) {
            list.add(i);
        }
        for (int i = 0; i < a.length; i++) {
            Arrays.fill(a[i], 250);
            a[i][i] = 0;
        }
    }
    //pick random k
    public List<Integer> setPickNodes(int pick, int k) {
        Collections.shuffle(list);
        pickNodes = new ArrayList<>();
        int index = 0;
        while (pickNodes.size() < k) {
            if (pick != list.get(index)) {
                pickNodes.add(list.get(index));
            }
            index++;
        }
        return pickNodes;
    }

    /*
     * Initializes Traffic Demand for each link
     */
    public void initializeTrafficDemand() {
        //int studentID1[] = {2, 0, 2, 1, 3, 0};

        int studentID[] = {2, 0, 2, 1, 4, 9, 0, 0, 1, 4, 2, 0, 2, 1, 4, 9, 0, 0, 1, 4, 2, 0, 2, 1, 4};

        b = new int[numberOfNodes][numberOfNodes];

        System.out.println("Input Traffic demand matrix bij");
        for(int i = 0; i < b.length; i++) {
            for(int j = 0; j < b.length; j++){
                b[i][j] = Math.abs(studentID[i] - studentID[j]);
                //System.out.println("Traffic demand of " + " ("+(i) + " , " + (j) + ") :" + b[i][j]);
                System.out.print(b[i][j] + " ");
            }
            System.out.println();
        }
    }

    /*
     * Calculates total cost for each link based on shortest path
     */
    public void calculateLinkCost(Graph graph, int source) {

        graph.createMinHeap(numberOfNodes, source);
        graph.calculateShortestPath();

        System.out.println();
        System.out.println("Source " + source);
        for(int i = 0; i < numberOfNodes; i++){
            if(source != i) {
                unitMinPathCost[source][i] = graph.printDistanceParent(i);
                minPathCost[source][i] = unitMinPathCost[source][i] * b[source][i];
                //System.out.print(unitMinPathCost[source][i]);
                //System.out.println();
                z_opt += minPathCost[source][i];
                System.out.println("Cost of the link: "+ "("+(+source+ ", "+ i) +"):" + minPathCost[source][i]);
            }
        }
        System.out.println();
    }

    public void printUnitMinPathCostMatrix(){
        for(int i =0; i<numberOfNodes; i++){
            for(int j=0; j<numberOfNodes; j++){
                System.out.print(unitMinPathCost[i][j]+"  ");
            }
            System.out.println();
        }
    }

    /*
     *  Calculates network density. Network density = (No of directed edges)/(no of nodes)(no of nodes - 1)
     */
    public int calculateNetworkDensity(){
        int count = 0;
        for(int i =0; i< numberOfNodes; i++){
            for(int j =0; j< numberOfNodes; j++){
                //condition to check unused link
                if (i != j & (unitMinPathCost[i][j] == 0 || (unitMinPathCost[i][j] != 1 & unitMinPathCost[i][j] != 200))){
                    count ++;

                }
            }
        }

        return count;

    }

}
