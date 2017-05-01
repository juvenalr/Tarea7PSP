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
public class testCalculosregresion {
    
     ConjuntoDatos datosX;
     ConjuntoDatos datosY;
    @Before
    public void setUp() 
    {
         datosX= new ConjuntoDatos();
          datosY= new ConjuntoDatos();

	 datosX.addDato(Double.parseDouble("130"));
	 datosX.addDato(Double.parseDouble("650"));
	 datosX.addDato(Double.parseDouble("99"));
	 datosX.addDato(Double.parseDouble("150"));
	 datosX.addDato(Double.parseDouble("128"));
         datosX.addDato(Double.parseDouble("302"));
         datosX.addDato(Double.parseDouble("95"));
         datosX.addDato(Double.parseDouble("945"));
         datosX.addDato(Double.parseDouble("368"));
         datosX.addDato(Double.parseDouble("961"));
         

         datosY.addDato(Double.parseDouble("186"));
	 datosY.addDato(Double.parseDouble("699"));
	 datosY.addDato(Double.parseDouble("132"));
	 datosY.addDato(Double.parseDouble("272"));
	 datosY.addDato(Double.parseDouble("291"));
         datosY.addDato(Double.parseDouble("331"));
         datosY.addDato(Double.parseDouble("199"));
         datosY.addDato(Double.parseDouble("1890"));
         datosY.addDato(Double.parseDouble("788"));
         datosY.addDato(Double.parseDouble("1601")); 
    }
    
    @Test 
    public void testB1()
    {
        CalculoRegresion cal = new CalculoRegresion();
        double valor= cal.calcularB1(datosX, datosY);
        assertEquals(1.727932426,valor,0.00001); 
    }
 
     @Test 
    public void testB0()
    {
        CalculoRegresion cal = new CalculoRegresion();
        double b1= cal.calcularB1(datosX, datosY);
        double mediax= cal.media(datosX);
        double mediay=cal.media(datosY);
        double valor= cal.calcularB0(mediay,mediax,b1);
        assertEquals(-22.55253275,valor,0.00001); 
    }

    
    
     @Test 
    public void testCoefieciente()
    {
        CalculoRegresion cal = new CalculoRegresion();
        
        double valor= cal.calcularCoeficiente(datosX, datosY);
        assertEquals(0.954496574,valor,0.00001); 
    }
    
     @Test 
    public void testmedia()
    {
        CalculoRegresion cal = new CalculoRegresion();
        
        double valor= cal.media(datosX);
        assertEquals(382.8,valor,0.00001); 
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
