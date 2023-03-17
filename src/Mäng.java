import java.util.ArrayList;
import java.util.List;

public class Mäng {
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
    }
}
