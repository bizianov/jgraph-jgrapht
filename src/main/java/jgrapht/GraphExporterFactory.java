package jgrapht;

import org.jgrapht.ext.ComponentAttributeProvider;
import org.jgrapht.ext.GraphMLExporter;
import org.jgrapht.ext.IntegerComponentNameProvider;
import org.jgrapht.graph.DefaultWeightedEdge;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by viacheslav on 6/12/17.
 */
public class GraphExporterFactory {
    public static GraphMLExporter get() {

        GraphMLExporter<CustomVertex, DefaultWeightedEdge> exporter = new GraphMLExporter<>(
                (v) -> v.getId(), null, new IntegerComponentNameProvider<>(), null);
        exporter.setExportEdgeWeights(true);
        exporter.registerAttribute("color",
                GraphMLExporter.AttributeCategory.NODE, GraphMLExporter.AttributeType.STRING);
        exporter.registerAttribute("name",
                GraphMLExporter.AttributeCategory.ALL, GraphMLExporter.AttributeType.STRING);

        ComponentAttributeProvider<CustomVertex> vertexAttributeProvider =
                new ComponentAttributeProvider<CustomVertex>() {
            @Override
            public Map<String, String> getComponentAttributes(CustomVertex component) {
                Map<String, String> vertexAttributes = new HashMap<>();
                if (component.getColor() != null) {
                    vertexAttributes.put("color", component.getColor().toString());
                }
                vertexAttributes.put("name", "node-" + component.getId());
                return vertexAttributes;
            }
        };

        ComponentAttributeProvider<DefaultWeightedEdge> edgeAttributeProvider =
                new ComponentAttributeProvider<DefaultWeightedEdge>() {
            @Override
            public Map<String, String> getComponentAttributes(DefaultWeightedEdge component) {
                Map<String, String> edgeAttributes = new HashMap<>();
                edgeAttributes.put("name", component.toString());
                return edgeAttributes;
            }
        };

        exporter.setVertexAttributeProvider(vertexAttributeProvider);
        exporter.setEdgeAttributeProvider(edgeAttributeProvider);

        return exporter;
    }
}
