package example;

import jPlot.JPlotXY;

import javax.swing.*;

/**
 * Created by cris9696 on 5/20/14.
 */
public class Example extends JFrame {

    public Example()
    {
        int[] x = {1,2,3};
        int[] y = {1,2,3};
        getContentPane().add(new JPlotXY(x,y,"asd",800,600));
        pack();
        setTitle("Example of plot");
    }

    public static void main(String[] args)
    {
        new Example().setVisible(true);
        setDefaultLookAndFeelDecorated(false);
    }

}
