package View;


import Dao.DoacaoDao;
import Dao.UsuarioDao;
import Model.Doacao;
import Model.Usuario;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class DoarView extends JPanel {

    private JButton btnAssinatura;
    private JButton btnDoar;
    private JLabel lbValor;
    private JSlider slValor;
    private Float valor;
    private MainFrame mainFrame;

    public DoarView(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setPreferredSize(new java.awt.Dimension(1024, 600));
        JLabel lbTituloDoar = new JLabel();
        slValor = new JSlider();
        lbValor = new JLabel();
        btnDoar = new JButton();
        btnAssinatura = new JButton();
        JLabel lbValorADoar = new JLabel();

        lbTituloDoar.setFont(new java.awt.Font("Calibri", Font.BOLD, 36)); // NOI18N
        lbTituloDoar.setText("Faça sua Doação");


        lbValorADoar.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbValorADoar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbValorADoar.setText("Valor a Doar");

        slValor.setValue(0);
        slValor.addChangeListener(evt -> slValorChanged(evt));

        lbValor.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbValor.setHorizontalAlignment(SwingConstants.CENTER);
        lbValor.setText("R$0,00");

        btnDoar.setText("Doar");
        btnDoar.addActionListener(evt -> btnDoarAction(evt));

        btnAssinatura.setText("Faça uma Assinatura");
        btnAssinatura.addActionListener(evt -> btnAssinaturaAction(evt));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbTituloDoar, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addComponent(slValor, javax.swing.GroupLayout.DEFAULT_SIZE, 532, Short.MAX_VALUE)
                                                        .addComponent(lbValorADoar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnDoar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(btnAssinatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(lbValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbTituloDoar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(12, 12, 12)
                                .addComponent(lbValorADoar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbValor)
                                .addGap(18, 18, 18)
                                .addComponent(btnDoar, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnAssinatura, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(215, Short.MAX_VALUE))
        );

    }

    private void btnDoarAction(ActionEvent evt) {
        JOptionPane.showMessageDialog(null, "Usuario encaminhado para Sistema de pagamento!", "Doação", JOptionPane.PLAIN_MESSAGE);
        Doacao doacao = new Doacao();
        doacao.setValorDoacao(slValor.getValue());
        doacao.setDataDoacao(LocalDate.now());
        DoacaoDao.inserir(doacao, mainFrame.getUsuario().get_id());
        // Atualiza o Usuario
        Usuario usuario = mainFrame.getUsuario();
        usuario.setDoador(true);
        UsuarioDao.alterar(usuario);
        mainFrame.setPaginaAtual(MainFrame.HOME);
        try {
            mainFrame.mainShow();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    private void btnAssinaturaAction(ActionEvent evt) {
        mainFrame.setPaginaAtual(MainFrame.ASSINATURA);
        try {
            mainFrame.mainShow();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    private void slValorChanged(ChangeEvent evt) {
        valor = (float) slValor.getValue();
        DecimalFormat formatter =
                (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.getDefault());
        String formatado = formatter.format(valor);

        lbValor.setText(formatado);
    }


}
