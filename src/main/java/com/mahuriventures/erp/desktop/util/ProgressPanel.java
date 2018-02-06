package com.mahuriventures.erp.desktop.util;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;

public class ProgressPanel extends JPanel{
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(this.getWidth()/2,this.getHeight()/2);
        g2.rotate(Math.toRadians(270));
        Arc2D.Float arc = new Arc2D.Float();
        arc.setFrameFromCenter(new Point(0,0),new Point(120,120));
        arc.setAngleStart(1);
        arc.setAngleExtent(100);
        g2.setColor(Color.RED);
        g2.draw(arc);
        g2.fill(arc);
    }
}
