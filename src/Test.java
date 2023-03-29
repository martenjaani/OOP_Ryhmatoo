import java.util.ArrayList;
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
    }
}
