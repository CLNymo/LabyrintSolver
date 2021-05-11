import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.*;

public class MainGUI {


    public static void main(String[] args) throws FileNotFoundException {
        VinduGUI vindu = new VinduGUI(velgFil());
    }

    private static File velgFil(){
        JFileChooser filvelger = new JFileChooser();
        int resultat = filvelger.showOpenDialog(null);

        if (resultat != JFileChooser.APPROVE_OPTION) {
            System.exit(1);
        }
        File fil = filvelger.getSelectedFile();

        return fil;
    }
}
