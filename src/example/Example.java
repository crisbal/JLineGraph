package example;

import jPlot.JPlotXY;

import javax.swing.*;

/**
 * Created by cris9696 on 5/20/14.
 */
public class Example extends JFrame {

    public Example()
    {
        int[] x = {55,56,57,58};
        int[] y = {120,170,-6,200};
        getContentPane().add(new JPlotXY(x,y,"Example",800,600));
        pack();
        setTitle("Example of plot");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new Example().setVisible(true);


    }

}
