import java.util.*;

/*
0 straight flush
1 nelik
2 maja
3 mastid
4 rida
5 kolmik
6 2 paari
7 paar
8 korge
 */
public class SeisuKontroll {
    private List<Kaart> käsi;
    private List<Kaart> ühiskaardid;
    private List<Kaart> kõikKaardid=new ArrayList<>();
    private List<List<List<Kaart>>> seisud;

    public SeisuKontroll(List<Kaart> käsi, List<Kaart> ühiskaardid) {
        this.käsi = käsi;
        this.ühiskaardid = ühiskaardid;
        kõikKaardid.addAll(käsi);
        kõikKaardid.addAll(ühiskaardid);
        Collections.sort(kõikKaardid);
        seisud=new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            seisud.add(i,new ArrayList<>());
        }

    }

    public void kõikVõimalused() {
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

        for (int[] indeksid : võimalused) {
            List<Kaart> kontrollitavadKaardid = new ArrayList<>();
            kontrollitavadKaardid.add(kõikKaardid.get(indeksid[0]));
            kontrollitavadKaardid.add(kõikKaardid.get(indeksid[1]));
            kontrollitavadKaardid.add(kõikKaardid.get(indeksid[2]));
            kontrollitavadKaardid.add(kõikKaardid.get(indeksid[3]));
            kontrollitavadKaardid.add(kõikKaardid.get(indeksid[4]));

            //kõrge
            paar(kontrollitavadKaardid);
            //kaks paari
            kolmik(kontrollitavadKaardid);
            rida(kontrollitavadKaardid);
            //mastid
            //maja
            nelik(kontrollitavadKaardid);
            //straight flush
        }
    }


    public void nelik(List<Kaart> viisKaarti){
        for (int i = 0; i < 2; i++) {
            int mituKordaEsineb=1;
            for (int j = i+1; j < viisKaarti.size(); j++) {
                if(viisKaarti.get(i).getTugevus() == viisKaarti.get(j).getTugevus()){
                    mituKordaEsineb++;
                }
                if(mituKordaEsineb==4){
                    mituKordaEsineb=0;
                    seisud.get(1).add(viisKaarti.subList(i,i+4));


                }

            }
        }

    }

    public void kolmik(List<Kaart> viisKaarti){
        for (int i = 0; i < 3; i++) {
            //mitu korda esineb
            int mituKordaEsineb=1;
            for (int j = i+1; j < viisKaarti.size(); j++) {
                if(viisKaarti.get(i).getTugevus() == viisKaarti.get(j).getTugevus()){
                    mituKordaEsineb++;
                }
                if(mituKordaEsineb==3){
                    seisud.add(5,seisud.get(5));
                    mituKordaEsineb=0;

                }

            }
        }

    }


    public void paar(List<Kaart> viisKaarti){
        for (int i = 0; i < 4; i++) {
            int mituKordaEsineb=1;
            for (int j = i+1; j < viisKaarti.size(); j++) {
                if(viisKaarti.get(i).getTugevusArv() == viisKaarti.get(j).getTugevusArv()){
                    mituKordaEsineb++;
                }
                if(mituKordaEsineb==2){
                    seisud.get(7).add(viisKaarti.subList(i,i+2));
                    mituKordaEsineb=0;

                }

            }
        }

    }

    public void rida(List<Kaart> viisKaarti) {
        int mituKorda = 0;
        for (int i = 0; i < viisKaarti.size()-1; i++) {
            if (viisKaarti.get(i).getTugevusArv() + 1 == viisKaarti.get(i + 1).getTugevusArv())
                mituKorda += 1;
            else break;
        }
        if (viisKaarti.get(viisKaarti.size()-2).getTugevusArv() + 1 == viisKaarti.get(viisKaarti.size()-1).getTugevusArv())
            mituKorda += 1;
        if (mituKorda == 5)
            seisud.get(4).add(viisKaarti);
    }

    public List<List<List<Kaart>>> getSeisud() {
        return seisud;
    }
    public List<Kaart> getKõikKaardid() {
        return kõikKaardid;
    }

    public int tugevaimSeis() {
        for (int i = 0; i < seisud.size(); i++) {
            if (seisud.get(i).size() != 0) {
                return i;
            }
        }
        return 0;
    }

    public List<Kaart> tugevaimadViis() {
        int suurimSumma = 0;
        int suurimIndeks = 0;
        if (tugevaimSeis() != 2) {
            for (int i = 0; i < seisud.get(tugevaimSeis()).size(); i++) {
                int ajutineSumma = 0;
                for (int j = 0; j < seisud.get(tugevaimSeis()).get(i).size(); j++) {
                    ajutineSumma += seisud.get(tugevaimSeis()).get(i).get(j).getTugevusArv();
                }
                if (ajutineSumma > suurimSumma) {
                    suurimSumma = ajutineSumma;
                    suurimIndeks = i;
                }
            }
        }
        return seisud.get(tugevaimSeis()).get(suurimIndeks);
    }
}
