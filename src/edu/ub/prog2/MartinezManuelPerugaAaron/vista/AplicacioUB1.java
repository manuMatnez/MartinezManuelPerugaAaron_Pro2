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
        
        CarpetaFitxers carpeta = new CarpetaFitxers();
        
        Scanner sc = new Scanner(System.in);
        
        Menu<OpcionsMenuPrincipal> menu = new Menu<OpcionsMenuPrincipal>("Menu Principal",OpcionsMenuPrincipal.values());

        menu.setDescripcions(descMenuPrincipal);

        OpcionsMenuPrincipal opcio;
        
        do {
            menu.mostrarMenu();

            opcio = menu.getOpcio(sc);

            switch(opcio) {
                case MENU_PRINCIPAL_OPCIO1:
                    System.out.println("Ruta del Fitxer:");
                    String ruta = sc.nextLine();
                    System.out.println("Descripcio del Fitxer:");
                    String desc = sc.nextLine();
                    
                    FitxerMultimedia fitxer = new FitxerMultimedia(ruta);
                    fitxer.setDescripcio(desc);
                    carpeta.addFitxer(fitxer);
                    
                    break;
                case MENU_PRINCIPAL_OPCIO2:
                    System.out.println("num del Fitxer:");
                    int n = sc.nextInt();
                    carpeta.removeFitxer(carpeta.getAt(n-1));
                    break;
                case MENU_PRINCIPAL_OPCIO3:
                    System.out.println(carpeta);
                    break;
                
                case MENU_PRINCIPAL_SORTIR:
                    System.out.println("Fins aviat!");
                    break;
            }

        } while(opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    }
    
}
