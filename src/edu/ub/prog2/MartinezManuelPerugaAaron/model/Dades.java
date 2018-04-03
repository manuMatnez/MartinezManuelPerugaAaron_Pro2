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
package edu.ub.prog2.MartinezManuelPerugaAaron.model;

import edu.ub.prog2.utils.AplicacioException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dades - Modelo
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public class Dades implements Serializable {

    private final BibliotecaFitxersMultimedia biblioteca;

    public Dades() {
        biblioteca = new BibliotecaFitxersMultimedia();
    }

    /**
     * Retorna la lista de ficheros multimedia en lista de Strings
     *
     * @return List
     */
    public List<String> getBibliotecaList() {
        List<String> bibList;
        String bibToStr = this.biblioteca.toString();

        if (bibToStr.isEmpty()) {
            bibList = new ArrayList<>(); // lista buida
        } else {
            String[] bibToStrArr = bibToStr.split("\n"); // Array de Strings (Lineas)
            bibList = new ArrayList<>(Arrays.asList(bibToStrArr));
        }
        return bibList;
    }

    /**
     * Borra un fichero de la biblioteca de ficheros
     *
     * @param id
     * @throws AplicacioException
     */
    public void deleteFitxer(int id) throws AplicacioException {
        id--;
        int size = this.biblioteca.getSize();
        if (id < 0) {
            throw new AplicacioException("La posició começa amb 1");
        } else if (id > size) {
            throw new AplicacioException("La posició no pot ser mès gran que: "
                    + size);
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
    public boolean buida() {
        return this.biblioteca.getSize() == 0;
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
     * @param r
     * @throws AplicacioException
     */
    public void afegirFitxer(String cami, String nomVideo, String codec,
            float durada, int alcada, int amplada, float fps, Reproductor r) throws AplicacioException {
        Video video = new Video(cami, nomVideo, codec, durada, alcada, amplada, fps, r);
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
     * @param r
     * @throws AplicacioException
     */
    public void afegirFitxer(String cami, String camiImatge, String nomAudio,
            String codec, float durada, int kbps, Reproductor r) throws AplicacioException {
        Audio audio = new Audio(cami, new File(camiImatge), nomAudio, codec, durada, kbps, r);
        biblioteca.addFitxer(audio);
    }

    /**
     * Guarda todos los datos del programa en un archivo. Usando Try-Catch con
     * recursos no hace falta usar finally ni .close(), ya que sirve para las
     * clases que implementan Closeable
     *
     * @param camiDesti
     * @throws AplicacioException
     */
    public void save(String camiDesti) throws AplicacioException {
        File savedFile = new File(camiDesti);
        try (FileOutputStream fout = new FileOutputStream(savedFile);
                ObjectOutputStream oos = new ObjectOutputStream(fout)) {
            oos.writeObject(this);
            oos.flush();
        } catch (IOException ex) {
            throw new AplicacioException("No es pot guardar el fitxer");
        }
    }

    /**
     * Carga todos los datos del programa en un archivo, para sobreescribir
     * Dades. Usando Try-Catch con recursos no hace falta usar finally ni
     * .close(), ya que sirve para las clases que implementan Closeable
     *
     * @param camiOrigen
     * @return
     * @throws AplicacioException
     */
    public Dades load(String camiOrigen) throws AplicacioException {
        File loadFile = new File(camiOrigen);
        Dades dades;
        if (!loadFile.exists()) {
            throw new AplicacioException("No existeix el fixter de dades");
        } else {
            try (FileInputStream fis = new FileInputStream(loadFile);
                    ObjectInputStream ois = new ObjectInputStream(fis)) {
                dades = (Dades) ois.readObject();
            } catch (IOException ex) {
                throw new AplicacioException("No es pot carregar o no existeix el fitxer");
            } catch (ClassNotFoundException ex) {
                throw new AplicacioException("Error amb les dades");
            }
            return dades;
        }
    }

}
