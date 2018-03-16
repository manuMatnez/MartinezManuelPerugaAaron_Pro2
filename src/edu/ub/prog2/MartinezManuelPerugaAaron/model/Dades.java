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
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class Dades {

    private final BibliotecaFitxersMultimedia biblioteca;

    public Dades() {
        biblioteca = new BibliotecaFitxersMultimedia();
    }

    /**
     * Retorna la lista de ficheros multimedia
     *
     * @return ArrayList
     */
    public ArrayList<File> getBiblioteca() {
        return biblioteca.getCarpeta();
    }

    /**
     * Borra un fichero de la biblioteca de ficheros
     *
     * @param id
     */
    public void deleteFitxer(int id) {
        FitxerMultimedia file = (FitxerMultimedia) biblioteca.getAt(id);
        biblioteca.removeFitxer(file);

    }

}
