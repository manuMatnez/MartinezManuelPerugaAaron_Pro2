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

import edu.ub.prog2.MartinezManuelPerugaAaron.model.CarpetaFitxers;
import edu.ub.prog2.MartinezManuelPerugaAaron.model.FitxerMultimedia;
import edu.ub.prog2.MartinezManuelPerugaAaron.model.exception.FitxersException;
import edu.ub.prog2.utils.Menu;
import java.util.Scanner;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class AplicacioUB1 {
    
    private static enum OpcionsMenuPrincipal {MENU_PRINCIPAL_OPCIO1,MENU_PRINCIPAL_OPCIO2,MENU_PRINCIPAL_OPCIO3,MENU_PRINCIPAL_SORTIR};
    
    private static String[] descMenuPrincipal={"Afegir fitxer multimèdia",
                                               "Eliminar fitxer multimèdia",
                                               "Mostrar carpeta",
                                               "Sortir"};
    
    public void gestioAplicacioUB() {
        
        Scanner sc = new Scanner(System.in);
        
        CarpetaFitxers carpeta;
        
        // try catch por si se ponen numeros no validos de capacidad
        try {
            carpeta = new CarpetaFitxers(100);
            } catch (FitxersException fe) {
                System.out.println(fe.getMessage());
                System.out.println("Valor per defecte: 100");
                carpeta = new CarpetaFitxers();
        }
        
        Menu<OpcionsMenuPrincipal> menu = new Menu<>("Reproductor UB"
                + " - Menu Principal - v1.0",OpcionsMenuPrincipal.values());

        menu.setDescripcions(descMenuPrincipal);

        OpcionsMenuPrincipal opcio;
        
        do {
            menu.mostrarMenu();

            opcio = menu.getOpcio(sc);

            switch(opcio) {
                case MENU_PRINCIPAL_OPCIO1:
                    if(carpeta.isFull()) {
                        System.out.println("Carpeta plena");
                    } else {
                        System.out.println("Ruta del Fitxer:");
                        String ruta = sc.nextLine();
                        
                        FitxerMultimedia fitxer;
                        
                        try {
                            fitxer = new FitxerMultimedia(ruta);
                    
                            if (fitxer.exists()) {
                                
                                System.out.println("Descripcio del Fitxer:");
                                String desc = sc.nextLine();
                                
                                // Setteando fitxer
                                fitxer.setDescripcio(desc);

                                carpeta.addFitxer(fitxer);
                            } else {
                                throw new FitxersException("No existeix el fitxer");
                            }
                        } catch (FitxersException cf) {
                            System.out.println(cf.getMessage());
                        }
                    }
                    
                    break;
                case MENU_PRINCIPAL_OPCIO2:
                    if(carpeta.getSize() == 0) {
                        System.out.println("La carpeta esta vacia");
                    } else {
                        System.out.println("Num del Fitxer:");
                        int pos = sc.nextInt();
                        FitxerMultimedia file;
                        try {
                            file = (FitxerMultimedia)carpeta.getAt(pos);
                            carpeta.removeFitxer(file);
                            System.out.println("Eliminado -> "+ file.getName());
                        } catch (IndexOutOfBoundsException iob) {
                            if (pos < 1) {
                                System.out.println("La posició começa amb 1");
                            } else if (pos > carpeta.getSize()) {
                                System.out.println("La posició no pot ser mes gran que: " + carpeta.getSize());
                            } else {
                                System.out.println("No hi ha fitxer en aquesta posicio");
                            }
                        }
                    }
                    break;
                case MENU_PRINCIPAL_OPCIO3:
                    System.out.println(carpeta);
                    break;
                
                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Adeu!");
                    break;
            }

        } while(opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    }
    
}
