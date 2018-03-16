/*
 * Copyright (C) 2018 Manuel Martinez, Aaron Peruga
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
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class AplicacioUB2 {

    private final Controlador ctrl;

    public AplicacioUB2() {
        ctrl = Controlador.getInstance();
    }

    private final static String VERSION = "v2.0";

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

    // SubMenu de Añadir fichero Multimedia a la biblioteca
    private static enum OpcionsMenuAfegir {
        SM_AFEGIR_VIDEO, SM_AFEGIR_AUDIO, SM_AFEGIR_TORNAR
    };

    private static final String[] DESC_MENU_AFEGIR = {"Afegir Video",
        "Afegir Audio",
        "Menu Anterior"};

    private void gestioAfegir(Scanner sc) {
        Menu<OpcionsMenuAfegir> menuAfegir = new Menu<>(DESC_MENU_GESTIO_BIBLIOTECA[0], OpcionsMenuAfegir.values());

        menuAfegir.setDescripcions(DESC_MENU_AFEGIR);

        OpcionsMenuAfegir opcion;

        do {
            menuAfegir.mostrarMenu();
            opcion = menuAfegir.getOpcio(sc);

            switch (opcion) {
                case SM_AFEGIR_VIDEO:
                    System.out.print("hola");
                    //ctrl.afegirVideo(path, nomVideo, codec, 0, 0, 0, 0);
                    break;
                case SM_AFEGIR_AUDIO:
                    //ctrl.afegirAudio(VERSION, VERSION, VERSION, VERSION, 0, 0);
                    break;
                case SM_AFEGIR_TORNAR:
                    System.out.println("Volviendo a >> " + DESC_MENU_PRINCIPAL[0]);
                    break;
            }

        } while (opcion != OpcionsMenuAfegir.SM_AFEGIR_TORNAR);
    }

    private void gestioBiblioteca(Scanner sc) {
        Menu<OpcionsMenuGestioBiblioteca> submenu = new Menu<>(DESC_MENU_PRINCIPAL[0], OpcionsMenuGestioBiblioteca.values());

        submenu.setDescripcions(DESC_MENU_GESTIO_BIBLIOTECA);

        OpcionsMenuGestioBiblioteca op;

        do {
            submenu.mostrarMenu();
            op = submenu.getOpcio(sc);

            switch (op) {
                case SM_GB_AFEGIR_FITXER:
                    gestioAfegir(sc);
                    break;
                case SM_GB_MOSTRAR_BIBLIOTECA:
                    List<String> bibl = ctrl.mostrarBiblioteca();
                    System.out.println("Carpeta de Fitxers:");
                    System.out.println("====================================");

                    if (bibl.isEmpty()) {
                        System.out.println("No hi ha fitxers");
                    } else {
                        bibl.forEach((file) -> {
                            System.out.println(file);
                        });
                    }
                    break;
                case SM_GB_ELIMINAR_FITXER:
                    if (ctrl.estaVacia()) {
                        System.out.println("No hi ha fitxers per esborrar");
                    } else {
                        System.out.println("Num del Fitxer:");
                        int id = sc.nextInt();
                        try {
                            ctrl.esborrarFitxer(id);
                            System.out.println("Fitxer amd id "+ id +" esborrat");
                        } catch (AplicacioException ex) {
                            System.out.println(ex.getMessage());
                        }
                    }
                    break;
                case SM_GB_TORNAR:
                    System.out.println("Volviendo a >> " + MENU_PRINCIPAL);
                    break;
            }

        } while (op != OpcionsMenuGestioBiblioteca.SM_GB_TORNAR);

    }

    public void gestioAplicacioUB() {

        System.out.println("/*************************************************\n"
                + "* Reproductor UB - " + VERSION + " - Grupo C\n"
                + "* Hecho por: Manuel Martinez & Aaron Peruga"
                + "\n**************************************************/\n");

        Scanner sc = new Scanner(System.in);

        Menu<OpcionsMenuPrincipal> menu = new Menu<>(MENU_PRINCIPAL, OpcionsMenuPrincipal.values());

        menu.setDescripcions(DESC_MENU_PRINCIPAL);

        OpcionsMenuPrincipal opcio;

        do {
            menu.mostrarMenu();

            opcio = menu.getOpcio(sc);

            switch (opcio) {

                case MP_GESTION_BIBLIOTECA:
                    gestioBiblioteca(sc);
                    break;
                case MP_GUARDAR_DADES:
                    //TODO
                    break;
                case MP_RECUPERAR_DADES:
                    //TODO
                    break;
                case MP_SORTIR:
                    System.out.println("Adeu!!");
                    break;

            }
        } while (opcio != OpcionsMenuPrincipal.MP_SORTIR);
    }

}
