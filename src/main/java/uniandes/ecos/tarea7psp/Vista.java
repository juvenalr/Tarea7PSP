/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uniandes.ecos.tarea7psp;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * clase qque se encarga de generar de mostrar los menus en pantalla
 * @author juvenal
 * @version 1.0 04/04/2017
 */
public class Vista 
{
    /**
     * genera un string a partir de una lista de resulatados
     * @param mapaIntervalos lista de resultados
     * @return cadena de texto
     */
     public String mostrarResultados(LinkedHashMap<String,String> mapaIntervalos)
     {
         String encabezado = " <!DOCTYPE html> <html>";
         String cabeza = "<head> <style> table, th,td {border: 1px solid black; border-collapse: collapse;} th, td {padding: 2px;}</style> </head>";
         String cuerpo = "<body>";
         String tablaInicio = "<table style=\"width:50%\">";
         String columnasEncabezado=  "<tr> <th>Parametro</th> <th>valor</th></tr>";
         String valores ="";
         for (Map.Entry<String,String> dato : mapaIntervalos.entrySet())
         {
          
            valores = valores + " <tr> "  + "<td>" + dato.getKey() + "</td>"  + "<td>"+ dato.getValue() + "</td>" + "</tr>";
         
         }
         
          String volverform=" <form> <button type="+"\""+"button"+ "onclick="+"\""+"alert('Hello World!')"+"\""+">volver</button> </form>";
         return encabezado +cabeza+cuerpo+ tablaInicio +columnasEncabezado +valores + " </table> " + volverform+"</body> </html>";
         
         
     }
     
     /**
     * genera un formulario para el ingreso de datos
     * @param  error parametro de error
     * @return formulario
     */
     public String mostrarFormularioIngreso(String error)
     {
         String inicio= " <form> ";
         String pError= "<br>" + error + "</br>";
         String cajaValoresX="<br> Lista Valores Variable Independiente X:</br>  <input type= " + "\""+"text"+"\""+ "name=" + "\"" +"datosx"+"\""+ " size= "+ "\"" +"50"+"\""+">";
          String cajaValoresY="<br> Lista Valores Variable Dependiente Y:</br>  <input type= " + "\""+"text"+"\""+ "name=" + "\"" +"datosy"+"\""+ " size= "+ "\"" +"50"+"\""+">";
         String cajaGlibertad="<br> Valor de X:</br>  <input type= " + "\""+"text"+"\""+ "name=" + "\"" +"xvalor"+"\""+">";
         String boton="<button type="+"\""+"button"+ "onclick="+"\""+"alert('Hello World!')"+"\""+">Ejecutar!</button>";
         String fin = "</form>";
        return inicio + pError + cajaValoresX+ cajaValoresY+boton + cajaGlibertad + fin;      
     }
}

