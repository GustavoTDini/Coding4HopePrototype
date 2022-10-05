package View;

import Dao.Criptografia;
import Dao.UsuarioDao;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.UUID;

public class Login extends JPanel {

    private final MainFrame mainFrame;

    JTextField txLogin;
    JPasswordField txSenha;

    public Login(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        this.setSize(1024, 600);
        this.setBackground(Color.white);


        JLabel lbLoginTitulo = new JLabel();
        JLabel lbLogin = new JLabel();
        txLogin = new JTextField();
        JLabel lbSenha = new JLabel();
        txSenha = new JPasswordField();
        JButton btnCadastrar = new JButton();
        JButton btnLogin = new JButton();

        setPreferredSize(new java.awt.Dimension(1024, 600));

        lbLoginTitulo.setFont(new java.awt.Font("Calibri", Font.BOLD, 36)); // NOI18N
        lbLoginTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        lbLoginTitulo.setText("LOGIN");

        lbLogin.setFont(new java.awt.Font("Calibri", Font.PLAIN, 18)); // NOI18N
        lbLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lbLogin.setText("Login");

        txLogin.setColumns(20);
        txLogin.setHorizontalAlignment(JTextField.CENTER);
        txLogin.setToolTipText("Login");

        lbSenha.setFont(new java.awt.Font("Calibri", Font.PLAIN, 18)); // NOI18N
        lbSenha.setHorizontalAlignment(SwingConstants.CENTER);
        lbSenha.setText("Senha");

        txSenha.setHorizontalAlignment(JTextField.CENTER);
        txSenha.setText("");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.setToolTipText("Ir para Cadastro ");
        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnCadastroAction(evt);
            }
        });

        btnLogin.setText("Login");
        btnCadastrar.setToolTipText("Fazer o login com nome e senha");
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLoginAction(evt);
            }
        });

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(lbLoginTitulo, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lbLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lbSenha, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addContainerGap())
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 307, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(txLogin, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(310, 310, 310))
                                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                                        .addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(txSenha, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 400, GroupLayout.PREFERRED_SIZE))
                                                                .addGap(311, 311, 311))))))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbLoginTitulo, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)
                                .addComponent(lbLogin)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbSenha)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txSenha, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCadastrar, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(188, Short.MAX_VALUE)
                        )
        );
    }

    private void btnLoginAction(ActionEvent e) {
        UUID id = UsuarioDao.localizarUsuario(txLogin.getText(), Criptografia.hashPassword(txSenha.getPassword()));
        if (id == null){
            JOptionPane.showMessageDialog(null, "Login ou Senha estão errados!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else{
            mainFrame.setUsuario(UsuarioDao.localizar(id));
            mainFrame.setPaginaAtual(MainFrame.HOME);
            try {
                mainFrame.mainShow();
            } catch (IOException ex) {
                throw new RuntimeException(String.valueOf(e));
            }
        }
    }

    private void btnCadastroAction(ActionEvent e) {
        mainFrame.setPaginaAtual(MainFrame.CADASTRO);
        try {
            mainFrame.mainShow();
        } catch (IOException ex) {
            throw new RuntimeException(String.valueOf(e));
        }
    }
}
