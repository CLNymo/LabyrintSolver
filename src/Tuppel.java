public class Tuppel {
    private final int[] tuppel = new int[2];

    public Tuppel(Rute rute){
        tuppel[0] = rute.hentXKoordinat();
        tuppel[1] = rute.hentYKoordinat();

    }

    public int[] hentTuppel(){
        return tuppel;
    }

    public boolean equals(Tuppel annenTuppel){
        if (tuppel[0] == annenTuppel.hentTuppel()[0]
                && tuppel[1] == annenTuppel.hentTuppel()[1]){
            return true;
        }
        else return false;
    }

    @Override
    public String toString(){
        return "(" + tuppel[0] + ", " + tuppel[1] + ")";
    }
}
