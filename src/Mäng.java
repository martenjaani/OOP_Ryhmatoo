import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mäng {

    public static void mäng(SeisuKontroll vasak, SeisuKontroll parem) {
        System.out.println(SeisuKontroll.indeksSeisuks(vasak.tugevaimSeis()) + " ja " + SeisuKontroll.indeksSeisuks(parem.tugevaimSeis()));
        System.out.println();

        System.out.println("vasak");
        System.out.println(vasak.väljastaSeis());
        System.out.println("parem");
        System.out.println(parem.väljastaSeis());

        if (parem.tugevaimSeis() < vasak.tugevaimSeis() && parem.tugevaimSeis() != -1) {
            System.out.println("Võidab parem, kellel on " + SeisuKontroll.indeksSeisuks(parem.tugevaimSeis()));
            for (Kaart kaart : parem.tugevaimadViis()) {
                System.out.print(kaart + " ");
            }
        } else if (parem.tugevaimSeis() > vasak.tugevaimSeis() && vasak.tugevaimSeis() != -1) {
            System.out.println("Võidab vasak, kellel on " + SeisuKontroll.indeksSeisuks(vasak.tugevaimSeis()));
            for (Kaart kaart1 : vasak.tugevaimadViis()) {
                System.out.print(kaart1 + " ");
            }
        } else if (vasak.tugevaimSeis() == parem.tugevaimSeis()) {
            int seis = vasak.tugevaimSeis();
            List<Kaart> vasakKõigeTugevam = vasak.getSeisud().get(seis).get(vasak.getSeisud().get(seis).size() - 1);
            List<Kaart> paremKõigeTugevam = parem.getSeisud().get(seis).get(parem.getSeisud().get(seis).size() - 1);
            if (seis == 2) {
                List<List<Kaart>> vasakuMajaPaarJaKolmik = SeisuKontroll.majaPaarJaKolmik(vasakKõigeTugevam);
                List<List<Kaart>> paremaMajaPaarJaKolmik = SeisuKontroll.majaPaarJaKolmik(paremKõigeTugevam);
                int vasakuKolmikuTugevus = vasakuMajaPaarJaKolmik.get(0).get(0).getTugevusArv();
                int paremaKolmikuTugevus = paremaMajaPaarJaKolmik.get(0).get(0).getTugevusArv();
                int vasakuPaariTugevus = paremaMajaPaarJaKolmik.get(1).get(0).getTugevusArv();
                int paremaPaariTugevus = paremaMajaPaarJaKolmik.get(1).get(0).getTugevusArv();
                if (vasakuKolmikuTugevus > paremaKolmikuTugevus) {
                    System.out.println("Võitja vasak!, tugevam maja");
                } else if (vasakuKolmikuTugevus < paremaKolmikuTugevus) {
                    System.out.println("Võitja parem!, tugevam maja");
                } else if (vasakuPaariTugevus > paremaPaariTugevus) {
                    System.out.println("Võitja vasak!, tugevam maja");
                } else if (vasakuPaariTugevus < paremaPaariTugevus) {
                    System.out.println("Võitja parem!, tugevam maja");
                } else System.out.println("Viik!");


            } else if (seis == 3) {
                if (vasakKõigeTugevam.get(vasakKõigeTugevam.size() - 1).getTugevusArv() > paremKõigeTugevam.get(paremKõigeTugevam.size() - 1).getTugevusArv()) {
                    System.out.println("Vasakul tugevam mast");
                } else if (vasakKõigeTugevam.get(vasakKõigeTugevam.size() - 1).getTugevusArv() < paremKõigeTugevam.get(paremKõigeTugevam.size() - 1).getTugevusArv()){
                    System.out.println("Paremal tugevam mast");
                }
                else System.out.println("Viik");

            } else if (seis == 6) {
                if (vasakKõigeTugevam.get(2).getTugevusArv() > paremKõigeTugevam.get(2).getTugevusArv()) {
                    System.out.println("Vasakul kõrgem paar tugevam");
                } else if (vasakKõigeTugevam.get(2).getTugevusArv() < paremKõigeTugevam.get(2).getTugevusArv()) {
                    System.out.println("Paremal kõrgem paar tugevam");
                } else if (vasakKõigeTugevam.get(0).getTugevusArv() > paremKõigeTugevam.get(0).getTugevusArv()) {
                    System.out.println("Vasakul üks paaridest tugevam");
                } else if (vasakKõigeTugevam.get(0).getTugevusArv() < paremKõigeTugevam.get(0).getTugevusArv()) {
                    System.out.println("Paremal üks paaridest tugevam");
                } else {
                    if (vasak.getSeisud().get(8).get(0).get(0).getTugevusArv() > parem.getSeisud().get(8).get(0).get(0).getTugevusArv()) {
                        System.out.println("Vasak võidab kõrgema kaardiga");
                    } else if (vasak.getSeisud().get(8).get(0).get(0).getTugevusArv() < parem.getSeisud().get(8).get(0).get(0).getTugevusArv()) {
                        System.out.println("Parem võidab kõrgema kaardiga");
                    } else System.out.println("Viik!");
                }
            } else {
                int vasakSumma = SeisuKontroll.tugevusedListist(vasakKõigeTugevam).stream().mapToInt(Integer::intValue).sum();
                int paremSumma = SeisuKontroll.tugevusedListist(paremKõigeTugevam).stream().mapToInt(Integer::intValue).sum();
                if (vasakSumma > paremSumma) {
                    System.out.println("Vasak võidab tänu kõrgemate kaartidele");
                } else if (vasakSumma < paremSumma) {
                    System.out.println("Parem võidab tänu kõrgemate kaartidele");

                } else if (vasak.getSeisud().get(8).get(0).get(0).getTugevusArv() > parem.getSeisud().get(8).get(0).get(0).getTugevusArv()) {
                    System.out.println("Vasak võidab kõrgema kaardiga");
                } else if (vasak.getSeisud().get(8).get(0).get(0).getTugevusArv() < parem.getSeisud().get(8).get(0).get(0).getTugevusArv()) {
                    System.out.println("Parem võidav kõrgema kaardiga");
                } else System.out.println("Viik");
            }


        }
    }

    public static String väljastaKaardid(List<Kaart> kaardid) {
        String väljund = "";
        for (int i = 0; i < kaardid.size() - 1; i++) {
            väljund += kaardid.get(i) + " ";
        }
        väljund += kaardid.get(kaardid.size() - 1);
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

        System.out.println(väljastaKaardid(vasakKäsi) + " ja " + väljastaKaardid(paremKäsi));
        System.out.println(väljastaKaardid(ühiskaardid));

        SeisuKontroll vasak = new SeisuKontroll(vasakKäsi, ühiskaardid);
        SeisuKontroll parem = new SeisuKontroll(paremKäsi, ühiskaardid);

        mäng(vasak, parem);
       /* System.out.println();
        System.out.println();
        System.out.println(vasak.getSeisud());
        System.out.println(parem.getSeisud());*/

    }
}
