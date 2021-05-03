import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Labyrint {
    private final File fil;
    private Rute[][] rutenett; // [rader][kolonner]
    private int antRader;
    private int antKolonner;
    private ArrayList<ArrayList<Tuppel>> utveier = new ArrayList<ArrayList<Tuppel>>();


    public Labyrint(File fil) throws FileNotFoundException{
        this.fil = fil;
        lesFraFil(); // først setter inn ruter i rutenett
        settRutenesNaboer(); // deretter går gjennom alle ruter og setter naboene derer

    }


    public void lesFraFil() throws FileNotFoundException {
        Scanner scanner = new Scanner(fil);
        if (scanner.hasNextLine()) { // leser forste linje
            String linje = scanner.nextLine();
            String[] data = linje.split(" ");
            antRader = Integer.parseInt(data[0]);
            antKolonner = Integer.parseInt(data[1]);

            rutenett = new Rute[antRader][antKolonner];
        }

        int radNr = 0; // radNr vil tilsvare y-koordinat for rutene
        while (scanner.hasNextLine()) {
            String linje = scanner.nextLine();
            String[] enRad = linje.split("");
            for (int kolonneNr = 0; kolonneNr < antKolonner; kolonneNr++) { // kolonneNr vil tilsvare x-koordinat for rutene

                // edge-case: hvis ruten er en åpning

                if (enRad[kolonneNr].equals(".")) {
                    if(radNr == 0 || kolonneNr == 0 || radNr == antRader - 1 || kolonneNr == antKolonner - 1){
                        Aapning rute = new Aapning(this, kolonneNr, radNr);
                        rutenett[radNr][kolonneNr] = rute;
                    } else {
                        HvitRute rute = new HvitRute(this, kolonneNr, radNr);
                        rutenett[radNr][kolonneNr] = rute;
                    }

                } else {
                    SvartRute rute = new SvartRute(this, kolonneNr, radNr);
                    rutenett[radNr][kolonneNr] = rute;
                }
            }
            radNr++;
        }
        scanner.close();
    }

    public void settRutenesNaboer() {
        for (int radNr = 0; radNr < antRader; radNr++){
            for(int kolonneNr = 0; kolonneNr < antKolonner; kolonneNr ++){
                Rute tmpRute = rutenett[radNr][kolonneNr];

                // setter først naboene på samme rad:
                if (kolonneNr == 0){
                    tmpRute.settOestNabo();
                }
                else if (kolonneNr == antKolonner - 1){
                    tmpRute.settVestNabo();
                }
                else {
                    tmpRute.settOestNabo();
                    tmpRute.settVestNabo();
                }

                // setter deretter naboene på samme kolonne:
                if (radNr == 0){
                    tmpRute.settSorNabo();
                }
                else if (radNr == antRader - 1){
                    tmpRute.settNordNabo();
                }
                else {
                    tmpRute.settNordNabo();
                    tmpRute.settSorNabo();
                }

            }
        }
    }

    public ArrayList<ArrayList<Tuppel>> hentUtveier(){
        return utveier;
    }

    public ArrayList<ArrayList<Tuppel>> finnUtveierFra(Rute r){
        utveier.clear(); // hver gang vi skal finne utveier må vi først tømme beholderen for de gamle
        r.finnUtveier();
        return utveier;
    }

    public ArrayList<Tuppel> finnKortesteUtveiFra(Rute r){

        finnUtveierFra(r);

        int minsteLengde = utveier.get(0).size();
        ArrayList<Tuppel> minsteVei = utveier.get(0);
        for (ArrayList<Tuppel> utvei : utveier){
            if (utvei.size() < minsteLengde){
                minsteLengde = utvei.size();
                minsteVei = utvei;
            }
        }
        System.out.println("Antall utveier funnet: " + utveier.size());
        System.out.println("Korteste utvei (lengde " + minsteLengde + "):");

        return minsteVei;
    }

    public void leggTilUtvei(ArrayList<Tuppel> utvei){
        utvei.remove(0); // fjerner forste element, fordi det er duplikat
        utveier.add(utvei);
    }


    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for(Rute[] rad : rutenett){
            for (Rute rute : rad){
                str.append(rute.tilTegn());
            }
            str.append("\n");
        }
        return str.toString();
    }

    public Rute[][] hentRutenett(){ return rutenett; }
    public int hentAntRader() { return antRader; }
    public int hentAntKolonner() { return antKolonner; }
}
