import java.util.ArrayList;
import java.util.stream.Stream;

abstract class Rute {
    protected Labyrint minLabyrint;
    protected int xKoordinat, yKoordinat;
    protected Rute nordNabo = null, sorNabo = null, oestNabo = null, vestNabo = null;
    protected Tuppel tuppel;
    protected Boolean flagg = false;

    public Rute(Labyrint minLabyrint, int x, int y) {
        // husk: koordinatsystemet begynner på 0. Første rute har koordinatene [0, 0]
        this.minLabyrint = minLabyrint;
        xKoordinat = x;
        yKoordinat = y;
        tuppel = new Tuppel(this);
    }

    abstract char tilTegn();

    abstract void gaa(ArrayList<Tuppel> forrigeSti);

    public void finnUtvei(){
        ArrayList<Tuppel> nySti = new ArrayList<Tuppel>();
        nySti.add(tuppel);
        gaa(nySti);
    }

    /*
    Diskusjon:
    Er det best at Ruten har ansvar for å sette sine egne naboer, eller burde dette være Labyrintens oppgave?
    Labyrinten er jo den som skal ha kontroll og sånn, men vi må uansett ha en metode i rute som lar den sette pekerne
    på naboene?
     */

    public void settNordNabo() {
        Rute[][] rutenett = minLabyrint.hentRutenett();
        nordNabo = rutenett[yKoordinat - 1][xKoordinat];
    }

    public void settSorNabo() {
        Rute[][] rutenett = minLabyrint.hentRutenett();
        sorNabo = rutenett[yKoordinat+1][xKoordinat];
    }

    public void settOestNabo() {
        Rute[][] rutenett = minLabyrint.hentRutenett();
        oestNabo = rutenett[yKoordinat][xKoordinat + 1];
    }

    public void settVestNabo() {
        Rute[][] rutenett = minLabyrint.hentRutenett();
        vestNabo = rutenett[yKoordinat][xKoordinat - 1];
    }

    public String toString(){
        return "[" + hentXKoordinat() + ", " + hentYKoordinat() + "]";
    }
    public void skrivNaboer(){
        System.out.println("Naboer for ruten " + this + ":");
        System.out.println("      " + nordNabo);
        System.out.println(vestNabo + "      " + oestNabo);
        System.out.println("      " + sorNabo);
        System.out.println("\n");
    }

    public Tuppel hentKoordinater(){
        return tuppel;
    }

    public boolean equals(Rute annenRute){
        return hentXKoordinat() == annenRute.hentXKoordinat() && hentYKoordinat() == annenRute.hentYKoordinat();
    }


    public int hentXKoordinat(){ return xKoordinat;}
    public int hentYKoordinat(){ return yKoordinat;}
}
