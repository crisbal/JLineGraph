package jPlot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cris9696 on 5/20/14.
 */


public class JPlotXY extends JComponent {


    private static final int BORDER = 30;

    private int h,w;
    private int[] xValues;
    private int[] yValues;
    private String plotName;

    public JPlotXY(int[] xValues, int[] yValues, String plotName, int w, int h) {
        super();
        this.xValues = xValues;
        this.yValues = yValues;
        this.plotName = plotName;
        this.w = w;
        this.h = h;
    }

    public Dimension getPreferredSize() {
        return new Dimension(w,h);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawLine(BORDER,BORDER,BORDER,h-BORDER*2);
        g.drawLine(BORDER,h-BORDER*2,w-BORDER,h-BORDER*2);
        g.drawString(plotName,BORDER,h-BORDER);
    }
}
