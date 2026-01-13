package sandbox;

import react.graphics.WinApp;

import java.awt.*;

public class RedRect extends WinApp {
    public RedRect(){
        super("RedRect", 1000, 700);
    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLUE);
        g.fillOval(100, 100, 100, 200);
        g.setColor(Color.BLACK);
        g.drawLine(100,600,600,100);
        int x = 400, y = 200;
        String msg = "Dude";
        g.drawString(msg, x, y);
        g.drawOval(x, y, 3, 3);
        FontMetrics fm = g.getFontMetrics();
        int a = fm.getAscent();
        int d = fm.getDescent();
        int w= fm.stringWidth(msg);
        g.drawRect(x, y - a, w, a + d);
    }

    public static void main(String[] args){
        PANEL = new RedRect();
        WinApp.launch();
    }
}
