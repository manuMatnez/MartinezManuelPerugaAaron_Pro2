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

import edu.ub.prog2.martinezmanuelperugaaaron3.model.Audio;
import edu.ub.prog2.martinezmanuelperugaaaron3.model.FitxerReproduible;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.EscoltadorReproduccioBasic;
import edu.ub.prog2.utils.ReproductorBasic;
import java.io.File;

/**
 * Reproductor - Controlador
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 2.0
 */
public class Reproductor extends ReproductorBasic {

    public Reproductor(EscoltadorReproduccioBasic controlador) {
        super(controlador);
    }

    public Reproductor(String vlcPath, EscoltadorReproduccioBasic controlador) {
        super(vlcPath, controlador);
    }

    public Reproductor(String vlcPath, int verbose, EscoltadorReproduccioBasic controlador) {
        super(vlcPath, verbose, controlador);
    }

    public void reprodueix(FitxerReproduible fr) throws AplicacioException {
        super.play(fr);
    }

    public void reprodueix(Audio audio, File fitxerImatge) throws AplicacioException {
        super.play(audio, fitxerImatge);
    }

}
