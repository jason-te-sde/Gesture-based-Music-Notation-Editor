package sandbox;

import react.graphics.G;
import react.graphics.WinApp;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Paint extends WinApp {
    public static int clicks = 0;
    public static Path thePath = new Path();
    public Paint(){
        super("Paint", 1000, 700);
    }

    public void paintComponent(Graphics g){
        G.clearBack(g);
        Color c = G.rndColor();
        g.setColor(c);
        g.fillOval(100, 100, 100, 200);
        g.setColor(Color.BLACK);
        thePath.draw(g);
        g.drawLine(100,600,600,100);
        int x = 400, y = 200;
        String msg = "Dude" + clicks;
        g.drawString(msg, x, y);
        g.drawOval(x, y, 3, 3);
        FontMetrics fm = g.getFontMetrics();
        int a = fm.getAscent();
        int d = fm.getDescent();
        int w= fm.stringWidth(msg);
        g.drawRect(x, y - a, w, a + d);
    }

    @Override
    public void mousePressed(MouseEvent me) {
        clicks++;
        thePath.clear();
        thePath.add(me.getPoint());
        repaint();
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        thePath.add(me.getPoint());
        repaint();
    }

    public static void main(String[] args){
        PANEL = new Paint();
        WinApp.launch();
    }

    //---------------------PATH-----------------------

    public static class Path extends ArrayList<Point> {
        public void draw(Graphics g) {
            for (int i = 1; i < size(); i++) {
                Point p = get(i-1), n = get(i);
                g.drawLine(p.x, p.y, n.x, n.y);
            }
        }
    }
}
