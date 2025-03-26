import java.lang.reflect.Array;
import org.graphstream.graph.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Dijkstra {
    private HashMap<Node, Integer> nodeDistances;
    private HashMap<Node, Node> previousNode;
    private ArrayList<Edge> relaxedEdges;
    private ArrayList<Node> visitedNodes;
    private ArrayList<Node> unvisitedNodes = new ArrayList<>();
    private PriorityQueue<Edge> queue = new PriorityQueue<>(
            Comparator.comparingInt(e -> (int) e.getAttribute("totalDistance")));

    public Dijkstra(MyGraph inputGraph) {
        ArrayList<Node> nodes = inputGraph.getNodeList();
        ArrayList<Edge> edges = inputGraph.getEdgeList();
        visitedNodes = new ArrayList<>();
        unvisitedNodes = new ArrayList<>();
        relaxedEdges = new ArrayList<Edge>();
        previousNode = new HashMap<Node, Node>();
        // initialize distance array. start should be 0, all else -1
        nodeDistances = new HashMap<Node, Integer>();
        for (int i = 0; i < nodes.size(); i++) {
            if (i == 0) {
                nodeDistances.put(nodes.get(0), 0);
            } else {
                nodeDistances.put(nodes.get(i), null);
            }
            unvisitedNodes.add(nodes.get(i));
        }
        logger.log('n', nodeDistances);

        findShortestPath(nodes, edges);
    }
    private void findShortestPath(ArrayList<Node> nodes, ArrayList<Edge> edges) {
       visitNode(nodes.get(0));

       while(!unvisitedNodes.isEmpty()){
           travelEdge(queue.poll());
       }
    }
    private void visitNode(Node currentNode){
        ArrayList<Edge> leavingEdges = new ArrayList<>();
        currentNode.leavingEdges().forEach(leavingEdges::add);
        int nodeDistance = nodeDistances.getOrDefault(currentNode, 0);
        for (Edge edge : leavingEdges){ // for all the outgoing edges
            Node nextNode = edge.getTargetNode();
            int edgeDistance = (int) edge.getAttribute("distance");
            int totalPathDistance = nodeDistance + edgeDistance;
            // update the path distance of the edge
            edge.setAttribute("totalDistance", totalPathDistance);
            logger.log('c', edge);
            logger.log("new distance for edge " + edge + ": " + totalPathDistance);
            // if this path to next node is shorter, replace the values in
            // nodeDistances and previousNode
            if (totalPathDistance < nodeDistances.get(nextNode)){
                nodeDistances.put(currentNode, totalPathDistance);
                previousNode.put(edge.getTargetNode(), currentNode);
            }

            queue.add(edge);
        }
        visitedNodes.add(currentNode);
        unvisitedNodes.remove(currentNode);


    }

    private void travelEdge(Edge targetEdge){
        // go from one node to the next
        Node targetNode = targetEdge.getTargetNode();
        if ((int) targetEdge.getAttribute("totalDistance") < nodeDistances.get(targetNode)){
            // relax edges
            ArrayList<Edge> incomingEdges = new ArrayList<>();
            targetNode.enteringEdges().forEach(incomingEdges::add);
            for(Edge edge: incomingEdges){
                if (edge != targetEdge){
                    relaxEdge(edge);
                }
            }
            visitNode(targetNode);
        }



        // add distance of edge, assign distance value to hashtable
    }

    private void relaxEdge(Edge targetEdge){
        relaxedEdges.add(targetEdge);
        logger.log("relaxed edge: " + targetEdge);

    }

}

