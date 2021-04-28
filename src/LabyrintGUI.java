import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class LabyrintGUI {
    Labyrint labyrint;
    JPanel panel = new JPanel();

    public LabyrintGUI(Labyrint l){
        labyrint = l;
        panel.setLayout(new GridLayout(l.hentAntRader(), l.hentAntKolonner()));
        lagKnapper();
    }

    private void lagKnapper(){
        Rute[][] rutenett = labyrint.hentRutenett();
        Arrays.stream(rutenett)
                .flatMap(Stream::of) // lager en stream med alle rutene
                .map(Rute::opprettRuteGUI) // lager en JButton av alle rutene (RuteGUI er en JButton)
                .forEach(ruteGUI -> panel.add(ruteGUI)); // legger knappene paa panelet, kommer automatisk paa riktig plass (tror jeg)

    }

    public void tegnUtveier(ArrayList<ArrayList<Tuppel>> utveier){

    }


    public JPanel hentPanel(){return panel;}
}
