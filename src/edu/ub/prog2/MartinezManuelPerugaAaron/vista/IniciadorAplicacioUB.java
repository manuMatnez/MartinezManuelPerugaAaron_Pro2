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
package edu.ub.prog2.MartinezManuelPerugaAaron.vista;

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.util.Collections;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 * IniciadorAplicacioUB - Vista (Main Class)
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 2.0
 */
public class IniciadorAplicacioUB {

    // Propiedades del Sistema Operativo START
    final static String OS = System.getProperty("os.name").toLowerCase();
    final static String USER_NAME = System.getProperty("user.name");
    // Propiedades del Sistema Operativo END

    // Constantes añadidas START
    private final static String VERSION = "3.0";
    private final static String ASTERISKS = String.join("", Collections.nCopies(50, "*"));
    private final static String HEADER = "/" + ASTERISKS + "\n"
            + "* Reproductor UB (Grup C)\n"
            + "* Autors: Manuel Martinez i Aaron Peruga\n"
            + "* Versió: " + VERSION + "\n"
            + ASTERISKS + "/";
    // Constantes añadidas END

    /**
     * Comprueba si el sistema operativo es MacOS de 64 bits
     *
     * @return boolean
     */
    public static boolean isMac() {
        return OS.contains("mac");
    }

    /**
     * Main
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // VLC 2.2 para Mac
        if (isMac()) {
            uk.co.caprica.vlcj.binding.LibC.INSTANCE.setenv("VLC_PLUGIN_PATH",
                    "/Applications/VLC.app/Contents/MacOS/plugins", 1);

            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),
                    "/Applications/VLC.app/Contents/MacOS/lib");

            Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        }

        System.out.println(HEADER);

        System.out.println();

        System.out.println("Benvingut al reproductor UB, " + USER_NAME);

        AplicacioUB3 aplicacio = new AplicacioUB3();

        aplicacio.gestioAplicacioUB();
    }

}
