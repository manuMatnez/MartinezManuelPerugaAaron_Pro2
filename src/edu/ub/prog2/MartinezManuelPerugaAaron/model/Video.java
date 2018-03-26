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
        fitxer.append(", Alcada='").append(alcada).append("'");
        fitxer.append(", Amplada='").append(amplada).append("'");
        fitxer.append(", Fps='").append(fps).append("'");

        return fitxer.toString();
    }

}
