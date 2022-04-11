package dijkstrasalgorithm;

public class DijkstrasAlgorithm {

    public static void main(String[] args) {
        //graph initialization
        Graph graph = new Graph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");

        graph.getNodes().add(nodeA);
        graph.getNodes().add(nodeB);
        graph.getNodes().add(nodeC);
        graph.getNodes().add(nodeD);
        graph.getNodes().add(nodeE);
        graph.getNodes().add(nodeF);
        graph.getNodes().add(nodeG);
        graph.getNodes().add(nodeH);

        nodeA.getNeighbours().put(nodeB, 8);
        nodeA.getNeighbours().put(nodeC, 2);
        nodeA.getNeighbours().put(nodeD, 5);

        nodeB.getNeighbours().put(nodeA, 8);
        nodeB.getNeighbours().put(nodeD, 2);
        nodeB.getNeighbours().put(nodeF, 13);

        nodeC.getNeighbours().put(nodeA, 2);
        nodeC.getNeighbours().put(nodeD, 2);
        nodeC.getNeighbours().put(nodeE, 5);

        nodeD.getNeighbours().put(nodeA, 5);
        nodeD.getNeighbours().put(nodeB, 2);
        nodeD.getNeighbours().put(nodeC, 2);
        nodeD.getNeighbours().put(nodeE, 1);
        nodeD.getNeighbours().put(nodeF, 6);
        nodeD.getNeighbours().put(nodeG, 3);

        nodeE.getNeighbours().put(nodeC, 5);
        nodeE.getNeighbours().put(nodeD, 1);
        nodeE.getNeighbours().put(nodeG, 1);

        nodeF.getNeighbours().put(nodeB, 13);
        nodeF.getNeighbours().put(nodeD, 6);
        nodeF.getNeighbours().put(nodeG, 2);
        nodeF.getNeighbours().put(nodeH, 3);

        nodeG.getNeighbours().put(nodeD, 3);
        nodeG.getNeighbours().put(nodeE, 1);
        nodeG.getNeighbours().put(nodeF, 2);
        nodeG.getNeighbours().put(nodeH, 6);

        nodeH.getNeighbours().put(nodeF, 3);
        nodeH.getNeighbours().put(nodeG, 6);
        

        //setting start node
        graph.setStart(nodeA);
        graph.getStart().setStart(true);
        graph.getStart().setShortest(0);

        //setting finish node
        graph.setFinish(nodeH);
        graph.getFinish().setEnd(true);

        //adding the starting node to the unvisited list
        graph.getUnvisited().add(graph.getStart());
        //finding and printing the best route  
        graph.bestRoute(graph.examineAllNodes());
     
    }

}
