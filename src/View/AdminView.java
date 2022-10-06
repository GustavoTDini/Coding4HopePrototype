package View;

import Dao.DoacaoDao;
import Dao.UsuarioDao;
import Model.Doacao;
import Model.Usuario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.List;

public class AdminView extends JPanel {

    private javax.swing.JButton bntdefAdmin;
    private javax.swing.JButton btnAddBLog;
    private javax.swing.JButton btnAddNoticia;
    private javax.swing.JButton btnAdministraor;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnApagar;
    private javax.swing.JButton btnCalculaDoacoes;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnVerificar;
    private javax.swing.JComboBox<String> cbAno;
    private javax.swing.JComboBox<String> cbMes;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCalculoDoacao;
    private JList<Doacao> lstDoacoes;
    private JList<Usuario> lstUsuarios;
    private MainFrame mainFrame;
    private String[] meses = new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };
    private String[] anos = new String[] { "2020", "2021", "2022" };


    public AdminView(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        this.setSize(1024, 600);
        this.setBackground(Color.white);
        javax.swing.JLabel lbTituloPerfil = new javax.swing.JLabel();
        btnAdministraor = new javax.swing.JButton();
        javax.swing.JLabel lbTituloAdmin = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstUsuarios = new JList<Usuario>();
        javax.swing.JLabel lbUsuarios = new javax.swing.JLabel();
        javax.swing.JLabel lbDoacoes = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstDoacoes = new JList<Doacao>();
        btnAlterar = new javax.swing.JButton();
        btnApagar = new javax.swing.JButton();
        javax.swing.JLabel lbMes = new javax.swing.JLabel();
        cbMes = new javax.swing.JComboBox<>();
        javax.swing.JLabel lbAno4 = new javax.swing.JLabel();
        cbAno = new javax.swing.JComboBox<>();
        lbCalculoDoacao = new javax.swing.JLabel();
        javax.swing.JLabel lbTotalDoacoes = new javax.swing.JLabel();
        btnCalculaDoacoes = new javax.swing.JButton();
        bntdefAdmin = new javax.swing.JButton();
        btnAddNoticia = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnAddBLog = new javax.swing.JButton();
        btnVerificar = new JButton();

        lbTituloPerfil.setFont(new java.awt.Font("Calibri", Font.BOLD, 36)); // NOI18N
        lbTituloPerfil.setText("Perfil");

        btnAdministraor.setText("Administrador");
        btnAdministraor.addActionListener(evt -> btnAdministraorAction(evt));

        setPreferredSize(new java.awt.Dimension(1024, 600));

        lbTituloAdmin.setFont(new java.awt.Font("Calibri", Font.BOLD, 36)); // NOI18N
        lbTituloAdmin.setText("Administrador");

        lstUsuarios.setModel(new javax.swing.AbstractListModel<>() {
            final List<Usuario> usuarios = UsuarioDao.mostrarTodosUsuarios();

            public int getSize() {
                return usuarios.size();
            }

            public Usuario getElementAt(int i) {
                return usuarios.get(i);
            }
        });
        jScrollPane1.setViewportView(lstUsuarios);

        lbUsuarios.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbUsuarios.setText("Usuários");

        lbDoacoes.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbDoacoes.setText("Doações");

        lstDoacoes.setModel(new javax.swing.AbstractListModel<>() {
            final List<Doacao> doacoes = DoacaoDao.mostrarTodasDoacoes();

            public int getSize() {
                return doacoes.size();
            }

            public Doacao getElementAt(int i) {
                return doacoes.get(i);
            }
        });
        jScrollPane2.setViewportView(lstDoacoes);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(evt -> btnAlterarAction(evt));

        btnApagar.setText("Apagar");
        btnAlterar.addActionListener(evt -> btnDeletarAction(evt));

        lbMes.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbMes.setText("Mês");

        cbMes.setModel(new javax.swing.DefaultComboBoxModel<>(meses));

        lbAno4.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbAno4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbAno4.setText("Ano");

        cbAno.setModel(new javax.swing.DefaultComboBoxModel<>(anos));

        lbCalculoDoacao.setFont(new java.awt.Font("Leelawadee UI", Font.BOLD, 24)); // NOI18N
        lbCalculoDoacao.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbCalculoDoacao.setText("");

        lbTotalDoacoes.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbTotalDoacoes.setText("Vericar Total de Doações por Mês");

        btnCalculaDoacoes.setText("Verificar");

        bntdefAdmin.setText("Definir como Administrador");

        btnAddNoticia.setText("Adicionar Notícia");
        btnAddNoticia.addActionListener(evt -> btnAddNoticiaAction(evt));

        btnSair.setText("Sair");
        btnSair.addActionListener(evt -> btnSairAction(evt));

        btnAddBLog.setText("Adicionar Blog");
        btnAddBLog.addActionListener(evt -> btnAddBLogAction(evt));

        btnVerificar.setText("Verificar Doador");
        btnVerificar.addActionListener(evt -> btnVerificarActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbTituloAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnAddNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddBLog, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(bntdefAdmin, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnApagar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnVerificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                                        .addComponent(jScrollPane1))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbDoacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnCalculaDoacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lbTotalDoacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbAno4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cbAno, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(lbCalculoDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(84, 84, 84)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbTituloAdmin)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbTotalDoacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbDoacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnCalculaDoacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbAno4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbMes, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbCalculoDoacao, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 151, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2)
                                                        .addComponent(jScrollPane1))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnApagar)
                                                        .addComponent(btnVerificar)
                                                        .addComponent(btnAlterar))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bntdefAdmin)))
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSair, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddBLog, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddNoticia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    private void btnVerificarActionPerformed(ActionEvent evt) {
    }

    private void btnDeletarAction(ActionEvent evt) {
    }

    private void btnAlterarAction(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Função ainda a ser implementada!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private void btnAdministraorAction(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void btnAddNoticiaAction(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Função ainda a ser implementada!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private void btnSairAction(java.awt.event.ActionEvent evt) {
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

    private void btnAddBLogAction(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Função ainda a ser implementada!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
