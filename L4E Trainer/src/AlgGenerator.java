import java.util.Random;

public class AlgGenerator {
    private static String[] slice5 = new String[] { "u", "e", "d", "E", "u'", "e'", "d'", "E'" };

    private static String[] slice7 = new String[] { "u", "e", "d", "E", "2u", "2d", "3e", "u'", "e'", "d'", "E'", "2u'", "2d'",
            "3e'" };

    private static String[] slice6 = new String[] { "u", "e", "d", "E", "2u", "2d", "u'", "e'", "d'", "E'", "2u'", "2d'" };

    private static String[] flips = new String[] { " R U2 R' F U' F' ", " R L' U R' L U F' U' F2 U2 F' ",
            " R L U R' L' U F' B' U' F B " };

    public static String createAlg5(boolean parity) {
        String s = "";
        for (int i = 0; i <= 2; i++) {
            Random rand = new Random();
            int sliceR = rand.nextInt((6) + 1) + 0;
            int flipR = rand.nextInt(1 + 1) + 0;
            if (sliceR >= 4) {
                s += slice5[sliceR] + flips[flipR] + " y ";
            } else
                s += slice5[sliceR] + flips[flipR] + " y ";
        }
        if (parity) {
            s += " z Rw U2 x Rw U2 Rw U2' Rw' U2 Lw U2 3Rw' U2' Rw U2 Rw' U2' Rw' R z' ";
        }

        return s;
    }

    public static String createAlg7(boolean parity) {
        String s = "";
        for (int i = 0; i <= 4; i++) {
            Random rand = new Random();
            int sliceR = rand.nextInt((13) + 1) + 0;
            int flipR = rand.nextInt(2 + 1) + 0;
            if (sliceR >= 6) {
                s += slice7[sliceR] + flips[flipR] + " y ";
            } else
                s += slice7[sliceR] + flips[flipR] + " y ";
        }
        if (parity) {
            s += " z Rw U2 x Rw U2 Rw U2' Rw' U2 Lw U2 3Rw' U2' Rw U2 Rw' U2' Rw' R z' ";
        }
        return s;
    }

    public static String createAlg6(boolean parity) {
        String s = "";
        for (int i = 0; i <= 4; i++) {
            Random rand = new Random();
            int sliceR = rand.nextInt((10) + 1) + 0;
            int flipR = rand.nextInt(1 + 1) + 0;
            if (sliceR >= 5) {
                s += slice6[sliceR] + flips[flipR] + " y ";
            } else
                s += slice6[sliceR] + flips[flipR] + " y ";
        }
        if (parity) {
            s += " z Rw U2 x Rw U2 Rw U2' Rw' U2 Lw U2 3Rw' U2' Rw U2 Rw' U2' Rw' R z' ";
        }
        return s;
    }

}