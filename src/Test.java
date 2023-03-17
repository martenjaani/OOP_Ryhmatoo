import java.util.List;

public class Test {
    public static void main(String[] args) {
        Pakk x = new Pakk();
        x.sega();
        for (int i = 0; i < x.getKaardid().size(); i++) {
            System.out.println(x.getKaardid().get(i));
        }
    }
}
