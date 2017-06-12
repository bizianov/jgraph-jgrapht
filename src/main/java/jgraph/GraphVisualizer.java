package jgraph;

import org.jgraph.JGraph;
import org.jgrapht.ext.JGraphModelAdapter;

import javax.swing.*;

/**
 * Created by viacheslav on 6/12/17.
 */
public class GraphVisualizer {

    private JGraph jGraph;

    public GraphVisualizer(JGraph jGraph) {
        this.jGraph = jGraph;
    }

    public void visualize() {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1000, 800);
        jFrame.getContentPane().add(jGraph);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.repaint();
    }
}
