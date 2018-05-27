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

import edu.ub.prog2.MartinezManuelPerugaAaron.controlador.Reproductor;
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
import java.util.Iterator;
import java.util.List;

/**
 * Dades - Modelo
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 3.0
 */
public class Dades implements Serializable {

    private final BibliotecaFitxersMultimedia biblioteca;
    private final List<AlbumFitxersMultimedia> albums;

    private boolean reproduccioCiclica, reproduccioAleatoria;

    public Dades() {
        biblioteca = new BibliotecaFitxersMultimedia();
        albums = new ArrayList<>();
        reproduccioCiclica = false;
        reproduccioAleatoria = false;
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
            bibList = new ArrayList<>(); // lista biblioBuida
        } else {
            String[] bibToStrArr = bibToStr.split("\n"); // Array de Strings (Lineas)
            bibList = new ArrayList<>(Arrays.asList(bibToStrArr));
        }
        return bibList;
    }

    /**
     * Retorna si la carpeta está vacía
     *
     * @return boolean
     */
    public boolean biblioBuida() {
        return this.biblioteca.getSize() == 0;
    }

    /**
     * Comprueba que el fichero existe, si no existe lanza excepción
     *
     * @param cami
     * @throws AplicacioException
     */
    public void comprovaExistenciaFitxer(String cami) throws AplicacioException {
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
     * Borra un fichero de la biblioteca de ficheros También borrara de todos
     * los albums (Práctica 3)
     *
     * @param id
     * @throws AplicacioException
     */
    public void esborrarFitxer(int id) throws AplicacioException {
        if (biblioBuida()) {
            throw new AplicacioException("No hi ha fitxers per eliminar");
        }
        try {
            FitxerMultimedia file = (FitxerMultimedia) biblioteca.getAt(id);
            biblioteca.removeFitxer(file);

            // PRACTICA 3
            albums.forEach((album) -> {
                while (album.contains(file)) {
                    album.removeFitxer(file);
                }
            });
        } catch (IndexOutOfBoundsException io) {
            throw new AplicacioException("Id de fitxer incorrecte");
        }

    }

    /**
     * Guarda todos los datos del programa en un archivo. Usando Try-Catch con
     * recursos no hace falta usar finally ni .close(), ya que sirve para las
     * clases que implementan Closeable
     *
     * @param camiDesti
     * @throws AplicacioException
     */
    public void guardarDades(String camiDesti) throws AplicacioException {
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
     * @return Dades
     * @throws AplicacioException
     */
    public static Dades carregarDades(String camiOrigen) throws AplicacioException {
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

    // PRACTICA 3
    //********************************************************************
    // Getters y Setters START
    public boolean isReproduccioCiclica() {
        return reproduccioCiclica;
    }

    public boolean isReproduccioAleatoria() {
        return reproduccioAleatoria;
    }

    public void setReproduccioCiclica(boolean reproduccioCiclica) {
        this.reproduccioCiclica = reproduccioCiclica;
    }

    public void setReproduccioAleatoria(boolean reproduccioAleatoria) {
        this.reproduccioAleatoria = reproduccioAleatoria;
    }
    // Getters y Setters END

    /**
     * Borra un album existente
     *
     * @param titol
     * @throws AplicacioException
     */
    public void esborrarUnAlbum(String titol) throws AplicacioException {
        albums.remove(getAlbumByTitle(titol));
    }

    /**
     * Añade un nuevo album
     *
     * @param titol
     * @param size
     * @throws AplicacioException
     */
    public void afegirAlbum(String titol, int size) throws AplicacioException {
        if (existeixAlbum(titol)) {
            throw new AplicacioException("Ya existeix aquest album");
        }
        if (titol.isEmpty() || titol.startsWith(" ")) {
            throw new AplicacioException("Titol no valid");
        }
        albums.add(new AlbumFitxersMultimedia(size, titol));
    }

    /**
     * Comprueba si existe un album
     *
     * @param titol
     * @return boolean
     */
    public boolean existeixAlbum(String titol) {
        AlbumFitxersMultimedia nouAlbum = new AlbumFitxersMultimedia(titol);
        return albums.contains(nouAlbum);
    }

    /**
     * Retorna la lista de albums
     *
     * @return List
     */
    public List<String> albumListToString() {
        List<String> albumList = new ArrayList<>(albums.size());
        Iterator<AlbumFitxersMultimedia> albumIt = albums.iterator();
        int id = 1;
        while (albumIt.hasNext()) {
            StringBuilder sb = new StringBuilder();
            AlbumFitxersMultimedia currentAlbum = albumIt.next();
            sb.append(currentAlbum.getTitol())
                    .append(" (spai lliure: ").append(currentAlbum.freeSpace()).append(")");
            albumList.add(sb.toString());
            id++;
        }
        return albumList;
    }

    /**
     * Retorna la lista de ficheros multimedia en lista de Strings
     *
     * @param titol
     * @return List
     * @throws AplicacioException
     */
    public List<String> albumToString(String titol) throws AplicacioException {
        List<String> albumList;
        String albumToStr = getAlbumByTitle(titol).toString();

        if (albumToStr.isEmpty()) {
            albumList = new ArrayList<>(); // lista biblioBuida
        } else {
            String[] albumToStrArr = albumToStr.split("\n"); // Array de Strings (Lineas)
            albumList = new ArrayList<>(Arrays.asList(albumToStrArr));
        }
        return albumList;
    }

    /**
     * Añade un fichero al Album seleccionado
     *
     * @param titolAlbum
     * @param id
     * @throws AplicacioException
     */
    public void afegirFitxerAlbum(String titolAlbum, int id) throws AplicacioException {
        if (biblioBuida()) {
            throw new AplicacioException("No hi ha fitxers a la biblioteca");
        }
        try {
            FitxerMultimedia file = (FitxerMultimedia) biblioteca.getAt(id);
            getAlbumByTitle(titolAlbum).addFitxer(file);
        } catch (IndexOutOfBoundsException io) {
            throw new AplicacioException("Id de fitxer incorrecte");
        }
    }

    /**
     * Borra un fichero del album seleccionado
     *
     * @param titol
     * @param id
     * @throws AplicacioException
     */
    public void esborrarFitxerAlbum(String titol, int id) throws AplicacioException {
        try {
            AlbumFitxersMultimedia album = getAlbumByTitle(titol);
            if (album.getSize() == 0) {
                throw new AplicacioException("No hi ha fitxers en aquest album");
            }
            FitxerMultimedia file = (FitxerMultimedia) album.getAt(id);
            album.removeFitxer(file);
        } catch (IndexOutOfBoundsException io) {
            throw new AplicacioException("Id de fitxer incorrecte");
        }
    }

    /**
     * Asigna el reproductor a cada fichero
     *
     * @param reproductor
     */
    public void setReproductor(Reproductor reproductor) {
        for (int i = 0; i < biblioteca.getSize(); i++) {
            File fitxer = biblioteca.getAt(i);
            if (fitxer instanceof FitxerReproduible) {
                ((FitxerReproduible) fitxer).setReproductor(reproductor);
            }
        }
    }

    /**
     * Retorna una CarpetaFitxers con un solo fichero
     *
     * @param id
     * @return
     * @throws AplicacioException
     */
    public CarpetaFitxers getCarpetaReproduccio(int id) throws AplicacioException {
        if (biblioBuida()) {
            throw new AplicacioException("No hi ha fitxers a la biblioteca");
        }
        try {
            CarpetaFitxers tmp = new CarpetaFitxers(1);
            tmp.addFitxer(biblioteca.getAt(id));
            return tmp;
        } catch (IndexOutOfBoundsException io) {
            throw new AplicacioException("Id de fitxer incorrecte");
        }
    }

    /**
     * Retorna la biblioteca
     *
     * @return CarpetaFitxer
     * @throws AplicacioException
     */
    public CarpetaFitxers getCarpetaReproduccio() throws AplicacioException {
        if (biblioBuida()) {
            throw new AplicacioException("No hi ha fitxers a la biblioteca");
        }
        return biblioteca;
    }

    /**
     * Retorna el album seleccionado
     *
     * @param titol
     * @return CarpetaFitxer
     * @throws AplicacioException
     */
    public CarpetaFitxers getCarpetaReproduccio(String titol) throws AplicacioException {
        AlbumFitxersMultimedia album = getAlbumByTitle(titol);
        if (album.getSize() == 0) {
            throw new AplicacioException("No hi ha fitxers en aquest album");
        }
        return album;
    }

    /**
     * Obtiene el título de un album
     *
     * @param id
     * @return
     * @throws AplicacioException
     */
    public String getTitolAlbum(int id) throws AplicacioException {
        if (albums.isEmpty()) {
            throw new AplicacioException("No hi ha albums");
        }
        try {
            return albums.get(id).getTitol();
        } catch (IndexOutOfBoundsException io) {
            throw new AplicacioException("Id del album incorrecte");
        }
    }

    public AlbumFitxersMultimedia getAlbumByTitle(String title) throws AplicacioException {
        AlbumFitxersMultimedia albumTmp = new AlbumFitxersMultimedia(title);
        int albumIndex = albums.indexOf(albumTmp);
        if (albumIndex == -1) {
            throw new AplicacioException("No existeix aquest album");
        }
        return albums.get(albumIndex);
    }

}
