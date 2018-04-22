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
package edu.ub.prog2.martinezmanuelperugaaaron3.controlador;

import edu.ub.prog2.martinezmanuelperugaaaron3.model.CarpetaFitxers;
import edu.ub.prog2.martinezmanuelperugaaaron3.model.FitxerReproduible;
import edu.ub.prog2.utils.AplicacioException;
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
    private int posicio; // TODO (DUDA)

    public EscoltadorReproduccio() {
    }

    // TODO (DUDA CONSTRUCTORES)
    /*
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
    }*/
    public void setLlistaReproduint(CarpetaFitxers llistaReproduint) {
        this.llistaReproduint = llistaReproduint;
        this.llistaCtrl = new boolean[llistaReproduint.getSize()];
    }

    // Getters START
    public CarpetaFitxers getLlistaReproduint() {
        return llistaReproduint;
    }

    public boolean[] getLlistaCtrl() {
        return llistaCtrl;
    }

    public boolean isReproduccioCiclica() {
        return reproduccioCiclica;
    }

    public boolean isReproduccioAleatoria() {
        return reproduccioAleatoria;
    }
    // Getters y Setters END

    //  Setters START
    public void setReproduccioCiclica(boolean reproduccioCiclica) {
        this.reproduccioCiclica = reproduccioCiclica;
    }

    public void setReproduccioAleatoria(boolean reproduccioAleatoria) {
        this.reproduccioAleatoria = reproduccioAleatoria;
    }
    // Setters END

    /**
     * Es llamado cuando acaba la reproducción de un fichero
     */
    @Override
    protected void onEndFile() {
        if (reproduccioCiclica && !hasNext()) {
            iniciarReproduccio(llistaReproduint, reproduccioCiclica);
        } else if (hasNext()) {
            next();
        }
    }

    /**
     * Es llamado desde onEndFile() cuando va a reproducir el siguiente fichero
     */
    @Override
    protected void next() {
        posicio = (posicio + 1) % llistaCtrl.length;
        continuaReproduccio();
    }

    /**
     * Comprueba si tiene más ficheros
     *
     * @return boolean
     */
    @Override
    protected boolean hasNext() {
        return !llistaCtrl[(posicio + 1) % llistaCtrl.length];
    }

    /**
     * Inicia la reproducción
     *
     * @param llistaReproduint
     * @param reproduccioCiclica
     */
    public void iniciarReproduccio(CarpetaFitxers llistaReproduint, boolean reproduccioCiclica) {
        // TODO (DUDA + IDEA)
        setLlistaReproduint(llistaReproduint);
        this.reproduccioCiclica = reproduccioCiclica;
        posicio = 0;
        if (isReproduccioAleatoria()) {
            posicio = (int) Math.round(Math.random() * (llistaCtrl.length - 1));
        } else {
            setLlistaReproduint(llistaReproduint);
            posicio = 0;
        }
        continuaReproduccio();
    }

    /**
     * Continua la reproduccion
     */
    public void continuaReproduccio() {
        File file = llistaReproduint.getAt(posicio);
        if (file instanceof FitxerReproduible) {
            // TODO (DUDA TRY-CATCH)
            try {
                this.llistaCtrl[posicio] = true;
                ((FitxerReproduible) file).reproduir();
            } catch (AplicacioException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
