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
package edu.ub.prog2.MartinezManuelPerugaAaron.controlador;

import edu.ub.prog2.MartinezManuelPerugaAaron.model.Dades;
import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class Controlador {

    private final Dades dades;

    private Controlador() {
        dades = new Dades();
    }

    private static class Loader {

        private static final Controlador INSTANCE = new Controlador();
    }

    public static Controlador getInstance() {
        return Loader.INSTANCE;
    }

    // Controlador
    public void afegirVideo(String path, String nomVideo, String codec,
            float durada, int alcada, int amplada, float fps) throws AplicacioException {
    }

    public void afegirAudio(String cami, String camiImatge, String nomAudio, String codec, float durada, int kbps) throws AplicacioException {
    }

    /**
     * Retorna una Lista de los toString() de los ficheros
     *
     * @return List
     */
    public List<String> mostrarBiblioteca() { // llista dels retorns de toString() dels fitxers
        List<String> bibl = new ArrayList<>();
        int id = 1;
        for (File file : dades.getBiblioteca()) {
            bibl.add("[" + id + "] " + file.toString());
            id++;
        }
        return bibl;
    }

    /**
     * Gestiona la eliminación de un fichero
     *
     * @param id
     * @throws AplicacioException
     */
    public void esborrarFitxer(int id) throws AplicacioException {
        id--;
        List<File> listaFicheros = dades.getBiblioteca();
        if (id < 0) {
            throw new AplicacioException("La posició começa amb 1");
        } else if (id > listaFicheros.size()) {
            throw new AplicacioException("La posició no pot ser mes gran que: " + listaFicheros.size());
        } else {
            dades.deleteFitxer(id);
        }
    }

    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
    }

    public void carregarDadesDisc(String camiOrigen) throws AplicacioException {
    }

}
