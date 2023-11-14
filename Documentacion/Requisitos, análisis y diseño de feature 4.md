Feature 4

<img width="198" alt="ISO Cdu4" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/2c08cb14-cace-4af4-a949-e5e53c1d1d2e">

Dar de baja un ejemplar.

Este requisito o función consiste en borrar/eliminar un ejemplar creado sobre un título en nuestro proyecto. Este está relacionado con dar de alta un ejemplar y, a su vez, con dar de baja un título, porque, al dar de baja un título que tengamos en nuestro software, instantáneamente, se darán de baja/eliminarán los ejemplares creados sobre estos títulos.
Para poder dar de baja un ejemplar de cualquier título debemos conocer su identificador, único.
Al ser un requisito o funcionalidad muy parecida a dar de baja/eliminar un título y, que depende de ella y de dar de alta un título o un ejemplar (porque si no hay títulos o ejemplares no puede darse de baja ningún ejemplar), los errores que podemos tener con esta funcionalidad serán los mismos o muy parecidos a los de dar de baja un título, pero añadiendo alguno adicional específico para dar de baja un ejemplar:
- Que el dato introducido para dar de baja el ejemplar no coincida con el tipo de dato que se espera, es decir, que se introduzcan caracteres que no corresponden al ID.
- Que haya algún error con la base de datos del sistema.
- Que se intente borrar un ejemplar de un título inexistente o un ejemplar que no existe.

Además debemos de realizar un control de errores para hacer que estos se minimicen o puedan ser controlados:
-	Comprobar que exista el título del cual vamos dar de baja o eliminar un ejemplar, porque no podemos eliminar un ejemplar de un título inexistente, entonces se deberá de ver en la base de datos del sistema que, ese título del cual queremos eliminar el ejemplar exista.
- 	Que no exista el ejemplar que queramos eliminar o dar de baja, ya que no podemos eliminar algo que no exista.
-	Realizar una comprobación de los datos introducidos, que en una casilla en la que se espere un carácter numérico no se introduzca una cadena de texto, etc.
- 	Que si el título es eliminado, que se eliminen todos los ejemplares que contenga ese título, ya que al no existir ese título ya, tampoco va a existir un ejemplar de este.

Para este caso de uso tenemos un flujo de eventos que descritos textualmente serian así:
- Lo primero de todo, el administrador de la biblioteca, que es el encargado de realizar todos los cambios, actualizaciones, modificaciones de la biblioteca entra al software del sistema y se identifica como el administrador.
- Posterior a esto el administrador entra en la opción de dar de baja / eliminar un ejemplar y el sistema del software le llevaría a la página en la cual deberá de meter los datos que necesite para dar de baja ese ejemplar.
- A continuación, debe introducir el identificador del ejemplar.
- Cuando tiene el dato introducido, se pulsa el botón de eliminar el ejemplar.
- En ese caso, cuando el sistema recibe los datos se encarga de ver que no hay errores como por ejemplo datos de texto donde debería de haber datos numéricos, o si logra no encuentra el ejemplar especificado.
    - **Si hay algún error** le devuelve la información al administrador, le indica que hay un error y le muestra donde estaría ese error (si es un error de información que ha introducido o si el error es de otro tipo como que el ejemplar o el título no existe).
    - En este caso el administrador se encarga de arreglar los errores que haya en la información que intentó introducir al sistema y volverá a mandarla, pero esta vez con la información correcta.
    - **Si no hay errores** el sistema acepta la información y elimina el ejemplar de la base de datos. Posterior a eso, se nos indicará que la información del ejemplar fue eliminada o dada de baja con éxito y habrá terminado con ese ejemplar.
- Cuando el ejemplar ha sido eliminado correctamente el administrador ya terminó de realizar todos los cambios necesarios en el sistema y, para finalizar, si no tiene nada más que hacer, se saldría del sistema.


