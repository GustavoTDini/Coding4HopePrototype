package View;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    JPanel container = new JPanel();
    ScrollPane scrollingPanel = new ScrollPane();

    Header header = new Header();
    Footer footer = new Footer();



    public MainFrame (){

        BorderLayout mainLayout = new BorderLayout(5,5);

        this.setSize(1024, 600);
        this.add(scrollingPanel);
        scrollingPanel.add(header, mainLayout.NORTH);
        scrollingPanel.add(footer, mainLayout.SOUTH);


        scrollingPanel.setBackground(Color.GREEN);
        scrollingPanel.setLayout(mainLayout);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
