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

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import edu.ub.prog2.MartinezManuelPerugaAaron.controlador.Controlador;
import edu.ub.prog2.utils.AplicacioException;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 * AplicacioUB4 - Vista
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public class AplicacioUB4 extends JFrame {

    private final Controlador ctrl;
    protected final static String TITLE = "Reproductor UB (Grup C)";
    protected final static String[] AUTORS = new String[]{"Manuel Martínez Martín", "Aarón Peruga Ortiga"};
    protected final static String VERSION = "4.0";
    protected final static String COPY = "Copyright 2018 Universitat de Barcelona";

    final static boolean MAC = System.getProperty("os.name").toLowerCase().contains("mac");

    /**
     * AplicacioUB4
     */
    public AplicacioUB4() {
        this.ctrl = Controlador.getInstance();
        initComponents();
    }

    /**
     * Inicializa el formulario JFrame
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbAlbums = new javax.swing.JComboBox<>();
        scpAlbums = new javax.swing.JScrollPane();
        lstAlbum = new javax.swing.JList<>();
        scpBiblioteca = new javax.swing.JScrollPane();
        lstBiblioteca = new javax.swing.JList<>();
        etBiblioteca = new javax.swing.JLabel();
        etAlbums = new javax.swing.JLabel();
        etAlbum = new javax.swing.JLabel();
        btnAfegirFitxerBiblioteca = new javax.swing.JButton();
        btnCrearAlbum = new javax.swing.JButton();
        btnEliminarAlbum = new javax.swing.JButton();
        btnEliminarFitxerBiblioteca = new javax.swing.JButton();
        btnAfegirFitxerAlbum = new javax.swing.JButton();
        btnEliminarFitxerAlbum = new javax.swing.JButton();
        btnAtura = new javax.swing.JButton();
        btnSalta = new javax.swing.JButton();
        btnReempren = new javax.swing.JButton();
        btnPause = new javax.swing.JButton();
        btnReproduirAlbum = new javax.swing.JButton();
        btnReproduirBiblioteca = new javax.swing.JButton();
        btnReproduirFitxerBiblioteca = new javax.swing.JButton();
        btnReproduirFitxerAlbum = new javax.swing.JButton();
        mbMenu = new javax.swing.JMenuBar();
        mMenu = new javax.swing.JMenu();
        mDades = new javax.swing.JMenu();
        miCarregar = new javax.swing.JMenuItem();
        miGuardar = new javax.swing.JMenuItem();
        miSortir = new javax.swing.JMenuItem();
        mPreferencies = new javax.swing.JMenu();
        cbmiRepAleatoria = new javax.swing.JCheckBoxMenuItem();
        cbmiRepContinua = new javax.swing.JCheckBoxMenuItem();
        mInfo = new javax.swing.JMenu();
        miSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(TITLE);
        setMinimumSize(new java.awt.Dimension(640, 480));
        setName(getClass().getSimpleName());
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        cmbAlbums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlbumsActionPerformed(evt);
            }
        });

        lstAlbum.setModel(updateAlbum());
        scpAlbums.setViewportView(lstAlbum);

        lstBiblioteca.setModel(updateBiblioteca());
        scpBiblioteca.setViewportView(lstBiblioteca);

        etBiblioteca.setFont(etBiblioteca.getFont().deriveFont(etBiblioteca.getFont().getStyle() | java.awt.Font.BOLD));
        etBiblioteca.setText("Biblioteca");

        etAlbums.setFont(etAlbums.getFont().deriveFont(etAlbums.getFont().getStyle() | java.awt.Font.BOLD));
        etAlbums.setText("Álbums");

        etAlbum.setFont(etAlbum.getFont().deriveFont(etAlbum.getFont().getStyle() | java.awt.Font.BOLD));
        etAlbum.setText("Álbum");

        btnAfegirFitxerBiblioteca.setText("Afegir Fitxer");
        btnAfegirFitxerBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirFitxerBibliotecaActionPerformed(evt);
            }
        });

        btnCrearAlbum.setText("Crear Álbum");
        btnCrearAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAlbumActionPerformed(evt);
            }
        });

        btnEliminarAlbum.setText("Eliminar Álbum");
        btnEliminarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlbumActionPerformed(evt);
            }
        });

        btnEliminarFitxerBiblioteca.setText("Eliminar Fitxers");
        btnEliminarFitxerBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFitxerBibliotecaActionPerformed(evt);
            }
        });

        btnAfegirFitxerAlbum.setText("Afegir Fitxers al Álbum");
        btnAfegirFitxerAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirFitxerAlbumActionPerformed(evt);
            }
        });

        btnEliminarFitxerAlbum.setText("Eliminar Fitxers de l'Álbum");
        btnEliminarFitxerAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFitxerAlbumActionPerformed(evt);
            }
        });

        btnAtura.setText("Atura");
        btnAtura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAturaActionPerformed(evt);
            }
        });

        btnSalta.setText("Salta");
        btnSalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaltaActionPerformed(evt);
            }
        });

        btnReempren.setText("Reempren");
        btnReempren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReemprenActionPerformed(evt);
            }
        });

        btnPause.setText("Pause");
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnReproduirAlbum.setText("Reproduir Álbum");
        btnReproduirAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproduirAlbumActionPerformed(evt);
            }
        });

        btnReproduirBiblioteca.setText("Reproduir Biblioteca");
        btnReproduirBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproduirBibliotecaActionPerformed(evt);
            }
        });

        btnReproduirFitxerBiblioteca.setText("Reproduir Fitxer");
        btnReproduirFitxerBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproduirFitxerBibliotecaActionPerformed(evt);
            }
        });

        btnReproduirFitxerAlbum.setText("Reproduir Fitxer Álbum");
        btnReproduirFitxerAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproduirFitxerAlbumActionPerformed(evt);
            }
        });

        mMenu.setText("Menú");

        mDades.setText("Dades");

        miCarregar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_MASK));
        miCarregar.setText("Carregar");
        miCarregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miCarregarActionPerformed(evt);
            }
        });
        mDades.add(miCarregar);

        miGuardar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        miGuardar.setText("Guardar");
        miGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miGuardarActionPerformed(evt);
            }
        });
        mDades.add(miGuardar);

        mMenu.add(mDades);

        miSortir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Q, java.awt.event.InputEvent.CTRL_MASK));
        miSortir.setText("Sortir");
        miSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSortirActionPerformed(evt);
            }
        });
        mMenu.add(miSortir);

        mbMenu.add(mMenu);

        mPreferencies.setText("Preferències");

        cbmiRepAleatoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        cbmiRepAleatoria.setSelected(ctrl.isReproduccioAleatoria());
        cbmiRepAleatoria.setText("Reproducció Aleatoria");
        cbmiRepAleatoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmiRepAleatoriaActionPerformed(evt);
            }
        });
        mPreferencies.add(cbmiRepAleatoria);

        cbmiRepContinua.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        cbmiRepContinua.setSelected(ctrl.isReproduccioContinua());
        cbmiRepContinua.setText("Reproducció Continua");
        cbmiRepContinua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmiRepContinuaActionPerformed(evt);
            }
        });
        mPreferencies.add(cbmiRepContinua);

        mbMenu.add(mPreferencies);

        mInfo.setText("Info");

        miSobre.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        miSobre.setText("Sobre");
        miSobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miSobreActionPerformed(evt);
            }
        });
        mInfo.add(miSobre);

        mbMenu.add(mInfo);

        setJMenuBar(mbMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(etBiblioteca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etAlbums)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(scpBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cmbAlbums, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminarAlbum)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(btnCrearAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(2, 2, 2))
                            .addComponent(btnReproduirAlbum, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(btnEliminarFitxerBiblioteca))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReproduirBiblioteca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReproduirFitxerBiblioteca))
                            .addComponent(btnAfegirFitxerBiblioteca))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReproduirFitxerAlbum)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(scpAlbums, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnAfegirFitxerAlbum, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(btnEliminarFitxerAlbum, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(etAlbum)
                        .addGap(101, 101, 101))))
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(btnReempren, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnPause, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSalta, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAtura)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etBiblioteca)
                    .addComponent(etAlbums)
                    .addComponent(etAlbum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(scpBiblioteca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAfegirFitxerBiblioteca)
                            .addComponent(btnEliminarFitxerBiblioteca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnReproduirFitxerBiblioteca)
                            .addComponent(btnReproduirBiblioteca))
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(btnAtura)
                            .addComponent(btnSalta)
                            .addComponent(btnReempren)
                            .addComponent(btnPause))
                        .addGap(15, 15, 15))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmbAlbums, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEliminarAlbum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCrearAlbum)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnReproduirAlbum)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(scpAlbums, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnAfegirFitxerAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminarFitxerAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReproduirFitxerAlbum)
                        .addGap(91, 91, 91))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCarregarActionPerformed
        File file;
        String cami;
        JFileChooser fileChooser = new JFileChooser();
        int resultat = fileChooser.showOpenDialog(this);
        if (resultat == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            cami = file.getPath();
            try {
                ctrl.carregarDadesDisc(cami);
                refreshAll();
                JOptionPane.showMessageDialog(this, "Dades carregades correctament", "Dades carregades", JOptionPane.INFORMATION_MESSAGE);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_miCarregarActionPerformed

    private void miGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGuardarActionPerformed
        File file;
        String cami;
        JFileChooser fileChooser = new JFileChooser();
        int resultat = fileChooser.showSaveDialog(this);
        if (resultat == JFileChooser.APPROVE_OPTION) {
            file = fileChooser.getSelectedFile();
            cami = file.getPath();
            try {
                ctrl.guardarDadesDisc(cami);
                fileChooser.setVisible(false);
                JOptionPane.showMessageDialog(this, "Dades guardades correctament", "Dades guardades", JOptionPane.INFORMATION_MESSAGE);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_miGuardarActionPerformed

    private void miSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSobreActionPerformed
        FrmSobre form = new FrmSobre(this, true);
        form.setVisible(true);
    }//GEN-LAST:event_miSobreActionPerformed

    private void cmbAlbumsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlbumsActionPerformed
        lstAlbum.setModel(updateAlbum());
    }//GEN-LAST:event_cmbAlbumsActionPerformed

    private void btnAfegirFitxerBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirFitxerBibliotecaActionPerformed
        FrmAfegirFitxerMultimedia form = new FrmAfegirFitxerMultimedia(this, true);
        form.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent ev) {
                lstBiblioteca.setModel(updateBiblioteca());
            }
        });
        form.setVisible(true);
    }//GEN-LAST:event_btnAfegirFitxerBibliotecaActionPerformed

    private void btnEliminarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlbumActionPerformed
        int index = this.cmbAlbums.getSelectedIndex();

        try {
            String titol = ctrl.getTitolAlbum(index);
            ctrl.esborrarAlbum(titol);
            this.cmbAlbums.setModel(updateAlbums());
            this.lstAlbum.setModel(updateAlbum());
            JOptionPane.showMessageDialog(this, "Álbum " + titol + " esborrat correctament", "Álbum esborray", JOptionPane.INFORMATION_MESSAGE);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarAlbumActionPerformed

    private void btnCrearAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAlbumActionPerformed
        String titol = JOptionPane.showInputDialog(this, "Introdueix el nom d l'álbum", "Crear Álbum - Nom", JOptionPane.QUESTION_MESSAGE);
        if (titol != null) {
            int capacitat;
            try {
                capacitat = Integer.parseInt(JOptionPane.showInputDialog(this, "Introdueix la capacitat de l'álbum", "Crear Álbum - Capacitat", JOptionPane.QUESTION_MESSAGE));
            } catch (HeadlessException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Capacitat no valida, assignada 10 per defecte", "Error amb Capacitat", JOptionPane.ERROR_MESSAGE);
                capacitat = 10;
            }

            try {
                ctrl.afegirAlbum(titol, capacitat);
                this.cmbAlbums.setModel(updateAlbums());
                JOptionPane.showMessageDialog(this, "Álbum " + titol + " creat correctament", "Álbum creat", JOptionPane.INFORMATION_MESSAGE);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnCrearAlbumActionPerformed

    private void miSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSortirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSortirActionPerformed

    private void cbmiRepContinuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmiRepContinuaActionPerformed
        ctrl.activarDesactivarContinua();
    }//GEN-LAST:event_cbmiRepContinuaActionPerformed

    private void cbmiRepAleatoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmiRepAleatoriaActionPerformed
        ctrl.activarDesactivarAleatoria();
    }//GEN-LAST:event_cbmiRepAleatoriaActionPerformed

    private void btnEliminarFitxerBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFitxerBibliotecaActionPerformed
        int[] indices = this.lstBiblioteca.getSelectedIndices();

        if (indices.length > 0) {
            try {
                int eliminados = 0;
                for (int i : indices) {
                    ctrl.esborrarFitxer(i - eliminados);
                    eliminados++;
                }
                this.lstBiblioteca.setModel(updateBiblioteca());
                this.lstAlbum.setModel(updateAlbum());
                this.cmbAlbums.setModel(updateAlbums());
                JOptionPane.showMessageDialog(this, "Fitxer/s esborrat/s", "Fitxer Esborrat/s", JOptionPane.INFORMATION_MESSAGE);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un o varis fitxers abans", "Avis", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarFitxerBibliotecaActionPerformed

    private void btnAfegirFitxerAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirFitxerAlbumActionPerformed
        int[] indices = this.lstBiblioteca.getSelectedIndices();
        int indexAlbum = this.cmbAlbums.getSelectedIndex();

        if (indices.length > 0) {
            try {
                String titol = ctrl.getTitolAlbum(indexAlbum);
                for (int i : indices) {
                    ctrl.afegirFitxer(titol, i);
                }
                this.lstAlbum.setModel(updateAlbum());
                this.cmbAlbums.setModel(updateAlbums());
                JOptionPane.showMessageDialog(this, "Fitxer/s afegit/s al álbum", "Fitxer Afegit/s al Álbum", JOptionPane.INFORMATION_MESSAGE);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un o varis fitxers abans", "Avis", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAfegirFitxerAlbumActionPerformed

    private void btnReproduirBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproduirBibliotecaActionPerformed
        try {
            ctrl.reproduirCarpeta();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReproduirBibliotecaActionPerformed

    private void btnReproduirFitxerBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproduirFitxerBibliotecaActionPerformed
        int index = this.lstBiblioteca.getSelectedIndex();
        try {
            ctrl.reproduirFitxer(index);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReproduirFitxerBibliotecaActionPerformed

    private void btnReproduirAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproduirAlbumActionPerformed
        int indexAlbum = this.cmbAlbums.getSelectedIndex();

        try {
            String titol = ctrl.getTitolAlbum(indexAlbum);
            ctrl.reproduirCarpeta(titol);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReproduirAlbumActionPerformed

    private void btnReproduirFitxerAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproduirFitxerAlbumActionPerformed
        int index = this.lstAlbum.getSelectedIndex();
        int indexAlbum = this.cmbAlbums.getSelectedIndex();

        try {
            String titol = ctrl.getTitolAlbum(indexAlbum);
            ctrl.reproduirFitxer(index, titol);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReproduirFitxerAlbumActionPerformed

    private void btnReemprenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReemprenActionPerformed
        try {
            ctrl.reemprenReproduccio();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnReemprenActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        try {
            ctrl.pausaReproduccio();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnAturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAturaActionPerformed
        try {
            ctrl.aturaReproduccio();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAturaActionPerformed

    private void btnSaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaltaActionPerformed
        try {
            ctrl.saltaReproduccio();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSaltaActionPerformed

    private void btnEliminarFitxerAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarFitxerAlbumActionPerformed
        int[] indices = this.lstAlbum.getSelectedIndices();
        int indexAlbum = this.cmbAlbums.getSelectedIndex();

        if (indices.length > 0) {
            try {
                int eliminados = 0;
                String titol = ctrl.getTitolAlbum(indexAlbum);
                for (int i : indices) {
                    ctrl.esborrarFitxer(titol, i - eliminados);
                    eliminados++;
                }
                this.lstAlbum.setModel(updateAlbum());
                this.cmbAlbums.setModel(updateAlbums());
                JOptionPane.showMessageDialog(this, "Fitxer/s esborrat/s del álbum", "Fitxer Esborrat/s del Álbum", JOptionPane.INFORMATION_MESSAGE);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un o varis fitxers abans", "Avis", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarFitxerAlbumActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        lstBiblioteca.clearSelection();
        lstAlbum.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    /**
     * Retorna una Lista Modelo de la biblioteca para asociarsela a un JList
     *
     * @return ListModel<String>
     */
    private ListModel<String> updateBiblioteca() {
        List<String> bibList = ctrl.mostrarBiblioteca();
        ListModel<String> model = new javax.swing.AbstractListModel<String>() {
            String[] strings = bibList.toArray(new String[bibList.size()]);

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        };
        return model;
    }

    /**
     * Retorna una Lista Modelo del álbum seleccionado para asociarsela a un
     * JList
     *
     * @return ListModel<String>
     */
    private ListModel<String> updateAlbum() {
        ListModel<String> model, emptyModel;
        int index = this.cmbAlbums.getSelectedIndex();
        emptyModel = new javax.swing.AbstractListModel<String>() {
            String[] strings = new String[0];

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        };
        if (index < 0) {
            return emptyModel;
        } else {
            try {
                String titol = ctrl.getTitolAlbum(index);
                List<String> albumList = ctrl.mostrarAlbum(titol);
                model = new javax.swing.AbstractListModel<String>() {
                    String[] strings = albumList.toArray(new String[albumList.size()]);

                    @Override
                    public int getSize() {
                        return strings.length;
                    }

                    @Override
                    public String getElementAt(int i) {
                        return strings[i];
                    }
                };
                return model;
            } catch (AplicacioException ex) {
                return emptyModel;
            }
        }
    }

    /**
     * Retorna una Lista Modelo de la albums para asociarsela a un JComboBox
     *
     * @return DefaultComboBoxModel<String>
     */
    private DefaultComboBoxModel<String> updateAlbums() {
        List<String> albumsList = ctrl.mostrarLlistatAlbums();
        String[] strings = albumsList.toArray(new String[albumsList.size()]);
        return new DefaultComboBoxModel<>(strings);
    }

    /**
     * Controla el evento para que acepte solo números ints válidos el
     * JTextField
     *
     * @param tf
     * @param evt
     */
    public static void onlyIntNumbers(JTextField tf, KeyEvent evt) {
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
    public static void onlyFloatNumbers(JTextField tf, KeyEvent evt) {
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
     * Refresca la vista entera
     */
    private void refreshAll() {
        this.lstBiblioteca.setModel(updateBiblioteca());
        this.cmbAlbums.setModel(updateAlbums());
        this.lstAlbum.setModel(updateAlbum());
        this.cbmiRepContinua.setSelected(ctrl.isReproduccioContinua());
        this.cbmiRepAleatoria.setSelected(ctrl.isReproduccioAleatoria());
    }

    /**
     * Main
     *
     * @param args[]
     */
    public static void main(String args[]) {

        // VLC 2.2 para Mac
        if (MAC) {
            uk.co.caprica.vlcj.binding.LibC.INSTANCE.setenv("VLC_PLUGIN_PATH",
                    "/Applications/VLC.app/Contents/MacOS/plugins", 1);

            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),
                    "/Applications/VLC.app/Contents/MacOS/lib");

            Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        }

        EventQueue.invokeLater(() -> {
            AplicacioUB4 app = new AplicacioUB4();
            app.setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfegirFitxerAlbum;
    private javax.swing.JButton btnAfegirFitxerBiblioteca;
    private javax.swing.JButton btnAtura;
    private javax.swing.JButton btnCrearAlbum;
    private javax.swing.JButton btnEliminarAlbum;
    private javax.swing.JButton btnEliminarFitxerAlbum;
    private javax.swing.JButton btnEliminarFitxerBiblioteca;
    private javax.swing.JButton btnPause;
    private javax.swing.JButton btnReempren;
    private javax.swing.JButton btnReproduirAlbum;
    private javax.swing.JButton btnReproduirBiblioteca;
    private javax.swing.JButton btnReproduirFitxerAlbum;
    private javax.swing.JButton btnReproduirFitxerBiblioteca;
    private javax.swing.JButton btnSalta;
    private javax.swing.JCheckBoxMenuItem cbmiRepAleatoria;
    private javax.swing.JCheckBoxMenuItem cbmiRepContinua;
    private javax.swing.JComboBox<String> cmbAlbums;
    private javax.swing.JLabel etAlbum;
    private javax.swing.JLabel etAlbums;
    private javax.swing.JLabel etBiblioteca;
    private javax.swing.JList<String> lstAlbum;
    private javax.swing.JList<String> lstBiblioteca;
    private javax.swing.JMenu mDades;
    private javax.swing.JMenu mInfo;
    private javax.swing.JMenu mMenu;
    private javax.swing.JMenu mPreferencies;
    private javax.swing.JMenuBar mbMenu;
    private javax.swing.JMenuItem miCarregar;
    private javax.swing.JMenuItem miGuardar;
    private javax.swing.JMenuItem miSobre;
    private javax.swing.JMenuItem miSortir;
    private javax.swing.JScrollPane scpAlbums;
    private javax.swing.JScrollPane scpBiblioteca;
    // End of variables declaration//GEN-END:variables

}
