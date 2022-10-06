package View;

import Dao.DoacaoDao;
import Dao.UsuarioDao;
import Model.Doacao;
import Model.Usuario;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class AdminView extends JPanel {

    private JButton bntdefAdmin;
    private JButton btnAddBLog;
    private JButton btnAddNoticia;
    private JButton btnAdministraor;
    private JButton btnAlterar;
    private JButton btnApagar;
    private JButton btnCalculaDoacoes;
    private JButton btnSair;
    private JButton btnVerificar;
    private JComboBox<String> cbAno;
    private JComboBox<String> cbMes;
    private JScrollPane jScrollPane1;
    private JScrollPane jScrollPane2;
    private JLabel lbCalculoDoacao;
    private JList<Doacao> lstDoacoes;
    private JList<Usuario> lstUsuarios;
    private MainFrame mainFrame;
    private String[] meses = new String[] { "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro" };
    private String[] anos = new String[] { "2020", "2021", "2022" };
    private Float valorCalculado;
    private Doacao doacaoSelecionada;
    private AbstractListModel lstDoacoesModel;
    private Usuario usuarioSelecionado;
    private AbstractListModel lstUsuariosModel;


    public AdminView(MainFrame mainFrame) {

        this.mainFrame = mainFrame;
        this.setSize(1024, 600);
        this.setBackground(Color.white);
        JLabel lbTituloPerfil = new JLabel();
        btnAdministraor = new JButton();
        JLabel lbTituloAdmin = new JLabel();
        jScrollPane1 = new JScrollPane();
        lstUsuarios = new JList<Usuario>();
        JLabel lbUsuarios = new JLabel();
        JLabel lbDoacoes = new JLabel();
        jScrollPane2 = new JScrollPane();
        lstDoacoes = new JList<Doacao>();
        btnAlterar = new JButton();
        btnApagar = new JButton();
        JLabel lbMes = new JLabel();
        cbMes = new JComboBox<>();
        JLabel lbAno4 = new JLabel();
        cbAno = new JComboBox<>();
        lbCalculoDoacao = new JLabel();
        JLabel lbTotalDoacoes = new JLabel();
        btnCalculaDoacoes = new JButton();
        bntdefAdmin = new JButton();
        btnAddNoticia = new JButton();
        btnSair = new JButton();
        btnAddBLog = new JButton();
        btnVerificar = new JButton();

        setPreferredSize(new java.awt.Dimension(1024, 600));

        lbTituloAdmin.setFont(new java.awt.Font("Calibri", Font.BOLD, 36)); // NOI18N
        lbTituloAdmin.setText("Administrador");

        lstUsuariosModel = new AbstractListModel<>() {
            final List<Usuario> usuarios = UsuarioDao.mostrarTodosUsuarios();

            public int getSize() {
                return usuarios.size();
            }

            public Usuario getElementAt(int i) {
                return usuarios.get(i);
            }
        };
        lstUsuarios.setModel(lstUsuariosModel);
        lstUsuarios.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstUsuarios.addListSelectionListener(evt -> lsSelecionarUsuariosAction(evt));
        jScrollPane1.setViewportView(lstUsuarios);

        lbUsuarios.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbUsuarios.setText("Usuários");

        lbDoacoes.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbDoacoes.setText("Doações");

        lstDoacoesModel = new AbstractListModel<>() {
            final List<Doacao> doacoes = DoacaoDao.mostrarTodasDoacoes();

            public int getSize() {
                return doacoes.size();
            }

            public Doacao getElementAt(int i) {
                return doacoes.get(i);
            }
        };
        lstDoacoes.setModel(lstDoacoesModel);
        lstDoacoes.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        lstDoacoes.addListSelectionListener(evt -> lsSelecionarDoacaoAction(evt));
        jScrollPane2.setViewportView(lstDoacoes);

        btnAlterar.setText("Alterar");
        btnAlterar.addActionListener(evt -> btnAlterarAction(evt));

        btnApagar.setText("Apagar");
        btnApagar.addActionListener(evt -> btnDeletarAction(evt));

        lbMes.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbMes.setHorizontalAlignment(SwingConstants.CENTER);
        lbMes.setText("Mês");

        cbMes.setModel(new DefaultComboBoxModel<>(meses));

        lbAno4.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbAno4.setHorizontalAlignment(SwingConstants.CENTER);
        lbAno4.setText("Ano");

        cbAno.setModel(new DefaultComboBoxModel<>(anos));

        lbCalculoDoacao.setFont(new java.awt.Font("Leelawadee UI", Font.BOLD, 12)); // NOI18N
        lbCalculoDoacao.setHorizontalAlignment(SwingConstants.CENTER);
        lbCalculoDoacao.setText("");

        lbTotalDoacoes.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbTotalDoacoes.setText("Vericar Total de Doações por Mês");

        btnCalculaDoacoes.setText("Verificar");
        btnCalculaDoacoes.addActionListener(evt -> btnCalculaAction(evt));

        bntdefAdmin.setText("Definir como Administrador");
        bntdefAdmin.addActionListener(evt -> btnAdministradorAction(evt));

        btnAddNoticia.setText("Adicionar Notícia");
        btnAddNoticia.addActionListener(evt -> btnAddNoticiaAction(evt));

        btnSair.setText("Sair");
        btnSair.addActionListener(evt -> btnSairAction(evt));

        btnAddBLog.setText("Adicionar Blog");
        btnAddBLog.addActionListener(evt -> btnAddBLogAction(evt));

        btnVerificar.setText("Verificar Doador");
        btnVerificar.addActionListener(evt -> btnVerificarAction(evt));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lbTituloAdmin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(btnAddNoticia, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnAddBLog, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(bntdefAdmin, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(btnAlterar, GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(btnApagar, GroupLayout.PREFERRED_SIZE, 150, GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(btnVerificar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbUsuarios, GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                                                                        .addComponent(jScrollPane1))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbDoacoes, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jScrollPane2, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(btnCalculaDoacoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lbTotalDoacoes, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbMes, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cbMes, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbAno4, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(cbAno, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(lbCalculoDoacao, GroupLayout.PREFERRED_SIZE, 292, GroupLayout.PREFERRED_SIZE))
                                                .addGap(84, 84, 84)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbTituloAdmin)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbTotalDoacoes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbUsuarios, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lbDoacoes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(btnCalculaDoacoes, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(lbAno4, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbMes, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(cbAno, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(cbMes, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(lbCalculoDoacao, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 151, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jScrollPane2)
                                                        .addComponent(jScrollPane1))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                                        .addComponent(btnApagar)
                                                        .addComponent(btnVerificar)
                                                        .addComponent(btnAlterar))
                                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(bntdefAdmin)))
                                .addGap(85, 85, 85)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(btnSair, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddBLog, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddNoticia, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
        );
    }

    private void lsSelecionarUsuariosAction(ListSelectionEvent evt) {
        usuarioSelecionado = (Usuario) lstUsuariosModel.getElementAt(lstUsuarios.getSelectedIndex());
    }

    private void lsSelecionarDoacaoAction(ListSelectionEvent evt) {
        doacaoSelecionada = (Doacao) lstDoacoesModel.getElementAt(lstDoacoes.getSelectedIndex());
    }

    private void btnCalculaAction(ActionEvent evt) {
        String mes = String.format( "%02d",cbMes.getSelectedIndex() + 1);
        String ano = String.valueOf(cbAno.getSelectedIndex() + 2020);
        valorCalculado = DoacaoDao.somarDoacoesData(ano, mes);
        if (valorCalculado == 0){
            lbCalculoDoacao.setText("Nada foi doado " + cbMes.getSelectedItem() + " de " + cbAno.getSelectedItem());
        } else{
            DecimalFormat formatter =
                    (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.getDefault());
            String valorFormatado = formatter.format(valorCalculado);
            lbCalculoDoacao.setText("Total doado em " + cbMes.getSelectedItem() + " de " + cbAno.getSelectedItem() + " é " + valorFormatado);
        }
    }

    private void btnVerificarAction(ActionEvent evt) {
        Usuario doador = UsuarioDao.localizar(doacaoSelecionada.get_id_usuario());
        JOptionPane.showMessageDialog(null, doador, "Doador", JOptionPane.PLAIN_MESSAGE);
    }

    private void btnDeletarAction(ActionEvent evt) {
        if (usuarioSelecionado != null){
            if (!usuarioSelecionado.get_id().equals(mainFrame.getUsuario().get_id())){
                String[] opcoes = {"Confirma", "Cancela"};
                int confirma = JOptionPane.showOptionDialog(null, "Deseja remover " + usuarioSelecionado,"Confirme sua opção", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
                if (confirma == 0) {
                    UsuarioDao.remover(usuarioSelecionado.get_id());
                }
            } else{
                JOptionPane.showMessageDialog(null, "Você não pode apagar seu Usuário", "Não permitido", JOptionPane.PLAIN_MESSAGE);
            }

        }
    }

    private void btnAlterarAction(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Função ainda a ser implementada!", "Erro", JOptionPane.ERROR_MESSAGE);
    }

    private void btnAdministradorAction(ActionEvent evt) {
        if (usuarioSelecionado != null){
            if(!usuarioSelecionado.isAdmin()){
                String[] opcoes = {"Confirma", "Cancela"};
                int confirma = JOptionPane.showOptionDialog(null, "Deseja tornar " + usuarioSelecionado + " Administrador","Confirme sua opção", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
                if (confirma == 0) {
                    usuarioSelecionado.setAdmin(true);
                    UsuarioDao.alterar(usuarioSelecionado);
                }
            } else if (!usuarioSelecionado.get_id().equals(mainFrame.getUsuario().get_id())){
                String[] opcoes = {"Confirma", "Cancela"};
                int confirma = JOptionPane.showOptionDialog(null, "Deseja revogar " + usuarioSelecionado + " como Administrador","Confirme sua opção", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
                if (confirma == 0) {
                    usuarioSelecionado.setAdmin(false);
                    UsuarioDao.alterar(usuarioSelecionado);
                }
            } else{
                JOptionPane.showMessageDialog(null, "Você não pode modificar seu status de Administrador", "Não permitido", JOptionPane.PLAIN_MESSAGE);
            }

        }
    }

    private void btnAddNoticiaAction(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Função ainda a ser implementada!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    private void btnAddBLogAction(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Função ainda a ser implementada!", "Erro", JOptionPane.ERROR_MESSAGE);
    }
}
