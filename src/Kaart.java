public class Kaart {
    private String tugevus;
    private char mast;

    public Kaart(String tugevus, char mast) {
        String[] tugevused = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        char[] mastid = {'♣', '♦', '♠', '♥'};
        boolean tugevusKontroll = false;
        boolean mastiKontroll = false;

        for (String t : tugevused) {
            if (t.equals(tugevus)) {
                this.tugevus = tugevus;
                tugevusKontroll = true;
                break;
            }
        }
        if (!tugevusKontroll)
            throw new RuntimeException("Ebasobiv kaardi tugevus.");

        for (char m : mastid) {
            if (m == mast) {
                this.mast = m;
                mastiKontroll = true;
                break;
            }
        }
        if (!mastiKontroll)
            throw new RuntimeException("Ebasobiv kaardi mast.");
    }

    public Kaart(String kaart) {
        String ajutineTugevus = kaart.substring(0, 1);
        String ajutineMast = kaart.substring(1);
        if (kaart.length() == 3) {
            ajutineTugevus = kaart.substring(0, 2);
            ajutineMast = kaart.substring(2);
        }

        String[] tugevused = {"A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2"};
        String[] mastid = {"♣", "♦", "♠", "♥"};
        boolean tugevusKontroll = false;
        boolean mastiKontroll = false;

        for (String t : tugevused) {
            if (t.equals(ajutineTugevus)) {
                this.tugevus = ajutineTugevus;
                tugevusKontroll = true;
                break;
            }
        }
        if (!tugevusKontroll)
            throw new RuntimeException("Ebasobiv kaardi tugevus.");

        for (String m : mastid) {
            if (m.equals(ajutineMast)) {
                this.mast = ajutineMast.charAt(0);
                mastiKontroll = true;
                break;
            }
        }
        if (!mastiKontroll)
            throw new RuntimeException("Ebasobiv kaardi mast.");
    }

    public String getTugevus() {
        return tugevus;
    }

    public char getMast() {
        return mast;
    }

    @Override
    public String toString() {
        return tugevus + mast;
    }
}
