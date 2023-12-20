Feature 2

<img width="195" alt="ISO Cdu3" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/bea9dff8-b685-48d4-9e5e-25ffbbb806fe">

Actualizar o dar de baja un título

Este requisito o función es bastante importante en nuestro proyecto, ya que, al tener un título debemos de poder modificar su título por si hubiese algún dato erróneo o por si algún dato cambiase con el tiempo y además, también tenemos que poder dar de baja un título ya que, por diferentes motivos, podría nuestro cliente o el administrador de la biblioteca borrar el título, ya sea porque el título ya sea muy antiguo, ya no tengamos más ejemplares porque todos estén ya muy defectuosos, etc.
Para poder actualizar los datos de un título debemos de tener una serie de datos y saber cuál de todos ellos es el dato a cambiar: 
- Título.
- ISBN.
- Nombre del autor.
- Apellido del autor.
- El tipo del título, es decir, si es libro o es revista.
- Número de reserva.

Para dar de baja un título es necesario únicamente conocer su ISBN, al igual que para buscar el título.
Al ser un requisito o funcionalidad muy parecida a dar de alta un título y que depende de ella, ya que si no tenemos ningún título creado no podremos actualizar la información de este ni tampoco podremos dar de baja ese título, los errores que podemos tener con esta funcionalidad serán los mismos o muy parecidos a los de dar de alta, incluyendo alguno único de esta funcionalidad:

- Que alguna de las características del título a introducir no coincida con el tipo de dato que se espera, es decir, que introduzcan datos que no corresponden en la casilla necesaria, por ejemplo, el año, se espere un carácter numérico y la persona que vaya a crear el título introduzca en esa casilla una cadena de texto, etc.
- Que haya algún error con la base de datos del sistema.
- Que se intente borrar o actualizar un título que no existe.

Además debemos de realizar un control de errores para hacer que estos se minimicen o puedan ser controlados:
- Comprobar que exista el título del cual vamos a cambiar alguna característica o vamos a borrar, ya que, si no existe ese título no podremos realizar ningún cambio ni eliminarle y nos dará un error.
- Realizar una comprobación de los datos introducidos, que en una casilla en la que se espere un carácter numérico no se introduzca una cadena de texto, etc.

Para este caso de uso tenemos un flujo de eventos que descritos textualmente serian así:
- Lo primero de todo, el administrador de la biblioteca, que es el encargado de realizar todos los cambios, actualizaciones, modificaciones de la biblioteca entra al software del sistema y se identifica como el administrador.
- Posterior a esto el administrador entra en la opción de Modificar/Borrar un título y el sistema del software le llevaría a la página en la cual deberá de meter los datos que necesite para modificar el título o para darle de baja.
- El administrador debe introducir el ISBN para encontrar el Título que desea modificar.
- Una vez encontrado el título debe elegir la opción que necesite, es decir, elegir si quiere modificar alguna característica y añadir esos datos como nuevos datos del título o si, por otra parte, lo que quiere realizar es dar de baja ese título.
- En ambos casos, cuando el sistema recibe los datos se encarga de ver que no hay errores como por ejemplo datos de texto donde debería de haber datos numéricos, si logra encontrar le título ya creado, etc.
    - **Si hay algún error** le devuelve la información al administrador y le indica que hay un error y le muestra donde estaría ese error, si es un error de información          que ha introducido y debe de cambiarlo o si el error es de otro tipo como que el título o información introducida no existe, como por ejemplo: si va a eliminar un título debemos introducir el ISBN correctamente, y si no no podrá eliminarse y se indicará al usuario.
    - En este caso el administrador se encarga de arreglar los errores que haya en la información que intentó introducir al sistema y volverá a mandarla, pero esta vez con la información correcta.
    - **Si no hay errores** el sistema acepta la información y realiza la acción que haya sido pedida a realizar, ya sea modificar el título o dar de baja este y nos indica que se pudo realizar dicha acción.
- Cuando la información ha sido cambiada o eliminada correctamente el administrador ya terminó de realizar todos los cambios necesarios en el sistema y, para finalizar, si no tiene nada más que realizar, se saldría del sistem
