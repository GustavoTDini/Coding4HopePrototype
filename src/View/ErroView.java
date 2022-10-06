package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ErroView extends JPanel {

    public ErroView(){

        JLabel lbTitulo = new JLabel();
        JLabel lbTexto = new JLabel();
        JLabel imageLabel = new JLabel();

        setPreferredSize(new java.awt.Dimension(1024, 600));

        lbTitulo.setFont(new java.awt.Font("Leelawadee UI", 1, 24)); // NOI18N
        lbTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitulo.setText("Erro 404");

        lbTexto.setFont(new java.awt.Font("Leelawadee UI", 1, 18)); // NOI18N
        lbTexto.setHorizontalAlignment(SwingConstants.CENTER);
        lbTexto.setText("Desculpe, não encontramos a página solicitada");

        BufferedImage bufferedImage;
        try {
            bufferedImage = ImageIO.read(new File("res/lostWorld.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Image worldImage = bufferedImage.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        imageLabel.setIcon(new ImageIcon(worldImage));
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lbTitulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbTexto, GroupLayout.DEFAULT_SIZE, 1018, Short.MAX_VALUE)
                                        .addComponent(imageLabel, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(90, 90, 90)
                                .addComponent(lbTitulo)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbTexto, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(imageLabel, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(219, Short.MAX_VALUE))
        );
    }

}
