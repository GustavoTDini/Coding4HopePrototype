package View;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class BlogView extends JPanel{

    public BlogView(MainFrame mainFrame) throws IOException {

        this.setLayout(new GridBagLayout());

        JLabel label = new JLabel("Blog");

        this.add(label);

        this.setSize(1024, 600);
        this.setBackground(Color.white);
    }

}
