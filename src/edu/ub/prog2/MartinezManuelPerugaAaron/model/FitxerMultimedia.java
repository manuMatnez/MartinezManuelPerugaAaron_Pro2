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
        nomFitxer = findName();
        extensio = findExtension();
        camiAbsolut = this.getParent();
        ultimaModificacio = new Date(this.lastModified());
    }
    
    private String findExtension() {
        String name = this.getName();

        int dotInd = this.getName().lastIndexOf('.'),
            sepInd = Math.max(name.lastIndexOf('/'), name.lastIndexOf('\\'));
        if (dotInd <= sepInd) {
            return "";
        }
        else{
            return name.substring(dotInd+1).toLowerCase();
        }
    }

    private String findName() {
        String name = this.getName();
        
        int dotInd = this.getName().lastIndexOf('.');
        return name.substring(0,dotInd).toLowerCase();
    }
    
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
    
    public void setNomFitxer(String nomFitxer){
        this.nomFitxer = nomFitxer;
    }
    
    public void setExtensio(String extensio){
        this.extensio = extensio;
    }
    
    public void setDescripcio(String descripcio){
        this.descripcio = descripcio;
    }
    
    public void setCamiAbsolut(String cami){
        camiAbsolut = cami;
    }

    public void setUltimaModificacio(Date ultimaModificacio) {
        this.ultimaModificacio = new Date(this.lastModified());
    }

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
        if (!Objects.equals(this.getUltimaModificacio(), other.getUltimaModificacio())) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.nomFitxer);
        hash = 67 * hash + Objects.hashCode(this.descripcio);
        hash = 67 * hash + Objects.hashCode(this.extensio);
        hash = 67 * hash + Objects.hashCode(this.lastModified());
        return hash;
    }

    @Override
    public String toString() {
        return "Descripció=" + descripcio + ", data=" + ultimaModificacio +", nom fitxer=" + nomFitxer + ", ext=" + extensio + ", cami complet=" + camiAbsolut;
    }
    
    
    
}
