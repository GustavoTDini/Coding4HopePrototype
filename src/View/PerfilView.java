package View;

import Dao.AssinaturaDao;
import Dao.Gerenciador;
import Dao.UsuarioDao;
import Model.Assinatura;
import Model.Usuario;
import com.sun.jdi.event.ExceptionEvent;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class PerfilView extends JPanel {

    private JTextField txCodigo;
    private JButton btnAddEndereco;
    private JButton btnAddTelefone;
    private JButton btnAdministraor;
    private JButton btnAtualizar;
    private JButton btnSenha;
    private JButton btnSair;
    private JTextField txEmail;
    private JTextField txUrl;
    private JFormattedTextField txDtNasc;
    private JLabel lbCodigo;
    private JLabel lbDoador;
    private JLabel lbDtNasc;
    private JLabel lbNome;
    private JPanel pnlEndereco;
    private JPanel pnlTelefone;
    private JTextField txLogin;
    private JTextField txNome;
    private JLabel lbAssinatura;
    private MainFrame mainFrame;
    private Usuario usuario;
    private String tipo;
    private Assinatura assinatura = null;

    public PerfilView(MainFrame mainFrame) throws IOException {
        this.mainFrame = mainFrame;
        this.usuario = mainFrame.getUsuario();
        this.setSize(1024, 600);
        this.setBackground(Color.white);
        setPreferredSize(new java.awt.Dimension(1024, 600));
        if (this.usuario.getCnpj() == null) {
            this.tipo = CadastroView.PF;
        } else {
            this.tipo = CadastroView.PJ;
        }
        assinatura = AssinaturaDao.verificaAssinatura(mainFrame.getUsuario().get_id());


        JLabel lbTituloPerfil = new JLabel();
        lbNome = new JLabel();
        JLabel lbLogin = new JLabel();
        lbCodigo = new JLabel();
        JLabel lbTel = new JLabel();
        JLabel lbEmail = new JLabel();
        JLabel lbUrl = new JLabel();
        lbDtNasc = new JLabel();
        JLabel lbendereco = new JLabel();
        btnAddEndereco = new JButton();
        btnAdministraor = new JButton();
        btnAtualizar = new JButton();
        btnSenha = new JButton();
        lbDoador = new JLabel();
        txLogin = new JTextField();
        btnAddTelefone = new JButton();
        btnSair = new JButton();
        txCodigo = new JTextField();
        txNome = new JTextField();
        txEmail = new JTextField();
        txUrl = new JTextField();
        txDtNasc = new JFormattedTextField();
        pnlEndereco = new JPanel();
        pnlTelefone = new JPanel();
        lbAssinatura = new JLabel();

        lbTituloPerfil.setFont(new java.awt.Font("Calibri", Font.BOLD, 36));
        lbTituloPerfil.setText("Perfil");

        lbNome.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18));
        if (this.tipo.equals(CadastroView.PJ)) {
            lbNome.setText("Razão Social:");
            txNome.setText(usuario.getNomeEmpresa());
        } else {
            lbNome.setText("Nome:");
            txNome.setText(usuario.getNome());
        }
        if (assinatura != null){
            lbAssinatura.setFont(new java.awt.Font("Leelawadee UI", Font.BOLD, 14));
            String assinaturaTexto = "Assinatura Ativa! Dia: " + assinatura.getDiaDoacao() + " no Valor de " + assinatura.getValorDoacao();
            lbAssinatura.setText(assinaturaTexto);
        }


        lbLogin.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18));
        lbLogin.setText("Login");
        txLogin.setText(usuario.getLogin());

        lbCodigo.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18));
        if (this.tipo.equals(CadastroView.PJ)) {
            lbCodigo.setText("CNPJ:");
            txCodigo.setText(usuario.getCnpj());
        } else {
            lbCodigo.setText("CPF:");
            txCodigo.setText(usuario.getCpf());
        }

        lbTel.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18));
        lbTel.setText("Telefones:");

        lbEmail.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18));
        lbEmail.setText("E-mail:");
        txEmail.setText(usuario.getEmail());

        lbUrl.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18));
        lbUrl.setText("URL:");
        txUrl.setText(usuario.getUrl());

        lbDtNasc.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18));
        lbDtNasc.setText("Data de Nascimento:");
        if (this.tipo.equals(CadastroView.PJ)) {
            lbDtNasc.setVisible(false);
            txDtNasc.setVisible(false);
        } else{
            if (usuario.getDataNascimento() != null){
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                txDtNasc.setText(usuario.getDataNascimento().format(formatter));
            }
            txDtNasc.setToolTipText("Coloque no formato DD/MM/AAAA");
        }

        lbendereco.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18));
        lbendereco.setText("Endereços:");

        btnAddEndereco.setText("Adicionar Endereço");
        btnAddEndereco.setMaximumSize(new java.awt.Dimension(139, 24));
        btnAddEndereco.setMinimumSize(new java.awt.Dimension(139, 24));
        btnAddEndereco.addActionListener(evt -> btnAddEnderecoAction(evt));

        btnAdministraor.setText("Administrador");
        btnAdministraor.addActionListener(evt -> btnAdministraorAction(evt));
        if(!this.usuario.isAdmin()){
            btnAdministraor.setVisible(false);
        }

        btnAtualizar.setText("Atualizar Dados");
        btnAtualizar.addActionListener(evt -> btnAtualizarAction(evt));

        btnSenha.setText("Alterar Senha");
        btnSenha.addActionListener(evt -> btnSenhaAction(evt));

        btnSair.setText("Sair");
        btnSair.addActionListener(evt -> btnSairAction(evt));

        if (usuario.isDoador()){
            BufferedImage logoPicture = ImageIO.read(new File("res/certificado.png"));
            Image certificadoIcon = logoPicture.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
            lbDoador.setFont(new java.awt.Font("Leelawadee UI", Font.BOLD, 18));
            lbDoador.setText("Doador Yeah!");
            lbDoador.setIcon(new ImageIcon(certificadoIcon));
        }


        btnAddTelefone.setText("Adicionar Telefone");
        btnAddTelefone.setPreferredSize(new java.awt.Dimension(144, 24));
        btnAddTelefone.addActionListener(evt -> btnAddTelefoneAction(evt));

        GroupLayout pnlEnderecoLayout = new GroupLayout(pnlEndereco);
        pnlEndereco.setLayout(pnlEnderecoLayout);
        pnlEnderecoLayout.setHorizontalGroup(
                pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlEnderecoLayout.setVerticalGroup(
                pnlEnderecoLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 112, Short.MAX_VALUE)
        );

        GroupLayout pnlTelefoneLayout = new GroupLayout(pnlTelefone);
        pnlTelefone.setLayout(pnlTelefoneLayout);
        pnlTelefoneLayout.setHorizontalGroup(
                pnlTelefoneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlTelefoneLayout.setVerticalGroup(
                pnlTelefoneLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(lbTituloPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbAssinatura, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(pnlTelefone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pnlEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(txLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lbTel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnAddTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(lbendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnAddEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(lbEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lbUrl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lbDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(txUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAdministraor, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(60, 60, 60)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbAssinatura, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbTituloPerfil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbDoador, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txDtNasc, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnAddEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbendereco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(14, 14, 14)
                                                .addComponent(lbTel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pnlTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnAdministraor, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }

    private void btnAddEnderecoAction(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnAdministraorAction(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnAtualizarAction(ActionEvent evt) {
        usuario.setLogin(txLogin.getText());
        usuario.setEmail(txEmail.getText());
        if (tipo.equals(CadastroView.PJ)){
            usuario.setNomeEmpresa(txNome.getText());
            usuario.setCnpj(txCodigo.getText());
        } else if (tipo.equals(CadastroView.PF)) {
            usuario.setNome(txNome.getText());
            usuario.setCpf(txCodigo.getText());
        }
        usuario.setUrl(txUrl.getText());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {
            LocalDate dtFormatada = LocalDate.parse(txDtNasc.getText(), formatter);
            usuario.setDataNascimento(dtFormatada);
        } catch(Throwable e) {
            e.printStackTrace();
            usuario.setDataNascimento(null);
        }
        UsuarioDao.alterar(usuario);
        JOptionPane.showMessageDialog(null, "Dados Alterados!", "Alteração", JOptionPane.PLAIN_MESSAGE);
    }

    private void btnAddTelefoneAction(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnSenhaAction(ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnSairAction(ActionEvent evt) {
        String[] opcoes = {"Sair", "Retornar"};
        int confirma = JOptionPane.showOptionDialog(null, "Deseja Sair!","Confirme sua opção", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
        if (confirma == 0) {
            mainFrame.setUsuario(null);
            mainFrame.setPaginaAtual(MainFrame.HOME);
            try {
                mainFrame.mainShow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }


}
