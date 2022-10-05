package View;

import javax.swing.*;
import java.awt.*;

public class Footer extends JPanel {

    public Footer() {
        JLabel jLabel1 = new JLabel();
        JLabel jLabel2 = new JLabel();
        JLabel jLabel3 = new JLabel();
        JLabel jLabel4 = new JLabel();
        JLabel jLabel5 = new JLabel();
        Font fonte =new Font("Leelawadee UI", Font.PLAIN, 14);

        setPreferredSize(new java.awt.Dimension(1024, 100));

        jLabel1.setFont(fonte); // NOI18N
        jLabel1.setText("CNPJ: 25.224.617/0001-11/");
        jLabel1.setForeground(Color.BLUE);

        jLabel2.setFont(fonte); // NOI18N
        jLabel2.setText("Email: contato@africadocoracao.org");
        jLabel2.setForeground(Color.BLUE);

        jLabel3.setFont(fonte); // NOI18N
        jLabel3.setText("Fone e Whatsapp: + 55 11 3105-7254 / 96737-8710");
        jLabel3.setForeground(Color.BLUE);

        jLabel4.setFont(fonte); // NOI18N
        jLabel4.setText("Centro - São Paulo/SP-Brasil");
        jLabel4.setForeground(Color.BLUE);

        jLabel5.setFont(fonte); // NOI18N
        jLabel5.setText("Rua Silveira Martins 115, Sala 14");
        jLabel5.setForeground(Color.BLUE);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel2)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jLabel3))
                                                .addGap(241, 241, 241)
                                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel5))))
                                .addContainerGap(184, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel5))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel4))
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(22, 22, 22))
        );
        this.setBackground(Color.lightGray);
    }
}
