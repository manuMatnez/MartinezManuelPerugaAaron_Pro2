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

import static edu.ub.prog2.MartinezManuelPerugaAaron.vista.IniciadorAplicacioUB.isMac;
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
    private final Reproductor reproductor;

    public Dades() {
        biblioteca = new BibliotecaFitxersMultimedia();
        if (isMac()) {
            reproductor = new Reproductor("/Application/VLC.app");
        } else {
            reproductor = new Reproductor();
        }
    }

    /**
     * Retorna la lista de ficheros multimedia en lista de Strings
     *
     * @return List
     */
    public List<String> getBibliotecaList() {
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
            throw new AplicacioException("La posició no pot ser mès gran que: "
                    + listaFicheros.size());
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

    /**
     * Comprueba que el fichero existe, si no existe lanza excepción
     *
     * @param cami
     * @throws AplicacioException
     */
    public void verify(String cami) throws AplicacioException {
        File tmp = new File(cami);
        if (!tmp.exists()) {
            throw new AplicacioException("El fitxer " + tmp.getName() + " no existeix");
        }
    }

    /**
     * Añade un nuevo video a la Biblioteca Multimedia
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
    public void afegirNouVideo(String cami, String nomVideo, String codec,
            float durada, int alcada, int amplada, float fps) throws AplicacioException {
        //TODO consultar
        Video video = new Video(cami, nomVideo, codec, durada, alcada, amplada, fps, reproductor);
        biblioteca.addFitxer(video);
    }

    /**
     * Añade un nuevo audio a la Biblioteca Multimedia
     *
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param codec
     * @param durada
     * @param kbps
     * @throws AplicacioException
     */
    public void afegirNouAudio(String cami, String camiImatge, String nomAudio,
            String codec, float durada, int kbps) throws AplicacioException {
        //TODO consultar
        Audio audio = new Audio(cami, new File(camiImatge), nomAudio, codec, durada, kbps, reproductor);
    }

}
