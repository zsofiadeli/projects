
package dijkstrasalgorithm;

import org.junit.Test;
import static org.junit.Assert.*;


public class GraphTest {

    public GraphTest() {
    }

    @Test
    public void testDistanceSetting() {
        
        Graph instance = new Graph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");

        instance.getNodes().add(nodeA);
        instance.getNodes().add(nodeB);
        instance.getNodes().add(nodeC);

        nodeA.getNeighbours().put(nodeB, 3);
        nodeA.getNeighbours().put(nodeC, 5);

        nodeB.getNeighbours().put(nodeA, 3);
        nodeB.getNeighbours().put(nodeC, 2);

        nodeC.getNeighbours().put(nodeA, 5);
        nodeC.getNeighbours().put(nodeB, 2);

        Node currentNode = nodeA;
        nodeA.setShortest(0);

        instance.distanceSetting(currentNode);

        assertEquals(3, nodeB.getShortest());
        assertEquals(5, nodeC.getShortest());
        assertEquals(nodeA, nodeC.getPrevNode());
        assertEquals(nodeA, nodeC.getPrevNode());

        instance = new Graph();

        nodeA = new Node("A");
        nodeB = new Node("B");
        nodeC = new Node("C");

        instance.getNodes().add(nodeA);
        instance.getNodes().add(nodeB);
        instance.getNodes().add(nodeC);

        nodeA.getNeighbours().put(nodeB, 6);
        nodeA.getNeighbours().put(nodeC, 5);

        nodeB.getNeighbours().put(nodeA, 6);
        nodeB.getNeighbours().put(nodeC, 2);

        nodeC.getNeighbours().put(nodeA, 5);
        nodeC.getNeighbours().put(nodeB, 2);

        nodeB.setShortest(4);
        nodeC.setShortest(5);

        currentNode = nodeA;
        nodeA.setShortest(0);

        instance.distanceSetting(currentNode);

        assertEquals(4, nodeB.getShortest());
        assertEquals(5, nodeC.getShortest());

        instance = new Graph();

        nodeA = new Node("A");
        nodeB = new Node("B");
        nodeC = new Node("C");

        instance.getNodes().add(nodeA);
        instance.getNodes().add(nodeB);
        instance.getNodes().add(nodeC);

        nodeA.getNeighbours().put(nodeB, 2);
        nodeA.getNeighbours().put(nodeC, 5);

        nodeB.getNeighbours().put(nodeA, 2);
        nodeB.getNeighbours().put(nodeC, 1);

        nodeC.getNeighbours().put(nodeA, 5);
        nodeC.getNeighbours().put(nodeB, 1);

        nodeB.setShortest(7);
        nodeC.setShortest(5);

        currentNode = nodeA;
        nodeA.setShortest(3);

        instance.distanceSetting(currentNode);

        assertEquals(5, nodeB.getShortest());
        assertEquals(5, nodeC.getShortest());

    }

    @Test
    public void testExamineAllNodes() {
       
        Graph instance = new Graph();

        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");

        instance.getNodes().add(nodeA);
        instance.getNodes().add(nodeB);
        instance.getNodes().add(nodeC);
        instance.getNodes().add(nodeD);

        nodeA.getNeighbours().put(nodeB, 3);
        nodeA.getNeighbours().put(nodeC, 5);

        nodeB.getNeighbours().put(nodeA, 3);
        nodeB.getNeighbours().put(nodeC, 2);
        nodeB.getNeighbours().put(nodeD, 2);

        nodeC.getNeighbours().put(nodeA, 5);
        nodeC.getNeighbours().put(nodeB, 2);
        nodeC.getNeighbours().put(nodeD, 1);

        nodeD.getNeighbours().put(nodeB, 2);
        nodeD.getNeighbours().put(nodeC, 1);

        instance.setStart(nodeA);
        nodeA.setStart(true);
        nodeA.setShortest(0);
        instance.getUnvisited().add(nodeA);

        instance.setFinish(nodeD);
        nodeD.setEnd(true);

        Node expResult = nodeD;
        Node result = instance.examineAllNodes();

        assertEquals(expResult, result);
        assertEquals(true, instance.getUnvisited().isEmpty());
        assertEquals(true, instance.getNodes().size() == instance.getVisited().size());

        instance = new Graph();

        nodeA = new Node("A");
        nodeB = new Node("B");
        nodeC = new Node("C");
        nodeD = new Node("D");

        instance.getNodes().add(nodeA);
        instance.getNodes().add(nodeB);
        instance.getNodes().add(nodeC);
        instance.getNodes().add(nodeD);

        nodeA.getNeighbours().put(nodeB, 3);
        nodeA.getNeighbours().put(nodeC, 5);

        nodeB.getNeighbours().put(nodeA, 3);
        nodeB.getNeighbours().put(nodeC, 2);
        nodeB.getNeighbours().put(nodeD, 2);

        nodeC.getNeighbours().put(nodeA, 5);
        nodeC.getNeighbours().put(nodeB, 2);
        nodeC.getNeighbours().put(nodeD, 1);

        nodeD.getNeighbours().put(nodeB, 2);
        nodeD.getNeighbours().put(nodeC, 1);

        instance.getUnvisited().add(nodeB);

        instance.setFinish(nodeA);

        expResult = nodeA;
        result = instance.examineAllNodes();

        assertEquals(expResult, result);
        assertEquals(true, instance.getUnvisited().isEmpty());
        assertEquals(true, instance.getNodes().size() == instance.getVisited().size());

    }

}
