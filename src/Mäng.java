import java.util.ArrayList;
import java.util.List;

public class Mäng {
    public static void test(SeisuKontroll vasak, SeisuKontroll parem) {
        System.out.println(vasak.tugevaimSeis() + " ja " + parem.tugevaimSeis());
        System.out.println();

        System.out.println("vasak");
        System.out.println(vasak.väljastaSeis());
        System.out.println("parem");
        System.out.println(parem.väljastaSeis());

        if (parem.tugevaimSeis() < vasak.tugevaimSeis()) {
            System.out.println("parem");
            for (Kaart kaart : parem.tugevaimadViis()) {
                System.out.print(kaart + " ");
            }
        }
        else if (parem.tugevaimSeis() > vasak.tugevaimSeis()){
            System.out.println("vasak");
            for (Kaart kaart1 : vasak.tugevaimadViis()) {
                System.out.print(kaart1 + " ");
            }
        }
        else System.out.println("viik");
    }
    public static String väljastaKaardid(List<Kaart> kaardid) {
        String väljund = "";
        for (int i = 0; i < kaardid.size()-1; i++) {
            väljund += kaardid.get(i) + " ";
        }
        väljund += kaardid.get(kaardid.size()-1);
        return väljund;
    }
    public static void main(String[] args) {
        Pakk mängukaardid = new Pakk();
        mängukaardid.sega();

        //Kaartide jagamine
        List<Kaart> vasakKäsi = new ArrayList<>();
        List<Kaart> paremKäsi = new ArrayList<>();
        List<Kaart> ühiskaardid = new ArrayList<>();

        for (int i = 0; i < 2; i++) {
            vasakKäsi.add(mängukaardid.võtaKaart());
            paremKäsi.add(mängukaardid.võtaKaart());
        }

        for (int i = 0; i < 5; i++) {
            ühiskaardid.add(mängukaardid.võtaKaart());
        }

        System.out.println(väljastaKaardid(vasakKäsi) + " ja " + väljastaKaardid(paremKäsi));
        System.out.println(väljastaKaardid(ühiskaardid));

        SeisuKontroll vasak = new SeisuKontroll(vasakKäsi, ühiskaardid);
        SeisuKontroll parem = new SeisuKontroll(paremKäsi, ühiskaardid);

        test(vasak, parem);
    }
}
