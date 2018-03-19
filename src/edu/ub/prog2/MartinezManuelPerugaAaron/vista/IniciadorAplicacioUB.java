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

import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.io.File;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class IniciadorAplicacioUB {

    // Propiedades del Sistema Operativo START
    private final static String OS = System.getProperty("os.name").toLowerCase();
    private final static String OS_ARCH = System.getProperty("os.arch");
    // Propiedades del Sistema Operativo END

    /*
    Directorio de la carpeta "plugins" del VLC
    Ahora la pondrá dentro del proyecto, pero se puede cambiar la ruta
    Siempre y cuando  los binarios estén en su sitio 
     */
    private static String vlcPluginPath;

    /*
    Directorio de la carpeta "lib" del VLC
    Ahora la pondrá dentro del proyecto, pero se puede cambiar la ruta
    Siempre y cuando  los binarios estén en su sitio 
     */
    private static String vlcCorePath;

    // Constantes añadidas START
    private final static String VERSION = "2.1";
    private final static String ASTERISKS = "*************************************************";
    private final static String HEADER = "/" + ASTERISKS + "\n"
            + "* Reproductor UB (Grup C)\n"
            + "* Autors: Manuel Martinez i Aaron Peruga\n"
            + "* Versió: " + VERSION + " - " + OS + "\n"
            + ASTERISKS + "/\n";
    // Constantes añadidas END

    /**
     * Comprueba si el sistema operativo es MacOS de 64 bits
     *
     * @return boolean
     */
    public static boolean isMac() {
        return OS.contains("mac") && OS_ARCH.contains("64");
    }

    /**
     * Comprueba si el sistema operativo es Windows de 64 bits
     *
     * @return boolean
     */
    public static boolean isWin64() {
        return OS.contains("win") && OS_ARCH.contains("64");
    }

    /**
     * Comprueba si el sistema operativo es GNU/Linux de 64 bits
     *
     * @return boolean
     */
    public static boolean isLinux64() {
        return OS.contains("nux") && OS_ARCH.contains("64");
    }

    /**
     * Main
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // VLC 2.2 para Mac, Windows y GNU/Linux x64
        if (isMac()) {
            vlcPluginPath = "vlcbin" + File.separator + "macos" + File.separator + "plugins";
            vlcCorePath = "vlcbin" + File.separator + "macos" + File.separator + "lib";
        } else if (isWin64()) {
            vlcPluginPath = "vlcbin" + File.separator + "win64" + File.separator + "plugins";
            vlcCorePath = "vlcbin" + File.separator + "win64" + File.separator + "lib";
        } else if (isLinux64()) {
            vlcPluginPath = "vlcbin" + File.separator + "gnu_amd64" + File.separator + "plugins";
            vlcCorePath = "vlcbin" + File.separator + "gnu_amd64" + File.separator + "lib";
        } else {
            System.err.println("Sistema operatiu no compatible!");
            System.exit(1);
        }

        uk.co.caprica.vlcj.binding.LibC.INSTANCE.setenv("VLC_PLUGIN_PATH", vlcPluginPath, 1);
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), vlcCorePath);
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);

        System.out.println(HEADER);

        AplicacioUB2 aplicacio = new AplicacioUB2();
        aplicacio.gestioAplicacioUB();
    }

}
