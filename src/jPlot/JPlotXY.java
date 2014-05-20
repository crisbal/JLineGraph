package jPlot;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cris9696 on 5/20/14.
 */


public class JPlotXY extends JComponent {


    private static final int PANEL_MARGIN = 30;
    private final int nOfItems;
    private int h, w;
    private long[] xValues;
    private long[] yValues;
    private String plotName;
    private int plotW, plotH;
    private long rangeX;
    private long rangeY;
    private Color lineColor;
    private int lineWidth;

    public JPlotXY(long[] xValues, long[] yValues, String plotName, int w, int h) {
        super();
        this.xValues = xValues;
        this.yValues = yValues;
        this.plotName = plotName;
        this.w = w;
        this.h = h;

        nOfItems = xValues.length;

        rangeX = getMax(xValues) - getMin(xValues);
        rangeY = getMax(yValues) - getMin(yValues);


        plotW = (int) (w - 2.9 * PANEL_MARGIN);
        plotH = (int) (h - 3.9 * PANEL_MARGIN);

        lineColor = Color.red;
        lineWidth = 3;
    }

    public Dimension getPreferredSize() {
        return new Dimension(w, h);
    }

    public void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;

        g.setColor(Color.white);
        g.fillRect(0,0,w,h);    //background

        for (int i = 1; i < nOfItems; i++) {
            g.setColor(lineColor);
            g.setStroke(new BasicStroke(lineWidth));

            long prevX = xValues[i - 1];
            long currX = xValues[i];

            long prevXatZero = prevX - getMin(xValues);
            long currXatZero = currX - getMin(xValues);

            long drawPrevX = (prevXatZero * plotW) / rangeX;   //it was THAT simple
            long drawCurrX = (currXatZero * plotW) / rangeX;

            long prevY = yValues[i - 1];
            long currY = yValues[i];

            long prevYatZero = prevY - getMin(yValues);
            long currYatZero = currY - getMin(yValues);

            int drawPrevY = (int) ((prevYatZero * plotH) / rangeY);   //it was THAT simple
            int drawCurrY = (int) ((currYatZero * plotH) / rangeY);


            g.drawLine((int)(drawPrevX + PANEL_MARGIN),
                    h - drawPrevY - PANEL_MARGIN * 2,
                    (int) (drawCurrX + PANEL_MARGIN),
                    h - drawCurrY - PANEL_MARGIN * 2);

            g.setColor(Color.black);
            g.setStroke(new BasicStroke(1));
        }

        g.setColor(Color.black);
        g.drawLine(PANEL_MARGIN, PANEL_MARGIN, PANEL_MARGIN, h - PANEL_MARGIN * 2); //x axis
        g.drawLine(PANEL_MARGIN, h - PANEL_MARGIN * 2, w - PANEL_MARGIN, h - PANEL_MARGIN * 2); //y axis

        g.drawString(plotName, (w-PANEL_MARGIN)/2, h - PANEL_MARGIN);   //graph name
    }

    public long getMin(long[] array) {
        long min = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] < min)
                min = array[i];
        }
        return min;
    }

    public long getMax(long[] array) {
        long max = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] > max)
                max = array[i];
        }
        return max;
    }

    public void setLineColor(Color c)
    {
        lineColor = c;
    }

    public void setLineWidth(int w)
    {
        lineWidth = w;
    }
}
