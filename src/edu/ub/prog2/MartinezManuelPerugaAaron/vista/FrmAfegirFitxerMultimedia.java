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
import static edu.ub.prog2.MartinezManuelPerugaAaron.vista.AplicacioUB4.onlyFloatNumbers;
import static edu.ub.prog2.MartinezManuelPerugaAaron.vista.AplicacioUB4.onlyIntNumbers;
import edu.ub.prog2.utils.AplicacioException;
import java.awt.Frame;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

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
        this.getRootPane().setDefaultButton(btnAcceptar);
    }

    /**
     * Inicializa el formulario JDialog
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btngpAudioVideo = new javax.swing.ButtonGroup();
        textCami = new javax.swing.JTextField();
        etCami = new javax.swing.JLabel();
        btnAcceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnObrirFitxer = new javax.swing.JButton();
        rbtnAudio = new javax.swing.JRadioButton();
        rbtnVideo = new javax.swing.JRadioButton();
        pnlAudioImatge = new javax.swing.JPanel();
        etImatge = new javax.swing.JLabel();
        textCamiImatge = new javax.swing.JTextField();
        btnObrirImatge = new javax.swing.JButton();
        etNom = new javax.swing.JLabel();
        textNom = new javax.swing.JTextField();
        etCodec = new javax.swing.JLabel();
        etDurada = new javax.swing.JLabel();
        textCodec = new javax.swing.JTextField();
        textDurada = new javax.swing.JTextField();
        etFpsKbps = new javax.swing.JLabel();
        textFpsKbps = new javax.swing.JTextField();
        pnlVideo = new javax.swing.JPanel();
        etAlcada = new javax.swing.JLabel();
        etAmplada = new javax.swing.JLabel();
        textAlcada = new javax.swing.JTextField();
        textAmplada = new javax.swing.JTextField();

        btngpAudioVideo.add(rbtnAudio);
        btngpAudioVideo.add(rbtnVideo);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(630, 300));
        setMinimumSize(new java.awt.Dimension(630, 300));
        setName(getClass().getSimpleName());
        setPreferredSize(new java.awt.Dimension(630, 300));
        setResizable(false);

        etCami.setText("Fitxer");

        btnAcceptar.setText("Aceptar");
        btnAcceptar.setFocusPainted(false);
        btnAcceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAcceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.setFocusPainted(false);
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnObrirFitxer.setText("Obrir");
        btnObrirFitxer.setFocusPainted(false);
        btnObrirFitxer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrirFitxerActionPerformed(evt);
            }
        });

        rbtnAudio.setFont(rbtnAudio.getFont().deriveFont((rbtnAudio.getFont().getStyle() | java.awt.Font.ITALIC) | java.awt.Font.BOLD));
        rbtnAudio.setSelected(true);
        rbtnAudio.setText("Audio");
        rbtnAudio.setFocusPainted(false);
        rbtnAudio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnAudioActionPerformed(evt);
            }
        });

        rbtnVideo.setFont(rbtnVideo.getFont().deriveFont((rbtnVideo.getFont().getStyle() | java.awt.Font.ITALIC) | java.awt.Font.BOLD));
        rbtnVideo.setText("Video");
        rbtnVideo.setFocusPainted(false);
        rbtnVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtnVideoActionPerformed(evt);
            }
        });

        etImatge.setText("Imatge");

        btnObrirImatge.setText("Obrir");
        btnObrirImatge.setFocusPainted(false);
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
                .addComponent(etImatge, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textCamiImatge)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnObrirImatge)
                .addGap(12, 12, 12))
        );
        pnlAudioImatgeLayout.setVerticalGroup(
            pnlAudioImatgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlAudioImatgeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(textCamiImatge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(etImatge)
                .addComponent(btnObrirImatge))
        );

        etNom.setText("Nom");

        etCodec.setText("Codec");

        etDurada.setText("Durada");

        textDurada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textDuradaKeyTyped(evt);
            }
        });

        etFpsKbps.setText("-");

        textFpsKbps.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textFpsKbpsKeyTyped(evt);
            }
        });

        etAlcada.setText("Alçada");

        etAmplada.setText("Amplada");

        textAlcada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAlcadaKeyTyped(evt);
            }
        });

        textAmplada.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textAmpladaKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout pnlVideoLayout = new javax.swing.GroupLayout(pnlVideo);
        pnlVideo.setLayout(pnlVideoLayout);
        pnlVideoLayout.setHorizontalGroup(
            pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVideoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etAmplada)
                    .addComponent(etAlcada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(textAmplada, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                    .addComponent(textAlcada))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        pnlVideoLayout.setVerticalGroup(
            pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVideoLayout.createSequentialGroup()
                .addGroup(pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAlcada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etAlcada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlVideoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textAmplada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(etAmplada))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtnAudio)
                    .addComponent(rbtnVideo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(etCami, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textCami)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnObrirFitxer)
                        .addGap(12, 12, 12))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(etCodec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(textCodec))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(etNom)
                                .addGap(21, 21, 21)
                                .addComponent(textNom, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etDurada)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textDurada, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(etFpsKbps, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(textFpsKbps, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlVideo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(btnAcceptar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar)
                .addGap(90, 90, 90))
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(pnlAudioImatge, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textCami, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnObrirFitxer)
                            .addComponent(etCami))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(etNom)
                                    .addComponent(textNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(etCodec)
                                    .addComponent(textCodec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(textDurada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(etDurada)))
                            .addComponent(pnlVideo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(etFpsKbps)
                            .addComponent(textFpsKbps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(rbtnAudio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtnVideo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlAudioImatge, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAcceptar)
                    .addComponent(btnCancelar))
                .addGap(14, 14, 14))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAcceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAcceptarActionPerformed
        String cami = textCami.getText();
        String nom = textNom.getText();
        String codec = textCodec.getText();
        float durada = textDurada.getText().isEmpty() ? 0.0f : Float.parseFloat(textDurada.getText());

        try {
            if (rbtnAudio.isSelected()) {
                String camiImatge = textCamiImatge.getText();
                int kbps = textFpsKbps.getText().isEmpty() ? 0 : Integer.parseInt(textFpsKbps.getText());
                ctrl.afegirAudio(cami, camiImatge, nom, codec, durada, kbps);
            } else {
                float fps = textFpsKbps.getText().isEmpty() ? 0.0f : Float.parseFloat(textFpsKbps.getText());
                int amplada = textAmplada.getText().isEmpty() ? 0 : Integer.parseInt(textAmplada.getText());
                int alcada = textAlcada.getText().isEmpty() ? 0 : Integer.parseInt(textAlcada.getText());
                ctrl.afegirVideo(cami, nom, codec, durada, alcada, amplada, fps);
            }
            JOptionPane.showMessageDialog(this, "Fitxer " + nom + " afegit", "Fitxer Afegit", JOptionPane.INFORMATION_MESSAGE);
            this.dispose();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAcceptarActionPerformed

    private void btnObrirFitxerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrirFitxerActionPerformed
        this.textCami.setText(fileChooserPath());
    }//GEN-LAST:event_btnObrirFitxerActionPerformed

    private void rbtnAudioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnAudioActionPerformed
        checkCtrl(); // Cambia entre audio o video
    }//GEN-LAST:event_rbtnAudioActionPerformed

    private void rbtnVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnVideoActionPerformed
        checkCtrl(); // Cambia entre audio o video
    }//GEN-LAST:event_rbtnVideoActionPerformed

    private void btnObrirImatgeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrirImatgeActionPerformed
        this.textCamiImatge.setText(fileChooserPath());
    }//GEN-LAST:event_btnObrirImatgeActionPerformed

    private void textAlcadaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAlcadaKeyTyped
        onlyIntNumbers(textAlcada, evt);
    }//GEN-LAST:event_textAlcadaKeyTyped

    private void textAmpladaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textAmpladaKeyTyped
        onlyIntNumbers(textAmplada, evt);
    }//GEN-LAST:event_textAmpladaKeyTyped

    private void textFpsKbpsKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFpsKbpsKeyTyped
        if (rbtnAudio.isSelected()) {
            onlyIntNumbers(textFpsKbps, evt);
        } else {
            onlyFloatNumbers(textFpsKbps, evt);
        }
    }//GEN-LAST:event_textFpsKbpsKeyTyped

    private void textDuradaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textDuradaKeyTyped
        onlyFloatNumbers(textDurada, evt);
    }//GEN-LAST:event_textDuradaKeyTyped

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
            etFpsKbps.setText("Kbs");
            pnlVideo.setVisible(false);
            pnlAudioImatge.setVisible(true);
            if (textFpsKbps.getText().contains(".")) {
                textFpsKbps.setText("");
            }
        } else {
            setTitle(TITLE + " " + TITLE_VIDEO);
            etFpsKbps.setText("Fps");
            pnlVideo.setVisible(true);
            pnlAudioImatge.setVisible(false);
        }
        textCami.requestFocus();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAcceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnObrirFitxer;
    private javax.swing.JButton btnObrirImatge;
    private javax.swing.ButtonGroup btngpAudioVideo;
    private javax.swing.JLabel etAlcada;
    private javax.swing.JLabel etAmplada;
    private javax.swing.JLabel etCami;
    private javax.swing.JLabel etCodec;
    private javax.swing.JLabel etDurada;
    private javax.swing.JLabel etFpsKbps;
    private javax.swing.JLabel etImatge;
    private javax.swing.JLabel etNom;
    private javax.swing.JPanel pnlAudioImatge;
    private javax.swing.JPanel pnlVideo;
    private javax.swing.JRadioButton rbtnAudio;
    private javax.swing.JRadioButton rbtnVideo;
    private javax.swing.JTextField textAlcada;
    private javax.swing.JTextField textAmplada;
    private javax.swing.JTextField textCami;
    private javax.swing.JTextField textCamiImatge;
    private javax.swing.JTextField textCodec;
    private javax.swing.JTextField textDurada;
    private javax.swing.JTextField textFpsKbps;
    private javax.swing.JTextField textNom;
    // End of variables declaration//GEN-END:variables
}
