import java.util.Random;

public class AlgGenerator {

    private static String[] flips = new String[] { " R U2 R' F' U' F ", " R L' U R' L U F' U' F2 U2 F' ",
            " R L U R' L' U F' B' U' F B " };

    public static String createAlg5(boolean parity) {
        String s = "";
        for (int i = 0; i <= 3; i++) {
            int sliceR = (int)(Math.random() * 11 );
            int flipR = (int)(Math.random() * 2 );
           switch(sliceR){
               case 0: s+= "u " + flips[flipR] + "u' y ";
                   break;
               case 1: s+= "e " + flips[flipR] + "e' y ";
                   break;
               case 2: s+= "d " + flips[flipR] + "d' y ";
                   break;
               case 3: s+= "u' " + flips[flipR] + "u y ";
                   break;
               case 4: s+="e' " + flips[flipR] + "e y ";
                   break;
               case 5: s+="d' " + flips[flipR] + "d y ";
                   break;
               case 6: s+= "E F2 E' y ";
                   break;
               case 7: s+= "u2 " +flips[flipR]+ "u2' y " ;
               	break;
               case 8: s+= "d2 " +flips[flipR]+ "d2' y " ;
               		break;
               case 9: s+= "e2 " +flips[flipR]+ "e2' y " ;
               		break;
           }
        }
        if (parity) {
            s += " z Rw U2 x Rw U2 Rw U2' Rw' U2 Lw U2 3Rw' U2' Rw U2 Rw' U2' Rw' R z' ";
        }
        
    return s;
        
    }
    public static String createAlg5w() {
        String s = "";
        for (int i = 0; i <= 3; i++) {
            int sliceR = (int)(Math.random() * 11 );
            int flipR = (int)(Math.random() * 2 );
           switch(sliceR){

           case 0: s+= "uw " + flips[flipR] + "uw' y ";
               break;
           case 1: s+= "ew " + flips[flipR] + "ew' y ";
               break;
           case 2: s+= "dw " + flips[flipR] + "dw' y ";
               break;
           case 3: s+= "uw' " + flips[flipR] + "uw y ";
               break;
           case 4: s+="ew' " + flips[flipR] + "ew y ";
               break;
           case 5: s+="dw' " + flips[flipR] + "dw y ";
               break;
           case 6: s+= "E F2 E' y ";
               break;
           case 7: s+= "uw2 " +flips[flipR]+ "uw2' y " ;
           	break;
           case 8: s+= "dw2 " +flips[flipR]+ "dw2' y " ;
           		break;
           case 9: s+= "ew2 " +flips[flipR]+ "ew2' y " ;
           		break;
       
           }
        }
        
    return s;
      
    }
    public static String createAlg7(boolean parity) {
       String s = createAlg5w()+ createAlg5(parity);
        if (parity) {
            s += " z Rw U2 x Rw U2 Rw U2' Rw' U2 Lw U2 3Rw' U2' Rw U2 Rw' U2' Rw' R z' ";
        }
        return s;
    }
    public static String createAlg6(boolean parity) {
    	 String s = createAlg5w()+ createAlg5(parity);
        if (parity) {
            s += " z Rw U2 x Rw U2 Rw U2' Rw' U2 Lw U2 3Rw' U2' Rw U2 Rw' U2' Rw' R z' ";
        }
        return s;
    }
}
