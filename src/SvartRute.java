import java.util.ArrayList;

class SvartRute extends Rute{


    public SvartRute(Labyrint minLabyrint, int x, int y) {
        super(minLabyrint, x, y);
    }

    @Override
    public char tilTegn(){
        return '#';
    }

    @Override
    public void gaa(ArrayList<Tuppel> forrigeSti){ } // metoden gjør ingenting, vi kan ikke gå på svart rute
}
