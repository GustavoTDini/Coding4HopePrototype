package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class HeaderButton extends JButton {

    public static Dimension HEADER_BUTTON_DIM = new Dimension(280, 200);

    private final int  destino;
    private final MainFrame mainFrame;

    public HeaderButton(Color color, int destino, String texto, int fontSize, MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.destino = destino;
        this.setLayout(new GridBagLayout());
        JLabel textoLabel = new JLabel();
        textoLabel.setText(texto);
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        textoLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, fontSize));
        textoLabel.setForeground(Color.BLUE);
        this.setBackground(color);
        this.add(textoLabel);
        this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        this.setMinimumSize(HEADER_BUTTON_DIM);
        this.addActionListener(evt -> headerBtnAction(evt));
        this.setVisible(true);
    }

    private void headerBtnAction(ActionEvent evt) {
        mainFrame.setPaginaAtual(this.destino);
        try {
            mainFrame.mainShow();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}