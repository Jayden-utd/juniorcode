package cs6385network.project1.dijkstra;

/**
 * @Description:
 * @author: Jayden
 * @date:3/6/21 11:48 AM
 */
public class Node {

    public int nodeValue;
    public int distance;
    public Node next;
    public Node parent;

    public Node() {

    }

    public Node(int value) {
        this.nodeValue = value;
    }

    public Node(int nodeValue, int distance) {
        this.nodeValue = nodeValue;
        this.distance = distance;
    }
}
