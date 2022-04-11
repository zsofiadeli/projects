package dijkstrasalgorithm;

import java.util.ArrayList;
import java.util.List;

public class Graph {

    private Node start;
    private Node finish;
    private List<Node> nodes;
    private List<Node> visited;
    private List<Node> unvisited;

    public Graph() {
        nodes = new ArrayList<>();
        visited = new ArrayList<>();
        unvisited = new ArrayList<>();
    }

   

    //setting distance from the start
    public void distanceSetting(Node currentNode) {

        for (Node node : currentNode.getNeighbours().keySet()) {
            if (node.getShortest() > (currentNode.getShortest() + currentNode.getNeighbours().get(node))) {
                node.setShortest(currentNode.getShortest() + currentNode.getNeighbours().get(node));
                node.setPrevNode(currentNode);
            }
        }
    }

    //examine all nodes and edges
    public Node examineAllNodes() {
    //return point, if all nodes have been examined
        if (unvisited.isEmpty()) {
            return finish; //returning the finish node
        }
        Node currentNode = unvisited.get(0);    //examined node

        distanceSetting(currentNode);  //setting distance from the start

        // examine if neighbor nodes are in the lists
        for (Node node : currentNode.getNeighbours().keySet()) {
            if (!unvisited.contains(node) && !visited.contains(node)) {
                unvisited.add(node);
            }
        }

        visited.add(currentNode);  // adding current node to visited list
        unvisited.remove(0);  //delete examined node from unviseted list

        return examineAllNodes();
    }

    //print the best route
    public void bestRoute(Node node) {
        List<Node> result = new ArrayList<>();
        Node n = node;

        while (!n.isStart()) {
            result.add(n);
            n = n.getPrevNode();
        }

        System.out.print("Best route from " + start + " to " + finish + ": " + start + ", ");
        for (int i = result.size() - 1; i >= 0; i--) {
            System.out.print(result.get(i) + ", ");
        }
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void setNodes(List<Node> nodes) {
        this.nodes = nodes;
    }

    public List<Node> getVisited() {
        return visited;
    }

    public void setVisited(List<Node> visited) {
        this.visited = visited;
    }

    public List<Node> getUnvisited() {
        return unvisited;
    }

    public void setUnvisited(List<Node> unvisited) {
        this.unvisited = unvisited;
    }

    public Node getStart() {
        return start;
    }

    public void setStart(Node start) {
        this.start = start;
    }

    public Node getFinish() {
        return finish;
    }

    public void setFinish(Node finish) {
        this.finish = finish;
    }

}
