import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Pakk x = new Pakk();
        x.sega();
        for (int i = 0; i < x.getKaardid().size(); i++) {
            System.out.println(x.getKaardid().get(i));
        }

        System.out.println();
        List<Kaart> proov = new ArrayList<>();
        Kaart esimene = new Kaart("K♠");
        Kaart teine = new Kaart("Q♥");

        proov.add(esimene);
        proov.add(teine);
        Collections.sort(proov);

        for (Kaart kaart : proov) {
            System.out.println(kaart);
        }
        int[][] võimalused = {
                {0,1,2,3,4},
                {0,1,2,3,5},
                {0,1,2,3,6},
                {0,1,2,4,5},
                {0,1,2,4,6},
                {0,1,2,5,6},
                {0,1,3,4,5},
                {0,1,3,4,6},
                {0,1,3,5,6},
                {0,1,4,5,6},
                {0,2,3,4,5},
                {0,2,3,4,6},
                {0,2,3,5,6},
                {0,2,4,5,6},
                {0,3,4,5,6},
                {1,2,3,4,5},
                {1,2,3,4,6},
                {1,2,3,5,6},
                {1,2,4,5,6},
                {1,3,4,5,6},
                {2,3,4,5,6}
        };

    }
}
