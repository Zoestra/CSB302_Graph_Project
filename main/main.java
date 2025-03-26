public static boolean run(boolean runflag){

  MyGraph graph = new MyGraph("1",6,  false);
  Dijkstra dijkstraDemo = new Dijkstra(graph);
  logger.line();
  logger.log("previous node map: ");
  logger.log(dijkstraDemo.getPreviousNode());
  logger.log("node distance map: ");
  logger.log(dijkstraDemo.getNodeDistances());
  logger.log("relaxed edges: ");
  logger.log(dijkstraDemo.getRelaxedEdges());


  graph.showGraph();

  runflag = false;
  return runflag;
}


public static void main(String[] args) {
  logger.startup();
  System.setProperty("org.graphstream.ui", "swing");
  Boolean runflag = true;

  while(runflag){
    try{
      runflag = run(runflag);
    } catch(Exception e){
      logger.log(e);
      runflag = false;
    }
  }

  logger.shutdown();
}


