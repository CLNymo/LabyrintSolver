import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.*;

public class VinduGUI extends JFrame { // vinduet er en Frame

    public VinduGUI(File fil) throws FileNotFoundException {
        super("Labyrint");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InfoGUI info = new InfoGUI();
        Labyrint labyrint = new Labyrint(fil);
        LabyrintGUI labyrintGUI = new LabyrintGUI(labyrint, info);


        add(labyrintGUI, BorderLayout.NORTH);
        add(info, BorderLayout.SOUTH);
        pack();
        setVisible(true);



    }
}
