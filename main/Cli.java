import java.util.Scanner;

public class Cli {

    public static boolean run(boolean runflag){
        boolean dijkstra;
        boolean floyd;
        Scanner userInput = new Scanner(System.in);


        logger.log("Welcome to the graph algorithm demonstrator");
        logger.line();

        while (runflag){
            int numNodes = 5;

            logger.log("Enter d for Dijkstras Algorithm");
            logger.log("Enter f for FLoyd Warshall Algorithm");
            logger.log("Enter q or q at any time to quit...");

            String input = userInput.nextLine();
            input.toLowerCase();
            logger.log("user input: " + input);

            boolean inputValid = false;
            switch(input){

                case "d":
                    logger.log("~~~~~Dijkstra's Algorithm~~~~~~");
                    logger.log("finds shortest path from node A");
                    logger.log("~~~~~~to all other nodes~~~~~~~");
                    logger.line();
                    logger.log("input number of nodes, or blank for default (5)...");

                    while(!inputValid){
                        String dijkInput = userInput.nextLine();
                        dijkInput.toLowerCase();
                        logger.log("user input: " + dijkInput);

                        if(dijkInput == "q"){
                            logger.log("exiting dijkstra's");
                            logger.line();
                            inputValid = true;
                            break;
                        } else{
                            try{
                                numNodes = Integer.parseInt(dijkInput);
                            } catch(NumberFormatException e){
                                logger.log("not a number. try again...");
                            } finally {
                                inputValid = true;
                            }
                        }
                    }
                    MyGraph dijkstraGraph = new MyGraph("1", numNodes, false, false);
                    graphSettings.styleGraph(dijkstraGraph);
                    Dijkstra dijkstraDemo = new Dijkstra(dijkstraGraph);
                    logger.line();
                    logger.log("previous node map: ");
                    logger.log(dijkstraDemo.getPreviousNode());
                    logger.log("node distance map: ");
                    logger.log(dijkstraDemo.getNodeDistances());
                    logger.log("relaxed edges: ");
                    logger.log(dijkstraDemo.getRelaxedEdges());
                    dijkstraGraph.showGraph();
                    inputValid = false;
                    break;


                case "f":
                    logger.log("~~~Floyd Warshall Algorithm~~~~");
                    logger.log("finds shortest path from every ");
                    logger.log("~~~node to every other node~~~~");
                    logger.line();
                    logger.log("input number of nodes, or blank for default (5)...");


                    while(!inputValid){
                        String floydInput = userInput.nextLine();
                        floydInput.toLowerCase();
                        logger.log("user input: " + floydInput);

                        if(floydInput == "q"){
                            logger.log("exiting floyd warshall");
                            logger.line();
                            inputValid = true;
                            break;
                        } else{
                            try{
                                numNodes = Integer.parseInt(floydInput);
                            } catch(NumberFormatException e){
                                logger.log("not a number. try again...");
                            } finally {
                                inputValid = true;
                            }
                        }
                    }

                    MyGraph floydGraph = new MyGraph("2", numNodes, true, true);
                    graphSettings.styleGraph(floydGraph);
                    FloydWarshall floydDem = new FloydWarshall(floydGraph);

                    inputValid = true;

                    floydGraph.showGraph();
                    break;
            }
        }


        runflag = false;
        return runflag;
    }

}
