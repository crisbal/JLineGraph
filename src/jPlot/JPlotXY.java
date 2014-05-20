package jPlot;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.QuadCurve2D;

/**
 * Created by cris9696 on 5/20/14.
 */


public class JPlotXY extends JComponent {


    private static final int PANEL_MARGIN = 30;

    private int h, w;
    private int[] xValues;
    private int[] yValues;
    private String plotName;

    private int plotW,plotH;
    private int rangeX,rangeY;

    private final int nOfItems;


    public JPlotXY(int[] xValues, int[] yValues, String plotName, int w, int h) {
        super();
        this.xValues = xValues;
        this.yValues = yValues;
        this.plotName = plotName;
        this.w = w;
        this.h = h;

        nOfItems = xValues.length;

        rangeX = getMax(xValues)-getMin(xValues);
        rangeY = getMax(yValues)-getMin(yValues);



        plotW = w -2*PANEL_MARGIN;
        plotH = h -2*PANEL_MARGIN;
    }

    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    public void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D)g1;

        g.setColor(Color.black);
        g.drawLine(PANEL_MARGIN, PANEL_MARGIN, PANEL_MARGIN, h - PANEL_MARGIN * 2);
        g.drawLine(PANEL_MARGIN, h - PANEL_MARGIN * 2, w - PANEL_MARGIN, h - PANEL_MARGIN * 2);
        g.drawString(plotName, PANEL_MARGIN, h - PANEL_MARGIN);

        for(int i=1;i<nOfItems;i++)
        {
            g.setColor(Color.red);
            g.setStroke(new BasicStroke(4));

            int prevX = xValues[i-1] - getMin(xValues);
            int currX = xValues[i] - getMin(xValues);

            int drawPrevX = (int) (double) ((prevX*plotW)/rangeX);
            int drawCurrX = (int) (double) ((currX*plotW)/rangeX);

            g.drawLine(drawPrevX + PANEL_MARGIN ,
                    h-yValues[i-1]-PANEL_MARGIN*2,
                    drawCurrX + PANEL_MARGIN,
                    h-yValues[i]-PANEL_MARGIN*2);

            g.setColor(Color.black);
            g.setStroke(new BasicStroke(1));


            g.drawLine(drawPrevX + PANEL_MARGIN,
                    0+PANEL_MARGIN*2,
                    drawPrevX + PANEL_MARGIN,
                    h-PANEL_MARGIN*2);

        }
    }

    public int getMin(int[] array) {
        int min = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] < min)
                min = array[i];
        }
        return min;
    }

    public int getMax(int[] array) {
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] > max)
                max = array[i];
        }
        return max;
    }
}
