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
public class testCalculo {
    
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
    public void testCalcularX()
         
    {
        Calculo cal = new Calculo();
        double valor= cal.calcularX(datosX, datosY);
        assertEquals(9.05273615,valor,0.00001); 
    }
    
      @Test
    public void testSignificancia()
         
    {        Calculo cal = new Calculo();
        double valor= cal.calcularSignificancia(datosX, datosY);
        assertEquals(0.0000177517,valor,0.000000001); 
    }
    
     @Test 
    public void testCalcularSigma()
    {
        Calculo cal = new Calculo();
        
        double valor= cal.calcularSigma(datosX, datosY);
        assertEquals(197.8955801,valor,0.00001); 
    }
    
        @Test 
    public void testCalRaiz()
    {
        Calculo cal = new Calculo();
        
        double valor= cal.calcularTerminoRaiz(datosX, 386.0);
        assertEquals(1.04881339,valor,0.00001); 
    }
     @Test
    public void testCalcularRango()
         
    { 
        Calculo cal = new Calculo();
        double valor= cal.calcularRango(datosX, datosY, 386.0);
        assertEquals(230.0017197,valor,0.0001); 
    }
    
    @Test
    public void testEstimarValores()
         
    { 
        Calculo cal = new Calculo();
        cal.estimarValores(datosX, datosY, 386.0);
        double valor= cal.getYk();
        assertEquals(644.4293838,valor,0.00001); 
        valor= cal.getUpi();
        assertEquals(874.4311035,valor,0.0001); 
        valor= cal.getLpi();
        assertEquals(414.427664,valor,0.0001); 
    }
}
