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
package edu.ub.prog2.MartinezManuelPerugaAaron.model;

import java.io.File;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class FitxerMultimedia extends File {
    
    private String camiAbsolut;
    private String nomFitxer;
    private String descripcio;
    private String extensio;
    private Date ultimaModificacio;
    
    public FitxerMultimedia(String cami) {
        super(cami);
    }
    
    /**
     * Retorna la extensión del fichero
     * @return String
     */
    private String findExtension() {
        String name = this.getName();

        int dotInd = this.getName().lastIndexOf('.'),
            sepInd = Math.max(name.lastIndexOf('/'), name.lastIndexOf('\\'));
        if (dotInd <= sepInd) {
            return "";
        }
        else{
            return name.substring(dotInd+1);
        }
    }

    /**
     * Retorna el nombre del fichero sin extensión
     * @return String
     */
    private String findName() {
        String name = this.getName();
        
        int dotInd = this.getName().lastIndexOf('.');
        if (dotInd == -1) {
            return name;
        } else {
            return name.substring(0,dotInd);
        }
    }
    
    /**
     * Retorna la ruta del fichero sin el nombre del fichero
     * @return String
     */
    private String findPath() {
        if (this.getParent() == null) {
            return "";
        } else {
        return this.getParent();
        }
    }
    
    /**
     * Retorna la fecha de ultima modificación del fichero
     * @return Date
     */
    
    private Date dateLastModified() {
        return new Date(this.lastModified());
    }
    
    // Getters
    
    public String getNomFitxer() {
        return nomFitxer;
    }
    
    public String getExtensio() {
        return extensio;
    }

    public String getDescripcio() {
        return descripcio;
    }
    
    public String getCamiAbsolut() {
        return camiAbsolut;
    }
    
    public Date getUltimaModificacio() {
        return ultimaModificacio;
    }
    
    // Setters
    
    public void setDescripcio(String descripcio){
        this.descripcio = descripcio;
    }
    
    //***************************************************************
    
    /*
       Interpretamos que como new File(cami) tiene el nommbre de fichero
       extension, ruta y fecha de ultima modificación lo aprovechamos y hacemos
       unos setters sabiendo que igualmente File es inmutable.
    */

    public void setNomFitxer(){
        this.nomFitxer = findName();
    }
    
    public void setExtensio(){
        this.extensio = findExtension();
    }
    
    public void setCamiAbsolut(){
        camiAbsolut = findPath();
    }
    
    public void setUltimaModificacio() {
        this.ultimaModificacio = dateLastModified();
    }
    
    //***************************************************************

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final FitxerMultimedia other = (FitxerMultimedia) obj;
        if (!Objects.equals(this.nomFitxer, other.nomFitxer)) {
            return false;
        }
        if (!Objects.equals(this.descripcio, other.descripcio)) {
            return false;
        }
        if (!Objects.equals(this.extensio, other.extensio)) {
            return false;
        }
        if (!Objects.equals(this.camiAbsolut, other.camiAbsolut)) {
            return false;
        }
        if (!Objects.equals(this.ultimaModificacio, other.ultimaModificacio)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.camiAbsolut);
        hash = 83 * hash + Objects.hashCode(this.nomFitxer);
        hash = 83 * hash + Objects.hashCode(this.descripcio);
        hash = 83 * hash + Objects.hashCode(this.extensio);
        hash = 83 * hash + Objects.hashCode(this.ultimaModificacio);
        return hash;
    }



    @Override
    public String toString() {
        String ext = "";
        if(extensio.length() > 0) {
            ext = "."+extensio;
        }
        return "Descripció=" + descripcio + ", data=" + ultimaModificacio +
                ", nom fitxer=" + nomFitxer + ", ext=" + extensio +
                ", cami complet=" + camiAbsolut+
                File.separator+nomFitxer+ext;
    }
    
    
    
}
