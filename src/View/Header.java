package View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class Header extends JPanel {

    private MainFrame mainFrame;
    private HeaderButton login;
    private HeaderButton doar;
    private HeaderButton perfil;


    public Header (MainFrame mainFrame) throws IOException {
        this.mainFrame = mainFrame;
    }

    public void HeaderUpdate() throws IOException {
        this.setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = (new Insets(1,2,1,2));
        constraints.weightx = 1;
        constraints.gridx = 1;
        //Criação do logo
        JPanel logo = new JPanel();
        logo.setSize(HeaderButton.HEADER_BUTTON_DIM);
        BufferedImage logoPicture = ImageIO.read(new File("res/logo.png"));
        Image logoIcon = logoPicture.getScaledInstance(140, 100, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(logoIcon));
        logo.setBackground(Color.lightGray);
        logo.setSize(HeaderButton.HEADER_BUTTON_DIM);
        logo.add(logoLabel);
        this.add(logo, constraints);

        // Criação do botão Home
        constraints.gridx = 2;
        HeaderButton home = new HeaderButton(Color.white, MainFrame.HOME, "Home", 18, mainFrame);
        this.add(home, constraints);

        // Criação do botão Sobre
        constraints.gridx = 3;
        HeaderButton sobre = new HeaderButton(Color.white, MainFrame.SOBRE, "Sobre", 18, mainFrame);
        this.add(sobre, constraints);

        // Criação do botão Projetos
        constraints.gridx = 4;
        HeaderButton projetos = new HeaderButton(Color.white, MainFrame.PROJETOS, "Projetos", 18, mainFrame);
        this.add(projetos, constraints);

        // Criação do botão Blog
        constraints.gridx = 5;
        HeaderButton blog = new HeaderButton(Color.white, MainFrame.BLOG, "Blog", 18, mainFrame);
        this.add(blog, constraints);

        // Criação do botão Relatorios
        constraints.gridx = 6;
        HeaderButton relatorios = new HeaderButton(Color.white, MainFrame.RELATORIOS, "Relatórios", 18, mainFrame);
        this.add(relatorios, constraints);

        if (mainFrame.getUsuario() == null){
            if (doar != null){
                this.remove(doar);
            }
            if (perfil != null){
                this.remove(perfil);
            }
            // Criação do botão Login
            constraints.gridx = 7;
            login = new HeaderButton(Color.YELLOW, MainFrame.LOGIN, "LOGIN", 22, mainFrame);
            this.add(login, constraints);
        } else{
            if (login != null){
                this.remove(login);
            }
            // Criação do botão Doar
            constraints.gridx = 7;
            doar = new HeaderButton(Color.YELLOW, MainFrame.DOAR, "DOE AGORA", 22, mainFrame);
            this.add(doar, constraints);
            // Criação do botão Perfil
            constraints.gridx = 8;
            perfil = new HeaderButton(Color.YELLOW, MainFrame.PERFIL, "PERFIL", 22, mainFrame);
            this.add(perfil, constraints);
        }

        this.setSize(1024, 100);
        this.setBackground(Color.white);
        this.repaint();
        this.revalidate();
        this.setVisible(true);

    }
}
