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
 * FitxerReproduible - Modelo, la superclass File ya implementa Serializable, no
 * hace falta
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public abstract class FitxerReproduible extends FitxerMultimedia {

    private final String codec;
    private final float durada;

    // transient no guardara el reproductor cuando serialicemos
    private transient Reproductor reproductor;

    // nom no puede ser porque lo sacamos de cami
    protected FitxerReproduible(String cami, String nom, String codec, float durada, Reproductor reproductor) throws AplicacioException {
        super(cami);
        setDescripcio(nom);
        this.codec = codec;
        this.durada = durada;
        this.reproductor = reproductor;
    }

    // Getters START
    protected String getCodec() {
        return codec;
    }

    protected float getDurada() {
        return durada;
    }

    public Reproductor getReproductor() {
        return reproductor;
    }
    // Getters END

    public void setReproductor(Reproductor reproductor) {
        this.reproductor = reproductor;
    }

    // Cambio a public para uso en EscoltadorReproduccio
    public abstract void reproduir() throws AplicacioException;

    @Override
    public String toString() {
        String ext = this.getExtensio();

        StringBuilder fitxer = new StringBuilder();

        fitxer.append("Nom='").append(getDescripcio()).append("', Data='")
                .append(this.getUltimaModificacio())
                .append("', Nom fitxer='").append(this.getNomFitxer())
                .append("', Extensio='");

        if (ext.length() > 0) {
            fitxer.append(ext);
        } else {
            fitxer.append("null");
        }

        fitxer.append("', Cami complet='").append(getCamiAbsolutComplet()).append("'");

        return fitxer.toString();
    }

}
