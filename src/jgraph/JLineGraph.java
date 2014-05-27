package jgraph;

import javax.swing.*;
import java.awt.*;

/**
 * Created by cris9696 on 5/20/14.
 */


public class JLineGraph extends JComponent {


    private static final int PANEL_MARGIN = 30;
    private final int nOfItems;
    private int startW, startH;
    private double[] xValues;
    private double[] yValues;
    private String plotName;
    private int plotW, plotH;
    private double rangeX;
    private double rangeY;
    private Color lineColor;
    private int lineWidth;

    public JLineGraph(double[] xValues, double[] yValues, String plotName, int w, int h) {
        super();
        this.xValues = xValues;
        this.yValues = yValues;
        this.plotName = plotName;

        this.startH = h;
        this.startW = w;

        nOfItems = xValues.length;

        rangeX = getMax(xValues) - getMin(xValues);
        rangeY = getMax(yValues) - getMin(yValues);


        plotW = (int) (w - 2.9 * PANEL_MARGIN);
        plotH = (int) (h - 3.9 * PANEL_MARGIN);

        lineColor = Color.red;
        lineWidth = 3;

        setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR)); //set cursor to be a +
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(startW, startH);
    }

    public void paintComponent(Graphics g1) {
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;

        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());    //background

        plotW = (int) (getWidth() - 2.9 * PANEL_MARGIN);
        plotH = (int) (getHeight() - 3.9 * PANEL_MARGIN);

        if (getMin(yValues) <= 0) { //eventually draw the 0 line
            int zeroLine = (int) ((0 - getMin(yValues) * plotH) / rangeY);
            g.setColor(Color.lightGray);
            g.drawString("0", PANEL_MARGIN - 25, getHeight() - zeroLine - PANEL_MARGIN * 2);
            g.drawLine(PANEL_MARGIN, getHeight() - zeroLine - 2 * PANEL_MARGIN, 2 * PANEL_MARGIN + plotW, getHeight() - zeroLine - 2 * PANEL_MARGIN);
        }


        for (int i = 1; i < nOfItems; i++) {
            g.setColor(lineColor);
            g.setStroke(new BasicStroke(lineWidth));

            double prevX = xValues[i - 1];
            double currX = xValues[i];

            double prevXatZero = prevX - getMin(xValues);
            double currXatZero = currX - getMin(xValues);

            double drawPrevX = (prevXatZero * plotW) / rangeX;   //it was THAT simple
            double drawCurrX = (currXatZero * plotW) / rangeX;

            double prevY = yValues[i - 1];
            double currY = yValues[i];

            double prevYatZero = prevY - getMin(yValues);
            double currYatZero = currY - getMin(yValues);

            int drawPrevY = (int) ((prevYatZero * plotH) / rangeY);   //it was THAT simple
            int drawCurrY = (int) ((currYatZero * plotH) / rangeY);


            g.drawLine((int) (drawPrevX + PANEL_MARGIN),         //the line
                    getHeight() - drawPrevY - PANEL_MARGIN * 2,
                    (int) (drawCurrX + PANEL_MARGIN),
                    getHeight() - drawCurrY - PANEL_MARGIN * 2);

            g.setColor(Color.black);
            g.setStroke(new BasicStroke(1));

            if (i == 1) //draw Y values
                g.drawString((int) prevY + "", PANEL_MARGIN - 25, getHeight() - drawPrevY - PANEL_MARGIN * 2);
            g.drawString((int) currY + "", PANEL_MARGIN - 25, getHeight() - drawCurrY - PANEL_MARGIN * 2);

            if (i == 1) //draw X values
                g.drawString((int) prevX + "", (int) (drawPrevX + PANEL_MARGIN), getHeight() - PANEL_MARGIN * 2 + 15);
            g.drawString((int) currX + "", (int) (drawCurrX + PANEL_MARGIN), getHeight() - PANEL_MARGIN * 2 + 15);

            g.setColor(Color.gray); //the dashed line from the axis to the point
            float dash[] = {10.0f};
            g.setStroke(new BasicStroke(1f, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
            g.drawLine(PANEL_MARGIN, getHeight() - drawCurrY - PANEL_MARGIN * 2, (int) (PANEL_MARGIN + drawCurrX), getHeight() - drawCurrY - PANEL_MARGIN * 2);
            g.drawLine((int) (PANEL_MARGIN + drawCurrX), getHeight() - PANEL_MARGIN * 2, (int) (PANEL_MARGIN + drawCurrX), getHeight() - drawCurrY - PANEL_MARGIN * 2);
        }

        g.setColor(Color.black);
        g.setStroke(new BasicStroke(1));
        g.drawLine(PANEL_MARGIN, PANEL_MARGIN, PANEL_MARGIN, getHeight() - PANEL_MARGIN * 2); //x axis
        g.drawLine(PANEL_MARGIN, getHeight() - PANEL_MARGIN * 2, getWidth() - PANEL_MARGIN, getHeight() - PANEL_MARGIN * 2); //y axis

        g.drawString(plotName, (getWidth() - PANEL_MARGIN) / 2, getHeight() - PANEL_MARGIN);   //graph name
    }

    public double getMin(double[] array) {
        double min = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] < min)
                min = array[i];
        }
        return min;
    }

    public double getMax(double[] array) {
        double max = 0;
        for (int i = 0; i < array.length; i++) {
            if (i == 0 || array[i] > max)
                max = array[i];
        }
        return max;
    }

    public void setLineColor(Color c) {
        lineColor = c;
    }

    public void setLineWidth(int w) {
        lineWidth = w;
    }
}
