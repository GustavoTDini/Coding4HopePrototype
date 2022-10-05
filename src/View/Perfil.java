package View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Perfil extends JPanel {

    public Perfil(MainFrame mainFrame) throws IOException {

        this.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Perfil");

        this.add(label);

        this.setSize(1024, 600);
        this.setBackground(Color.white);
    }


}
