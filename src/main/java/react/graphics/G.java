package react.graphics;

import java.awt.*;
import java.util.Random;

public class G {
    public static Random RND = new Random();
    public static int rnd(int max) { return RND.nextInt(max);}
    public static Color rndColor() {return new Color(rnd(254), rnd(254), rnd(254));}
    public static void clearBack(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, 5000, 5000);
    }
    // ----------------------V----------------------
    public static class V {
        public int x, y;
        public V(int x, int y) {this.set(x, y);}
        public void set(int x, int y) {this.x = x; this.y = y;}
        public void add(V v) {x += v.x; y += v.y;}
    }

    // ----------------------VS----------------------
    public static class VS {
        public V loc, size;
        public VS(int x, int y, int w, int h ) {loc = new V(x, y); size = new V(w, h);}

        public void fill(Graphics g, Color c) {
            g.setColor(c);
            g.fillRect(loc.x, loc.y, size.x, size.y);
        }

        public boolean hit(int x, int y) {
            return loc.x <= x && loc.y <= y && x <= (loc.x + size.x) && y <= (loc.y + size.y);
        }
    }

    // ----------------------LoHi----------------------
    public static class VoHi {

    }

    // ----------------------BBox----------------------
    public static class BBox {

    }

    // ----------------------PL----------------------
    public static class PL {

    }

    public static void splin(Graphics g, int ax, int ay, int bx, int by, int cx, int cy, int n) {
        if (n == 0) {g.drawLine(ax, ay, cx, cy); return;}
        int abx = (ax + bx) / 2, aby = (ay + by) / 2;
        int bcx = (bx + cx) / 2, bcy = (by + cy) / 2;
        int abcx = (abx + bcx) / 2, abcy = (aby + bcy) / 2;
        splin(g, ax, ay, abx, aby, abcx, abcy, n - 1);
        splin(g, abcx, abcy, bcx, bcy, cx, cy, n - 1);


    }
}
