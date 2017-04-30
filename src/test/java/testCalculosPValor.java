/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
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
public class testCalculosPValor {
    
    public testCalculosPValor() {
    }
    
   @Test 
     public void testgenerarSegmentos()
     {
       CalculoPValor cal = new CalculoPValor();
       ArrayList<Double> segmentos = cal.generarSegmentos(1.1, 10);
       assertEquals(0.0,segmentos.get(0),0.00001);
       assertEquals(0.88,segmentos.get(8),0.00001);
       assertEquals(1.1,segmentos.get(10),0.00001);
     }
    @Test 
     public void testoperarSumaFraccionesEntero()
     {
       CalculoPValor cal = new CalculoPValor();
       ArrayList<Double> segmentos = cal.operarSumaFraccionesEntero(9, 2, -1);
       assertEquals(7.0,segmentos.get(0),0.00001);
       assertEquals(2.0,segmentos.get(1),0.00001);
       
     }
     
     @Test 
     public void testcalcularFuncionGamma()
     {
       CalculoPValor cal = new CalculoPValor();
       Double gama = cal.calcularFuncionGamma(10, 2.0);
       assertEquals(24,gama,0.00001);      
       
     }
   
     @Test 
     public void testcalcularPrimeraParteFuncion()
     {
       CalculoPValor cal = new CalculoPValor ();
       Double funcion = cal.calcularPrimeraParteFuncion(10);
       assertEquals(0.3891084,funcion,0.00001);      
       
     }
     
     @Test 
     public void testcalcularSegundaParteFuncion()
     {
      CalculoPValor  cal = new CalculoPValor ();
       Double funcion = cal.calcularSegundaParteFuncion(0.99, 9);
       assertEquals(0.5964,funcion,0.00001);  
       funcion = cal.calcularSegundaParteFuncion(0.11812, 10);
       assertEquals(0.992360892,funcion,0.00001);   
       
     }
     
  
      @Test 
     public void testcalcularSumatoriaImpar()
     {
        
       CalculoPValor  cal = new CalculoPValor ();
       ArrayList<Double> segmentos = cal.generarSegmentos(1.1, 10);
       Double funcion = cal.calcularSumatoriaImpar(segmentos, 10, 9);
       assertEquals(6.37288,funcion,0.00001);        
       
     }
     
      @Test 
     public void testcalcularSumatoriaPar()
     {
        
       CalculoPValor cal = new CalculoPValor ();
       ArrayList<Double> segmentos = cal.generarSegmentos(1.1, 10);
       Double funcion = cal.calcularSumatoriaPar(segmentos, 10, 9);
       assertEquals(2.57962,funcion,0.0001);        
       
     }
     
      @Test 
     public void testcalcularValorP()
     {        
       CalculoPValor  cal = new CalculoPValor ();
       
       Double funcion = cal.calcularValorP(1.1812, 10, 10);
       assertEquals(0.367573746,funcion,0.0001);        
       
     }
     
     @Test 
     public void testestimarValorP()
     {        
       CalculoPValor  cal = new CalculoPValor ();
       
       Double funcion = cal.estimarValorP(1.1, 10, 9, 0.00001);
       assertEquals(0.35005864,funcion,0.0001);        
        funcion = cal.estimarValorP(1.1812, 10,10 , 0.00001);
        assertEquals(0.36757,funcion,0.0001);    
        funcion = cal.estimarValorP(2.750, 10, 30, 0.00001);
        assertEquals(0.49500,funcion,0.0001);       

     }
     
      @Test 
     public void testestimarValorX()
     {        
       CalculoPValor  cal = new CalculoPValor ();
       
       Double funcion = cal.estimarValorX(0.35,8,0.000001);
       assertEquals(1.1081466,funcion,0.00001);
       
             

     }
}
