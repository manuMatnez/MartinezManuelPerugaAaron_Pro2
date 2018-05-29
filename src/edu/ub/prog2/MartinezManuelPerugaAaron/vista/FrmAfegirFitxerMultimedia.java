/*
 * Copyright (C) 2018 Manuel Martinez, Aaron Peruga, Universitat de Barcelona
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package edu.ub.prog2.MartinezManuelPerugaAaron.vista;

import edu.ub.prog2.MartinezManuelPerugaAaron.controlador.Controlador;
import edu.ub.prog2.utils.AplicacioException;
import java.awt.Frame;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * FrmAfegirFitxerMultimedia - Vista
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public class FrmAfegirFitxerMultimedia extends JDialog {

    private final Controlador ctrl;
    private final static String TITLE = "Afegir Fitxer de";
    private final static String TITLE_AUDIO = "Audio";
    private final static String TITLE_VIDEO = "Video";

    /**
     * FrmAfegirFitxerMultimedia
     *
     * @param parent
     * @param modal
     */
    public FrmAfegirFitxerMultimedia(Frame parent, boolean modal) {
        super(parent, modal);
        this.ctrl = Controlador.getInstance();
        initComponents();
        checkCtrl(); // Cambia entre audio o video
    }

    /**
     * Inicializa el formulario JDialog
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngpAudioVideo = new javax.swing.ButtonGroup();
        tfCami = new javax.swing.JTextField();
        lblCami = new javax.swing.JLabel();
        btnAcceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnObrirFitxer = new javax.swing.JButton();
        rbtnAudio = new javax.swing.JRadioButton();
        rbtnVideo = new javax.swing.JRadioButton();
        pnlAudioImatge = new javax.swing.JPanel();
        lblImatge = new javax.swing.JLabel();
        tfCamiImatge = new javax.swing.JTextField();
        btnObrirImatge = new javax.swing.JButton();
        lblNom = new javax.swing.JLabel();
        tfNom = new javax.swing.JTextField();
        lblCodec = new javax.swing.JLabel();
        lblDurada = new javax.swing.JLabel();
        tfCodec = new javax.swing.JTextField();
        tfDurada = new javax.swing.JTextField();
        lblFpsKbps = new javax.swing.JLabel();
        tfFpsKbps = new javax.swing.JTextField();
        pnlVideo = new javax.swing.JPanel();
        lblAlcada = new javax.swing.JLabel();
        lblAmplada = new javax.swing.JLabel();
        tfAlcada = new javax.swing.JTextField();
        tfAmplada = new javax.swing.JTextField();
        ImageIcon logoUB = new ImageIcon(getClass().getClassLoader().getResource("assets/logo_ub.png"));
        lblLogoUB = new javax.swing.JLabel(logoUB);

        btngpAudioVideo.add(rbtnAudio);
        btngpAudioVideo.add(rbtnVideo);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setName(getClass().getSimpleName());
        setResizable(false);

        lblCami.setText("Fitxer");

        btnAcceptar.setText("Aceptar");
        btnAcceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnObrirFitxer.setText("Obrir");
        btnObrirFitxer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrirFitxerActionPerformed(evt);
            }
        });

        rbtnAudio.setSelected(true);
        rbtnAudio.setText("Audio");
        rbtnAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAudioActionPerformed(evt);
            }
        });

        rbtnVideo.setText("Video");
        rbtnVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVideoActionPerformed(evt);
            }
        });

        lblImatge.setText("Imatge");

        btnObrirImatge.setText("Obrir");
        btnObrirImatge.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrirImatgeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlAudioImatgeLayout = new javax.swing.GroupLayout(pnlAudioImatge);
        pnlAudioImatge.setLayout(pnlAudioImatgeLayout);
        pnlAudioImatgeLayout.setHorizontalGroup(
            pnlAudioImatgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAudioImatgeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblImatge, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCamiImatge, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnObrirImatge)
                .addGap(12, 12, 12))
        );
        pnlAudioImatgeLayout.setVerticalGroup(
            pnlAudioImatgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAudioImatgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(tfCamiImatge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(lblImatge)
                .addComponent(btnObrirImatge))
        );

        lblNom.setText("Nom");

        lblCodec.setText("Codec");

        lblDurada.setText("Durada");

        tfDurada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDuradaKeyTyped(evt);
            }
        });

        lblFpsKbps.setText("-");

        tfFpsKbps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfFpsKbpsKeyTyped(evt);
            }
        });

        lblAlcada.setText("Alçada");

        lblAmplada.setText("Amplada");

        tfAlcada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAlcadaKeyTyped(evt);
            }
        });

        tfAmplada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfAmpladaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlVideoLayout = new javax.swing.GroupLayout(pnlVideo);
        pnlVideo.setLayout(pnlVideoLayout);
        pnlVideoLayout.setHorizontalGroup(
            pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVideoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblAmplada)
                    .addComponent(lblAlcada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(tfAlcada)
                    .addComponent(tfAmplada, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)))
        );
        pnlVideoLayout.setVerticalGroup(
            pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVideoLayout.createSequentialGroup()
                .addGroup(pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAlcada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAlcada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfAmplada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblAmplada))
                .addGap(15, 15, 15))
        );

        lblLogoUB.setText("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblLogoUB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbtnAudio)
                    .addComponent(rbtnVideo))
                .addGap(41, 41, 41)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCami, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCami))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblCodec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(tfCodec))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(lblNom)
                                .addGap(21, 21, 21)
                                .addComponent(tfNom, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDurada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tfDurada, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblFpsKbps, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(tfFpsKbps, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnObrirFitxer))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(pnlAudioImatge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnAcceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLogoUB, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rbtnAudio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnVideo))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tfCami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnObrirFitxer)
                            .addComponent(lblCami))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pnlVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNom)
                                    .addComponent(tfNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblCodec)
                                    .addComponent(tfCodec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(tfDurada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblDurada))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblFpsKbps)
                                    .addComponent(tfFpsKbps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnlAudioImatge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcceptar)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        lblLogoUB.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAcceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptarActionPerformed
        String cami = tfCami.getText();
        String nom = tfNom.getText();
        String codec = tfCodec.getText();
        float durada = tfDurada.getText().isEmpty() ? 0.0f : Float.parseFloat(tfDurada.getText());

        JOptionPane optionPane = new JOptionPane("Fitxer " + nom + " Afegit", JOptionPane.PLAIN_MESSAGE);
        JDialog dialog = optionPane.createDialog("Fitxer Afegit!");
        try {
            if (rbtnAudio.isSelected()) {
                String camiImatge = tfCamiImatge.getText();
                int kbps = tfFpsKbps.getText().isEmpty() ? 0 : Integer.parseInt(tfFpsKbps.getText());
                ctrl.afegirAudio(cami, camiImatge, nom, codec, durada, kbps);
                this.dispose();
            } else {
                float fps = tfFpsKbps.getText().isEmpty() ? 0.0f : Float.parseFloat(tfFpsKbps.getText());
                int amplada = tfAmplada.getText().isEmpty() ? 0 : Integer.parseInt(tfAmplada.getText());
                int alcada = tfAlcada.getText().isEmpty() ? 0 : Integer.parseInt(tfAlcada.getText());
                ctrl.afegirVideo(cami, nom, codec, durada, alcada, amplada, fps);
                this.dispose();
            }
        } catch (AplicacioException ex) {
            // TODO JDialog
            optionPane = new JOptionPane(ex.getMessage(), JOptionPane.ERROR_MESSAGE);
            dialog = optionPane.createDialog("Error!");
        } finally {
            dialog.setAlwaysOnTop(true);
            dialog.setBounds(0, 23, dialog.getWidth(), dialog.getHeight());
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_btnAcceptarActionPerformed

    private void btnObrirFitxerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrirFitxerActionPerformed
        this.tfCami.setText(fileChooserPath());
    }//GEN-LAST:event_btnObrirFitxerActionPerformed

    private void rbtnAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAudioActionPerformed
        checkCtrl(); // Cambia entre audio o video
    }//GEN-LAST:event_rbtnAudioActionPerformed

    private void rbtnVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVideoActionPerformed
        checkCtrl(); // Cambia entre audio o video
    }//GEN-LAST:event_rbtnVideoActionPerformed

    private void btnObrirImatgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrirImatgeActionPerformed
        this.tfCamiImatge.setText(fileChooserPath());
    }//GEN-LAST:event_btnObrirImatgeActionPerformed

    private void tfAlcadaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAlcadaKeyTyped
        onlyIntNumbers(tfAlcada, evt);
    }//GEN-LAST:event_tfAlcadaKeyTyped

    private void tfAmpladaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfAmpladaKeyTyped
        onlyIntNumbers(tfAmplada, evt);
    }//GEN-LAST:event_tfAmpladaKeyTyped

    private void tfFpsKbpsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfFpsKbpsKeyTyped
        if (rbtnAudio.isSelected()) {
            onlyIntNumbers(tfFpsKbps, evt);
        } else {
            onlyFloatNumbers(tfFpsKbps, evt);
        }
    }//GEN-LAST:event_tfFpsKbpsKeyTyped

    private void tfDuradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDuradaKeyTyped
        onlyFloatNumbers(tfDurada, evt);
    }//GEN-LAST:event_tfDuradaKeyTyped

    /**
     * Controla el evento para que acepte solo números ints válidos el
     * JTextField
     *
     * @param tf
     * @param evt
     */
    private void onlyIntNumbers(JTextField tf, KeyEvent evt) {
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE))) {
            evt.consume();
        }
        String txt = tf.getText();
        try {
            int screen = Integer.parseInt(txt);
        } catch (NumberFormatException ne) {
            if (txt.isEmpty()) {
                txt = "0";
            }
            if (Long.parseLong(txt) > Integer.MAX_VALUE) {
                evt.consume();
            }
        }
    }

    /**
     * Controla el evento para que acepte solo números floats válidos el
     * JTextField
     *
     * @param tf
     * @param evt
     */
    private void onlyFloatNumbers(JTextField tf, KeyEvent evt) {
        char vChar = evt.getKeyChar();
        if (!(Character.isDigit(vChar) || (vChar == KeyEvent.VK_BACK_SPACE)
                || (vChar == KeyEvent.VK_DELETE) || (vChar == KeyEvent.VK_PERIOD && !tf.getText().contains(".") && !tf.getText().isEmpty()))) {
            evt.consume();
        }
        String txt = tf.getText();
        try {
            float screen = Float.parseFloat(txt);
        } catch (NumberFormatException ne) {
            if (txt.isEmpty()) {
                txt = "0.0";
            }
            if (Double.parseDouble(txt) > Float.MAX_VALUE) {
                evt.consume();
            }

        }
    }

    /**
     * Retorna el String del path absoluto del fichero seleccionado
     *
     * @return String
     */
    private String fileChooserPath() {
        String path = "";
        JFileChooser fileChooser = new JFileChooser();
        int resultat = fileChooser.showOpenDialog(this);
        if (resultat == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            path = file.getAbsolutePath();
        }
        return path;
    }

    /**
     * Activa desactiva los controles requeridos para rellenar el JDialog de
     * Audio o Video
     */
    private void checkCtrl() {
        if (rbtnAudio.isSelected()) {
            setTitle(TITLE + " " + TITLE_AUDIO);
            lblFpsKbps.setText("Kbs");
            pnlVideo.setVisible(false);
            pnlAudioImatge.setVisible(true);
            rbtnAudio.setEnabled(false);
            rbtnVideo.setEnabled(true);
        } else {
            setTitle(TITLE + " " + TITLE_VIDEO);
            lblFpsKbps.setText("Fps");
            pnlVideo.setVisible(true);
            pnlAudioImatge.setVisible(false);
            rbtnAudio.setEnabled(true);
            rbtnVideo.setEnabled(false);
        }
        tfCamiImatge.setText("");
        tfAmplada.setText("");
        tfAlcada.setText("");
        tfFpsKbps.setText("");
        pack();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnObrirFitxer;
    private javax.swing.JButton btnObrirImatge;
    private javax.swing.ButtonGroup btngpAudioVideo;
    private javax.swing.JLabel lblAlcada;
    private javax.swing.JLabel lblAmplada;
    private javax.swing.JLabel lblCami;
    private javax.swing.JLabel lblCodec;
    private javax.swing.JLabel lblDurada;
    private javax.swing.JLabel lblFpsKbps;
    private javax.swing.JLabel lblImatge;
    private javax.swing.JLabel lblLogoUB;
    private javax.swing.JLabel lblNom;
    private javax.swing.JPanel pnlAudioImatge;
    private javax.swing.JPanel pnlVideo;
    private javax.swing.JRadioButton rbtnAudio;
    private javax.swing.JRadioButton rbtnVideo;
    private javax.swing.JTextField tfAlcada;
    private javax.swing.JTextField tfAmplada;
    private javax.swing.JTextField tfCami;
    private javax.swing.JTextField tfCamiImatge;
    private javax.swing.JTextField tfCodec;
    private javax.swing.JTextField tfDurada;
    private javax.swing.JTextField tfFpsKbps;
    private javax.swing.JTextField tfNom;
    // End of variables declaration//GEN-END:variables
}
