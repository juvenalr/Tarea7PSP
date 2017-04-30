package uniandes.ecos.tarea7psp;

import java.util.ArrayList;
/**
 * realiza los diferntes calculos aritmeticos para las estimacion de p dado un x y valor de x dado un p
 * @author juvenal
 * @version 2.0 29/04/2017
 */
public class CalculoPValor
{
    /**
     * genera una lista con los valores de los sgmentos para un intervalo 
     * @param xi tamño del intervalo
     * @param numeroSegmentos nuemro de segmentos en los que se dividira el intervalo
     * @return lista de segmentos
     */
    public ArrayList<Double> generarSegmentos(double xi, double numeroSegmentos)
    {
      ArrayList<Double> segmentos = new ArrayList<Double>();
      
      if (numeroSegmentos>0)
      {
        double w= xi/numeroSegmentos;
        
        for (int i= 0;i<=numeroSegmentos;i++)
        {
            segmentos.add(w*i);
        }
      }
      return segmentos;
    }
    
    /**
     * devuelve la suma entre una fraccion y un entero
     * @param numA numerador de la fraccion
     * @param denomA denominador de la fraccion
     * @param entero numero entro a sumas
     * @return suma
     */
    public ArrayList<Double> operarSumaFraccionesEntero(double numA, double denomA, double entero)
    {
     ArrayList<Double> valores =   new ArrayList<Double>();
     valores.add((numA + entero * denomA));
     valores.add(denomA);
     return valores;
    }
    
    /**
     * calcula la funcion gama para una numero expresado como fraccion
     * @param numerador nuemerador de la fraccion
     * @param denominador denominador de la fraccion
     * @return valor de la funcion gamma
     */
    public double calcularFuncionGamma(double numerador, double denominador)
    { 
      
      ArrayList<Double> sumafraccion;
      
               
      if (numerador % denominador ==0)
      {
          if ( numerador / denominador == 1)
          {
           sumafraccion= operarSumaFraccionesEntero(numerador/denominador,1,0);
          }
          else
          {
            sumafraccion= operarSumaFraccionesEntero(numerador/denominador,1,-1.0);
          }
      }
      else
      {
          sumafraccion= operarSumaFraccionesEntero(numerador,denominador,-1.0);
      }
      double suma = sumafraccion.get(0)/ sumafraccion.get(1);
      if(suma ==1.0)
      {
        return suma*1.0;
      }
       else if ( suma==0.5)
           
       {
        return suma*Math.sqrt(Math.PI);
       }       
       
      return suma*calcularFuncionGamma(sumafraccion.get(0),sumafraccion.get(1));      
    }
    
    /**
     * retorna el valor de la primera parte de la funcion
     * @param gradosLibertad numero grados de libertad
     * @return valor
     */
    public double calcularPrimeraParteFuncion(int gradosLibertad)
    {
     double numerador;
     double denominador;    
     numerador = this.calcularFuncionGamma(gradosLibertad +1, 2.0);
     denominador = Math.sqrt(gradosLibertad*Math.PI)*this.calcularFuncionGamma(gradosLibertad,2);
     if (denominador != 0.0)
     {
      return numerador/denominador;
     }
     else
     {
      return 0.0;
     }     
    }
    
    /**
     * retorna el valor de la segunda parte de funcion
     * @param xi valor del segmento
     * @param gradosLibertad numero grados libertad
     * @return valor segunda parte funcion
     */
    public double calcularSegundaParteFuncion(double xi, int gradosLibertad)
    {
        double exponente = ((gradosLibertad +1)/2.0) *-1.0;
        double base = 1.0 + (Math.pow(xi,2.0)/gradosLibertad);
        return Math.pow(base, exponente);
    
    }
      
    
    /**
     * calcula la sumatoria impar de la funcion p
     * @param segmentos lista de segmentos
     * @param numeroSegmentos numero de segmentos
     * @param gradosLibertad grados libertad
     * @return 
     */
    public double calcularSumatoriaImpar(ArrayList<Double> segmentos , int numeroSegmentos,int gradosLibertad)
    {
      double suma=0;
      for (int i= 1; i<= numeroSegmentos -1;i++)
      {
       if (i %2 != 0)
       {
           suma = suma + 4*calcularPrimeraParteFuncion(gradosLibertad)*calcularSegundaParteFuncion(segmentos.get(i),gradosLibertad);
       }       
      }
      return suma;
    }
    
      /**
     * calcula la sumatoria impar de la funcion p
     * @param segmentos lista de segmentos
     * @param numeroSegmentos numero de segmentos
     * @param gradosLibertad grados libertad
     * @return 
     */
    public double calcularSumatoriaPar(ArrayList<Double> segmentos , int numeroSegmentos,int gradosLibertad)
    {
      double suma=0;
      for (int i= 1; i<= numeroSegmentos -2;i++)
      {
       if (i %2 == 0)
       {
           suma = suma + 2*calcularPrimeraParteFuncion(gradosLibertad)*calcularSegundaParteFuncion(segmentos.get(i),gradosLibertad);
       }       
      }
      return suma;
    }
    /**
     * calcula el p valor para un valor x dado un numero de segmentos
     * @param x valor del intervalo
     * @param numeroSegmentos  nuemro de segmentos en que se divide el intervalo
     * @param gradosLibertad grados de libertad 
     * @return 
     */
   public double calcularValorP(double x, int numeroSegmentos,int gradosLibertad )
   {   
     ArrayList<Double> segmentos = generarSegmentos(x,numeroSegmentos);
     double valorF0= calcularPrimeraParteFuncion(gradosLibertad)* calcularSegundaParteFuncion(segmentos.get(0),gradosLibertad);  
     double valorFx= calcularPrimeraParteFuncion(gradosLibertad)* calcularSegundaParteFuncion(segmentos.get(numeroSegmentos),gradosLibertad);
     double sumaImpar= calcularSumatoriaImpar(segmentos, numeroSegmentos,gradosLibertad);
     double sumaPar =calcularSumatoriaPar(segmentos, numeroSegmentos,gradosLibertad);
     double w = x/ numeroSegmentos;
     
     return w/3*(valorF0 + sumaImpar+ sumaPar  +valorFx);
   }
   
   /**
    * Estima el valor de p
    * @param x valor del intervalo
    * @param numeroSegmentos numero de segmentos en los que se divide el intervalo
    * @param gradosLibertad grados de libertad
    * @param errorAceptable error aceptable
    * @return valor p estimado
    */
   
   public double estimarValorP(double x, int numeroSegmentos,int gradosLibertad, double errorAceptable)
   {    
       if (x == 0.0)
       {
        return 0.0;
        
       }
       else
       {
            double pInicial = calcularValorP(x, numeroSegmentos,gradosLibertad);
            int numeroSegmentoNext =  numeroSegmentos *2;
            double pSiguiente = calcularValorP(x,numeroSegmentoNext,gradosLibertad);
            double error= Math.abs(pInicial - pSiguiente);
        
            while(error > errorAceptable)
            {
              pInicial =pSiguiente;
              numeroSegmentoNext = numeroSegmentoNext*2;
              pSiguiente= calcularValorP(x,numeroSegmentoNext,gradosLibertad);
              error= Math.abs(pInicial - pSiguiente);
            }
        
        return pSiguiente;        
       }
   }
   
    /**
    * Estima el valor de x 
    * @param pValor pValor Base
    * @param gradosLibertad grados de libertad
    * @param tolerancia tolerancia
    * @return valor x estimado
    */
    public double estimarValorX(double pValor, int gradosLibertad, double tolerancia)
    {
        double x= 1.0;
        double pVCalculado= estimarValorP(x, 10, gradosLibertad,0.000001);
        double eActual= pValor - pVCalculado;
        double eBase=eActual;
        double d=0.5;
        
        while ( Math.abs(eActual) >=tolerancia  )
        {
          if ( (eBase > 0 && eActual <0) || (eActual > 0 && eBase <0))
          {
            d= d/2;
          }
          
          if (eActual > 0)
          {
            x=x+d;
          }
          
          else
          {
           x=x-d;
          }
          eBase=eActual;
          pVCalculado= estimarValorP(x, 10, gradosLibertad,0.000001);
          eActual = pValor - pVCalculado;
        }
        
                
        return x;
    }
    
   
}
