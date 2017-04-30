"Tarea5 PSP2.1" 
- 201710_CSOF5101_01 CONCEPTOS AVANZADOS DE INGENIERÍA SOFTWARE
- Programa 6 PSP2.1
- Juvenal Alberto Riaño Heredia cod 201710795
- 18/04/2017

-ruta GitHub https://github.com/juvenalr/Tarea6PSP.git
- Instrucciones para ejecutar el programa
    
	
	Para ejecutar el programa existen dos opciones
	
	1. ejecute el programa desde la url https://juvenalpsp6.herokuapp.com/Intervalos

  	2. Desplegar la solución en una cuenta heroku

  	* en su computador abre el una consola de comandos y ubíquese en una carpeta de su predilección
	
	* ejecute el comando >git clone https://github.com/juvenalr/Tarea6PSP.git
    
	* ubíquese dentro de la carpeta Tarea6PSP-master > cd Tarea6PSPPSP
	
	* cree un app heroku > heroku create
	   Nota: deberá contar con una cuenta Heroku y haber instalado Heroku CLI en si equipo (https://devcenter.heroku.com/articles/getting-started-with-java#set-up)
    * despliegue los archivos en heroku > git push heroku master
	   Nota: si esta utilizando una cuenta libre de heroku recuerde que solo puede desplegar 5 aplicaciones si ya tiene todas ocupadas necesitara borrar una para realizar el despliegue
    * escale el dyno 	> heroku ps:scale web=1
	*  abra la aplicación >heroku open
	    Nota: en este punto desplegara un error agregue a la url de la aplicación  en el navegador el siguiente texto "/Intervalos" sin las comillas
