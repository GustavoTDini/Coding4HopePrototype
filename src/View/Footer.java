package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Footer extends JPanel implements ActionListener {

    public Footer() {
        this.setLayout(new BorderLayout());
        this.setSize(1024, 100);
        this.setBackground(Color.cyan);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
