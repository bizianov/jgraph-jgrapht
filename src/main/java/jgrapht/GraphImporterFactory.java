package jgrapht;

import org.jgrapht.ext.EdgeProvider;
import org.jgrapht.ext.GraphMLImporter;
import org.jgrapht.ext.VertexProvider;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.Map;

/**
 * Created by viacheslav on 6/12/17.
 */
public class GraphImporterFactory {
    public static GraphMLImporter get() {

        EdgeProvider<CustomVertex, DefaultWeightedEdge> edgeEdgeProvider =
                new EdgeProvider<CustomVertex, DefaultWeightedEdge>() {
                    @Override
                    public DefaultWeightedEdge buildEdge(CustomVertex from, CustomVertex to, String label,
                                                         Map<String, String> attributes) {
                        return new DefaultWeightedEdge();
                    }
                };

        VertexProvider<CustomVertex> vertexProvider = new VertexProvider<CustomVertex>() {
            @Override
            public CustomVertex buildVertex(String id, Map<String, String> attributes) {
                CustomVertex customVertex = new CustomVertex(id);
                String color = attributes.get("color");
                if (color != null) {
                    switch (color) {
                        case "black" :
                            customVertex.setColor(Color.BLACK);
                            break;
                        case "white" :
                            customVertex.setColor(Color.WHITE);
                            break;
                        default:
                    }
                }
                return customVertex;
            }
        };

        return new GraphMLImporter(vertexProvider, edgeEdgeProvider);
    }
}
