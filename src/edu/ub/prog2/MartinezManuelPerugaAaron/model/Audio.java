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

/**
 * Audio - Modelo, la superclass File ya implementa Serializable, no hace falta
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public class Audio extends FitxerReproduible {

    private File fitxerImatge;
    private final int kbps;

    public Audio(String cami, File fitxerImatge, String nom, String codec,
            float durada, int kbps, Reproductor reproductor) throws AplicacioException {
        super(cami, nom, codec, durada, reproductor);
        if (kbps == 0) {
            throw new AplicacioException("Kbps no pot estar buit o ser 0");
        }
        this.fitxerImatge = fitxerImatge;
        this.kbps = kbps;
    }

    // Getters START
    public int getKbps() {
        return kbps;
    }

    public File getFitxerImatge() {
        return fitxerImatge;
    }
    // Getters END

    // Setters START
    public void setFitxerImatge(File fitxerImatge) {
        this.fitxerImatge = fitxerImatge;
    }
    // Setters END

    @Override
    public void reproduir() throws AplicacioException {
        getReproductor().reprodueix(this, fitxerImatge);
    }

    @Override
    public String toString() {
        StringBuilder fitxer = new StringBuilder();

        fitxer.append("Tipus: ").append(this.getClass().getSimpleName()).append("\n");

        fitxer.append(super.toString()).append("\n");

        fitxer.append("Codec: ").append(getCodec()).append("\n");
        fitxer.append("Durada: ").append(getDurada()).append("\n");
        fitxer.append("Kbps: ").append(kbps);

        return fitxer.toString();
    }

}
