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
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
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

    protected final static ImageIcon ERROR_IMG = new ImageIcon(AplicacioUB4.class.getResource("/assets/error.png"));
    protected final static ImageIcon WARNING_IMG = new ImageIcon(AplicacioUB4.class.getResource("/assets/warning.png"));
    protected final static ImageIcon INFO_IMG = new ImageIcon(AplicacioUB4.class.getResource("/assets/info.png"));

    private final static boolean MAC = System.getProperty("os.name").toLowerCase().contains("mac");

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
        scpAlbum = new javax.swing.JScrollPane();
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
        setBounds(new java.awt.Rectangle(0, 23, 0, 0));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setName(getClass().getSimpleName());
        setSize(new java.awt.Dimension(0, 0));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        cmbAlbums.setModel(new DefaultComboBoxModel<>());
        cmbAlbums.setFocusable(false);
        cmbAlbums.setFont(cmbAlbums.getFont().deriveFont(cmbAlbums.getFont().getSize()-2f));
        cmbAlbums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlbumsActionPerformed(evt);
            }
        });

        lstAlbum.setModel(makeListModel(new ArrayList<>()));
        lstAlbum.setFocusable(false);
        lstAlbum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAlbumMouseClicked(evt);
            }
        });
        scpAlbum.setViewportView(lstAlbum);

        lstBiblioteca.setModel(makeListModel(new ArrayList<>()));
        lstBiblioteca.setFocusable(false);
        lstBiblioteca.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstBibliotecaMouseClicked(evt);
            }
        });
        scpBiblioteca.setViewportView(lstBiblioteca);

        etBiblioteca.setFont(etBiblioteca.getFont().deriveFont(etBiblioteca.getFont().getStyle() | java.awt.Font.BOLD));
        etBiblioteca.setText("Biblioteca");

        etAlbums.setFont(etAlbums.getFont().deriveFont(etAlbums.getFont().getStyle() | java.awt.Font.BOLD));
        etAlbums.setText("Álbums");

        etAlbum.setFont(etAlbum.getFont().deriveFont(etAlbum.getFont().getStyle() | java.awt.Font.BOLD));
        etAlbum.setText("Álbum");

        btnAfegirFitxerBiblioteca.setText("Afegir Fitxer");
        btnAfegirFitxerBiblioteca.setFocusPainted(false);
        btnAfegirFitxerBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirFitxerBibliotecaActionPerformed(evt);
            }
        });

        btnCrearAlbum.setText("Crear Álbum");
        btnCrearAlbum.setFocusPainted(false);
        btnCrearAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAlbumActionPerformed(evt);
            }
        });

        btnEliminarAlbum.setText("Eliminar Álbum");
        btnEliminarAlbum.setFocusPainted(false);
        btnEliminarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlbumActionPerformed(evt);
            }
        });

        btnEliminarFitxerBiblioteca.setText("Eliminar Fitxers");
        btnEliminarFitxerBiblioteca.setFocusPainted(false);
        btnEliminarFitxerBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFitxerBibliotecaActionPerformed(evt);
            }
        });

        btnAfegirFitxerAlbum.setText("Afegir Fitxers al Álbum");
        btnAfegirFitxerAlbum.setFocusPainted(false);
        btnAfegirFitxerAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirFitxerAlbumActionPerformed(evt);
            }
        });

        btnEliminarFitxerAlbum.setText("Eliminar Fitxers de l'Álbum");
        btnEliminarFitxerAlbum.setFocusPainted(false);
        btnEliminarFitxerAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarFitxerAlbumActionPerformed(evt);
            }
        });

        btnAtura.setText("Atura");
        btnAtura.setFocusPainted(false);
        btnAtura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAturaActionPerformed(evt);
            }
        });

        btnSalta.setText("Salta");
        btnSalta.setFocusPainted(false);
        btnSalta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaltaActionPerformed(evt);
            }
        });

        btnReempren.setText("Reempren");
        btnReempren.setFocusPainted(false);
        btnReempren.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReemprenActionPerformed(evt);
            }
        });

        btnPause.setText("Pause");
        btnPause.setFocusPainted(false);
        btnPause.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPauseActionPerformed(evt);
            }
        });

        btnReproduirAlbum.setText("Reproduir Álbum");
        btnReproduirAlbum.setFocusPainted(false);
        btnReproduirAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproduirAlbumActionPerformed(evt);
            }
        });

        btnReproduirBiblioteca.setText("Reproduir Biblioteca");
        btnReproduirBiblioteca.setFocusPainted(false);
        btnReproduirBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproduirBibliotecaActionPerformed(evt);
            }
        });

        btnReproduirFitxerBiblioteca.setText("Reproduir Fitxer");
        btnReproduirFitxerBiblioteca.setFocusPainted(false);
        btnReproduirFitxerBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReproduirFitxerBibliotecaActionPerformed(evt);
            }
        });

        btnReproduirFitxerAlbum.setText("Reproduir Fitxer Álbum");
        btnReproduirFitxerAlbum.setFocusPainted(false);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(scpBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnEliminarAlbum, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnCrearAlbum, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnReproduirAlbum, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cmbAlbums, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnReproduirBiblioteca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnReproduirFitxerBiblioteca))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnAfegirFitxerBiblioteca)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnEliminarFitxerBiblioteca)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(etBiblioteca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(etAlbums)
                        .addGap(56, 56, 56)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnReproduirFitxerAlbum)
                            .addComponent(btnAfegirFitxerAlbum)
                            .addComponent(btnEliminarFitxerAlbum)
                            .addComponent(scpAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(etAlbum)
                        .addGap(118, 118, 118))))
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
                            .addComponent(scpAlbum, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE))
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
                JOptionPane.showMessageDialog(this, "Dades carregades correctament", "Dades carregades", JOptionPane.PLAIN_MESSAGE, INFO_IMG);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
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
                JOptionPane.showMessageDialog(this, "Dades guardades correctament", "Dades guardades", JOptionPane.PLAIN_MESSAGE, INFO_IMG);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
            }
        }
    }//GEN-LAST:event_miGuardarActionPerformed

    private void miSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSobreActionPerformed
        FrmSobre form = new FrmSobre(this, true);
        form.setVisible(true);
    }//GEN-LAST:event_miSobreActionPerformed

    private void cmbAlbumsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlbumsActionPerformed
        refreshAlbum();
    }//GEN-LAST:event_cmbAlbumsActionPerformed

    private void btnAfegirFitxerBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirFitxerBibliotecaActionPerformed
        FrmAfegirFitxerMultimedia form = new FrmAfegirFitxerMultimedia(this, true);
        form.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent ev) {
                if (form.isAfegit()) {
                    refreshBiblioteca();
                }
            }
        });
        form.setVisible(true);
    }//GEN-LAST:event_btnAfegirFitxerBibliotecaActionPerformed

    private void btnEliminarAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarAlbumActionPerformed
        int index = this.cmbAlbums.getSelectedIndex();

        try {
            String titol = ctrl.getTitolAlbum(index);
            ctrl.esborrarAlbum(titol);
            refreshAlbums();
            refreshAlbum();
            JOptionPane.showMessageDialog(this, "Álbum " + titol + " esborrat correctament", "Álbum esborray", JOptionPane.PLAIN_MESSAGE, INFO_IMG);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_btnEliminarAlbumActionPerformed

    private void btnCrearAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAlbumActionPerformed
        String titol = JOptionPane.showInputDialog(this, "Introdueix el nom d l'álbum", "Crear Álbum - Nom", JOptionPane.PLAIN_MESSAGE);
        if (titol != null) {
            int capacitatFinal;
            String capacitat = JOptionPane.showInputDialog(this, "Introdueix la capacitat de l'álbum", "Crear Álbum - Capacitat", JOptionPane.PLAIN_MESSAGE);
            if (capacitat != null) {
                String messageCapacitat = "";
                String message;
                ImageIcon tipus = INFO_IMG;
                try {
                    capacitatFinal = Integer.parseInt(capacitat);
                } catch (HeadlessException | NumberFormatException ex) {
                    messageCapacitat = "capacitat no valida, assignada 10 per defecte";
                    capacitatFinal = 10;
                }

                try {
                    ctrl.afegirAlbum(titol, capacitatFinal);
                    refreshAlbums();
                    message = "Álbum " + titol + " creat";
                    if (!messageCapacitat.isEmpty()) {
                        message += "\n" + messageCapacitat;
                        tipus = WARNING_IMG;
                    }
                    JOptionPane.showMessageDialog(this, message, "Álbum creat", JOptionPane.PLAIN_MESSAGE, tipus);
                } catch (AplicacioException ex) {
                    JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
                }
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
                refreshBiblioteca();
                refreshAlbums();
                refreshAlbum();
                JOptionPane.showMessageDialog(this, "Fitxer/s esborrat/s", "Fitxer Esborrat/s", JOptionPane.PLAIN_MESSAGE, INFO_IMG);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un o varis fitxers abans", "Avis", JOptionPane.PLAIN_MESSAGE, WARNING_IMG);
        }
    }//GEN-LAST:event_btnEliminarFitxerBibliotecaActionPerformed

    private void btnAfegirFitxerAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAfegirFitxerAlbumActionPerformed
        int[] indices = this.lstBiblioteca.getSelectedIndices();
        int indexAlbum = this.cmbAlbums.getSelectedIndex();
        int afegits = 0;
        String messageFinestra, titolFinestra;
        ImageIcon tipusFinestra;

        if (indices.length > 0) {
            try {
                String titol = ctrl.getTitolAlbum(indexAlbum);
                for (int i : indices) {
                    ctrl.afegirFitxer(titol, i);
                    afegits++;
                }
                messageFinestra = "Fitxer/s afegit/s al álbum";
                titolFinestra = "Fitxer/s afegit/s al álbum";
                tipusFinestra = INFO_IMG;
            } catch (AplicacioException ex) {
                messageFinestra = ex.getMessage() + ", fitxers afegits: " + afegits;
                titolFinestra = "Error";
                tipusFinestra = ERROR_IMG;
            }
            if (afegits >= 1) {
                refreshAlbum();
                refreshAlbums();
            }
            JOptionPane.showMessageDialog(this, messageFinestra, titolFinestra, JOptionPane.PLAIN_MESSAGE, tipusFinestra);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un o varis fitxers abans", "Avis", JOptionPane.PLAIN_MESSAGE, WARNING_IMG);
        }
    }//GEN-LAST:event_btnAfegirFitxerAlbumActionPerformed

    private void btnReproduirBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproduirBibliotecaActionPerformed
        try {
            ctrl.reproduirCarpeta();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_btnReproduirBibliotecaActionPerformed

    private void btnReproduirFitxerBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproduirFitxerBibliotecaActionPerformed
        int index = this.lstBiblioteca.getSelectedIndex();
        try {
            ctrl.reproduirFitxer(index);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_btnReproduirFitxerBibliotecaActionPerformed

    private void btnReproduirAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproduirAlbumActionPerformed
        int indexAlbum = this.cmbAlbums.getSelectedIndex();

        try {
            String titol = ctrl.getTitolAlbum(indexAlbum);
            ctrl.reproduirCarpeta(titol);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_btnReproduirAlbumActionPerformed

    private void btnReproduirFitxerAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReproduirFitxerAlbumActionPerformed
        int index = this.lstAlbum.getSelectedIndex();
        int indexAlbum = this.cmbAlbums.getSelectedIndex();

        try {
            String titol = ctrl.getTitolAlbum(indexAlbum);
            ctrl.reproduirFitxer(index, titol);
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_btnReproduirFitxerAlbumActionPerformed

    private void btnReemprenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReemprenActionPerformed
        try {
            ctrl.reemprenReproduccio();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_btnReemprenActionPerformed

    private void btnPauseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPauseActionPerformed
        try {
            ctrl.pausaReproduccio();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_btnPauseActionPerformed

    private void btnAturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAturaActionPerformed
        try {
            ctrl.aturaReproduccio();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_btnAturaActionPerformed

    private void btnSaltaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaltaActionPerformed
        try {
            ctrl.saltaReproduccio();
        } catch (AplicacioException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
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
                refreshAlbum();
                refreshAlbums();
                JOptionPane.showMessageDialog(this, "Fitxer/s esborrat/s del álbum", "Fitxer Esborrat/s del Álbum", JOptionPane.PLAIN_MESSAGE, INFO_IMG);
            } catch (AplicacioException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona un o varis fitxers abans", "Avis", JOptionPane.PLAIN_MESSAGE, WARNING_IMG);
        }
    }//GEN-LAST:event_btnEliminarFitxerAlbumActionPerformed

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        lstBiblioteca.clearSelection();
        lstAlbum.clearSelection();
    }//GEN-LAST:event_formMouseClicked

    private void lstBibliotecaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstBibliotecaMouseClicked
        JList list = (JList) evt.getSource();
        int index = list.locationToIndex(evt.getPoint());
        if (evt.getClickCount() == 2 && index >= 0) {
            JOptionPane.showMessageDialog(this, ctrl.infoFitxer(index), "Informació del Fitxer", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_lstBibliotecaMouseClicked

    private void lstAlbumMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAlbumMouseClicked
        int indexAlbum = this.cmbAlbums.getSelectedIndex();
        try {
            JList list = (JList) evt.getSource();
            int index = list.locationToIndex(evt.getPoint());
            if (evt.getClickCount() == 2 && index >= 0) {
                String titol = ctrl.getTitolAlbum(indexAlbum);
                JOptionPane.showMessageDialog(this, ctrl.infoFitxer(titol, index), "Informació del Fitxer del Álbum", JOptionPane.PLAIN_MESSAGE);
            }
        } catch (AplicacioException ae) {
            JOptionPane.showMessageDialog(this, ae.getMessage(), "Error", JOptionPane.PLAIN_MESSAGE, ERROR_IMG);
        }
    }//GEN-LAST:event_lstAlbumMouseClicked

    /**
     * Hace y retorna un nuevo ListModel<String> para asociarselo a un Jlist
     *
     * @param list
     * @return ListModel<String>
     */
    private ListModel<String> makeListModel(List<String> list) {
        return new AbstractListModel<String>() {
            String[] strings = list.toArray(new String[list.size()]);

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public String getElementAt(int i) {
                return strings[i];
            }
        };
    }

    /**
     * Refersca el JList de la biblioteca
     */
    private void refreshBiblioteca() {
        List<String> bibList = ctrl.mostrarBiblioteca();
        int[] indices = lstBiblioteca.getSelectedIndices();
        this.lstBiblioteca.setModel(makeListModel(bibList));
        this.lstBiblioteca.setSelectedIndices(indices);
    }

    /**
     * Refresca el JList del album
     */
    private void refreshAlbum() {
        int index = this.cmbAlbums.getSelectedIndex();
        try {
            String titol = ctrl.getTitolAlbum(index);
            List<String> albumList = ctrl.mostrarAlbum(titol);
            int[] indices = lstAlbum.getSelectedIndices();
            lstAlbum.setModel(makeListModel(albumList));
            lstAlbum.setSelectedIndices(indices);
        } catch (AplicacioException ex) {
            lstAlbum.setModel(makeListModel(new ArrayList<>()));
        }
    }

    /**
     * Refresca el JComboBox de albums
     */
    private void refreshAlbums() {
        List<String> albumsList = ctrl.mostrarLlistatAlbums();
        int index = cmbAlbums.getSelectedIndex();
        String[] strings = albumsList.toArray(new String[albumsList.size()]);
        cmbAlbums.setModel(new DefaultComboBoxModel<>(strings));
        int modelSize = cmbAlbums.getModel().getSize();

        if (modelSize > 0) {
            if (index == -1) {
                index++;
            } else if (index > modelSize - 1) {
                index--;
            }
            cmbAlbums.setSelectedIndex(index);
        }
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
        refreshBiblioteca();
        refreshAlbums();
        refreshAlbum();
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
            System.setProperty("apple.laf.useScreenMenuBar", "true");
            System.setProperty("com.apple.mrj.application.apple.menu.about.name", TITLE);

            uk.co.caprica.vlcj.binding.LibC.INSTANCE.setenv("VLC_PLUGIN_PATH",
                    "/Applications/VLC.app/Contents/MacOS/plugins", 1);

            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),
                    "/Applications/VLC.app/Contents/MacOS/lib");

            Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        }

        EventQueue.invokeLater(() -> {
            AplicacioUB4 app = new AplicacioUB4();
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                System.err.println(e.getMessage());
            }

            UIManager.put("OptionPane.cancelButtonText", "Cancel·lar");
            UIManager.put("OptionPane.okButtonText", "Acceptar");

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
    private javax.swing.JScrollPane scpAlbum;
    private javax.swing.JScrollPane scpBiblioteca;
    // End of variables declaration//GEN-END:variables

}
