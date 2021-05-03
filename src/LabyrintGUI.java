import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class LabyrintGUI extends JPanel { // labyrinten er et panel
    private final Labyrint labyrint;
    private ArrayList<RuteGUI> knapper = new ArrayList<RuteGUI>();
    private InfoGUI infoGUI;

    public LabyrintGUI(Labyrint l, InfoGUI i){
        super();
        labyrint = l;
        infoGUI = i;
        setLayout(new GridLayout(l.hentAntRader(), l.hentAntKolonner()));
        lagKnapper();
    }

    private void lagKnapper(){
        Rute[][] rutenett = labyrint.hentRutenett();
        Arrays.stream(rutenett) // lager stream
                .flatMap(rad -> Stream.of(rad)) // gjør streamen flat / pakker ut fra array
                .map(rute -> new RuteGUI(this, rute)) // lager knapper(RuteGUI) av alle rutene
                .forEach(rute -> this.add(rute)); // legger alle knapper på panelet(LabyrintGUI)

    }
    public void leggTilKnapp(RuteGUI r){
        knapper.add(r);
    }

    private void clearUtveier(){
        for (RuteGUI knapp : knapper){
            knapp.settStandardFarge();
        }
    }

    public void skrivInfo(){
        infoGUI.skrivInfo(labyrint);
    }

    public void finnUtveierFra(Rute r){
        clearUtveier(); // fjerner tidligere utveier
        ArrayList<Tuppel> utvei = labyrint.finnKortesteUtveiFra(r);

        for (Tuppel tuppel : utvei){
            RuteGUI rute = tuppel.hentRute().hentGUI();
            rute.setBackground(new Color(230, 0, 126));
        }

    }

    public InfoGUI hentInfoGUI(){return infoGUI;}

    public void tegnUtveier(ArrayList<ArrayList<Tuppel>> utveier){

    }
}
