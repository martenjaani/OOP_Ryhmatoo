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


/*Kaart kaart1=new Kaart("7",'♥');
        Kaart kaart2=new Kaart("8",'♣');
        Kaart kaart3=new Kaart("8",'♠');
        Kaart kaart4=new Kaart("10",'♥');
        Kaart kaart5=new Kaart("J",'♥');
        Kaart kaart6=new Kaart("7",'♦');
        Kaart kaart7=new Kaart("7",'♣');
        Kaart kaart8=new Kaart("8",'♥');
        Kaart kaart9=new Kaart("7",'♠');
        vasakKäsi.addAll(Arrays.asList(kaart2,kaart3));
        ühiskaardid.addAll(Arrays.asList(kaart4,kaart5,kaart6,kaart7,kaart8));
        paremKäsi.addAll(Arrays.asList(kaart1,kaart9));*/

/* System.out.println();
        System.out.println();
        System.out.println(vasak.getSeisud());
        System.out.println(parem.getSeisud());*/
