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
import static edu.ub.prog2.MartinezManuelPerugaAaron.vista.IniciadorAplicacioUB.USER_NAME;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.Menu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 * AplicacioUB3 - Vista
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public class AplicacioUB3 {

    private final Controlador ctrl;

    public AplicacioUB3() {
        ctrl = Controlador.getInstance();
    }

    // Titulos de las Secciones de los menús START
    private static final String MENU_PRINCIPAL_SEC = "Menu Principal";
    private static final String GESTIO_BIBLIOTECA_SEC = "Gestio de Biblioteca";
    private static final String AFEGIR_FITXER_BIB_SEC = "Afegir Fitxer a Biblioteca";
    private static final String GESTIO_ALBUMS_SEC = "Gestio Albums";
    private static final String GESTIO_ALBUM_SEC = "Gestionar Album";
    private static final String CONTROL_REPR_VISIO_SEC = "Control Reproduccio/Visio";
    private static final String GESTION_REPR_CURSO_SEC = "Gestio Reproduccio en Curs";
    // Titulos de las Secciones de los menús END

    // Menú anterior para no repetir el String
    private static final String MENU_ANTERIOR_NAME = "Menu anterior";

    // Menú Principal
    private static enum OpcionsMenuPrincipal {
        MP_GESTION_BIBLIOTECA, MP_GESTIO_ALBUMS, MP_CONTROL_REPRODUCCIÓ, MP_GUARDAR_DADES, MP_RECUPERAR_DADES, MP_SORTIR
    };

    private static final String[] DESC_MENU_PRINCIPAL = {
        "Gestio Biblioteca",
        "Gestio Albums",
        "Control Reproduccio/Visio",
        "Guardar Dades",
        "Recuperar Dades",
        "Sortir"
    };

    // Menu de Gestión de Biblioteca
    private static enum OpcionsMenuGestioBiblioteca {
        M_GB_AFEGIR_FITXER, M_GB_MOSTRAR_BIBLIOTECA, M_GB_ELIMINAR_FITXER, M_GB_TORNAR
    };

    private static final String[] DESC_MENU_GESTIO_BIBLIOTECA = {
        "Afegir fitxer multimedia a la biblioteca",
        "Mostrar Biblioteca",
        "Elimina fitxer multimedia",
        MENU_ANTERIOR_NAME
    };

    // Menu de la opción GestioAlbums
    private static enum OpcionsMenuGestioAlbums {
        M_GA_AFEGIR_ALBUM, M_GA_MOSTRAR_ALBUMS, M_GA_ELIMINAR_ALBUM, M_GA_GESTIONAR_ALBUM, M_GA_TORNAR
    };

    private static final String[] DESC_MENU_GESTIO_ALBUMS = {
        "Afegir Albums",
        "Mostrar Albums",
        "Eliminar Albums",
        "Gestionar Album",
        MENU_ANTERIOR_NAME
    };

    // SubMenu de la opción gestionar albums
    private static enum OpcionsSubMenuGestionarAlbum {
        SM_GA_AFEGIR_FITXER, SM_GA_MOSTRAR_ALBUM, SM_GA_ELIMINAR_FITXER, SM_GA_TORNAR
    };

    private static final String[] DESC_SUBMENU_GESTIONAR_ALBUM = {
        "Afegir Fitxer Multimedia",
        "Mostrar Àlbum",
        "Eliminar Fitxer Multimedia",
        MENU_ANTERIOR_NAME
    };

    // Menu de la opcion control reproducció 
    private static enum OpcionsMenuControl {
        M_C_REPRODUIR_FITXER, M_C_REPRODUIR_BIBLIOTECA, M_C_REPRODUIR_ALBUM,
        M_C_ACT_DES_CONTINUA, M_C_ACT_DES_ALEATORIA, M_C_GESTIO_REPRODUCCIO, M_C_MENU_ANTERIOR
    };

    private static final String[] DESC_MENU_CONTROL_REPRODUCCIO = {
        "Reproduir fitxer reproduible",
        "Reproduir tota la biblioteca",
        "Reproduir un album",
        "Activar/Desactivar reproduccio continua ",
        "Activar/Desactivar reproduccio aleatoria ",
        "Gestio reproduccio en curs",
        MENU_ANTERIOR_NAME
    };

    //SubMenu de la opción gestio Reproduccio en curs
    private static enum OpcionsSubMenuControl {
        SM_GR_REEMPREN, SM_GR_PAUSA, SM_GR_ATURA, SM_GR_SALTA, SM_GR_SORTIR
    }

    private static final String[] DESC_SUBMENU_GESTIO_REPRODUCCIO = {
        "Re-emprèn",
        "Pausa",
        "Atura",
        "Salta",
        MENU_ANTERIOR_NAME
    };

    // SubMenu de Añadir fichero Multimedia a la biblioteca
    private static enum OpcionsMenuAfegir {
        SM_AFEGIR_VIDEO, SM_AFEGIR_AUDIO, SM_AFEGIR_TORNAR
    };

    private static final String[] DESC_MENU_AFEGIR = {
        "Afegir Video",
        "Afegir Audio",
        MENU_ANTERIOR_NAME
    };

    private static final String CARPETA_FITXERS_TITLE = "Carpeta de Fitxers:\n"
            + String.join("", Collections.nCopies(35, "-"));

    /**
     * Pide los datos para poder añadir un fichero de video
     *
     * @param sc
     */
    private void writeVideo(Scanner sc) {
        System.out.print("Ruta del Fitxer >> ");
        String cami = sc.nextLine();
        System.out.println();
        try {
            ctrl.comprovaExistenciaFitxer(cami);

            System.out.print("Descripcio del Fitxer >> ");
            String desc = sc.nextLine();
            System.out.println();

            System.out.print("Codec (String) >> ");
            String codec = sc.nextLine();
            System.out.println();

            System.out.print("Durada (float) >> ");
            float durada = sc.nextFloat();
            System.out.println();

            System.out.print("Alcada (int) >> ");
            int alcada = sc.nextInt();
            System.out.println();

            System.out.print("Amplada (int) >> ");
            int amplada = sc.nextInt();
            System.out.println();

            System.out.print("Frames per Second (float) >> ");
            float fps = sc.nextFloat();
            System.out.println();

            ctrl.afegirVideo(cami, desc, codec, durada, alcada, amplada, fps);

            System.out.println("Fitxer afegit");

        } catch (AplicacioException ae) {
            //System.err.println(ae.getMessage()); Salida de error
            System.out.println(ae.getMessage());
        }
    }

    /**
     * Pide los datos para poder añadir un fichero de audio
     *
     * @param sc
     */
    private void writeAudio(Scanner sc) {
        System.out.print("Ruta del Fitxer >> ");
        String cami = sc.nextLine();
        System.out.println();
        try {
            ctrl.comprovaExistenciaFitxer(cami);

            System.out.print("Ruta de la imatge del Fitxer >> ");
            String imatgeFitxer = sc.nextLine();
            System.out.println();

            //ctrl.comprovaExistenciaFitxer(imatgeFitxer);
            System.out.print("Descripcio del Fitxer >> ");
            String desc = sc.nextLine();
            System.out.println();

            System.out.print("Codec (String) >> ");
            String codec = sc.next();
            System.out.println();

            System.out.print("Durada (float) >> ");
            float durada = sc.nextFloat();
            System.out.println();

            System.out.print("Kbps (int) >> ");
            int kbps = sc.nextInt();
            System.out.println();

            ctrl.afegirAudio(cami, imatgeFitxer, desc, codec, durada, kbps);

            System.out.println("Fitxer afegit");

        } catch (AplicacioException ae) {
            //System.err.println(ae.getMessage()); Salida de error
            System.out.println(ae.getMessage());
        }
    }

    /**
     * Pide los datos para poder borrar un fichero de la Biblioteca
     *
     * @param sc
     */
    private void eliminarFitxer(Scanner sc) {
        if (ctrl.estaBuida()) {
            System.out.println("No hi ha fitxers per esborrar");
        } else {
            System.out.print("ID del Fitxer >> ");
            int id = sc.nextInt();
            System.out.println();
            try {
                ctrl.esborrarFitxer(id);
                System.out.println("Fitxer amd id " + id + " esborrat");
            } catch (AplicacioException ae) {
                //System.err.println(ae.getMessage()); Salida de error
                System.out.println(ae.getMessage());
            }
        }
    }

    /**
     * Muestra el contenido de la biblioteca
     */
    private void mostrarBiblioteca() {
        List<String> bibl = (ArrayList<String>) ctrl.mostrarBiblioteca();
        System.out.println(CARPETA_FITXERS_TITLE);

        if (bibl.isEmpty()) {
            System.out.println("No hi ha fitxers");
        } else {
            bibl.forEach((file) -> {
                System.out.println(file);
            });
        }
    }

    /**
     * Pide el path para poder guardar los datos en un archivo
     *
     * @param sc
     */
    private void saveFile(Scanner sc) {
        List<String> bibl = (ArrayList<String>) ctrl.mostrarBiblioteca();
        if (bibl.isEmpty()) {
            System.out.println("No hi ha dades que guardar");
        } else {
            System.out.print("Ruta completa amb el nom >> ");
            String cami = sc.nextLine();
            System.out.println();
            try {
                ctrl.guardarDadesDisc(cami);

                System.out.println("Dades emmagatzemades!!");

            } catch (AplicacioException ae) {
                //System.err.println(ae.getMessage()); Salida de error
                System.out.println(ae.getMessage());
            }
        }
    }

    /**
     * Pide el path para cargar un archivo con datos guardados
     *
     * @param sc
     */
    private void loadFile(Scanner sc) {
        System.out.print("Ruta completa amb el nom >> ");
        String cami = sc.nextLine();
        System.out.println();
        try {
            ctrl.carregarDadesDisc(cami);

            System.out.println("Dades carregades!!");

        } catch (AplicacioException ae) {
            //System.err.println(ae.getMessage()); Salida de error
            System.out.println(ae.getMessage());
        }
    }

    /**
     * Menú Gestionar Albums
     *
     * @param sc
     */
    private void gestioAlbums(Scanner sc) {
        Menu<OpcionsMenuGestioAlbums> menuAlbum = new Menu<>(GESTIO_ALBUMS_SEC, OpcionsMenuGestioAlbums.values());

        menuAlbum.setDescripcions(DESC_MENU_GESTIO_ALBUMS);

        OpcionsMenuGestioAlbums opcio;

        do {
            System.out.println();

            menuAlbum.mostrarMenu();

            opcio = menuAlbum.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case M_GA_AFEGIR_ALBUM:
                    // TODO
                    break;
                case M_GA_MOSTRAR_ALBUMS:
                    // TODO
                    break;
                case M_GA_ELIMINAR_ALBUM:
                    // TODO
                    break;
                case M_GA_GESTIONAR_ALBUM:
                    gestionarAlbum(sc);
                    break;
                case M_GA_TORNAR:
                    System.out.println("Tornant a >> " + MENU_PRINCIPAL_SEC);
                    break;
            }
        } while (opcio != OpcionsMenuGestioAlbums.M_GA_TORNAR);
    }

    /**
     * Menú Gestionar un Album
     *
     * @param sc
     */
    private void gestionarAlbum(Scanner sc) {
        Menu<OpcionsSubMenuGestionarAlbum> submenuAlbums = new Menu<>(GESTIO_ALBUM_SEC, OpcionsSubMenuGestionarAlbum.values());

        submenuAlbums.setDescripcions(DESC_SUBMENU_GESTIONAR_ALBUM);

        OpcionsSubMenuGestionarAlbum opcio;

        do {
            System.out.println();

            submenuAlbums.mostrarMenu();

            opcio = submenuAlbums.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case SM_GA_AFEGIR_FITXER:
                    // TODO
                    break;
                case SM_GA_ELIMINAR_FITXER:
                    // TODO
                    break;
                case SM_GA_MOSTRAR_ALBUM:
                    // TODO
                    break;
                case SM_GA_TORNAR:
                    System.out.println("Tornant a >> " + GESTIO_ALBUMS_SEC);
                    break;
            }
        } while (opcio != OpcionsSubMenuGestionarAlbum.SM_GA_TORNAR);
    }

    /**
     * Menú Control de Reproducción/Visión
     *
     * @param sc
     */
    private void gestioControl(Scanner sc) {
        Menu<OpcionsMenuControl> menuControl = new Menu<>(CONTROL_REPR_VISIO_SEC, OpcionsMenuControl.values());

        menuControl.setDescripcions(DESC_MENU_CONTROL_REPRODUCCIO);

        OpcionsMenuControl opcio;

        do {
            System.out.println();

            menuControl.mostrarMenu();

            opcio = menuControl.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case M_C_REPRODUIR_FITXER:
                    // TODO
                    break;
                case M_C_REPRODUIR_BIBLIOTECA:
                    // TODO
                    break;
                case M_C_REPRODUIR_ALBUM:
                    // TODO
                    break;
                case M_C_ACT_DES_CONTINUA:
                    // TODO
                    break;
                case M_C_ACT_DES_ALEATORIA:
                    // TODO
                    break;
                case M_C_GESTIO_REPRODUCCIO:
                    gestionarReproduccio(sc);
                    break;
                case M_C_MENU_ANTERIOR:
                    System.out.println("Tornant a >> " + MENU_PRINCIPAL_SEC);
                    break;
            }
        } while (opcio != OpcionsMenuControl.M_C_MENU_ANTERIOR);
    }

    /**
     * Menú Gestiona Reproducción
     *
     * @param sc
     */
    private void gestionarReproduccio(Scanner sc) {
        Menu<OpcionsSubMenuControl> submenuControl = new Menu<>(GESTION_REPR_CURSO_SEC, OpcionsSubMenuControl.values());

        submenuControl.setDescripcions(DESC_SUBMENU_GESTIO_REPRODUCCIO);

        OpcionsSubMenuControl opcio;

        do {
            System.out.println();

            submenuControl.mostrarMenu();

            opcio = submenuControl.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case SM_GR_REEMPREN:
                    // TODO
                    break;
                case SM_GR_PAUSA:
                    // TODO
                    break;
                case SM_GR_ATURA:
                    // TODO
                    break;
                case SM_GR_SALTA:
                    // TODO
                    break;
                case SM_GR_SORTIR:
                    System.out.println("Tornant a >> " + CONTROL_REPR_VISIO_SEC);
                    break;
            }

        } while (opcio != OpcionsSubMenuControl.SM_GR_SORTIR);
    }

    /**
     * Menú Añadir archivo a la Biblioteca
     *
     * @param sc
     */
    private void gestioAfegir(Scanner sc) {
        Menu<OpcionsMenuAfegir> menuAfegir = new Menu<>(AFEGIR_FITXER_BIB_SEC, OpcionsMenuAfegir.values());

        menuAfegir.setDescripcions(DESC_MENU_AFEGIR);

        OpcionsMenuAfegir opcio;

        do {
            System.out.println();

            menuAfegir.mostrarMenu();

            opcio = menuAfegir.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case SM_AFEGIR_VIDEO:
                    writeVideo(sc);
                    break;
                case SM_AFEGIR_AUDIO:
                    writeAudio(sc);
                    break;
                case SM_AFEGIR_TORNAR:
                    System.out.println("Tornant a >> " + GESTIO_BIBLIOTECA_SEC);
                    break;
            }

        } while (opcio != OpcionsMenuAfegir.SM_AFEGIR_TORNAR);
    }

    /**
     * Menú Gestion Biblioteca
     *
     * @param sc
     */
    private void gestioBiblioteca(Scanner sc) {
        Menu<OpcionsMenuGestioBiblioteca> subMenu = new Menu<>(GESTIO_BIBLIOTECA_SEC, OpcionsMenuGestioBiblioteca.values());

        subMenu.setDescripcions(DESC_MENU_GESTIO_BIBLIOTECA);

        OpcionsMenuGestioBiblioteca opcio;

        do {
            System.out.println();

            subMenu.mostrarMenu();

            opcio = subMenu.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case M_GB_AFEGIR_FITXER:
                    gestioAfegir(sc);
                    break;
                case M_GB_MOSTRAR_BIBLIOTECA:
                    mostrarBiblioteca();
                    break;
                case M_GB_ELIMINAR_FITXER:
                    eliminarFitxer(sc);
                    break;
                case M_GB_TORNAR:
                    System.out.println("Tornant a >> " + MENU_PRINCIPAL_SEC);
                    break;
            }

        } while (opcio != OpcionsMenuGestioBiblioteca.M_GB_TORNAR);

    }

    /**
     * Menú principal, Método principal de la vista para Gestion de la
     * Aplicación. Try-Catch con recursos para cerrar Scanner sin close(),
     * sugerido por Netbeans
     */
    public void gestioAplicacioUB() {

        try (Scanner sc = new Scanner(System.in)) {

            // Para usar '.' en vez de ',' en la terminal
            sc.useLocale(Locale.ENGLISH);

            Menu<OpcionsMenuPrincipal> menu = new Menu<>(MENU_PRINCIPAL_SEC, OpcionsMenuPrincipal.values());

            menu.setDescripcions(DESC_MENU_PRINCIPAL);

            OpcionsMenuPrincipal opcio;

            do {
                System.out.println();

                menu.mostrarMenu();

                opcio = menu.getOpcio(sc);

                System.out.println();

                switch (opcio) {
                    case MP_GESTION_BIBLIOTECA:
                        gestioBiblioteca(sc);
                        break;
                    case MP_GESTIO_ALBUMS:
                        gestioAlbums(sc);
                        break;
                    case MP_CONTROL_REPRODUCCIÓ:
                        gestioControl(sc);
                        break;
                    case MP_GUARDAR_DADES:
                        saveFile(sc);
                        break;
                    case MP_RECUPERAR_DADES:
                        loadFile(sc);
                        break;
                    case MP_SORTIR:
                        System.out.println("Adeu " + USER_NAME + "!!");
                        break;
                }
            } while (opcio != OpcionsMenuPrincipal.MP_SORTIR);
        }
    }

}
