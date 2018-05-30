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
import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.List;
import java.util.Locale;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
    private final static String TITLE = "Reproductor UB (Grup C)";

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
        lblBiblioteca = new javax.swing.JLabel();
        lblAlbums = new javax.swing.JLabel();
        lblAlbum = new javax.swing.JLabel();
        btnAfegirFitxerBiblioteca = new javax.swing.JButton();
        btnEliminarImatge = new javax.swing.JButton();
        btnCrearAlbum = new javax.swing.JButton();
        btnEliminarAlbum = new javax.swing.JButton();
        btnAfegirImatgeAlbum = new javax.swing.JButton();
        btnEliminarImatgeAlbum = new javax.swing.JButton();
        mbMenu = new javax.swing.JMenuBar();
        mMenu = new javax.swing.JMenu();
        mDades = new javax.swing.JMenu();
        miCarregar = new javax.swing.JMenuItem();
        miGuardar = new javax.swing.JMenuItem();
        miSortir = new javax.swing.JMenuItem();
        mPreferencies = new javax.swing.JMenu();
        jCheckBoxMenuItem2 = new javax.swing.JCheckBoxMenuItem();
        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        mInfo = new javax.swing.JMenu();
        miSobre = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle(TITLE);
        setName(getClass().getSimpleName());

        cmbAlbums.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbAlbums.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbAlbumsActionPerformed(evt);
            }
        });

        lstAlbum.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        scpAlbums.setViewportView(lstAlbum);

        lstBiblioteca.setModel(updateBiblioteca());
        scpBiblioteca.setViewportView(lstBiblioteca);

        lblBiblioteca.setText("Biblioteca");

        lblAlbums.setText("Albums");

        lblAlbum.setText("Album");

        btnAfegirFitxerBiblioteca.setText("Afegir Fitxer");
        btnAfegirFitxerBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAfegirFitxerBibliotecaActionPerformed(evt);
            }
        });

        btnEliminarImatge.setText("Eliminar Imatge");

        btnCrearAlbum.setText("Crear Album");
        btnCrearAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearAlbumActionPerformed(evt);
            }
        });

        btnEliminarAlbum.setText("Eliminar Album");
        btnEliminarAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarAlbumActionPerformed(evt);
            }
        });

        btnAfegirImatgeAlbum.setText("Afegir Imatge al álbum");

        btnEliminarImatgeAlbum.setText("Eliminar Imatge album");

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

        jCheckBoxMenuItem2.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem2.setText("Reproducció Aleatoria");
        mPreferencies.add(jCheckBoxMenuItem2);

        jCheckBoxMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_MASK));
        jCheckBoxMenuItem1.setText("Reproduccio Continua");
        jCheckBoxMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBoxMenuItem1ActionPerformed(evt);
            }
        });
        mPreferencies.add(jCheckBoxMenuItem1);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAfegirFitxerBiblioteca)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnEliminarImatge)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminarImatgeAlbum))
                    .addComponent(btnCrearAlbum)
                    .addComponent(btnEliminarAlbum)
                    .addComponent(btnAfegirImatgeAlbum)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(scpBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblBiblioteca))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblAlbums)
                            .addComponent(scpAlbums, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblAlbum)
                            .addComponent(cmbAlbums, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(363, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblBiblioteca)
                    .addComponent(lblAlbums))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpBiblioteca, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbAlbums, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAlbum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scpAlbums)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAfegirFitxerBiblioteca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEliminarImatge)
                    .addComponent(btnEliminarImatgeAlbum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrearAlbum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminarAlbum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnAfegirImatgeAlbum)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miCarregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miCarregarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miCarregarActionPerformed

    private void miGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miGuardarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miGuardarActionPerformed

    private void miSobreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSobreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_miSobreActionPerformed

    private void cmbAlbumsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbAlbumsActionPerformed
        // TODO add your handling code here:
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
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarAlbumActionPerformed

    private void btnCrearAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCrearAlbumActionPerformed

    private void miSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miSortirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_miSortirActionPerformed

    private void jCheckBoxMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBoxMenuItem1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBoxMenuItem1ActionPerformed

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
     * Main
     *
     * @param args[]
     */
    public static void main(String args[]) {

        Locale.setDefault(Locale.US);

        // VLC 2.2 para Mac
        if (MAC) {
            uk.co.caprica.vlcj.binding.LibC.INSTANCE.setenv("VLC_PLUGIN_PATH",
                    "/Applications/VLC.app/Contents/MacOS/plugins", 1);

            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),
                    "/Applications/VLC.app/Contents/MacOS/lib");

            Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        }

        EventQueue.invokeLater(() -> {
            new AplicacioUB4().setVisible(true);
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAfegirFitxerBiblioteca;
    private javax.swing.JButton btnAfegirImatgeAlbum;
    private javax.swing.JButton btnCrearAlbum;
    private javax.swing.JButton btnEliminarAlbum;
    private javax.swing.JButton btnEliminarImatge;
    private javax.swing.JButton btnEliminarImatgeAlbum;
    private javax.swing.JComboBox<String> cmbAlbums;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem2;
    private javax.swing.JLabel lblAlbum;
    private javax.swing.JLabel lblAlbums;
    private javax.swing.JLabel lblBiblioteca;
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
