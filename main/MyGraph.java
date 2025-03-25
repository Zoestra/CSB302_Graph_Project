import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;
import org.graphstream.ui.view.Viewer;

import java.util.ArrayList;
import java.util.Random;

public class MyGraph {
    final private SingleGraph graph;
    final private String[] alpha = "ABCDEFGHJKLMNPQRSTUVWXYZ".split("");
    final private ArrayList<Node> nodeList = new ArrayList<>();
    final private ArrayList<Edge> edgeList = new ArrayList<>();

    static{
        System.setProperty("org.graphstream.ui", "swing");
    }

    // this class exists to narrow the complexity of the graphstream classes down to just what I need

    /**
     * Wrapper for graphstream's SingleGraph class
     * @param id id of the grapoh
     * @param numNodes number of nodes
     * @param isDirected
     */
    public MyGraph(String id, int numNodes, boolean isDirected) {
        logger.log("initializing graph");
        graph = new SingleGraph(id, false, true);
        createRandomGraph(numNodes, isDirected);
        logger.log("n", this);

    }

    private void createRandomGraph(int numNodes, boolean isDirected){
        Random rand = new Random();

        for (int i = 0; i < numNodes; i++){
            this.graph.addNode(alpha[i]);
            this.nodeList.add(this.graph.getNode(alpha[i]));
        }

        for (int i = 0; i < numNodes; i++){
            // for every new node
            Node currentNode = this.nodeList.get(i);
            // pick a random number of edges between 1 and 3
            int numEdges = rand.nextInt( 3) + 1;
            for (int j = 0; j < numEdges; j++){
                // pick a random target node
                int randIndex = rand.nextInt(numNodes);
                while (randIndex == i){
                    randIndex = rand.nextInt(numNodes);
                }
                // create a random edge between nodelist[i] and the target node
                String targetNodeID = this.nodeList.get(randIndex).getId();
                String edgeName = (currentNode.getId() + targetNodeID);
                // assign the new edge a random weight
                if(!currentNode.hasEdgeBetween(targetNodeID)){
                    this.graph.addEdge(edgeName, currentNode.getId(), targetNodeID, isDirected);
                    Edge newEdge = this.graph.getEdge(edgeName);
                    newEdge.setAttribute("weight", rand.nextInt(15));
                    this.edgeList.add(newEdge);
                }
            }
        }
    }

    public void showGraph(){
        Viewer viewer = graph.display();
        viewer.getDefaultView().enableMouseOptions();
    }

    public ArrayList<Edge> getEdgeList() {
        return edgeList;
    }

    public ArrayList<Node> getNodeList() {
        return nodeList;
    }

    public SingleGraph getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        return "MyGraph{graph=" + graph +
                "\nnodeList=" + nodeList +
                "\nedgeList=" + edgeList +
                '}';
    }
}
