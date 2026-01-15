package sandbox;

import react.graphics.G;
import react.graphics.WinApp;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Squares extends WinApp {
//    public static G.VS theVS = new G.VS(100, 100, 200, 300);
//    public static Color color = G.rndColor();
    public static Square.List squares = new Square.List();
    public static Square lastSquare;
    private boolean dragging = false;
    private static G.V mouseDelta = new G.V(0, 0); // overwritten my mouse press
    public static boolean showSplin = true;

    public Squares() {super("Squares", 1000, 800);}

    public void paintComponent(Graphics g) {
        G.clearBack(g);
//        theVS.fill(g, color);
        squares.draw(g);
        if (showSplin && squares.size() > 2) {
            g.setColor(Color.BLACK);
            G.V a = squares.get(0).loc, b = squares.get(1).loc, c = squares.get(2).loc;
            G.splin(g, a.x, a.y, b.x, b.y, c.x, c.y, 2);
        }
    }

    public void mousePressed(MouseEvent me) {
//        if (theVS.hit(me.getX(), me.getY())) {
//            color = G.rndColor();
//        }
        //Capture
        int x = me.getX(), y = me.getY();

        lastSquare = squares.hit(x, y);
        if (lastSquare == null) {
            dragging = false;
            lastSquare = new Square(x, y);
            squares.add(lastSquare);
        } else {
            dragging = true;
            mouseDelta.set(lastSquare.loc.x- x, lastSquare.loc.y - y);
        }
//        squares.add(lastSquare);
        repaint();
    }

    public void mouseDragged(MouseEvent me) {
        int x = me.getX(), y = me.getY();
        if (dragging) {
            lastSquare.moveTo(x + mouseDelta.x, y + mouseDelta.y);
        } else {
            lastSquare.resize(me.getX(), me.getY());
        }
        repaint();
    }

    public static void main(String[] args) {
        PANEL = new Squares();
        WinApp.launch();
    }

    // ---------------------Square-----------------------
    public static class Square extends G.VS {
        public Color c = G.rndColor();
        public Square(int x, int y) {super(x, y, 100, 100);}

        public void draw(Graphics g) {fill(g, c);}

        public void resize(int x, int y) {
            if (x > loc.x && y > loc.y ) {
                size.set(x - loc.x, y - loc.y);
            }
        }

        public void moveTo(int x, int y) {loc.set(x, y);}

        //---------------------List-----------------------
        public static class List extends ArrayList<Square> {
            public void draw(Graphics g) { for (Square s : this) {s.draw(g);}}

            public Square hit(int x, int y) {
                Square res = null;

                for (Square s : this) {if (s.hit(x, y)) {res = s;}}

                return res;
            }
        }
    }
}
