import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RuteGUI extends JButton {
    private Rute rute;
    private char tekst;
    private LabyrintGUI labyrintGUI;



    public RuteGUI(LabyrintGUI l,  Rute r){ // ruteGUI er en type knapp
        super(""); // tekst på knapp blir samme som på rute
        rute = r;
        tekst = r.tilTegn();
        addActionListener(new TrykkPaa());
        settStandardFarge();
        labyrintGUI = l;
        r.settGUI(this);
        l.leggTilKnapp(this);
    }

    public void settStandardFarge(){
        if (tekst == '#'){
            setBackground(Color.BLACK);
        } else {
            setBackground(new Color(249, 189, 221));
        }
    }

    class TrykkPaa implements ActionListener{
        private boolean trykketPaa = false;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (tekst != '#') {
                trykketPaa = !trykketPaa;
                if (trykketPaa) {
                    labyrintGUI.finnUtveierFra(rute);
                    labyrintGUI.skrivInfo();
                }
            }
        }
    }
}
