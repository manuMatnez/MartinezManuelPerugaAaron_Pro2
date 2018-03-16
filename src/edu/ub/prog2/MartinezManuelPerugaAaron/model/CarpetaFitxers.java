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
public class CarpetaFitxers {

    // capacidad máxima de la carpeta
    private static int capacity;

    private ArrayList<File> carpeta;

    public CarpetaFitxers() {
        capacity = 100; // default
        carpeta = new ArrayList(capacity);
    }

    public CarpetaFitxers(int cap) throws AplicacioException {
        if (cap < 1) {
            throw new AplicacioException("Numero menor de 0: " + cap);
        }
        capacity = cap;
        carpeta = new ArrayList(capacity);
    }

    /**
     * Obtiene el tamaño de la carpeta en ficheros
     *
     * @return int
     */
    public int getSize() {
        return carpeta.size();
    }

    /**
     * Añade un fichero a la carpeta si no está ya contenido
     *
     * @param fitxer
     * @throws AplicacioException
     */
    public void addFitxer(File fitxer) throws AplicacioException {
        if (carpeta.contains(fitxer)) {
            throw new AplicacioException("Ya existeix el fitxer");
        } else {
            carpeta.add(fitxer);
        }
    }

    /**
     * Borra un archivo de la carpeta
     *
     * @param fitxer
     */
    public void removeFitxer(File fitxer) {
        carpeta.remove(fitxer);
    }

    /**
     * Obtiene un fichero atraves de su indice empezando desde 1 el primero
     *
     * @param position
     * @return File
     */
    public File getAt(int position) {
        int fakePos = position - 1;
        File file = carpeta.get(fakePos);

        return file;
    }

    /**
     * Elimina los archivos de la carpeta
     */
    public void clear() {
        carpeta.clear();
    }

    /**
     * Comprueba si la carpeta está llena
     *
     * @return boolean
     */
    public boolean isFull() {
        return carpeta.size() == capacity;
    }

    /**
     * Comprueba el espacio libre
     *
     * @return String
     */
    public String freeSpace() {
        return "Free Space (" + String.valueOf(capacity - carpeta.size()) + ")";
    }

    /**
     * Obtiene la carpeta de ficheros
     *
     * @return ArrayList
     */
    public ArrayList<File> getCarpeta() {
        return carpeta;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carpeta de Fitxers: ").append(freeSpace())
                .append("\n====================================\n");

        if (carpeta.size() > 0) {
            int id = 1;
            for (File file : carpeta) {
                sb.append("\n[").append(id).append("] ").append(file);
                id++;
            }
        } else {
            sb.append("\nNo hi ha fitxers");
        }

        return sb.toString();
    }
}
