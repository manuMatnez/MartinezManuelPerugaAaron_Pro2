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
package edu.ub.prog2.MartinezManuelPerugaAaron.model;

import edu.ub.prog2.utils.AplicacioException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class BibliotecaFitxersMultimedia extends CarpetaFitxers {

    public BibliotecaFitxersMultimedia() {
    }
    
    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public String freeSpace() {
        return "Sin limite";
    }

    @Override
    public String toString() {
        return "BibliotecaFitxersMultimedia{" + '}';
    }
    
    
    
    
    
    

}
