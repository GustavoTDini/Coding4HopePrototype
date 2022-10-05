package View;

import Dao.Criptografia;
import Dao.UsuarioDao;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;


public class Cadastro extends JPanel {

    private final MainFrame mainFrame;
    private final JTextField txLogin;
    private final JPasswordField txSenha;
    private final JTextField txNome;
    private final JTextField txEmail;
    private final JLabel lbCodigo;
    private final JTextField txCodigo;
    private final JComboBox<String> cbSelecionaTipo;
    public static final String PF = "Pessoa Física";
    public static final String PJ = "Pessoa Jurídica";
    private Usuario usuario;



    Cadastro(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        this.usuario = new Usuario();
        JLabel lbCadastroTitulo = new JLabel();
        JLabel lbLogin = new JLabel();
        txLogin = new JTextField();
        JLabel lbSenha = new JLabel();
        txSenha = new JPasswordField();
        JLabel lbNome = new JLabel();
        txNome = new JTextField();
        JLabel lbEmail = new JLabel();
        txEmail = new JTextField();
        JButton btnCadastrar = new JButton();
        lbCodigo = new javax.swing.JLabel();
        txCodigo = new javax.swing.JTextField();
        cbSelecionaTipo = new JComboBox<>();
        setPreferredSize(new java.awt.Dimension(1024, 600));

        lbCadastroTitulo.setFont(new java.awt.Font("Calibri", Font.BOLD, 36)); // NOI18N
        lbCadastroTitulo.setText("Cadastro");

        lbLogin.setText("Login");
        lbSenha.setText("Senha");
        lbNome.setText("Nome");
        lbEmail.setText("E-mail");

        btnCadastrar.setText("Cadastrar");
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    btnCadastroAction(evt);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        cbSelecionaTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pessoa Física", "Pessoa Jurídica" }));
        cbSelecionaTipo.setToolTipText("");
        cbSelecionaTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTipoAction(evt);
            }
        });

        lbCodigo.setText("CPF");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbCadastroTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbLogin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbSenha, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbNome, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(lbCodigo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbSelecionaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(0, 814, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbCadastroTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(4, 4, 4)
                                .addComponent(cbSelecionaTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(72, Short.MAX_VALUE))
        );
    }
    
    private void btnCadastroAction(ActionEvent e) throws SQLException {
        if (txEmail.getText().equals("") || txLogin.getText().equals("")|| txSenha.getPassword().length == 0|| txNome.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Voce deve preencher todos os campos!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if ((Objects.equals(cbSelecionaTipo.getSelectedItem(), PF) && !usuario.isCpf(txCodigo.getText()))){
            JOptionPane.showMessageDialog(null, "Favor inserir o CPF Corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else if ((Objects.equals(cbSelecionaTipo.getSelectedItem(), PJ) && !usuario.isCnpj(txCodigo.getText()))){
            JOptionPane.showMessageDialog(null, "Favor inserir o CNPJ Corretamente!", "Erro", JOptionPane.ERROR_MESSAGE);
        } else{
            usuario.setEmail(txEmail.getText());
            usuario.setLogin(txLogin.getText());
            usuario.setSenha(Criptografia.hashPassword(txSenha.getPassword()));
            usuario.setCpf(txCodigo.getText());
            usuario.setNome(txNome.getText());
            usuario.setCnpj(txCodigo.getText());
            usuario.setCnpj(txNome.getText());
            UsuarioDao.inserir(usuario, cbSelecionaTipo.getSelectedItem().toString());
            JOptionPane.showMessageDialog(null, "Usuario Cadastrado!", "Cadastro", JOptionPane.PLAIN_MESSAGE);
            mainFrame.setPaginaAtual(MainFrame.LOGIN);
            try {
                mainFrame.mainShow();
            } catch (IOException ex) {
                throw new RuntimeException(String.valueOf(e));
            }
        }
    }

    private void cbTipoAction(ActionEvent e) {
        Object selected = ((JComboBox<?>) e.getSource()).getSelectedItem();
        assert selected != null;
        if(selected.toString().equals(PF)){
            lbCodigo.setText("CPF");
        } else if(selected.toString().equals(PJ)){
            lbCodigo.setText("CNPJ");
        }

    }

}
