"Tarea7 PSP2.1" 
- 201710_CSOF5101_01 CONCEPTOS AVANZADOS DE INGENIERÍA SOFTWARE
- Programa 7 PSP2.1
- Juvenal Alberto Riaño Heredia cod 201710795
- 29/04/2017

-ruta GitHub https://github.com/juvenalr/Tarea7PSP.git
- Instrucciones para ejecutar el programa
    
	
	Para ejecutar el programa existen dos opciones
	
	1. ejecute el programa desde la url https://juvenalpsp7.herokuapp.com/Rangos

	  * los valores ingresados en las cajas de texto de Listas de Valoore Varieble Independinte X y Listas de Valoore Varieble Independinte Y.
		deben ingrsarse con el sigunte formato numero1,numero2,.... Los valores decimales se separan con punto numero.decimal
		en la carpetta psp_forms encontrara un txt llamdo valores_tests con las los valores utilizados en las pruebas
		
	
	
	
  	2. Desplegar la solución en una cuenta heroku

  	* en su computador abre el una consola de comandos y ubíquese en una carpeta de su predilección
	
	* ejecute el comando >git clone https://github.com/juvenalr/Tarea7PSP.git
    
	* ubíquese dentro de la carpeta Tarea7PSP-master > cd Tarea7PSP
	
	* cree un app heroku > heroku create
	   Nota: deberá contar con una cuenta Heroku y haber instalado Heroku CLI en si equipo (https://devcenter.heroku.com/articles/getting-started-with-java#set-up)
    * despliegue los archivos en heroku > git push heroku master
	   Nota: si esta utilizando una cuenta libre de heroku recuerde que solo puede desplegar 5 aplicaciones si ya tiene todas ocupadas necesitara borrar una para realizar el despliegue
    * escale el dyno 	> heroku ps:scale web=1
	*  abra la aplicación >heroku open
	    Nota: en este punto desplegara un error agregue a la url de la aplicación  en el navegador el siguiente texto "/Rangos" sin las comillas
