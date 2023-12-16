Reservar un ejemplar:

<img width="226" alt="ISO Cdu8" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/384dd9b4-7064-4337-88fb-0d2465f68e09">

Este requisito o función se basa en que un cliente realice la reserva de un ejemplar que quiera coger prestado posteriormente, esto está relacionado con hacer un préstamo de un ejemplar pero no del todo ya que, esto se realizaría cuando un usuario vaya a realizar el préstamo de un ejemplar pero, al buscarlo, no lo encontraría y entonces preguntaría al bibliotecario por el título del libro y los ejemplares de ese. El bibliotecario le indicaría que en esos momentos todos los ejemplares de ese título que está buscando no se encuentran disponibles ya que todos están prestados a otros usuarios pero le indicará que puede reservar un ejemplar para, cuando el primer usuario que devuelva su ejemplar de ese libro, se le avise y pueda así tomar prestado el ejemplar de ese libro.
Para poder realizar una reserva de un ejemplar necesitamos los siguientes datos:
-	ISBN.
-	Título.
-	Número Reserva.
-	Id Usuario.
-	Fecha.

Al estar relacionado con el requisito de realizar el préstamo de un ejemplar, ya que, al reservar un ejemplar queremos realizar posteriormente a ello el préstamo de este, y además, si estamos reservando un ejemplar es porque al intentar tomar prestado un ejemplar no se pudo realizar el préstamo y estamos esperando a que llegue un ejemplar del título que estamos buscando para poder realizar ese préstamo, por lo tanto este requisito tendrá algún error de realizar un préstamo pero con errores únicos de realizar una reserva de un ejemplar:
- Que cuando metamos algún dato del usuario alguno de ellos sea erróneo y no nos encuentre el usuario que quiere realizar la reserva.
- Que haya algún error con la base de datos del sistema.
- Que no exista el título del ejemplar del que se quiere realizar la reserva.

Además debemos de realizar un control de errores para hacer que estos se minimicen o puedan ser controlados:
-	Comprobar que exista el título y ejemplares de este y que, como es necesario que pase para que no se realice el préstamo y se pase a la reserva, comprobar que no haya ningún ejemplar disponible de ese título que busca el usuario.
-	Realizar una comprobación de los datos introducidos, que en una casilla en la que se espere un carácter numérico no se introduzca una cadena de texto, etc.
- 	Que el usuario al que estamos realizando la reserva exista.

Para este caso de uso tenemos un flujo de eventos que descritos textualmente serian así:
- Lo primero de todo, el cliente viene a la biblioteca e indica al bibliotecario que quiere un ejemplar de un título cualquiera. Al indicar el usuario eso al bibliotecario este se mete en el software e introduce el título o ejemplar que quiere el usuario y en el software se le indica que de ese título no tienen ningún ejemplar disponible para prestarle en esos momentos y le indica al usuario que puede realizar una reserva para un ejemplar de ese título.
- Al aceptar el usuario que quiere realizar una reserva de un ejemplar de ese título, se mete en la base de datos para meter todos los datos necesarios para poder realizar la reserva de un ejemplar para ese usuario.
- Al meter los datos necesarios para la reserva del ejemplar pedido por el usuario debemos de ver una cosa con los datos:
    - **Si hay algún error** le devuelve la información al bibliotecario y le indica que hay un error y le muestra donde estaría ese error.
    - En este caso el bibliotecario se encarga de arreglar los errores que haya en la información que intentó introducir al sistema y volverá a mandarla, pero esta vez con la información correcta.
    - **Si no hay errores** el sistema acepta la información nos indica que se realizó la reserva sin ningún tipo de problema.
- Cuando todo se haya realizado correctamente el administrador ya terminó de realizar todos los cambios necesarios en el sistema y, para finalizar, si no tiene nada más que realizar, se saldría del sistema.


