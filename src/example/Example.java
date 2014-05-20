package example;

import jPlot.JPlotXY;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cris9696 on 5/20/14.
 */
public class Example extends JFrame {

    public Example() {
        long[] x = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        long[] y = {55, 348, 246, 266, 116, 158, 299, 313, 90};

        JPlotXY chart = new JPlotXY(x, y, "Example", 800, 600);
        chart.setLineColor(Color.green);
        chart.setLineWidth(2);
        getContentPane().add(chart);
        pack();
        setTitle("Example");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Example().setVisible(true);


    }

}
