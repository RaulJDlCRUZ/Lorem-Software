Feature 3

<img width="170" alt="ISO Cdu3" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/4c72cb2e-ebfe-4e01-9501-3890d93692bf">

Dar de alta un ejemplar

Este requisito o función es, al igual que los dos requisitos anteriores, bastante importante en nuestro proyecto. Al tener un título, debemos de poder crear ejemplares de este mismo para así poder realizar el préstamo de ejemplares de ese título, ya que, si no creamos ningún ejemplar, no podremos realizar prácticamente ninguna de las funciones siguientes. 
Para poder dar de alta un ejemplar de cualquier título debemos de tener una serie de datos, lo cuales serían estos: 
-	ISBN del título
-	Identificador del ejemplar 
Al ser un requisito o funcionalidad muy parecida a dar de alta un título y depender de ella (si no tenemos un título, no podemos añadir un ejemplar de ese título), los errores que podemos tener con esta funcionalidad serán los mismos o muy parecidos a los de dar de alta, con alguno adicional:
- Que el ID del ejemplar no coincida con el tipo esperado, es decir, que se introduzca otro tipo de dato o caracteres no válidos.
- Que haya algún error con la base de datos del sistema.
- Que se intente crear un ejemplar de un título inexistente.

Además, debemos de realizar un control de errores para hacer que los errores se minimicen al máximo posible:
-	Comprobar que exista el título del cual vamos a añadir un ejemplar, porque no podemos añadir un ejemplar de un título inexistente.
-	Realizar una comprobación de los datos y los caracteres introducidos para ver si son válidos.
- 	Que no se dupliquen los ejemplares con un mismo id que diferenciaría a unos ejemplares de otros para crearlos además de también diferenciar qué ejemplar se reserva o entrega a cada cliente.

Para este caso de uso tenemos un flujo de eventos que, descrito textualmente, sería así:
- Lo primero de todo, el administrador de la biblioteca, que es el encargado de realizar todos los cambios, actualizaciones, modificaciones de la biblioteca entra al software del sistema y se identifica como el administrador.
- Posterior a esto el administrador entra en la opción de dar de alta un ejemplar y el sistema del software le llevaría a la página en la cual deberá de meter los datos que necesite para dar de alta ese ejemplar a crear.
- Deberá introducir el ISBN del título del cual se desea añadir un ejemplar, y posteriormente el identificador de ese propio ejemplar en la página.
- Cuando tiene todos los datos del ejemplar introducidos se pulsa el botón de crear/añadir el ejemplar nuevo que estábamos creando y así se pasan todos los datos al sistema y estos pasarán, si no hay errores, a la base de datos. 
- En este caso, cuando el sistema recibe los datos se encarga de ver que no hay errores como por ejemplo datos de texto donde debería de haber datos numéricos, si el título existe y crear un ejemplar de este, comprobar el identificador para ver que no se esté duplicando el mismo ejemplar, etc.
    - **Si hay algún error** le devuelve la información al administrador y le indica que hay un error y le muestra donde estaría ese error, si es un error de información          que ha introducido, o si el error es de otro tipo como que el título no existe por lo tanto no puede crear ese ejemplar o si ese ejemplar con ese ID ya estaba creado con anterioridad, etc.
    - En este caso el administrador se encarga de arreglar los errores que haya en la información que intentó introducir al sistema y volver a mandarla, pero esta vez con la información correcta.
    - **Si no hay errores** el sistema acepta la información y guarda el ejemplar creado en la base de datos. Posterior a eso, se nos indicará que el ejemplar fue añadido con éxito y habrá finalizado el proceso.
- Cuando el ejemplar ha sido creado correctamente, el administrador ya terminó de realizar todos los cambios necesarios en el sistema y, para finalizar, si no tiene nada más que realizar, saldría del sistema.

