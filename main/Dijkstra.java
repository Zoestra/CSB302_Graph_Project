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
    private PriorityQueue<Node> pQueue = new PriorityQueue<>(
            Comparator.comparingInt(e -> (int) e.getAttribute("distance")));

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
                nodes.get(0).setAttribute("distance", 0);
                nodes.get(0).setAttribute("ui.style", "stroke-color: #27C674;");
            } else {
                nodeDistances.put(nodes.get(i), Integer.MAX_VALUE);
                nodes.get(i).setAttribute("distance", Integer.MAX_VALUE);
            }
            unvisitedNodes.add(nodes.get(i));
        }
            logger.log("Node Distances");
            logger.log(nodeDistances);
            logger.log("Unvisited Nodes");
            logger.log(unvisitedNodes);
            logger.log("starting shortest path");
            logger.line();
        findShortestPath(nodes);
    }
    private void findShortestPath(ArrayList<Node> nodes) {
           logger.log("visiting first node");
       visitNode(nodes.get(0));

       while(!pQueue.isEmpty()){
               logger.line();
               logger.log("Queue = " + pQueue);
               logger.log("Unvisited Nodes: " + unvisitedNodes);
               logger.line();
               logger.log("visiting node: " + pQueue.peek());
               logger.line();
           if(visitedNodes.contains(pQueue.peek())){
               pQueue.poll();
           }
           else {
               visitNode(pQueue.poll());
           }
       }
    }
    private void visitNode(Node currentNode){
        visitedNodes.add(currentNode);
        unvisitedNodes.remove(currentNode);

        int distanceTravelled = (int) currentNode.getAttribute("distance");

        // get neighbor node
        ArrayList<Node> neighbors = new ArrayList<>();
        currentNode.neighborNodes().forEach(neighbors::add);
            logger.log("neighbor nodes = " + neighbors);

        // add neighbor nodes to distance and previous tables
        for(Node neighbor : neighbors){
            int distanceBetween = (int) currentNode.getEdgeBetween(neighbor).getAttribute("distance");
            int totalDistance = distanceBetween + distanceTravelled;

            if(!visitedNodes.contains(neighbor)){
                    logger.log("checking neighbor " + neighbor);
                if(totalDistance < nodeDistances.get(neighbor)){
                    nodeDistances.put(neighbor, totalDistance);
                    neighbor.setAttribute("distance", totalDistance );
                    logger.log("updating neighbor " + neighbor);
                    logger.log("new total distance = " + totalDistance);

                    pQueue.add(neighbor);

                    if(previousNode.containsKey(neighbor)) {
                        Edge targetEdge = neighbor.getEdgeBetween(previousNode.get(neighbor));
                        relaxEdge(targetEdge);
                        previousNode.put(neighbor, currentNode);
                        logger.log("updating " + neighbor + ":");
                        logger.log("previous node = " + currentNode);
                    }
                    else{
                        previousNode.put(neighbor, currentNode);
                    }
                }
            }
        }
            logger.log("updated node distances");
            logger.log(nodeDistances);
    }

    private void relaxEdge(Edge targetEdge){
        relaxedEdges.add(targetEdge);
        logger.log("relaxed edge: " + targetEdge);
        targetEdge.setAttribute("ui.class", "relaxed");

    }
    public HashMap<Node, Integer> getNodeDistances() {
        return nodeDistances;
    }

    public HashMap<Node, Node> getPreviousNode() {
        return previousNode;
    }

    public ArrayList<Edge> getRelaxedEdges() {
        return relaxedEdges;
    }
}

