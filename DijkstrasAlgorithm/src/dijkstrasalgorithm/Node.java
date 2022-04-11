package dijkstrasalgorithm;

import java.util.HashMap;
import java.util.Map;

public class Node {

    private String name;
    private int shortest;
    private Node prevNode;
    private Map<Node, Integer> neighbours;
    private boolean start;
    private boolean end;

    public Node(String name) {
        this.name = name;
        shortest = Integer.MAX_VALUE;
        this.neighbours = new HashMap<>();
    }

    public void addDistance(Node n, Integer d) {
        neighbours.put(n, d);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getShortest() {
        return shortest;
    }

    public void setShortest(int shortest) {
        this.shortest = shortest;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Map<Node, Integer> getNeighbours() {
        return neighbours;
    }

    public void setNeighbours(Map<Node, Integer> neighbours) {
        this.neighbours = neighbours;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return name;
    }

}
