import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public static void graphProject(){

  MyGraph graph = new MyGraph("1",26,  true);
  graph.showGraph();
}


public static void main(String[] args) {
  logger.startup();

  try{
    graphProject();
  } catch(Exception e){
    logger.log(e);
  }
  logger.shutdown();
}
