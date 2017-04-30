/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.tarea7psp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * clase que administra los conjuntos de datos
 * @author juvenal
 * @version 3.0 30/04/2017
 */
public class AdministrarDatos
{
	
	
	/**Lista de conjuntos de datos*/
	private ArrayList<ConjuntoDatos> ListaConjuntoDatos;
	
	/**objeto de tipo Calculo*/
	private Calculo calculos;
	
	public AdministrarDatos()
	{
		ListaConjuntoDatos= new ArrayList<ConjuntoDatos>();
		calculos = new Calculo();
	}
	
	/**
     * Lee los valores desde un archivo de texto
     *  @return  retorna falso si no puede abrir el archivo
     */
	
	public boolean leerArchivo(String path)

	{
		boolean leido = false;
		ListaConjuntoDatos= new ArrayList<ConjuntoDatos>();
		if ( path.contains(".txt"))
		{
                    
			try {
				BufferedReader br = new BufferedReader(new FileReader(path));
				
				try {
                                        String line = br.readLine();
					while (line != null) 
					{
                                            ConjuntoDatos nuevoConjuntoDatos= new ConjuntoDatos();
							
                                            String[] valores= line.split(",") ;
                                            for (int i= 0; i<valores.length;i++) 
                                            {
						if (i==0)
						{
                                                    nuevoConjuntoDatos.setTitulo(valores[i]);
						}				        
						else
						{
                                                    try 
                                                    {
                                                            Double pValor= Double.parseDouble(valores[i]);
								
                                                            nuevoConjuntoDatos.addDato(pValor);
                                                    }
						    catch(NumberFormatException ex)
                                                    {
							System.out.println("Conjunto de Datos " +nuevoConjuntoDatos.getTitulo()+ "Valor No Cargado: " + valores[i]);								
                                                    }
						}						
							
                                            }
                                            ListaConjuntoDatos.add(nuevoConjuntoDatos);
                                            line = br.readLine();
                                        }
                                        leido= true;
                                        br.close();
                                    } 
                                    catch (IOException e) 
                                    {
					
                                    }
				
                            } 
                            catch (FileNotFoundException e) 
                            {
				return false;
                            }
		}
		
		return leido;
	}

	/**
	 * devuleve el un conjunto de datos de la lista
	 * 
     * @param indice del conjunto de datos
     */
	public ConjuntoDatos getConjunto(int indice)
	{
		
		return ListaConjuntoDatos.get(indice);
	}
	
    /**
    * Obtiene los valores de la regresion, significancia y rangos
    * 
     * @param indX del conjunto de datos X
     * @param indY del conjunto de datos Y
     * 
     */
	public Map<String,String> calcularVaolers(int indX, int indY,double valorx)
	{
		
                Map<String,String> parametros= new HashMap<String,String>();
                
                ConjuntoDatos datosX = this.getConjunto(indX);
		ConjuntoDatos datosY= this.getConjunto(indY);
                if ( calculos.estimarValores(datosX, datosY, valorx))
                {
                    parametros.put("r",String.valueOf(calculos.getR()));
                    parametros.put("r2",String.valueOf(calculos.getR2()));
                    parametros.put("significance",String.valueOf(calculos.getSignificancia()));
                    parametros.put("b0",String.valueOf(calculos.getB0()));
                    parametros.put("b1",String.valueOf(calculos.getB1()));
                    parametros.put("Yk",String.valueOf(calculos.getYk()));
                    parametros.put("Range",String.valueOf(calculos.getRango()));
                    parametros.put("UPI",String.valueOf(calculos.getUpi()));
                    parametros.put("LPI",String.valueOf(calculos.getLpi()));
                }
                else
                {
                    parametros.put("Error","Error en calculos");
                }
                	
		
		return parametros;
		
	}
	
	/**
     * obtiene la lista del conjunto de datos
     *  @return  lista del conjunto de datos
     */
	public ArrayList<ConjuntoDatos>  getListaConjuntoDatos()
	{
		return ListaConjuntoDatos;
	}
	
	/**
     * obtiene la lista del conjunto de datos
     *  @return  lista del conjunto de datos
     */
	public Map<String,String>  getTitulosListaConjuntoDatos()
	{
		Map<String,String> titulos= new HashMap<String,String>();
		int indice=1;
		for(ConjuntoDatos datos :getListaConjuntoDatos())
		{
			titulos.put(Integer.toString(indice), datos.getTitulo());
			indice=indice+1;
		}
		
		return titulos;
		
	}
}