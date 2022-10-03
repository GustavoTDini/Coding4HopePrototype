package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Header extends JPanel implements ActionListener {

    public Header (){
        this.setLayout(new BorderLayout());
        this.setSize(1024, 100);
        this.setBackground(Color.darkGray);
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
