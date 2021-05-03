import javax.swing.*;

public class InfoGUI extends JPanel {
    private JLabel info;

    public InfoGUI(){
        info = new JLabel("Trykk på en hvit rute for å finne korteste utvei fra labyrinten.");
        add(info);
    }

    public void skrivInfo(Labyrint l){
        info.setText(
                "Antall utveier funnet: " + l.hentUtveier().size() + "\n Korteste utvei vises paa kartet.");
    }
}
