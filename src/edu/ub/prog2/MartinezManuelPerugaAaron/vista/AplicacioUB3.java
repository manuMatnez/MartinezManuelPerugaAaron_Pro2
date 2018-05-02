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
    private static final String CONTROL_REPR_VISIO_SEC = "Control Reproduccio";
    private static final String GESTION_REPR_CURSO_SEC = "Gestio Reproduccio en Curs";
    // Titulos de las Secciones de los menús END

    // Mensaje: 'Tornant a' START
    private static final String TORNANT_A = "Tornant a >> ";
    // Mensaje: 'Tornant a' END

    // Menú anterior para no repetir el String
    private static final String MENU_ANTERIOR_NAME = "Menu anterior";

    // Menú Principal
    private static enum OpcionsMenuPrincipal {
        MP_GESTION_BIBLIOTECA, MP_GESTIO_ALBUMS, MP_CONTROL_REPRODUCCIÓ, MP_GUARDAR_DADES, MP_RECUPERAR_DADES, MP_SORTIR
    };

    private static final String[] DESC_MENU_PRINCIPAL = {
        "Gestio Biblioteca",
        "Gestio Albums",
        "Control Reproduccio",
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
        "Afegir Album",
        "Mostrar Albums",
        "Eliminar Album",
        "Gestionar Album",
        MENU_ANTERIOR_NAME
    };

    // SubMenu de la opción gestionar albums
    private static enum OpcionsSubMenuGestionarAlbum {
        SM_GA_AFEGIR_FITXER, SM_GA_MOSTRAR_ALBUM, SM_GA_ELIMINAR_FITXER, SM_GA_TORNAR
    };

    private static final String[] DESC_SUBMENU_GESTIONAR_ALBUM = {
        "Afegir Fitxer Multimedia",
        "Mostrar Album",
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
        "Activar/Desactivar reproduccio continua",
        "Activar/Desactivar reproduccio aleatoria",
        "Gestio reproduccio en curs",
        MENU_ANTERIOR_NAME
    };

    //SubMenu de la opción gestio Reproduccio en curs
    private static enum OpcionsSubMenuControl {
        SM_GR_REEMPREN, SM_GR_PAUSA, SM_GR_ATURA, SM_GR_SALTA, SM_GR_SORTIR
    }

    private static final String[] DESC_SUBMENU_GESTIO_REPRODUCCIO = {
        "Re-empren",
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

    private static final String SEP = String.join("", Collections.nCopies(35, "-"));

    private static final String BIBLIOTECA_FITXERS_TITLE = "Biblioteca de Fitxers";

    private static final String ALBUMS_FITXERS_TITLE = "Albums";

    private static final String ALBUM_FITXERS_TITLE = "Album ";

    // FUNCIONES ALBUMS START
    /**
     * Pide los datos para crear un nuevo album
     *
     * @param sc
     */
    private void crearAlbum(Scanner sc) {
        try {
            System.out.print("Nom del nuou album >> ");
            String album = sc.nextLine();

            preguntaTamanyAlbum(sc, album);
            System.out.println("\nAlbum afegit -> " + album);
        } catch (AplicacioException ae) {
            System.out.println(ae.getMessage());
        }
    }

    /**
     * Pregunta si quiere tamaño personalizado del album
     *
     * @param sc
     * @param album
     * @throws AplicacioException
     */
    private void preguntaTamanyAlbum(Scanner sc, String album) throws AplicacioException {
        System.out.print("Vols un tamany de album personalitzat? (s/n) >> ");
        char respuesta = sc.nextLine().toLowerCase().charAt(0);
        switch (respuesta) {
            case 's':
                System.out.print("Tamany del nuou album >> ");
                int size = sc.nextInt();
                ctrl.afegirAlbum(album, size);
                break;
            case 'n':
                ctrl.afegirAlbum(album);
                break;
            default:
                preguntaTamanyAlbum(sc, album);
                break;
        }

    }

    /**
     * Pide los datos para borrar un album
     *
     * @param sc
     */
    private void eliminarAlbum(Scanner sc) {
        if (ctrl.albumsBuit()) {
            System.out.println("No hi ha cap album per esborrar");
        } else {
            try {
                System.out.print("Nom del album >> ");
                String album = sc.nextLine();
                ctrl.esborrarAlbum(album);
                System.out.println("\nAlbum eliminat -> " + album);
            } catch (AplicacioException ae) {
                System.out.println(ae.getMessage());
            }
        }
    }

    /**
     * Muestra todos los albums
     */
    private void mostrarAlbums() {
        List<String> albums = (ArrayList<String>) ctrl.mostrarLlistatAlbums();
        System.out.println(ALBUMS_FITXERS_TITLE + "\n" + SEP);

        if (albums.isEmpty()) {
            System.out.println("No hi ha albums");
        } else {
            albums.forEach((album) -> {
                System.out.println(album);
            });
        }
    }

    private void seleccionaAlbum(Scanner sc) {
        if (ctrl.albumsBuit()) {
            System.out.println("No hi ha cap album per gestionar");
        } else {
            System.out.print("Nom del album >> ");
            String album = sc.nextLine();
            System.out.println();
            if (ctrl.existeixAlbum(album)) {
                gestionarAlbum(sc, album);
            } else {
                System.out.println("No existeix l album");
            }
        }
    }
    // FUNCIONES ALBUMS END

    // FUNCIONES UN ALBUM START
    /**
     * Pide los datos para poder añadir un fichero a un album
     *
     * @param sc
     */
    private void afegirFitxerAlbum(Scanner sc, String album) {
        if (ctrl.biblioBuida()) {
            System.out.println("No hi ha cap fitxer a la biblioteca");
        } else {
            try {
                //System.out.print("Nom del album >> ");
                //String album = sc.nextLine();
                System.out.print("ID del fitxer >> ");
                int id = sc.nextInt();
                int fixId = id - 1;
                ctrl.afegirFitxer(album, fixId);
                System.out.println("\nFitxer amb id " + id + " afegit a " + album);
            } catch (AplicacioException ae) {
                System.out.println(ae.getMessage());
            }
        }
    }

    /**
     * Pide los datos para poder eliminar un fichero de un album
     *
     * @param sc
     */
    private void eliminarFitxerAlbum(Scanner sc, String album) {
        try {
            if (ctrl.albumBuit(album)) {
                System.out.println("Album buit");
            } else {
                //System.out.print("Nom del album >> ");
                //String album = sc.nextLine();
                System.out.print("ID del fitxer >> ");
                int id = sc.nextInt();
                int fixId = id - 1;
                ctrl.esborrarFitxer(album, fixId);
                System.out.println("\nFitxer amb id " + id + " esborrat en " + album);
            }
        } catch (AplicacioException ae) {
            System.out.println(ae.getMessage());
        }
    }

    /**
     * Muestra un album
     *
     * @param title
     * @throws AplicacioException
     */
    private void mostrarUnAlbum(String title) {
        try {
            List<String> album = (ArrayList<String>) ctrl.mostrarAlbum(title);
            System.out.println(ALBUM_FITXERS_TITLE + title + "\n" + SEP);

            if (album.isEmpty()) {
                System.out.println("No hi ha fitxers");
            } else {
                album.forEach((file) -> {
                    System.out.println(file);
                });
            }
        } catch (AplicacioException ae) {
            System.out.println(ae.getMessage());
        }
    }

    // FUNCIONES UN ALBUM END
    // FUNCIONES AFEGIR BIBLIOTECA START
    /**
     * Pide los datos para poder añadir un fichero de video
     *
     * @param sc
     */
    private void afegirVideoBiblioteca(Scanner sc) {
        System.out.print("Ruta del Fitxer >> ");
        String cami = sc.nextLine();
        try {
            ctrl.comprovaExistenciaFitxer(cami);

            System.out.print("Nom del Fitxer >> ");
            String desc = sc.nextLine();

            System.out.print("Codec (String) >> ");
            String codec = sc.nextLine();

            System.out.print("Durada (float) >> ");
            float durada = sc.nextFloat();

            System.out.print("Alcada (int) >> ");
            int alcada = sc.nextInt();

            System.out.print("Amplada (int) >> ");
            int amplada = sc.nextInt();

            System.out.print("Frames per Second (float) >> ");
            float fps = sc.nextFloat();

            ctrl.afegirVideo(cami, desc, codec, durada, alcada, amplada, fps);

            System.out.println("\nFitxer afegit");

        } catch (AplicacioException ae) {
            //System.err.println(ae.getMessage()); Salida de error
            System.out.println(ae.getMessage());
        }
    }

    /**
     * Pregunta y pide los datos de la ubicación de la caratula de la canción
     *
     * @param sc
     * @return String
     */
    private String preguntaImatgeFitxer(Scanner sc) {
        System.out.print("Vols afegir una imatge al fitxer de audio? (s/n) >> ");
        char respuesta = sc.nextLine().toLowerCase().charAt(0);
        switch (respuesta) {
            case 's':
                System.out.print("Ruta de la imatge del Fitxer >> ");
                return sc.nextLine();
            case 'n':
                return "";
            default:
                return preguntaImatgeFitxer(sc);
        }
    }

    /**
     * Pide los datos para poder añadir un fichero de audio
     *
     * @param sc
     */
    private void afegirAudioBiblioteca(Scanner sc) {
        System.out.print("Ruta del Fitxer >> ");
        String cami = sc.nextLine();
        try {
            ctrl.comprovaExistenciaFitxer(cami);

            String imatgeFitxer = preguntaImatgeFitxer(sc);
            //ctrl.comprovaExistenciaFitxer(imatgeFitxer);

            System.out.print("Nom del Fitxer >> ");
            String desc = sc.nextLine();

            System.out.print("Codec (String) >> ");
            String codec = sc.next();

            System.out.print("Durada (float) >> ");
            float durada = sc.nextFloat();

            System.out.print("Kbps (int) >> ");
            int kbps = sc.nextInt();

            ctrl.afegirAudio(cami, imatgeFitxer, desc, codec, durada, kbps);

            System.out.println("\nFitxer afegit");

        } catch (AplicacioException ae) {
            //System.err.println(ae.getMessage()); Salida de error
            System.out.println(ae.getMessage());
        }
    }
    // FUNCIONES AFEGIR BIBLIOTECA END

    // FUNCIONES GESTION BIBLIOTECA START
    /**
     * Pide los datos para poder borrar un fichero de la Biblioteca
     *
     * @param sc
     */
    private void eliminarFitxer(Scanner sc) {
        if (ctrl.biblioBuida()) {
            System.out.println("No hi ha fitxers per esborrar");
        } else {
            System.out.print("ID del Fitxer >> ");
            int id = sc.nextInt();
            int fixId = id - 1;
            try {
                ctrl.esborrarFitxer(fixId);
                System.out.println("\nFitxer amd id " + id + " esborrat");
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
        System.out.println(BIBLIOTECA_FITXERS_TITLE + "\n" + SEP);

        if (bibl.isEmpty()) {
            System.out.println("No hi ha fitxers");
        } else {
            bibl.forEach((file) -> {
                System.out.println(file);
            });
        }
    }
    // FUNCIONES GESTION BIBLIOTECA END

    // FUNCIONES CONTROL START
    /**
     * Pide la id del fichero para reproducirlo
     *
     * @param sc
     */
    private void controlReproduirFitxer(Scanner sc) {
        if (ctrl.biblioBuida()) {
            System.out.println("No hi ha cap fitxer pera reproduir");
        } else {
            try {
                System.out.print("ID del fitxer >> ");
                int id = sc.nextInt();
                int fixId = id - 1;
                ctrl.reproduirFitxer(fixId);
            } catch (AplicacioException ae) {
                System.out.println(ae.getMessage());
            }
        }
    }

    /**
     * Pide el nombre del album para reproducirlo
     *
     * @param sc
     */
    private void controlReproduirAlbum(Scanner sc) {
        if (ctrl.albumsBuit()) {
            System.out.println("No hi ha cap album pera reproduir");
        } else {
            try {
                System.out.print("Nom del album >> ");
                String album = sc.nextLine();
                ctrl.reproduirCarpeta(album);
            } catch (AplicacioException ae) {
                System.out.println(ae.getMessage());
            }
        }
    }
    // FUNCIONES CONTROL END

    // PERSISTENCIA START
    /**
     * Pide el path para poder guardar los datos en un archivo
     *
     * @param sc
     */
    private void guardarDades(Scanner sc) {
        List<String> bibl = (ArrayList<String>) ctrl.mostrarBiblioteca();
        if (bibl.isEmpty()) {
            System.out.println("No hi ha dades que guardar\n");
        } else {
            System.out.print("Ruta completa amb el nom >> ");
            String cami = sc.nextLine();
            try {
                ctrl.guardarDadesDisc(cami);

                System.out.println("\nDades emmagatzemades!!\n");

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
    private void cargarDades(Scanner sc) {
        System.out.print("Ruta completa amb el nom >> ");
        String cami = sc.nextLine();
        try {
            ctrl.carregarDadesDisc(cami);

            System.out.println("\nDades carregades!!\n");

        } catch (AplicacioException ae) {
            //System.err.println(ae.getMessage()); Salida de error
            System.out.println(ae.getMessage());
        }
    }
    // PERSISTENCIA END

    /**
     * Menú Gestionar Albums
     *
     * @param sc
     */
    private void gestioAlbums(Scanner sc) {
        Menu<OpcionsMenuGestioAlbums> menuAlbums = new Menu<>(GESTIO_ALBUMS_SEC, OpcionsMenuGestioAlbums.values());

        menuAlbums.setDescripcions(DESC_MENU_GESTIO_ALBUMS);

        OpcionsMenuGestioAlbums opcio;

        do {
            menuAlbums.mostrarMenu();

            opcio = menuAlbums.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case M_GA_AFEGIR_ALBUM:
                    crearAlbum(sc);
                    break;
                case M_GA_MOSTRAR_ALBUMS:
                    mostrarAlbums();
                    break;
                case M_GA_ELIMINAR_ALBUM:
                    mostrarAlbums();
                    System.out.println();
                    eliminarAlbum(sc);
                    break;
                case M_GA_GESTIONAR_ALBUM:
                    mostrarAlbums();
                    System.out.println();
                    seleccionaAlbum(sc);
                    break;
                case M_GA_TORNAR:
                    System.out.println(TORNANT_A + MENU_PRINCIPAL_SEC);
                    break;
            }
            System.out.println();
        } while (opcio != OpcionsMenuGestioAlbums.M_GA_TORNAR);
    }

    /**
     * Menú Gestionar un Album
     *
     * @param sc
     */
    private void gestionarAlbum(Scanner sc, String album) {
        Menu<OpcionsSubMenuGestionarAlbum> subMenuAlbum = new Menu<>(GESTIO_ALBUM_SEC + ": " + album, OpcionsSubMenuGestionarAlbum.values());

        subMenuAlbum.setDescripcions(DESC_SUBMENU_GESTIONAR_ALBUM);

        OpcionsSubMenuGestionarAlbum opcio;

        do {
            subMenuAlbum.mostrarMenu();

            opcio = subMenuAlbum.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case SM_GA_AFEGIR_FITXER:
                    mostrarBiblioteca();
                    System.out.println();
                    afegirFitxerAlbum(sc, album);
                    break;
                case SM_GA_ELIMINAR_FITXER:
                    mostrarUnAlbum(album);
                    System.out.println();
                    eliminarFitxerAlbum(sc, album);
                    break;
                case SM_GA_MOSTRAR_ALBUM:
                    mostrarUnAlbum(album);
                    break;
                case SM_GA_TORNAR:
                    System.out.println(TORNANT_A + GESTIO_ALBUMS_SEC);
                    break;
            }
            System.out.println();
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
            menuControl.mostrarMenu();

            opcio = menuControl.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case M_C_REPRODUIR_FITXER:
                    mostrarBiblioteca();
                    System.out.println();
                    controlReproduirFitxer(sc);
                    break;
                case M_C_REPRODUIR_BIBLIOTECA:
                    try {
                        ctrl.reproduirCarpeta();
                    } catch (AplicacioException ae) {
                        System.out.println(ae.getMessage());
                    }
                    break;
                case M_C_REPRODUIR_ALBUM:
                    mostrarAlbums();
                    System.out.println();
                    controlReproduirAlbum(sc);
                    break;
                case M_C_ACT_DES_CONTINUA:
                    boolean continua = ctrl.activarDesactivarContinua();
                    if (continua) {
                        System.out.println("Reproduccio continua activada");
                    } else {
                        System.out.println("Reproduccio continua desactivada");
                    }
                    break;
                case M_C_ACT_DES_ALEATORIA:
                    boolean aleatoria = ctrl.activarDesactivarAleatoria();
                    if (aleatoria) {
                        System.out.println("Reproduccio aleatoria activada");
                    } else {
                        System.out.println("Reproduccio aleatoria desactivada");
                    }
                    break;
                case M_C_GESTIO_REPRODUCCIO:
                    gestionarReproduccio(sc);
                    break;
                case M_C_MENU_ANTERIOR:
                    System.out.println(TORNANT_A + MENU_PRINCIPAL_SEC);
                    break;
            }
            System.out.println();
        } while (opcio != OpcionsMenuControl.M_C_MENU_ANTERIOR);
    }

    /**
     * Menú Gestiona Reproducción
     *
     * @param sc
     */
    private void gestionarReproduccio(Scanner sc) {
        Menu<OpcionsSubMenuControl> subMenuControl = new Menu<>(GESTION_REPR_CURSO_SEC, OpcionsSubMenuControl.values());

        subMenuControl.setDescripcions(DESC_SUBMENU_GESTIO_REPRODUCCIO);

        OpcionsSubMenuControl opcio;

        do {
            subMenuControl.mostrarMenu();

            opcio = subMenuControl.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case SM_GR_REEMPREN:
                    try {
                        ctrl.reemprenReproduccio();
                    } catch (AplicacioException ae) {
                        System.out.println(ae.getMessage());
                    }
                    break;
                case SM_GR_PAUSA:
                    try {
                        ctrl.pausaReproduccio();
                    } catch (AplicacioException ae) {
                        System.out.println(ae.getMessage());
                    }
                    break;
                case SM_GR_ATURA:
                    try {
                        ctrl.aturaReproduccio();
                    } catch (AplicacioException ae) {
                        System.out.println(ae.getMessage());
                    }
                    break;
                case SM_GR_SALTA:
                    try {
                        ctrl.saltaReproduccio();
                    } catch (AplicacioException ae) {
                        System.out.println(ae.getMessage());
                    }
                    break;
                case SM_GR_SORTIR:
                    System.out.println(TORNANT_A + CONTROL_REPR_VISIO_SEC);
                    System.out.println();
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
            menuAfegir.mostrarMenu();

            opcio = menuAfegir.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case SM_AFEGIR_VIDEO:
                    afegirVideoBiblioteca(sc);
                    break;
                case SM_AFEGIR_AUDIO:
                    afegirAudioBiblioteca(sc);
                    break;
                case SM_AFEGIR_TORNAR:
                    System.out.println(TORNANT_A + GESTIO_BIBLIOTECA_SEC);
                    break;
            }
            System.out.println();
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
                    mostrarBiblioteca();
                    System.out.println();
                    eliminarFitxer(sc);
                    break;
                case M_GB_TORNAR:
                    System.out.println(TORNANT_A + MENU_PRINCIPAL_SEC);
                    break;
            }
            System.out.println();
        } while (opcio != OpcionsMenuGestioBiblioteca.M_GB_TORNAR);

    }

    /**
     * Menú principal, Función base de la vista para Gestion de la Aplicación.
     * Try-Catch con recursos para cerrar Scanner sin close(), sugerido por
     * Netbeans
     */
    public void gestioAplicacioUB() {

        try (Scanner sc = new Scanner(System.in)) {

            // Para usar '.' en vez de ',' en la terminal
            sc.useLocale(Locale.ENGLISH);

            Menu<OpcionsMenuPrincipal> menu = new Menu<>(MENU_PRINCIPAL_SEC, OpcionsMenuPrincipal.values());

            menu.setDescripcions(DESC_MENU_PRINCIPAL);

            OpcionsMenuPrincipal opcio;

            do {
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
                        guardarDades(sc);
                        break;
                    case MP_RECUPERAR_DADES:
                        cargarDades(sc);
                        break;
                    case MP_SORTIR:
                        System.out.print("Adeu ");
                        break;
                }
            } while (opcio != OpcionsMenuPrincipal.MP_SORTIR);
        }
    }

}
