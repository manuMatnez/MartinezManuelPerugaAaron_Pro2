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
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.EscoltadorReproduccioBasic;
import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * EscoltadorReproduccio - Controlador
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.2
 */
public class EscoltadorReproduccio extends EscoltadorReproduccioBasic {

    private CarpetaFitxers llistaReproduint;
    private List<Integer> llistaCtrl;
    private boolean reproduccioCiclica, reproduccioAleatoria;
    private int posicio;
    private boolean reproduint;

    public EscoltadorReproduccio() {
    }

    // Getters & Setters START
    public boolean isReproduint() {
        return reproduint;
    }

    public void setReproduint(boolean reproduint) {
        this.reproduint = reproduint;
    }
    // Getters & Setters END

    /**
     * Es llamado cuando acaba la reproducción de un fichero y lo usamos para
     * llamar a next()
     */
    @Override
    protected void onEndFile() {
        next();
    }

    /**
     * Es llamado desde onEndFile() cuando va a reproducir el siguiente fichero
     * en caso de que sea posible, si no acaba la reproducción
     */
    @Override
    protected void next() {
        posicio = (posicio + 1) % llistaCtrl.size();
        if (hasNext()) {
            File file = llistaReproduint.getAt(llistaCtrl.get(posicio));
            if (file instanceof FitxerReproduible) {
                try {
                    ((FitxerReproduible) file).reproduir();
                } catch (AplicacioException ex) {
                    /////////////////////////////////////////////////////////////
                    // Evitamos el loop de ciclica so no funciona ningún fichero
                    // Los que no funcionen se elimina el index de la llistaCtrl
                    llistaCtrl.remove(posicio);
                    posicio--;
                    /////////////////////////////////////////////////////////////
                    next();
                }
            }
        } else {
            reproduint = false;
        }
    }

    /**
     * Comprueba si hay más archivos por reproducir
     *
     * @return boolean
     */
    @Override
    protected boolean hasNext() {
        return posicio + 1 <= llistaCtrl.size() || (reproduccioCiclica && !llistaCtrl.isEmpty());
    }

    /**
     * Inicia la reproducción
     *
     * @param llistaReproduint
     * @param reproduccioCiclica
     * @param reproduccioAleatoria
     */
    public void iniciarReproduccio(CarpetaFitxers llistaReproduint, boolean reproduccioCiclica, boolean reproduccioAleatoria) {
        this.llistaReproduint = llistaReproduint;
        //////////////////////////////////////////////////////////////////////////////////////////////////
        // (JAVA8) Generamos una Lista de interos desde 0 hasta tamaño de carpeta-1
        llistaCtrl = IntStream.range(0, llistaReproduint.getSize()).boxed().collect(Collectors.toList());
        //////////////////////////////////////////////////////////////////////////////////////////////////
        this.reproduccioCiclica = reproduccioCiclica;
        this.reproduccioAleatoria = reproduccioAleatoria;
        posicio = -1;
        reproduint = true;
        if (this.reproduccioAleatoria) {
            Collections.shuffle(llistaCtrl);
        }
        next();
    }

}
