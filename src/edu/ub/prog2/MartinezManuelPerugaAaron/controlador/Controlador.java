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
import edu.ub.prog2.utils.AplicacioException;
import edu.ub.prog2.utils.InControlador;
import java.util.List;

/**
 * Controlador Singleton (para tener solo un objeto de este tipo)
 *
 * @author Manuel Martinez, Aaron Peruga
 * @version 2.0
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
     * Retorna si la carpeta está vacía a traves de Dades
     *
     * @return boolean
     */
    public boolean estaBuida() {
        return dades.estaBuida();
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
        return dades.getBiblioteca();
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
        dades.guardarDadesDisc(camiDesti);
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
        this.dades = dades.carregarDadesDisc(camiOrigen);
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

    // PRACTICA 3 - IMPLEMENTACION METODOS -> InControlador
    /**
     * Añade un nuevo album a traves de Dades
     *
     * @param titol
     * @throws AplicacioException
     */
    @Override
    public void afegirAlbum(String titol) throws AplicacioException {
        dades.afegirAlbum(titol);
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
     * Añade un fichero al Album seleccionado a traves de Dades (La comprobación
     * de la existencia la hacemos aquí aprovechando existeixalbum())
     *
     * @param titolAlbum
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void afegirFitxer(String titolAlbum, int id) throws AplicacioException {
        if (!existeixAlbum(titolAlbum)) {
            throw new AplicacioException("No existeix aquest album");
        }
        dades.afegirFitxerAlbum(titolAlbum, id);
    }

    /**
     * Retorna el contenido de un Album en una Lista de String a traves de Dades
     *
     * @param titol
     * @return
     * @throws AplicacioException
     */
    @Override
    public List<String> mostrarAlbum(String titol) throws AplicacioException {
        return dades.albumToString(titol);
    }

    /**
     * Borra un fichero de un album a traves de Dades (La comprobación de la
     * existencia la hacemos aquí aprovechando existeixalbum())
     *
     * @param titol
     * @param id
     * @throws AplicacioException
     */
    @Override
    public void esborrarFitxer(String titol, int id) throws AplicacioException {
        if (!existeixAlbum(titol)) {
            throw new AplicacioException("No existeix aquest album");
        }
        dades.esborrarFitxerAlbum(titol, id);
    }

    @Override
    public void reproduirFitxer(int id) throws AplicacioException {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void obrirFinestraReproductor() {
        this.reproductor.open();
    }

    @Override
    public void tancarFinestraReproductor() throws AplicacioException {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reproduirCarpeta() throws AplicacioException {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reproduirCarpeta(String titol) throws AplicacioException {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void reemprenReproduccio() throws AplicacioException {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void pausaReproduccio() throws AplicacioException {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void aturaReproduccio() throws AplicacioException {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saltaReproduccio() throws AplicacioException {
        // TODO
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Activa o desactiva reproduccion continua
     */
    public void activarDesactivarContinua() {
        if (escoltador.isReproduccioCiclica()) {
            escoltador.setReproduccioCiclica(false);
        } else {
            escoltador.setReproduccioCiclica(true);
        }
    }

    /**
     * Activa o desactiva reproducción aleatoria
     */
    public void activarDesactivarAleatoria() {
        if (escoltador.isReproduccioAleatoria()) {
            escoltador.setReproduccioAleatoria(false);
        } else {
            escoltador.setReproduccioAleatoria(true);
        }
    }

}
