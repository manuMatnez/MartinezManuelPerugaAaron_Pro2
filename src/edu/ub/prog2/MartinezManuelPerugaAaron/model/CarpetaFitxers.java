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
import edu.ub.prog2.utils.InFileFolder;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * CarpetaFitxers - Modelo
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 3.0
 */
public class CarpetaFitxers implements InFileFolder, Serializable {

    // capacidad máxima de la carpeta
    private int capacity;

    private ArrayList<FitxerMultimedia> carpeta;

    public CarpetaFitxers() {
        capacity = 10;
        carpeta = new ArrayList<>();
    }

    public CarpetaFitxers(int cap) throws AplicacioException {
        if (cap < 1) {
            throw new AplicacioException("Tamany de la carpeta no positiu");
        }
        capacity = cap;
        carpeta = new ArrayList<>(capacity);
    }

    /**
     * Obtiene el tamaño de la carpeta en ficheros
     *
     * @return int
     */
    @Override
    public int getSize() {
        return carpeta.size();
    }

    /**
     * Añade un fichero a la carpeta
     *
     * @param fitxer
     * @throws AplicacioException
     */
    @Override
    public void addFitxer(File fitxer) throws AplicacioException {
        if (isFull()) {
            throw new AplicacioException("Carpeta plena");
        } else {
            carpeta.add((FitxerMultimedia) fitxer);
        }
    }

    /**
     * Borra un archivo de la carpeta
     *
     * @param fitxer
     */
    @Override
    public void removeFitxer(File fitxer) {
        carpeta.remove((FitxerMultimedia) fitxer);
    }

    /**
     * Obtiene un fichero atraves de su indice
     *
     * @param position
     * @return File
     */
    @Override
    public File getAt(int position) {
        return carpeta.get(position);
    }

    /**
     * Elimina los archivos de la carpeta
     */
    @Override
    public void clear() {
        carpeta.clear();
    }

    /**
     * Comprueba si la carpeta está llena
     *
     * @return boolean
     */
    @Override
    public boolean isFull() {
        return carpeta.size() == capacity;
    }

    /**
     * Comprueba el espacio libre
     *
     * @return int
     */
    public int freeSpace() {
        return capacity - carpeta.size();
    }

    public boolean contains(File fitxer) {
        return carpeta.contains((FitxerMultimedia) fitxer);
    }

    //Prácticas 1 - 3
    /*
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int id = 1;

        Iterator<FitxerMultimedia> fileIt = carpeta.iterator();

        while (fileIt.hasNext()) {
            FitxerMultimedia currentFile = fileIt.next();
            sb.append("[").append(id).append("] ").append(currentFile).append("\n");
            id++;
        }
        return sb.toString();
    }
     */
    // Práctica 4
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        Iterator<FitxerMultimedia> fileIt = carpeta.iterator();

        while (fileIt.hasNext()) {
            FitxerMultimedia currentFile = fileIt.next();
            sb.append(currentFile.getDescripcio())
                    .append(" [").append(currentFile.getClass().getSimpleName())
                    .append("] (").append(currentFile.getUltimaModificacio())
                    .append(")").append("\n");
        }
        return sb.toString();
    }

}
