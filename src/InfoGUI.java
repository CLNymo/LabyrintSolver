import javax.swing.*;

public class InfoGUI extends JPanel {
    private JLabel info;

    public InfoGUI(){
        info = new JLabel("<html><i>Trykk på en rute for å finne korteste <br>utvei fra labyrinten.</i><html>");
        add(info);
    }

    public void skrivInfo(Labyrint l){
        info.setText(
                "<html><i>Antall utveier funnet: " + l.hentUtveier().size() + "<br> Korteste utvei vises paa kartet.</i><html>");
    }
}
