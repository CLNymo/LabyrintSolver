import java.util.ArrayList;
import java.util.stream.Stream;

public class HvitRute extends Rute{



    public HvitRute(Labyrint minLabyrint, int x, int y) {
        super(minLabyrint, x, y);
    }

    @Override
    public char tilTegn(){
        return '.';
    }

    @Override
    public void gaa(ArrayList<Tuppel> forrigeSti) {
        flagg = true;
        forrigeSti.add(tuppel);
        //System.out.println("Går til " + tuppel);

        Stream.of(nordNabo, oestNabo, sorNabo, vestNabo) // lager stream fordi d ser kult ut
                .filter(rute -> !(rute == null)) // fjerner tomme naboer
                .filter(rute -> !rute.flagg) // fjerner naboer vi allerede har passert
                .forEach(rute -> rute.gaa(new ArrayList<Tuppel>(forrigeSti)));

        flagg = false; // flagg vil nullstilles etter at en utvei er funnet
    }

}
