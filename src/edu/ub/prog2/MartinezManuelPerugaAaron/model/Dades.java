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
import java.util.List;

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
     * Retorna la lista de ficheros multimedia en lista de Strings
     *
     * @return List
     */
    public List<String> getBiblioteca() {
        List<String> biblio = new ArrayList<>();
        int id = 1;
        for (File file : this.biblioteca.getCarpeta()) {
            biblio.add("[" + id + "] " + file.toString());
            id++;
        }
        return biblio;
    }

    /**
     * Borra un fichero de la biblioteca de ficheros
     *
     * @param id
     * @throws AplicacioException
     */
    public void deleteFitxer(int id) throws AplicacioException {
        id--;
        List<File> listaFicheros = this.biblioteca.getCarpeta();
        if (id < 0) {
            throw new AplicacioException("La posició começa amb 1");
        } else if (id > listaFicheros.size()) {
            throw new AplicacioException("La posició no pot ser mes gran que: " + listaFicheros.size());
        } else {
            FitxerMultimedia file = (FitxerMultimedia) biblioteca.getAt(id);
            biblioteca.removeFitxer(file);
        }
    }

    /**
     * Retorna si la carpeta está vacía
     *
     * @return boolean
     */
    public boolean vacia() {
        return this.biblioteca.getCarpeta().isEmpty();
    }
    
    //TODO toString()

}
