/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.tarea7psp;

import java.util.ArrayList;

/**
 * realiza los diferntes calculos aritmeticos definir el rango
 * @author juvenal
 * @version 2.0 29/04/2017
 */
public class Calculo
{
    /**valor correlacion*/
    private Double r;
    
    /**valor correlacion al cudrado*/
    private Double r2;
    
   /**coeficiente B0*/
    private Double b0;
    
   /**coeficiente B1*/
    private Double b1;
    
    /**valor estimado de y*/
    private Double yk;
    /**valor estimado de la significancia*/

    /**
     * 
     * @return valor de r
     */
    public Double getR()
    {
        return r;
    }

     /**
     * 
     * @return valor de r2
     */
    public Double getR2()
    {
        return r2;
    }

    /**
     * 
     * @return valor de B0
     */
    public Double getB0() {
        return b0;
    }

     /**
     * 
     * @return valor de B1
     */
    public Double getB1() 
    {
        return b1;
    }

     /**
     * 
     * @return valor de yk
     */
    public Double getYk() 
    {
        return yk;
    }

     /**
     * 
     * @return valor de la significacncia
     */
    public Double getSignificancia() 
    {
        return significancia;
    }

     /**
     * 
     * @return valor del rango al 70%
     */
    public Double getRango() 
    {
        return rango;
    }

     /**
     * 
     * @return valor del limite superior
     */
    public Double getUpi() 
    {
        return upi;
    }

       /**
     * 
     * @return valor del limite inferior
     */
    public Double getLpi()
    {
        return lpi;
    }
    
    private Double significancia;
    
    /**valor estimado de rango*/
    private Double rango;
    
    /**limite superior*/
    private Double upi;
    
    /**limite inferior*/
    private Double lpi;
    
    
    /**
    * constructor de la clase
    * 
    */
  
    public Calculo() 
    {
        this.r = 0.0;
        this.r2 = 0.0;
        this.b0 = 0.0;
        this.yk = 0.0;
        this.rango = 0.0;
        this.upi = 0.0;
        this.lpi = 0.0;
    }
    
    /**
	 * calcula la el valor de x dados dos conjuntos de datos
	 * @param datosX conjunto de datos X variable independiente
	 * @param datosY conjunto de datos Y variable dependiente
	 * @return valor de x
    */
    
    public double calcularX(ConjuntoDatos datosX, ConjuntoDatos datosY )
    {
     CalculoRegresion calRegresion = new CalculoRegresion();
     int n=datosX.getNumeroElementos();
     double x=0.0;
     double pr= calRegresion.calcularCoeficiente(datosX, datosY);
     if (Math.abs(pr)<1)
     {
      x= Math.abs(pr)*Math.sqrt((double)n-2.0)/Math.sqrt((double)1-Math.pow(pr, 2.0));
      this.r=pr;
      this.r2= Math.pow(pr, 2.0);
      return x;
     }
     return x;
    }
    
     /**
	 * calcula la el valor de la significancia dados dos conjuntos de datos
	 * @param datosX conjunto de datos X variable independiente
	 * @param datosY conjunto de datos Y variable dependiente
	 * @return valor de significacia
    */
    public double calcularSignificancia(ConjuntoDatos datosX, ConjuntoDatos datosY )
    {
        CalculoPValor calPValor = new CalculoPValor();
        int n=datosX.getNumeroElementos();
        double psignificancia=0.0;
        double x = calcularX(datosX,datosY);
        double p= calPValor.estimarValorP(x,10,n-2,0.00001);
        psignificancia = 1 -2*p;
        this.significancia = psignificancia;        
        return psignificancia;
    }
    
     /**
	 * calcula la el valor de sigma dados dos conjuntos de datos
	 * @param datosX conjunto de datos X variable independiente
	 * @param datosY conjunto de datos Y variable dependiente
	 * @return valor de sigma
    */
    public double calcularSigma(ConjuntoDatos datosX, ConjuntoDatos datosY)
    {
        CalculoRegresion calRegresion = new CalculoRegresion();
        int n=datosX.getNumeroElementos();
        double mediaX = calRegresion.media(datosX);
        double mediaY=calRegresion.media(datosY);
        double pb1= calRegresion.calcularB1(datosX, datosY);
        double pb0= calRegresion.calcularB0(mediaY,mediaX, pb1);
        double sumaValor=0.0;
        double sigma=0.0;
        ArrayList<Double> valoresX= datosX.getListaValoresNumero();
	ArrayList<Double> valoresY= datosY.getListaValoresNumero();
        for(int i= 0;i<n;i++)
        {
         sumaValor= sumaValor + Math.pow(valoresY.get(i) - pb0 - pb1* valoresX.get(i),2.0);
        }
        sigma=Math.sqrt((1/((double)n-2.0))*sumaValor);
        this.b0=pb0;
        this.b1=pb1;
        
        return sigma;
    }
    
    /**
	 * calcula la el valor del temino de la raiz de la ecuacion para calcular el rango
	 * @param datosX conjunto de datos X variable independiente
	 *@param  xk valor dado de x
	 * @return valor de sigma
    */
        public double calcularTerminoRaiz(ConjuntoDatos datosX, Double xk)
    {
        CalculoRegresion calRegresion = new CalculoRegresion();
        int n=datosX.getNumeroElementos();
        double mediaX = calRegresion.media(datosX);
        double sumaValor=0.0;
        double raiz=0.0;
        ArrayList<Double> valoresX= datosX.getListaValoresNumero();
	
        for(int i= 0;i<n;i++)
        {
         sumaValor= sumaValor + Math.pow(valoresX.get(i) - mediaX,2.0);
        }
        raiz=Math.sqrt((double)1+(1/(double)n)+(Math.pow(xk-mediaX,2.0)/sumaValor));
              
        return raiz;
    }
    
     /**
	 * calcula la el valor del rango dados dos conjuntos de datos y un valor de x
	 * @param datosX conjunto de datos X variable independiente
	 * @param datosY conjunto de datos Y variable dependiente
          *@param  xk valor dado de x
	 * @return valor de sigma
    */
    public double calcularRango(ConjuntoDatos datosX, ConjuntoDatos datosY, Double xk)
    {
        CalculoRegresion calRegresion = new CalculoRegresion();
        CalculoPValor calPValor = new CalculoPValor();
        int n=datosX.getNumeroElementos();
        double sigma= calcularSigma(datosX,datosY);
        double raiz = calcularTerminoRaiz(datosX,xk);
        double xEstimado = calPValor.estimarValorX(0.35, n-2, 0.0000000001);
        double prango =0.0;
        prango = xEstimado*sigma*raiz;
        this.rango = prango;
        return prango;
    }   
    
       /**
	 * calcula los valores de los rangos y significancia dados dos conjuntos de datos y los valores de x
	 * @param datosX conjunto de datos X variable independiente
	 * @param datosY conjunto de datos Y variable dependiente
	 
    */
    public Boolean estimarValores(ConjuntoDatos datosX, ConjuntoDatos datosY, Double xk)
    {
        try
        {
        double significancia=calcularSignificancia(datosX,datosY);
        double prango= calcularRango(  datosX,  datosY,xk );
        double pyk = this.b0 + this.b1*xk;
        this.yk=pyk;
        this.upi = pyk+ prango;
        this.lpi= pyk- prango;
        return true;
        }
        catch (ArithmeticException e)
        {
          return false;
        }
        
    }  
}
