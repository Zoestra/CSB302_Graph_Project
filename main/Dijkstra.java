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
            Comparator.comparingInt(e -> (int) e.getAttribute("weight")));

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
                nodeDistances.put(nodes.get(i), -1);
            }
            unvisitedNodes.add(nodes.get(i));
        }
        logger.log('n', nodeDistances);

        findShortestPath(nodes, edges);


    }

    private void findShortestPath(ArrayList<Node> nodes, ArrayList<Edge> edges) {
       visitNode(nodes.get(0));

       while(!unvisitedNodes.isEmpty()){

       }

    }


    private void visitNode(Node currentNode){
        currentNode.leavingEdges().forEach(queue::add);
        visitedNodes.add(currentNode);
        unvisitedNodes.remove(currentNode);

    }

    private void travelEdge(Edge targetEdge){
        // go from one node to the next
        // add distance of edge, assign distance value to hashtable
        // relax edges
    }

    private void relaxEdge(Edge targetEdge){

    }

}

