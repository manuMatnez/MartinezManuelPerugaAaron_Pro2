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

import edu.ub.prog2.utils.Menu;
import java.util.Scanner;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class AplicacioUB2 {
    
    private static enum OpcionsMenuPrincipal {
        MENU_PRINCIPAL_OPCIO1, MENU_PRINCIPAL_OPCIO2, MENU_PRINCIPAL_OPCIO3, MENU_PRINCIPAL_SORTIR
    };
    
    private static enum OpcionsSubmenu {
        SUBMENU_OPCIO1,  SUBMENU_OPCIO2,  SUBMENU_OPCIO3,  SUBMENU_SORTIR
    };
    
    private static enum OpcionsMenuAfegir {
        MENU_OPCIO1, MENU_OPCIO2,  MENU_SORTIR
    };
    

    private static String[] descMenuPrincipal = {"Gestió Biblioteca ",
        " Guardar dades ",
        " Recuperar dades ",
        " Sortir "};
    
    private static String[] descSubmenu = {"Afegir fitxer Multimedia a la biblioteca ",
        " Mostrar Biblioteca ",
        " Elimina Fitxer Multimédia ",
        " Menu Anterior "};
    
    private static String[] descMenuAfegir= {"Afegir Video",
        " Afegir Audio ",
        " Menu Anterior "};
    
    
    public void gestioAplicacioUB() {
        
        Scanner sc = new Scanner(System.in);
        
        Menu<OpcionsMenuPrincipal> menu = new Menu<>("Reproductor UB"
                + " - Menu Principal - v1.0", OpcionsMenuPrincipal.values());

        menu.setDescripcions(descMenuPrincipal);

        OpcionsMenuPrincipal opcio;
        
        do{
            menu.mostrarMenu();
            
            opcio = menu.getOpcio(sc);
            
            switch(opcio){
                
                case MENU_PRINCIPAL_OPCIO1:
                    
                    Menu<OpcionsSubmenu> submenu = new Menu<>("Reproductor UB"
                + " - Menu Gestió Biblioteca", OpcionsSubmenu.values());
                    
                    submenu.setDescripcions(descSubmenu);
                    
                    OpcionsSubmenu op;
                    
                    do{
                        submenu.mostrarMenu();
                        op = submenu.getOpcio(sc);
                        
                        switch(op){
                            case SUBMENU_OPCIO1:
                                Menu<OpcionsMenuAfegir> menuAfegir = new Menu<>("Reroductor UB"
                                + " - Menu Afegir Fitxer Multimedia", OpcionsMenuAfegir.values());
                                
                                menuAfegir.setDescripcions(descMenuAfegir);
                                
                                OpcionsMenuAfegir opcion;
                                
                                do{
                                    menuAfegir.mostrarMenu();
                                    opcion = menuAfegir.getOpcio(sc);
                                    
                                    switch(opcion){
                                        case MENU_OPCIO1:break;
                                        case MENU_OPCIO2:break;
                                        case MENU_SORTIR:break;
                                    }
                                    
                                }while(opcion != OpcionsMenuAfegir.MENU_SORTIR);
                                break;
                        }
                        
                    }while(op != OpcionsSubmenu.SUBMENU_SORTIR);
                    
                    break;
                case MENU_PRINCIPAL_OPCIO2: break;
                case MENU_PRINCIPAL_OPCIO3: break;
                case MENU_PRINCIPAL_SORTIR: 
                    System.out.println("Adeu!!");
                    break;
                  
            }   
        }while(opcio != OpcionsMenuPrincipal.MENU_PRINCIPAL_SORTIR);
    }

}
