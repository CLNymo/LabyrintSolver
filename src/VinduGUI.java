import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class VinduGUI {

    public VinduGUI(File fil) throws FileNotFoundException {

        Labyrint labyrint = new Labyrint(fil);
        labyrint.opprettGUI();

        JFrame vindu = new JFrame("Labyrint");
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
