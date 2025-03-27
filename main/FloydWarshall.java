import org.graphstream.graph.Edge;
import org.graphstream.graph.Node;

import java.util.ArrayList;

import static java.lang.Double.POSITIVE_INFINITY;

public class FloydWarshall {
   private ArrayList<Edge> edgeList;
   private ArrayList<Node> nodeList;
   private double[][] distMatrix;

   public FloydWarshall(MyGraph graph){
       this.nodeList = graph.getNodeList();
       this.edgeList = graph.getEdgeList();

       int n = nodeList.size();
       this.distMatrix = new double[n][n];
       for(int i = 0; i < n; i++){
           java.util.Arrays.fill(distMatrix[i], POSITIVE_INFINITY);
       }

       logger.log("initializing adjacency matrix");

       for(int i = 0; i < n; i++){
           distMatrix[i][i] = 0;
       }
       logger.log("placing zeros");
       logger.log(distMatrix);

       for(Edge edge : edgeList){
           int sourceIndex = nodeList.indexOf(edge.getSourceNode());
           int targetIndex = nodeList.indexOf(edge.getTargetNode());
           distMatrix[sourceIndex][targetIndex] = (int) edge.getAttribute("distance");
       }


       for(int k = 0; k < n; k++) {
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {

                   if(distMatrix[i][j] > distMatrix[i][k] + distMatrix[k][j]){
                       distMatrix[i][j] = distMatrix[i][k] = distMatrix[k][j];
                       logger.log("updating ["+i+"]["+j+"] to " + distMatrix[i][j]);
                   }

               }
           }
       }
       logger.log("algorithm complete!");
       logger.log(distMatrix);
       logger.line();
   }


}