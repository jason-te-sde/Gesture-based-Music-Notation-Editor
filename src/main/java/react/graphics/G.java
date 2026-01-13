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
}
