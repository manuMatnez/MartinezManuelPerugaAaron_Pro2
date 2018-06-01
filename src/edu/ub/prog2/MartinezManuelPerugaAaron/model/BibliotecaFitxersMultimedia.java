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

/**
 * BibliotecaFitxersMultimedia - Modelo, a superclass CarpetaFitxers ya
 * implementa Serializable, no hace falta
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 2.0
 */
public class BibliotecaFitxersMultimedia extends CarpetaFitxers {

    public BibliotecaFitxersMultimedia() {
        super();
    }

    /**
     * Añade un fichero a la carpeta si no existe
     *
     * @param fitxer
     * @throws AplicacioException
     */
    @Override
    public void addFitxer(File fitxer) throws AplicacioException {
        if (!fitxer.exists()) {
            throw new AplicacioException("El fitxer " + fitxer.getName() + " no existeix");
        }
        if (super.contains(fitxer)) {
            throw new AplicacioException("Ya existeix el fitxer");
        } else {
            super.addFitxer(fitxer);
        }
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public int freeSpace() {
        return -1;
    }

}
