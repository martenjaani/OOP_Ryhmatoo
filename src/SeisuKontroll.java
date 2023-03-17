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

    public void nelik(List<Kaart> viisKaarti){
        for (int i = 0; i < 2; i++) {
            int mituKordaEsineb=1;
            for (int j = i+1; j < viisKaarti.size(); j++) {
                if(viisKaarti.get(i).getTugevusArv() == viisKaarti.get(j).getTugevusArv()){
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
                if(viisKaarti.get(i).getTugevusArv() == viisKaarti.get(j).getTugevusArv()){
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

    public void maja(){
        if(!seisud.get(7).isEmpty() && !seisud.get(5).isEmpty() && !new HashSet<>(seisud.get(5)).containsAll(seisud.get(7))){
            seisud.get(2).add(seisud.get(7).get(0));
            seisud.get(2).add(seisud.get(5).get(0));
        }
    }


    public List<List<List<Kaart>>> getSeisud() {
        return seisud;
    }
    public List<Kaart> getKõikKaardid() {
        return kõikKaardid;
    }

    public int tugevaimSeis() {
        for (int i = 0; i < seisud.size(); i++) {
            if (seisud.get(i).size() != 0)
                return i;
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
