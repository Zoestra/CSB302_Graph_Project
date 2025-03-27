import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;
import java.util.Comparator;
import java.util.ArrayList;

public class FloydWarshall {
   private ArrayList<Edge> edgeList;
   private ArrayList<Node> nodeList;
   private int[][] adjacencyMatrix;

   public FloydWarshall(MyGraph graph){
       this.nodeList = graph.getNodeList();
       this.edgeList = graph.getEdgeList();





       int n = nodeList.size();
       this.adjacencyMatrix = new int[n][n];

       nodeList.sort(Comparator.comparing(Node::getId));

       for(Node node:nodeList){
           ArrayList<Edge> outgoingEdges = new ArrayList<>();
           node.leavingEdges().forEach(outgoingEdges::add);
           int i = nodeList.indexOf(node);
           for(Edge edge : outgoingEdges){

           }

       }

   }


}
