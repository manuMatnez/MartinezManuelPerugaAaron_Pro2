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
package edu.ub.prog2.MartinezManuelPerugaAaron.controlador;

import edu.ub.prog2.MartinezManuelPerugaAaron.model.CarpetaFitxers;
import edu.ub.prog2.MartinezManuelPerugaAaron.model.FitxerReproduible;
import edu.ub.prog2.utils.EscoltadorReproduccioBasic;
import java.io.File;
import java.io.Serializable;

/**
 * EscoltadorReproduccio - Controlador
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public class EscoltadorReproduccio extends EscoltadorReproduccioBasic implements Serializable {

    private CarpetaFitxers llistaReproduint;
    private boolean[] llistaCtrl;
    private boolean reproduccioCiclica, reproduccioAleatoria;
    private int posicio; // TODO

    public EscoltadorReproduccio() {
        setLlistaReproduint(null);
        this.reproduccioCiclica = false;
        this.reproduccioAleatoria = false;
    }

    public EscoltadorReproduccio(CarpetaFitxers llistaReproduint) {
        setLlistaReproduint(llistaReproduint);
        this.reproduccioCiclica = false;
        this.reproduccioAleatoria = false;
    }

    public EscoltadorReproduccio(CarpetaFitxers llistaReproduint, boolean reproduccioCiclica,
            boolean reproduccioAleatoria) {
        setLlistaReproduint(llistaReproduint);
        this.reproduccioCiclica = reproduccioCiclica;
        this.reproduccioAleatoria = reproduccioAleatoria;
    }

    // Getters y Setters START
    public CarpetaFitxers getLlistaReproduint() {
        return llistaReproduint;
    }

    public void setLlistaReproduint(CarpetaFitxers llistaReproduint) {
        try {
            this.llistaReproduint = llistaReproduint;
            this.llistaCtrl = new boolean[llistaReproduint.getSize()];
            this.posicio = 0;
        } catch (NullPointerException n) {
            this.llistaReproduint = null;
            this.llistaCtrl = null;
            this.posicio = 0;
        }
    }

    public boolean[] getLlistaCtrl() {
        return llistaCtrl;
    }

    public boolean isReproduccioCiclica() {
        return reproduccioCiclica;
    }

    public void setReproduccioCiclica(boolean reproduccioCiclica) {
        this.reproduccioCiclica = reproduccioCiclica;
    }

    public boolean isReproduccioAleatoria() {
        return reproduccioAleatoria;
    }

    public void setReproduccioAleatoria(boolean reproduccioAleatoria) {
        this.reproduccioAleatoria = reproduccioAleatoria;
    }
    // Getters y Setters END

    /**
     * Cuando acaba la reproducción de un fichero
     */
    @Override
    protected void onEndFile() {
        boolean teSeguent = hasNext();
        if (reproduccioCiclica && !teSeguent) {
            setLlistaReproduint(llistaReproduint);
            next();
        } else if (teSeguent) {
            next();
        }
    }

    /**
     * Cuando va a reproducir el siguiente fichero
     */
    @Override
    protected void next() {
        posicio++;
        iniciarReproduccio(llistaReproduint, reproduccioCiclica);
    }

    /**
     * Comprueba si tiene más ficheros
     *
     * @return boolean
     */
    @Override
    protected boolean hasNext() {
        return llistaCtrl[llistaCtrl.length - 1] == true;
    }

    /**
     * Inicia la reproducción
     *
     * @param llistaReproduint
     * @param reproduccioCiclica
     */
    public void iniciarReproduccio(CarpetaFitxers llistaReproduint, boolean reproduccioCiclica) {
        setLlistaReproduint(llistaReproduint);
        setReproduccioCiclica(reproduccioCiclica);

        File file = llistaReproduint.getAt(posicio);
        if (file instanceof FitxerReproduible) {
            this.llistaCtrl[posicio] = true;
            ((FitxerReproduible) file).reproduir();
        }
    }

}
