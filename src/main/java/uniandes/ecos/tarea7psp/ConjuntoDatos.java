/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.tarea7psp;


import java.util.ArrayList;

/**
 * lista vinculada de nodos
 * @author juvenal
 * @version 2.0 06/03/2017
 */
public class ConjuntoDatos
{
	
	/** Nodo raiz de la lista   */
	private Dato root;
	
	/** Titulo del conjunto de datos*/
	private String titulo;
	
	/**
	 * Constructor de la clase	 
	*/
	public ConjuntoDatos() 
	{
		this.root=null;
	}

    /**
   * Retorna el nodo raiz de la lista
   * @return nodo raiz
   */
	public Dato getRoot()
	{
		return root;
	}
	
	/**
   * Asigna el nodo raiz de la lista
   * @param root nodo raiz
   */

	public void setRoot(Dato root)
	{
		this.root = root;
	}

	/**
   * Retorna el titulo del conjunto de datos
   * @return titulo
   */
	public String getTitulo()
	{
		return titulo;
	}

	/**
   * Asigna el titulo al conjunto de datos
   * @param titulo titulo del conjunto de datos
   */
	public void setTitulo(String titulo)
	{
		this.titulo = titulo;
	}
	
	/**
   * adiciona un nuevo dato a la lista 
   * @param valor nuevo valor a adicionar
   */
	
	public void addDato(Double valor)
	{
		
		Dato datoNuevo= new Dato();
		datoNuevo.setValor(valor);
		datoNuevo.setNextDato(null);
		if (this.getRoot() == null)
		{
			this.setRoot(datoNuevo);
		}
		
		
		else
		{
			Dato actDato = getRoot();
			while (actDato.getNextDato() != null)
			{
				actDato=actDato.getNextDato();
				
			}
			actDato.setNextDato(datoNuevo);
		}
	}
	
	/**
   * Obtiene el numero de elementos de la lista
   * @return numero de elementos
   */
	public int getNumeroElementos()
	{
		int numElementos=0;
		
		if (this.getRoot() != null)
			
		{  Dato actDato = this.getRoot();
			while (actDato != null)
			{
				numElementos +=1;
				actDato = actDato.getNextDato();
				
			}
		}
		
		return numElementos;		
		
	}
	
	/**
   * Elimina un dato de una posiscion dada si no se puede eliminar retorna falso
   * @param posicion posiscion del elemento a eleiminar dentro de la lista
   * @return verdadero se el dato fue borrado
   */
	public boolean delDato(int posicion)
	{
		boolean borrado = false;
		
		int numeroElementos = this.getNumeroElementos();
		
		if (numeroElementos >= posicion)
		{
		 
			if (posicion ==1)
			{
				this.setRoot(this.getRoot().getNextDato());
				borrado=true;
			}
			
			else
			{
				Dato beforeDato=this.getRoot() ;
				Dato actDato=this.getRoot().getNextDato();
				int p=2;
				while (p < posicion )
				{
					beforeDato= actDato;
					actDato= actDato.getNextDato();
					p+=1;
				}
				
				beforeDato.setNextDato(actDato.getNextDato());
				borrado=true;
			}
		}
		
		
		return borrado;
		
	}
	
   /**
   * obtiene una lista de los valores del conjunto de datos en formato texto
   * @return lista de valores 
   */
	public ArrayList<String> getListaValores()
	{
		ArrayList<String> lValores = new ArrayList<String>();
		
		if (this.getRoot() != null)
			
		{  Dato actDato = this.getRoot();
			while (actDato != null)
			{
				if (actDato != null)
				{
				lValores.add(String.valueOf(actDato.getValor()));
				}
				actDato = actDato.getNextDato();				
			}
		}
			
		return lValores;
	}
	
	/**
	* obtiene una lista de los valores del conjunto de datos
	 * 
	 * @return lista de valores
	*/
	public ArrayList<Double> getListaValoresNumero()
	{
		ArrayList<Double> lValores = new ArrayList<Double>();
		
		if (this.getRoot() != null)
			
		{  Dato actDato = this.getRoot();
			while (actDato != null)
			{
				if (actDato != null)
				{
				lValores.add(actDato.getValor());
				}
				actDato = actDato.getNextDato();
				
			}
		}
		
	
		return lValores;		
		
	}

	
}