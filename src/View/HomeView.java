package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class HomeView extends JPanel{

    private JPanel painel;
    private Image bgimage;

    public HomeView(MainFrame mainFrame){
        this.setSize(1024, 600);

        JLabel titulo = new JLabel("Servimos a Migrantes e Refugiados de qualquer Lugar do mundo");
        titulo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
        titulo.setForeground(Color.BLUE);
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File("res/maos.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bgimage = bufferedImage.getScaledInstance(1024, 500, Image.SCALE_SMOOTH);
        JLabel imageLabel = new JLabel(new ImageIcon(bgimage));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel texto = new JLabel("Uma Organização construída pela diversidade com meta integradora de migrantes, atuando na inclusão social dos migrantes/refugiados");
        texto.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 15));
        texto.setForeground(Color.BLUE);
        texto.setHorizontalAlignment(SwingConstants.CENTER);

        this.setLayout(new GroupLayout(this));
        this.setLayout(new GridLayout());

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addComponent(titulo, GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                        .addComponent(imageLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(texto, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(titulo)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imageLabel, GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(texto)
                                .addContainerGap())
        );



        this.setVisible(true);

    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(bgimage,0,0, getWidth(), getHeight(), this);
        super.paintComponent(g);
    }
}
