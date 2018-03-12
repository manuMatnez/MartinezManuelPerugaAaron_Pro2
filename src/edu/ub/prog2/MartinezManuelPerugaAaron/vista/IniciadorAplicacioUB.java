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
package edu.ub.prog2.MartinezManuelPerugaAaron.vista;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class IniciadorAplicacioUB {

    /**
     * VLC 2.2 para Mac: public static void main(String[] args) {
     * uk.co.caprica.vlcj.binding.LibC.INSTANCE.setenv("VLC_PLUGIN_PATH",
     * "/Applications/VLC.app/Contents/MacOS/plugins", 1);
     * NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),
     * "/Applications/VLC.app/Contents/MacOS/lib");
     * Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
     * Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AplicacioUB1 aplicacio = new AplicacioUB1();
        aplicacio.gestioAplicacioUB();
    }

}
