package View;

import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MainFrame extends JFrame {

    public static final int HOME = 1000;
    public static final int SOBRE = 2000;
    public static final int PROJETOS = 3000;
    public static final int BLOG = 4000;
    public static final int RELATORIOS = 5000;
    public static final int LOGIN = 6000;
    public static final int PERFIL = 7000;
    public static final int DOAR = 8000;
    public static final int ERRO = 9000;
    public static final int ADMIN = 10000;
    public static final int USUARIO = 11000;
    public static final int ASSINATURA = 12000;
    public static final int CADASTRO = 13000;

    private int paginaAtual = HOME;
    private Usuario usuario = null;
    public static Dimension MAIN_DIM = new Dimension(1024, 900);
    private Header header;
    private JPanel centro;
    private Footer footer;



    public MainFrame () throws IOException {
        header = new Header(this);
        centro = null;
        footer = new Footer();
    }

    public void mainShow() throws IOException {
        this.setSize(MAIN_DIM);
        Container container = this.getContentPane();

        container.setLayout(new BorderLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.weightx = 0.5;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        if (header != null){
            container.remove(header);
            header = null;
        }
        header = new Header(this);
        header.HeaderUpdate();
        container.add(header, BorderLayout.NORTH);
        if (centro != null){
            container.remove(centro);
            centro = null;
        }
        constraints.gridy = 0;
        constraints.gridx = 3;
        switch (this.paginaAtual){
            case LOGIN -> {
                centro =  new LoginView(this);
            }
            case PERFIL -> {
                centro = new PerfilView(this);
            }
            case BLOG -> {
                centro = new BlogView(this);
            }
            case HOME -> {
                centro = new HomeView(this);
                System.out.println(usuario);
            }
            case  CADASTRO -> {
                centro = new CadastroView(this);
            }
            case  DOAR -> {
                centro = new DoarView(this);
            }
            case  ASSINATURA -> {
                centro = new AssinaturaView(this);
            }

            default -> centro = new JPanel();
        }
        container.add(centro, BorderLayout.CENTER);
        container.add(footer, BorderLayout.PAGE_END);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.repaint();
        this.revalidate();
        this.setVisible(true);
    }

    public int getPaginaAtual() {
        return paginaAtual;
    }

    public void setPaginaAtual(int paginaAtual) {
        this.paginaAtual = paginaAtual;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
