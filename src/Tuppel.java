public class Tuppel {
    private final int[] tuppel = new int[2];
    private final Rute tilhorendeRute;

    public Tuppel(Rute rute){
        tilhorendeRute = rute;
        tuppel[0] = rute.hentXKoordinat();
        tuppel[1] = rute.hentYKoordinat();
    }

    public int[] hentTuppel(){
        return tuppel;
    }

    public boolean equals(Tuppel annenTuppel){ // returnerer true eller false hvis to tupler er like
        return tuppel[0] == annenTuppel.hentTuppel()[0]
                && tuppel[1] == annenTuppel.hentTuppel()[1];
    }

    public Rute hentRute(){return tilhorendeRute;}

    @Override
    public String toString(){
        return "(" + tuppel[0] + ", " + tuppel[1] + ")";
    }
}
