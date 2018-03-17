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

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class Audio extends FitxerReproduible {

    private final File fitxerImatge;
    private final int kbps;

    public Audio(String cami, File fitxerImatge, String nom, String codec,
            float durada, int kbps, Reproductor r) throws AplicacioException {
        super(cami, nom, codec, durada, r);

        this.fitxerImatge = fitxerImatge;
        this.kbps = kbps;
    }

    // Getters START
    public int getKbps() {
        return kbps;
    }
    // Getters END
    
    @Override
    protected void reproduir() {
        throw new UnsupportedOperationException("No soportat, es a la practica 3");
    }

    @Override
    public String toString() {
        StringBuilder fitxer = new StringBuilder();

        fitxer.append("Tipus='").append(this.getClass().getSimpleName()).append("', ");

        fitxer.append(super.toString());

        fitxer.append(", Codec='").append(getCodec()).append("'");
        fitxer.append(", Durada='").append(getDurada()).append("'");
        fitxer.append(", Kbps='").append(kbps).append("'");

        return fitxer.toString();
    }

}
