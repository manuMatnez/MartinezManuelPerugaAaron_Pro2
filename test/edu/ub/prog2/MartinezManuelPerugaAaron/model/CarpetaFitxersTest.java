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

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Manuel Martinez, Aaron Peruga
 */
public class CarpetaFitxersTest {
    
    public CarpetaFitxersTest() {
    }
    
    FitxerMultimedia test1;
    FitxerMultimedia test2;
    FitxerMultimedia test3;
    
    @Before
    public void setUp() throws Exception {
        test1 = new FitxerMultimedia("/home/ficheros/casa.png");
        test1.setCamiAbsolut();
        test1.setDescripcio("test de casa");
        test1.setNomFitxer();
        test1.setUltimaModificacio();
        test1.setExtensio();
        
        test2 = new FitxerMultimedia("/home/ficheros/casa.png");
        test2.setCamiAbsolut();
        test2.setDescripcio("test de casa");
        test2.setNomFitxer();
        test2.setUltimaModificacio();
        test2.setExtensio();
        
        test3 = new FitxerMultimedia("/home/ficheros/playa.png");
        test3.setCamiAbsolut();
        test3.setDescripcio("test de playa");
        test3.setNomFitxer();
        test3.setUltimaModificacio();
        test3.setExtensio();
    }
    

    /**
     * Test of getSize method, of class CarpetaFitxers.
     */
    @Test
    public void testGetSize() throws Exception {
        System.out.println("getSize");
        CarpetaFitxers instance = new CarpetaFitxers();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        
        //Ficheros repetidos
        instance.addFitxer(test1);
        instance.addFitxer(test2);
        int expResult2 = 1;
        int result2 = instance.getSize();
        assertEquals(expResult2, result2);
    }

    /**
     * Test of addFitxer method, of class CarpetaFitxers.
     */
    @Test
    public void testAddFitxer() throws Exception {
        System.out.println("addFitxer");
        CarpetaFitxers instance = new CarpetaFitxers();
        int expResult = 100;
        
        // Test limite de ficheros, equals y añadir
        for (int i = 0;i < expResult;i++) {
            FitxerMultimedia tmp = new FitxerMultimedia("/home/"+String.valueOf(i)+"/"+String.valueOf(i)+"."+String.valueOf(i)+String.valueOf(i));
            tmp.setCamiAbsolut();
            tmp.setDescripcio(String.valueOf(i));
            tmp.setNomFitxer();
            tmp.setUltimaModificacio();
            tmp.setExtensio();

            instance.addFitxer(tmp);
            
        }
        int result = instance.getSize();
        
        assertEquals(expResult, result);
    }

    /**
     * Test of removeFitxer method, of class CarpetaFitxers.
     */
    @Test
    public void testRemoveFitxer() throws Exception {
        System.out.println("removeFitxer");
        CarpetaFitxers instance = new CarpetaFitxers();
        instance.addFitxer(test3);
        
        int expResult = 1;
        
        instance.removeFitxer(instance.getAt(2));
        int result = instance.getSize();
        
        assertEquals(expResult, result);
        
        int expResult2 = 0;
        
        instance.removeFitxer(instance.getAt(1));
        
        int result2 = instance.getSize();
        
        assertEquals(expResult2, result2);
        
    }

    /**
     * Test of clear method, of class CarpetaFitxers.
     */
    @Test
    public void testClear() throws Exception {
        System.out.println("clear");
        CarpetaFitxers instance = new CarpetaFitxers();
        
        for (int i = 0;i < 100;i++) {
            instance.addFitxer(new FitxerMultimedia("/home/ficheros/picnic"+i+".png"));
        }
        
        instance.clear();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
    }

    /**
     * Test of freeSpace method, of class CarpetaFitxers.
     */
    @Test
    public void testFreeSpace() throws Exception {
        System.out.println("freeSpace");
        CarpetaFitxers instance = new CarpetaFitxers();
        int expResult = 99;
        
        instance.addFitxer(test1);
        int result = instance.freeSpace();
        assertEquals(expResult, result);
    }

}
