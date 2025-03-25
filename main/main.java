public static boolean run(boolean runflag){

  MyGraph graph = new MyGraph("1",26,  true);
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


