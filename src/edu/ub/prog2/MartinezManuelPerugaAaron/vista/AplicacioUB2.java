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
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * AplicacioUB2 - Vista
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public class AplicacioUB2 {

    private final Controlador ctrl;

    public AplicacioUB2() {
        ctrl = Controlador.getInstance();
    }

    private static final String MENU_PRINCIPAL = "Menu Principal";

    // Menú Principal
    private static enum OpcionsMenuPrincipal {
        MP_GESTION_BIBLIOTECA, MP_GUARDAR_DADES, MP_RECUPERAR_DADES, MP_SORTIR
    };

    private static final String[] DESC_MENU_PRINCIPAL = {"Gestió Biblioteca",
        "Guardar Dades",
        "Recuperar Dades",
        "Sortir"};

    // SubMenu de Gestión de Biblioteca
    private static enum OpcionsMenuGestioBiblioteca {
        SM_GB_AFEGIR_FITXER, SM_GB_MOSTRAR_BIBLIOTECA, SM_GB_ELIMINAR_FITXER, SM_GB_TORNAR
    };

    private static final String[] DESC_MENU_GESTIO_BIBLIOTECA = {"Afegir fitxer multimedia a la biblioteca",
        "Mostrar Biblioteca",
        "Elimina fitxer multimédia",
        "Menu Anterior"};

    private static final String CARPETA_FITXERS_TITLE = "Carpeta de Fitxers:\n"
            + String.join("", Collections.nCopies(35, "-"));

    // SubMenu de Añadir fichero Multimedia a la biblioteca
    private static enum OpcionsMenuAfegir {
        SM_AFEGIR_VIDEO, SM_AFEGIR_AUDIO, SM_AFEGIR_TORNAR
    };

    private static final String[] DESC_MENU_AFEGIR = {"Afegir Video",
        "Afegir Audio",
        "Menu Anterior"};

    /**
     * Pide los datos para poder crear un fichero de video
     *
     * @param sc
     */
    private void writeVideo(Scanner sc) {
        System.out.println("Ruta del Fitxer:");
        String cami = sc.nextLine();
        try {
            ctrl.checkExist(cami);

            System.out.println("Descripcio del Fitxer:");
            String desc = sc.nextLine();

            System.out.println("Codec:");
            String codec = sc.nextLine();

            System.out.println("Durada:");
            float durada = sc.nextFloat();

            System.out.println("Alcada:");
            int alcada = sc.nextInt();

            System.out.println("Amplada:");
            int amplada = sc.nextInt();

            System.out.println("Frames per Second:");
            float fps = sc.nextFloat();

            ctrl.afegirVideo(cami, codec, codec, durada, alcada, amplada, fps);

            System.out.println("Fitxer afegit");

        } catch (AplicacioException ae) {
            //System.err.println(ae.getMessage()); Salida de error
            System.out.println(ae.getMessage());
        }
    }

    /**
     * Pide los datos para poder crear un fichero de audio
     *
     * @param sc
     */
    private void writeAudio(Scanner sc) {
        System.out.println("Ruta del Fitxer:");
        String cami = sc.nextLine();
        try {
            ctrl.checkExist(cami);

            System.out.println("Ruta de la imatge del Fitxer:");
            String imatgeFitxer = sc.nextLine();

            ctrl.checkExist(imatgeFitxer);

            System.out.println("Descripcio del Fitxer:");
            String desc = sc.nextLine();

            System.out.println("Codec:");
            String codec = sc.nextLine();

            System.out.println("Durada:");
            float durada = sc.nextFloat();

            System.out.println("Kbps:");
            int kbps = sc.nextInt();

            ctrl.afegirAudio(cami, imatgeFitxer, desc, codec, durada, kbps);

            System.out.println("Fitxer afegit");

        } catch (AplicacioException ae) {
            //System.err.println(ae.getMessage()); Salida de error
            System.out.println(ae.getMessage());
        }
    }

    private void saveFile(Scanner sc) {
        System.out.println("Ruta completa amb el nom:");
        String cami = sc.nextLine();
        try {
            ctrl.guardarDadesDisc(cami);

            System.out.println("Dades emmagatzemades!!");

        } catch (AplicacioException ae) {
            //System.err.println(ae.getMessage()); Salida de error
            System.out.println(ae.getMessage());
        }
    }

    private void loadFile(Scanner sc) {
        System.out.println("Ruta completa amb el nom:");
        String cami = sc.nextLine();
        try {
            ctrl.carregarDadesDisc(cami);

            System.out.println("Dades carregades!!");

        } catch (AplicacioException ae) {
            //System.err.println(ae.getMessage()); Salida de error
            System.out.println(ae.getMessage());
        }
    }

    private void gestioAfegir(Scanner sc) {
        Menu<OpcionsMenuAfegir> menuAfegir = new Menu<>(DESC_MENU_GESTIO_BIBLIOTECA[0], OpcionsMenuAfegir.values());

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
                    System.out.println("Tornant a >> " + DESC_MENU_PRINCIPAL[0]);
                    break;
            }

        } while (opcio != OpcionsMenuAfegir.SM_AFEGIR_TORNAR);
    }

    private void gestioBiblioteca(Scanner sc) {
        Menu<OpcionsMenuGestioBiblioteca> subMenu = new Menu<>(DESC_MENU_PRINCIPAL[0], OpcionsMenuGestioBiblioteca.values());

        subMenu.setDescripcions(DESC_MENU_GESTIO_BIBLIOTECA);

        OpcionsMenuGestioBiblioteca opcio;

        do {
            System.out.println();

            subMenu.mostrarMenu();

            opcio = subMenu.getOpcio(sc);

            System.out.println();

            switch (opcio) {
                case SM_GB_AFEGIR_FITXER:
                    gestioAfegir(sc);
                    break;
                case SM_GB_MOSTRAR_BIBLIOTECA:
                    List<String> bibl = ctrl.mostrarBiblioteca();
                    System.out.println(CARPETA_FITXERS_TITLE);

                    if (bibl.isEmpty()) {
                        System.out.println("No hi ha fitxers");
                    } else {
                        bibl.forEach((file) -> {
                            System.out.println(file);
                        });
                    }
                    break;
                case SM_GB_ELIMINAR_FITXER:
                    if (ctrl.estaBuida()) {
                        System.out.println("No hi ha fitxers per esborrar");
                    } else {
                        System.out.println("ID del Fitxer:");
                        int id = sc.nextInt();
                        try {
                            ctrl.esborrarFitxer(id);
                            System.out.println("Fitxer amd id " + id + " esborrat");
                        } catch (AplicacioException ae) {
                            //System.err.println(ae.getMessage()); Salida de error
                            System.out.println(ae.getMessage());
                        }
                    }
                    break;
                case SM_GB_TORNAR:
                    System.out.println("Tornant a >> " + MENU_PRINCIPAL);
                    break;
            }

        } while (opcio != OpcionsMenuGestioBiblioteca.SM_GB_TORNAR);

    }

    public void gestioAplicacioUB() {

        Scanner sc = new Scanner(System.in);

        Menu<OpcionsMenuPrincipal> menu = new Menu<>(MENU_PRINCIPAL, OpcionsMenuPrincipal.values());

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
                case MP_GUARDAR_DADES:
                    saveFile(sc);
                    break;
                case MP_RECUPERAR_DADES:
                    loadFile(sc);
                    break;
                case MP_SORTIR:
                    System.out.println("Adeu!!");
                    break;

            }
        } while (opcio != OpcionsMenuPrincipal.MP_SORTIR);
    }

}
