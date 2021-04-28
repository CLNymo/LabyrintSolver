import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RuteGUI extends JButton {
    Rute rute;
    Labyrint labyrint;
    char tekst;
    boolean trykketPaa = false;

    public RuteGUI(Rute r){ // ruteGUI er en type knapp
        super(String.valueOf(r.tilTegn())); // tekst på knapp blir samme som på rute
        rute = r;
        labyrint = rute.hentLabyrint();
        tekst = r.tilTegn();
    }

    class TrykkPaa implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            trykketPaa = !trykketPaa;
            if (trykketPaa){
                labyrint.finnUtveiFra(rute);
            }
        }
    }
}
