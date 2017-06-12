import jgraph.GraphVisualizer;
import jgrapht.Color;
import jgrapht.CustomVertex;
import jgrapht.GraphExporterFactory;
import jgrapht.GraphImporterFactory;
import org.jgraph.JGraph;
import org.jgrapht.Graph;
import org.jgrapht.ext.*;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.DirectedWeightedPseudograph;

import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Set;

/**
 * Created by viacheslav on 6/12/17.
 */
public class GraphDemo {

    public static final String PATH = "/home/viacheslav/dev/java/agt/graph/src/main/resources/graph.xml";

    public static void main(String[] args) throws IOException, ExportException, ImportException {
        Graph<CustomVertex, DefaultWeightedEdge> graph = new DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);

        //fill the graph
        CustomVertex customVertex1 = new CustomVertex("1", Color.BLACK);
        CustomVertex customVertex2 = new CustomVertex("2", Color.WHITE);
        CustomVertex customVertex3 = new CustomVertex("3", Color.WHITE);
        CustomVertex customVertex4 = new CustomVertex("4", Color.BLACK);

        graph.addVertex(customVertex1);
        graph.addVertex(customVertex2);
        graph.addVertex(customVertex3);
        graph.addVertex(customVertex4);

        graph.addEdge(customVertex1, customVertex2);
        graph.addEdge(customVertex1, customVertex3);
        graph.addEdge(customVertex2, customVertex4);
        graph.addEdge(customVertex3, customVertex4);

        //export graph to the file
        GraphMLExporter graphMLExporter = GraphExporterFactory.get();
        Writer writer = Files.newBufferedWriter(Paths.get(PATH));
        graphMLExporter.exportGraph(graph, writer);

        //import graph back from the file
        GraphMLImporter graphImporter = GraphImporterFactory.get();
        Reader reader = Files.newBufferedReader(Paths.get(PATH));
        Graph<CustomVertex, DefaultWeightedEdge> _graph = new DirectedWeightedPseudograph<>(DefaultWeightedEdge.class);
        graphImporter.importGraph(_graph, reader);

        //verify graph was imported correctly
        Set<DefaultWeightedEdge> edgeSet = _graph.edgeSet();
        System.out.println("--- LIST OF EDGES ---");
        edgeSet.stream().forEach(System.out::println);

        Set<CustomVertex> vertexSet = _graph.vertexSet();
        System.out.println("--- LIST OF VERTEX ---");
        vertexSet.stream().forEach(System.out::println);

        //visualize graph
        JGraph jGraph = new JGraph(new JGraphModelAdapter<>(graph));
        new GraphVisualizer(jGraph).visualize();
    }
}
