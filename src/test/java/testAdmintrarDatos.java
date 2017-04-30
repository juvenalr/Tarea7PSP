/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import uniandes.ecos.tarea7psp.*;
/**
 *
 * @author usuario
 */
public class testAdmintrarDatos {
    
    public testAdmintrarDatos() {
    }
    
    @Test
    public void testleerArchivo()
      
            
    { 
        AdministrarDatos admin  = new AdministrarDatos();
        String datosX= "130,650,99,150,128,302,95,945,368,961";
        String datosY= "186,699,132,272,291,331,199,1890,788,1601";
        String valor= admin.leerArchivo(datosX,datosY);
        assertEquals("ok",valor); 
    }
}
