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
import java.util.Objects;

/**
 * AlbumFitxersMultimedia - Modelo
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 2.0
 */
public class AlbumFitxersMultimedia extends CarpetaFitxers {

    private String titol;

    public AlbumFitxersMultimedia(String titol) {
        this.titol = titol;
    }

    public AlbumFitxersMultimedia(int cap, String titol) throws AplicacioException {
        super(cap);
        this.titol = titol;
    }

    // Getters y Setters START
    public String getTitol() {
        return titol;
    }

    public void setTitol(String titol) {
        this.titol = titol;
    }
    // Getters y Setters END

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.titol);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AlbumFitxersMultimedia other = (AlbumFitxersMultimedia) obj;
        if (!Objects.equals(this.titol, other.titol)) {
            return false;
        }
        return true;
    }

}
