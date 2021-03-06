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

/**
 * Video - Modelo, la superclass File ya implementa Serializable, no hace falta
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public class Video extends FitxerReproduible {

    private final int alcada;
    private final int amplada;
    private final float fps;

    public Video(String cami, String nom, String codec, float durada, int alcada,
            int amplada, float fps, Reproductor reproductor) throws AplicacioException {
        super(cami, nom, codec, durada, reproductor);
        if (alcada == 0) {
            throw new AplicacioException("Alçada no pot estar buida o ser 0");
        }
        if (amplada == 0) {
            throw new AplicacioException("Amplada no pot estar buida o ser 0");
        }
        if (fps == 0.0) {
            throw new AplicacioException("Fps no pot estar buit o ser 0");
        }
        this.alcada = alcada;
        this.amplada = amplada;
        this.fps = fps;
    }

    // Getters START
    public int getAlcada() {
        return alcada;
    }

    public int getAmplada() {
        return amplada;
    }

    public float getFps() {
        return fps;
    }
    // Getters END

    @Override
    public void reproduir() throws AplicacioException {
        getReproductor().reprodueix(this);
    }

    @Override
    public String toString() {
        StringBuilder fitxer = new StringBuilder();

        fitxer.append("Tipus: ").append(this.getClass().getSimpleName()).append("\n");

        fitxer.append(super.toString()).append("\n");

        fitxer.append("Codec: ").append(getCodec()).append("\n");
        fitxer.append("Durada: ").append(getDurada()).append("\n");
        fitxer.append("Alcada: ").append(alcada).append("\n");
        fitxer.append("Amplada: ").append(amplada).append("\n");
        fitxer.append("Fps: ").append(fps);

        return fitxer.toString();
    }

}
