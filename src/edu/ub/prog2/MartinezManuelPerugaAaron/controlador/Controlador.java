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
    /**
     * Retorna si la carpeta está vacía a traves de Dades
     *
     * @return boolean
     */
    public boolean estaVacia() {
        return dades.vacia();
    }

    /**
     * Añade a la Biblioteca Multimedia un video a traves de Dades
     *
     * @param cami
     * @param nomVideo
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @throws AplicacioException
     */
    public void afegirVideo(String cami, String nomVideo, String codec,
            float durada, int alcada, int amplada, float fps) throws AplicacioException {
        dades.afegirNouVideo(cami, nomVideo, codec, durada, alcada, amplada, fps);
    }

    /**
     * Añade a la Biblioteca Multimedia un audio a traves de Dades
     *
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param codec
     * @param durada
     * @param kbps
     * @throws AplicacioException
     */
    public void afegirAudio(String cami, String camiImatge, String nomAudio,
            String codec, float durada, int kbps) throws AplicacioException {
        dades.afegirNouAudio(cami, camiImatge, nomAudio, codec, durada, kbps);
    }

    /**
     * Retorna una Lista de los toString() de los ficheros a traves de Dades
     *
     * @return List
     */
    public List<String> mostrarBiblioteca() { // llista dels retorns de toString() dels fitxers
        return dades.getBibliotecaList();
    }

    /**
     * Gestiona la eliminación de un fichero a traves de Dades
     *
     * @param id
     * @throws AplicacioException
     */
    public void esborrarFitxer(int id) throws AplicacioException {
        dades.deleteFitxer(id);
    }

    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        //TODO
    }

    public void carregarDadesDisc(String camiOrigen) throws AplicacioException {
        //TODO
    }

    /**
     * Comprueba si el fixhero existe a traves de Dades
     *
     * @param cami
     * @throws AplicacioException
     */
    public void checkExist(String cami) throws AplicacioException {
        dades.verify(cami);
    }

}
