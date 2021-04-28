import java.util.ArrayList;

public class Aapning extends HvitRute{

    public Aapning(Labyrint minLabyrint, int x, int y) {
        super(minLabyrint, x, y);
    }

    @Override
    public void gaa(ArrayList<Tuppel> forrigeSti) { // finner vi en åpning skal stien lagres som en utvei i labyrinten
        ArrayList<Tuppel> nySti = new ArrayList<Tuppel>(forrigeSti);
        nySti.add(tuppel);
        minLabyrint.leggTilUtvei(nySti);
    }
}
