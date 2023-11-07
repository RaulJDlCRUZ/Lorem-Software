Feature 1

<img width="178" alt="ISO Cdu2" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/8e314f68-817b-41e3-895f-a1eb7abd896f">

Dar de alta un título:

Este requisito o función es la más importante de nuestro proyecto, ya que sin títulos no podremos tener ejemplares de libros que están en la biblioteca y que, próximamente,
serán prestados a los distintos clientes de esa biblioteca. 
Por lo tanto, si no se da de alta algún título no se podría realizar ninguno de los siguientes requisitos o funciones dados por el cliente a cumplir en nuestro proyecto.

Para dar de alta un título debemos de saber una serie de datos como: 
- Título a introducir.
-	ISBN.
-	Nombre del autor.
-	Apellido del autor.
-	El tipo del título, es decir, si es libro o es revista.
-	Número de reserva.

Al tener que realizar una gran cantidad de apuntes en nuestro requisito de dar de alta un título debemos de tener en cuenta los posibles casos de errores que podríamos llegar
a tener al realizar la implementación de este caso:
-	Que alguna de las características del título a introducir sean erróneas.
-	Que introduzcan datos que no corresponden en la casilla necesaria, es decir, que para, por ejemplo, el año, se espere un carácter numérico y la persona que vaya a crear el
título introduzca en esa casilla una cadena de texto.
-	Que haya algún error con la base de datos del sistema.

Además debemos de realizar un control de errores para hacer que estos se minimicen o puedan ser controlados:
-	Comprobar que solo exista un título, es decir, controlar que no se vuelva a crear un título ya existente para así evitar duplicar un título ya creado.
-	Realizar una comprobación de los datos introducidos, que en una casilla en la que se espere un carácter numérico no se introduzca una cadena de texto, etc.

Para este caso de uso tenemos un flujo de eventos que descritos textualmente serian así:
- Lo primero de todo, el administrador de la biblioteca, que es el encargado de realizar todos los cambios, actualizaciones, modificaciones de la biblioteca entra al software del sistema y se identifica como el administrador.
- Posterior a esto el administrador entra en la opción de Añadir/Modificar un título y el sistema del software le llevaría a la página en la cual deberá de meter los datos necesarios para crear el nuevo título en el software del sistema de la biblioteca.
- Lo primero de todo debe de introducir el nombre del libro/revista que vaya a crear, después de ello introduce el ISBN, el nombre del autor que escribió ese título, los apellidos de este, el tipo del título que está introduciendo, si es libro o si es revista y por último el número de reserva.
- Cuando tiene todos los datos del título introducidos en el software pulsa el botón de crear o añadir para así poder pasar los datos al sistema.
- Cuando el sistema recibe los datos se encarga de ver que no hay errores como por ejemplo datos de texto donde debería de haber datos numericos, si el título se encuentra creado con anterioridad y entonces no podría crearse de nuevo, etc.
    - **Si hay algún error** le devuelve la información al administrador y le indica que hay un error y le muestra donde estaría ese error, si es un error de información          que ha introducido y debe de cambiarlo o si el error es de otro tipo como que el título esta duplicado, etc.
    - En este caso el administrador se encarga de arreglar los errores que haya en la información que intentó introducir al sistema y volverá a mandarla, pero esta vez con
      la información correcta.
    - **Si no hay errores** el sistema acepta la información y la guarda en la base de datos del sistema para el posterior uso de esta información en la página de la 
      biblioteca.
- Cuando la información ha sido añadida correctamente el administrador ya terminó de añadir toda la información necesaria y, para finalizar, si no tiene nada más que añadir o modificar, se saldría del sistema.
