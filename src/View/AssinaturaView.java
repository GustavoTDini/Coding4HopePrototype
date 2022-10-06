package View;

import Dao.AssinaturaDao;
import Model.Assinatura;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

public class AssinaturaView extends JPanel {

    private JButton btnAssinatura;
    private JComboBox<Integer> cbselecionaDia;
    private JLabel lbAlertaDia;
    private JLabel lbValor;
    private JSlider slValor;
    private Float valor;
    private int dia = 1;
    private MainFrame mainFrame;
    private final Integer[] dias = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31 };
    String[] opcoes = {"Confirmar", "Retornar"};



    public AssinaturaView(MainFrame mainFrame){
        this.mainFrame = mainFrame;
        JLabel lbTituloAssinar = new JLabel();
        JLabel lbDiaAssinatura = new JLabel();
        slValor = new JSlider();
        lbValor = new JLabel();
        cbselecionaDia = new JComboBox<Integer>();
        JLabel lbValorADoar1 = new JLabel();
        lbAlertaDia = new JLabel();
        btnAssinatura = new JButton();

        lbTituloAssinar.setFont(new java.awt.Font("Calibri", Font.BOLD, 36)); // NOI18N
        lbTituloAssinar.setText("Faça sua Doação");

        lbDiaAssinatura.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbDiaAssinatura.setHorizontalAlignment(SwingConstants.CENTER);
        lbDiaAssinatura.setText("Data da Doação Mensal");

        slValor.setValue(0);
        slValor.addChangeListener(evt -> slValorChanged(evt));

        lbValor.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbValor.setHorizontalAlignment(SwingConstants.CENTER);
        lbValor.setText("R$0,00");

        cbselecionaDia.setModel(new DefaultComboBoxModel<>(dias));
        cbselecionaDia.addActionListener(evt -> csSelecionaDiaEvent(evt));

        lbValorADoar1.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 18)); // NOI18N
        lbValorADoar1.setHorizontalAlignment(SwingConstants.CENTER);
        lbValorADoar1.setText("Valor a Doar");

        lbAlertaDia.setFont(new java.awt.Font("Leelawadee UI", Font.PLAIN, 12)); // NOI18N
        lbAlertaDia.setText("");

        btnAssinatura.setText("Assinar");
        btnAssinatura.addActionListener(evt -> btnAssinaturaActionPerformed(evt));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbAlertaDia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(slValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbDiaAssinatura, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(cbselecionaDia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnAssinatura, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(lbValorADoar1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(lbTituloAssinar, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE))
                                .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(lbTituloAssinar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(lbValorADoar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(slValor, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAlertaDia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbDiaAssinatura, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addComponent(cbselecionaDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAssinatura, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(318, Short.MAX_VALUE))
        );

    }

    private void csSelecionaDiaEvent(ActionEvent evt) {
        dia = dias[cbselecionaDia.getSelectedIndex()];
        if (dia >= 28){
            lbAlertaDia.setText("Caso o dia selecionado for maior que os dias de um mês, a doação será feita no último dia!");
        } else{
            lbAlertaDia.setText("");
        }

    }

    private void slValorChanged(ChangeEvent evt) {
        DecimalFormat formatter =
                (DecimalFormat) NumberFormat.getCurrencyInstance(Locale.getDefault());
        String formatado = formatter.format(slValor.getValue());
        valor = (float) slValor.getValue();
        lbValor.setText(formatado);
    }

    private void btnAssinaturaActionPerformed(java.awt.event.ActionEvent evt) {
        int confirma = JOptionPane.showOptionDialog(null, "Confirma a Assinatura!","Assinatura", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, null);
        if (confirma == 0) {
            Assinatura assinatura = new Assinatura();
            assinatura.setDataInicio(LocalDate.now());
            assinatura.setDiaDoacao(dia);
            assinatura.setValorDoacao(valor);
            AssinaturaDao.inserir(assinatura, mainFrame.getUsuario().get_id());
            mainFrame.setPaginaAtual(MainFrame.HOME);
            try {
                mainFrame.mainShow();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }







}
