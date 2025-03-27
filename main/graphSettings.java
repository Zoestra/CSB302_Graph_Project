import org.graphstream.graph.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class graphSettings {
    private static String styles;

    public static void setup() throws IOException {
        readStyleSheet();
        System.setProperty("org.graphstream.ui", "swing");
        System.setProperty("ui.stylesheet", styles);

    }

    public static MyGraph styleGraph(MyGraph myGraph){
        Graph graph = myGraph.getGraph();
        graph.setAttribute("ui.stylesheet", styles);
        return myGraph;

    }

    private static void readStyleSheet() throws IOException {
        styles = new String(Files.readAllBytes(Paths.get("main/style.txt")));
    }




}