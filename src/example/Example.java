package example;

import jPlot.JPlotXY;

import javax.swing.*;

/**
 * Created by cris9696 on 5/20/14.
 */
public class Example extends JFrame {

    public Example()
    {
        int[] x = {0, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71};
        int[] y = {177, 348, 246, 266, 116, 158, 299, 313, 182, 60, 24, 303, 386, 228, 513, 360, 448, 544, 314, 384, 488, 99, 34, 534, 463, 228, 169, 19, 423, 166, 167, 78, 435, 232, 1, 322, 9, 427, 473, 452, 283, 582, 473, 83, 36, 560, 67, 418, 78, 193, 201, 402, 166, 596, 235, 452, 125, 593, 325, 262, 418, 487, 243, 55, 351, 248, 421, 58, 224, 18, 442, 104, 297, 317, 584, 389, 50, 406, 318, 405, 143, 108, 363, 170, 528, 457, 312, 490, 239, 254, 29, 141, 34, 594, 434, 360, 319, 345, 571, 484};
        getContentPane().add(new JPlotXY(x,y,"Example",1280,720));
        pack();
        setTitle("Example");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args)
    {
        new Example().setVisible(true);


    }

}
