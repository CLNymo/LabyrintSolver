import java.util.ArrayList;

abstract class Rute {
    protected final Labyrint labyrint;
    protected final int xKoordinat, yKoordinat;
    protected final Tuppel tuppel;
    protected Rute nordNabo = null, sorNabo = null, oestNabo = null, vestNabo = null;
    protected Boolean flagg = false;
    protected RuteGUI GUI; // ruten har en referanse til tilsvarende GUI-knapp
    // alle init-variablene må være protected for at subklassen skal få tilgang. Er det OK, eller bør det gjøres på en anne måte?

    public Rute(Labyrint minLabyrint, int x, int y) {
        // koordinatsystemet begynner på 0. Første rute har koordinatene [0, 0]
        labyrint = minLabyrint;
        xKoordinat = x;
        yKoordinat = y;
        tuppel = new Tuppel(this);

    }

    abstract char tilTegn();

    abstract void gaa(ArrayList<Tuppel> forrigeSti);

    public void finnUtveier(){
        ArrayList<Tuppel> nySti = new ArrayList<Tuppel>();
        nySti.add(tuppel);
        gaa(nySti);
    }

    public void settNordNabo() {
        Rute[][] rutenett = labyrint.hentRutenett();
        nordNabo = rutenett[yKoordinat - 1][xKoordinat];
    }

    public void settSorNabo() {
        Rute[][] rutenett = labyrint.hentRutenett();
        sorNabo = rutenett[yKoordinat+1][xKoordinat];
    }

    public void settOestNabo() {
        Rute[][] rutenett = labyrint.hentRutenett();
        oestNabo = rutenett[yKoordinat][xKoordinat + 1];
    }

    public void settVestNabo() {
        Rute[][] rutenett = labyrint.hentRutenett();
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

    public void settGUI(RuteGUI r){GUI = r;}
    public RuteGUI hentGUI(){return GUI;}

    public Labyrint hentLabyrint(){return labyrint;}

    public int hentXKoordinat(){ return xKoordinat;}
    public int hentYKoordinat(){ return yKoordinat;}
}
