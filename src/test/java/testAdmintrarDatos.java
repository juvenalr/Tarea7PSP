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
        boolean valor= admin.leerArchivo("D:\\JUVENAL\\estudio\\Especializacion_Construccion_Software\\Conceptos_Avanzados_De_IngSoftware\\Tarea_7\\Archivo_Datos_Test1.txt");
        assertEquals(true,valor); 
    }
}
