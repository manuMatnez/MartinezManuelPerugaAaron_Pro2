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
package edu.ub.prog2.MartinezManuelPerugaAaron.controlador;

import edu.ub.prog2.MartinezManuelPerugaAaron.model.Dades;
import edu.ub.prog2.MartinezManuelPerugaAaron.model.Reproductor;
import edu.ub.prog2.utils.AplicacioException;
import java.util.List;

/**
 * Controlador Singleton (para tener solo un objeto de este tipo de controlador,
 * dades y reproductor)
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public class Controlador {

    private Dades dades;
    private final Reproductor reproductor;

    private Controlador() {
        dades = new Dades();
        reproductor = new Reproductor();
    }

    private static class Loader {

        private static final Controlador INSTANCE = new Controlador();
    }

    public static Controlador getInstance() {
        return Loader.INSTANCE;
    }

    /**
     * Retorna si la carpeta está vacía a traves de Dades
     *
     * @return boolean
     */
    public boolean estaBuida() {
        return dades.buida();
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
        dades.afegirFitxer(cami, nomVideo, codec, durada, alcada, amplada, fps, this.reproductor);
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
        dades.afegirFitxer(cami, camiImatge, nomAudio, codec, durada, kbps, this.reproductor);
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

    /**
     * Gestiona el guardado de datos a traves de Dades
     *
     * @param camiDesti
     * @throws AplicacioException
     */
    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        dades.save(camiDesti);
    }

    /**
     * Gestiona el cargado de datos a traves de Dades sobreescribiendo los datos
     * actuales
     *
     * @param camiOrigen
     * @throws AplicacioException
     */
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException {
        this.dades = dades.load(camiOrigen);
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
