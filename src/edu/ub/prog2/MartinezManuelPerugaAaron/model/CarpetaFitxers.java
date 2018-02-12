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
import java.util.ArrayList;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class CarpetaFitxers {
    
    private static final int CAPACITY = 100;
    
    private ArrayList<File> carpeta;

    public CarpetaFitxers() {
        this.carpeta = new ArrayList(CAPACITY);
    }
    
    public int getSize(){
        return carpeta.size();
    }
    
    public void addFitxer(File fitxer){
        if(!isFull()) {
            carpeta.add(fitxer);
        }
    }
    
    public void removeFitxer(File fitxer){
        carpeta.remove(fitxer);
    }
    
    public File getAt(int position){
        return carpeta.get(position);
    }
    
    public void clear(){
        carpeta.clear();
    }
    
    public boolean isFull(){
        return carpeta.size() == CAPACITY;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Carpeta de Fitxers:\n==================\n");
        
        int id = 1;
        for (File file: carpeta){
            sb.append("\n[").append(id).append("] ").append(file);
            id++;
        }
        
        return sb.toString();
    }
    
    
    
}
