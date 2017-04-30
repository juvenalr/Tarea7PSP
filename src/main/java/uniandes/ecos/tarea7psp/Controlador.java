/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.tarea7psp;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import spark.ModelAndView;
import spark.template.freemarker.FreeMarkerEngine;
import static spark.Spark.*;
import java.util.HashMap;
import java.util.Map;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Set;
/**
 *
 * @author usuario
 */
public class Controlador 
{
    /**Objeto de la clase AdministrarDatos que se encarga de los procesos y calculo*/ 
  public AdministrarDatos adminDatos;
  
  /**Objeto de la clase vista que mustra los menus en pantalla*/
  public Vista menus;
  /**
   * Constructo de la clase
   */
  public Controlador()
  {
	  adminDatos= new AdministrarDatos();
	  menus=new Vista();
  }
  
  
  
   public static void main(String[] args) 
   {
       Controlador control = new Controlador();

        port(Integer.valueOf(System.getenv("PORT")));
        staticFileLocation("/public");
      
        get("/Rangos", (req, res) -> 
        {
            int nParametros=0;
            double valorX=0;
            String error="";
            Set<String> queryParams = req.queryParams();
            if  (queryParams.size()>0)
            {      
		   
		    for(String param : queryParams)
                    {
                      if (param.equals("ruta"))
                      {
                         if (control.adminDatos.leerArchivo(param))
                         {
                           nParametros=0;
                           nParametros+=1;
                         }
                         else
                         {
                             error="Error no se pudo leer el archivo de texto";
                         }
                      }
		    	
                      if (param.equals("xvalor"))
                      {
                        try
                        {
                            valorX= Double.parseDouble( req.queryParams(param).replace(",",".") );
                            nParametros+=1;
                        }
                        catch(NumberFormatException e)
                        {
                           nParametros=0;
                           error="Error el valor de x debe ser un entero";
                        }
                      }
                    }
                    
                    if (nParametros==2)
                    {
                         Map<String,String> intervalos= control.adminDatos.calcularVaolers(0, 1, valorX);
                         return control.menus.mostrarResultados(intervalos);
                    }
            }
	    	
            return control.menus.mostrarFormularioIngreso(error);
            
         }
        );
          
        
   }
}