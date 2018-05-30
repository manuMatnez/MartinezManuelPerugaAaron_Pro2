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

import edu.ub.prog2.MartinezManuelPerugaAaron.model.Dades;
import static edu.ub.prog2.MartinezManuelPerugaAaron.model.Dades.carregarDades;
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.InControlador;
import java.util.List;

/**
 * Controlador Singleton (para tener solo un objeto de este tipo)
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 3.0
 */
public class Controlador implements InControlador {

    private Dades dades;
    private final Reproductor reproductor;
    private final EscoltadorReproduccio escoltador;

    private Controlador() {
        dades = new Dades();
        escoltador = new EscoltadorReproduccio();
        reproductor = new Reproductor(escoltador);
    }

    private static class Loader {

        private static final Controlador INSTANCE = new Controlador();
    }

    public static Controlador getInstance() {
        return Loader.INSTANCE;
    }

    /**
     * Añade a la Biblioteca Multimedia un video a traves de Dades
     *
     * @param cami
     * @param nomVideo
     * @param codec
     * @param durada
     * @param alcada
     * @param amplada
     * @param fps
     * @throws AplicacioException
     */
    @Override
    public void afegirVideo(String cami, String nomVideo, String codec,
            float durada, int alcada, int amplada, float fps) throws AplicacioException {
        dades.afegirFitxer(cami, nomVideo, codec, durada, alcada, amplada, fps, this.reproductor);
    }

    /**
     * Añade a la Biblioteca Multimedia un audio a traves de Dades
     *
     * @param cami
     * @param camiImatge
     * @param nomAudio
     * @param codec
     * @param durada
     * @param kbps
     * @throws AplicacioException
     */
    @Override
    public void afegirAudio(String cami, String camiImatge, String nomAudio,
            String codec, float durada, int kbps) throws AplicacioException {
        dades.afegirFitxer(cami, camiImatge, nomAudio, codec, durada, kbps, this.reproductor);
    }

    /**
     * Retorna una Lista de los toString() de los ficheros a traves de Dades
     *
     * @return List
     */
    @Override
    public List<String> mostrarBiblioteca() { // llista dels retorns de toString() dels fitxers
        return dades.getBibliotecaList();
    }

    /**
     * Gestiona la eliminación de un fichero a traves de Dades
     *
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void esborrarFitxer(int id) throws AplicacioException {
        dades.esborrarFitxer(id);
    }

    /**
     * Gestiona el guardado de datos a traves de Dades
     *
     * @param camiDesti
     * @throws AplicacioException
     */
    @Override
    public void guardarDadesDisc(String camiDesti) throws AplicacioException {
        dades.guardarDades(camiDesti);
    }

    /**
     * Gestiona el cargado de datos a traves de Dades sobreescribiendo los datos
     * actuales
     *
     * @param camiOrigen
     * @throws AplicacioException
     */
    @Override
    public void carregarDadesDisc(String camiOrigen) throws AplicacioException {
        this.dades = carregarDades(camiOrigen);
        dades.setReproductor(reproductor);
    }

    /**
     * Comprueba si el fixhero existe a traves de Dades
     *
     * @param cami
     * @throws AplicacioException
     */
    public void comprovaExistenciaFitxer(String cami) throws AplicacioException {
        dades.comprovaExistenciaFitxer(cami);
    }

    /**
     * Añade un nuevo album a traves de Dades
     *
     * @param titol
     * @throws AplicacioException
     */
    @Override
    public void afegirAlbum(String titol) throws AplicacioException {
        dades.afegirAlbum(titol, 10);
    }

    /**
     * Añade un nuevo album con tamaño personalizado a traves de Dades
     *
     * @param titol
     * @param size
     * @throws AplicacioException
     */
    public void afegirAlbum(String titol, int size) throws AplicacioException {
        dades.afegirAlbum(titol, size);
    }

    /**
     * Retorna una Lista de Strings de Albums a traves de Dades
     *
     * @return List
     */
    @Override
    public List<String> mostrarLlistatAlbums() {
        return dades.albumListToString();
    }

    /**
     * Borra un album a traves de Dades
     *
     * @param titol
     * @throws AplicacioException
     */
    @Override
    public void esborrarAlbum(String titol) throws AplicacioException {
        dades.esborrarUnAlbum(titol);
    }

    /**
     * Comprueba si existe el Album a traves de Dades
     *
     * @param titol
     * @return
     */
    @Override
    public boolean existeixAlbum(String titol) {
        return dades.existeixAlbum(titol);
    }

    /**
     * Añade un fichero al Album seleccionado a traves de Dades
     *
     * @param titolAlbum
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void afegirFitxer(String titolAlbum, int id) throws AplicacioException {
        dades.afegirFitxerAlbum(titolAlbum, id);
    }

    /**
     * Retorna el contenido de un Album en una Lista de String a traves de Dades
     *
     * @param titol
     * @return List
     * @throws AplicacioException
     */
    @Override
    public List<String> mostrarAlbum(String titol) throws AplicacioException {
        return dades.albumToString(titol);
    }

    /**
     * Borra un fichero de un album a traves de Dades
     *
     * @param titol
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void esborrarFitxer(String titol, int id) throws AplicacioException {
        dades.esborrarFitxerAlbum(titol, id);
    }

    /**
     * Abre la ventana del reproductor
     */
    @Override
    public void obrirFinestraReproductor() {
        reproductor.open();
    }

    /**
     * Cierra la ventana del reproductor
     *
     * @throws AplicacioException
     */
    @Override
    public void tancarFinestraReproductor() throws AplicacioException {
        reproductor.close();
    }

    /**
     * Reproduce un solo fichero
     *
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void reproduirFitxer(int id) throws AplicacioException {
        try {
            obrirFinestraReproductor();
            escoltador.iniciarReproduccio(dades.getCarpetaReproduccio(id),
                    dades.isReproduccioCiclica(), false);
        } catch (AplicacioException ae) {
            tancarFinestraReproductor();
            throw new AplicacioException("Error al reproduir");
        }
    }

    /**
     * Reproduce la biblioteca
     *
     * @throws AplicacioException
     */
    @Override
    public void reproduirCarpeta() throws AplicacioException {
        try {
            obrirFinestraReproductor();
            escoltador.iniciarReproduccio(dades.getCarpetaReproduccio(),
                    dades.isReproduccioCiclica(), dades.isReproduccioAleatoria());
        } catch (AplicacioException ae) {
            tancarFinestraReproductor();
            throw new AplicacioException("Error al reproduir");
        }
    }

    /**
     * Reproduce un album
     *
     * @param titol
     * @throws AplicacioException
     */
    @Override
    public void reproduirCarpeta(String titol) throws AplicacioException {
        if (!existeixAlbum(titol)) {
            throw new AplicacioException("No existeix aquest album");
        }
        try {
            obrirFinestraReproductor();
            escoltador.iniciarReproduccio(dades.getCarpetaReproduccio(titol),
                    dades.isReproduccioCiclica(), dades.isReproduccioAleatoria());
        } catch (AplicacioException ae) {
            tancarFinestraReproductor();
            throw new AplicacioException("Error al reproduir");
        }
    }

    /**
     * Regresa a la reproducción
     *
     * @throws AplicacioException
     */
    @Override
    public void reemprenReproduccio() throws AplicacioException {
        if (!escoltador.isReproduint()) {
            throw new AplicacioException("No hi ha reproduccio en curs pausada");
        }
        reproductor.resume();
    }

    /**
     * Pausa la reproduccion
     *
     * @throws AplicacioException
     */
    @Override
    public void pausaReproduccio() throws AplicacioException {
        if (!escoltador.isReproduint()) {
            throw new AplicacioException("No hi ha reproduccio en curs");
        }
        reproductor.pause();
    }

    /**
     * Para la reproduccion
     *
     * @throws AplicacioException
     */
    @Override
    public void aturaReproduccio() throws AplicacioException {
        if (!escoltador.isReproduint()) {
            throw new AplicacioException("No hi ha reproduccio en curs per aturar");
        }
        reproductor.stop();
        escoltador.setReproduint(false);
        tancarFinestraReproductor();
    }

    /**
     * Cambia al siguiente para reproducir
     *
     * @throws AplicacioException
     */
    @Override
    public void saltaReproduccio() throws AplicacioException {
        if (!escoltador.isReproduint()) {
            throw new AplicacioException("No hi ha reproduccio en curs per poder saltar");
        } else if (!escoltador.hasNext()) {
            throw new AplicacioException("No hi han mes fitxers per reproduir");
        }
        escoltador.next();
    }

    /**
     * Activa o desactiva reproduccion continua
     *
     * @return boolean
     */
    public boolean activarDesactivarContinua() {
        dades.setReproduccioCiclica(!dades.isReproduccioCiclica());
        return dades.isReproduccioCiclica();
    }

    /**
     * Activa o desactiva reproducción aleatoria
     *
     * @return boolean
     */
    public boolean activarDesactivarAleatoria() {
        dades.setReproduccioAleatoria(!dades.isReproduccioAleatoria());
        return dades.isReproduccioAleatoria();
    }

    public String getTitolAlbum(int id) throws AplicacioException {
        return dades.getTitolAlbum(id);
    }

    /**
     * Comprueba si es reproducción aleatoria
     *
     * @return boolean
     */
    public boolean isReproduccioAleatoria() {
        return dades.isReproduccioAleatoria();
    }

    /**
     * Comprueba si es reproduccion ciclica
     *
     * @return boolean
     */
    public boolean isReproduccioContinua() {
        return dades.isReproduccioCiclica();
    }

}
