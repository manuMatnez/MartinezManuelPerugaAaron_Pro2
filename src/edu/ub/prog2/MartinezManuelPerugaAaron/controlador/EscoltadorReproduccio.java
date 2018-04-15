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
import edu.ub.prog2.utils.EscoltadorReproduccioBasic;

/**
 * EscoltadorReproduccio - Controlador
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 1.0
 */
public class EscoltadorReproduccio extends EscoltadorReproduccioBasic {

    private CarpetaFitxers llistaReproduint;
    private boolean[] llistaCtrl;
    private boolean reproduccioCiclica, reproduccioAleatoria;

    /*public EscoltadorReproduccio(CarpetaFitxers llistaReproduint, 
            boolean[] llistaCtrl, boolean reproduccioCiclica, 
            boolean reproduccioAleatoria) {
        this.llistaReproduint = llistaReproduint;
        this.llistaCtrl = llistaCtrl;
        this.reproduccioCiclica = reproduccioCiclica;
        this.reproduccioAleatoria = reproduccioAleatoria;
    }*/

    // Getters y Setters START
    
    public CarpetaFitxers getLlistaReproduint() {
        return llistaReproduint;
    }

    public void setLlistaReproduint(CarpetaFitxers llistaReproduint) {
        this.llistaReproduint = llistaReproduint;
    }

    public boolean[] getLlistaCtrl() {
        return llistaCtrl;
    }

    public void setLlistaCtrl(boolean[] llistaCtrl) {
        this.llistaCtrl = llistaCtrl;
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

    @Override
    protected void onEndFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void next() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected boolean hasNext() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
