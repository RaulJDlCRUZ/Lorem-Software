Borrar las reservas:

<img width="300" alt="ISO Cdu9" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/e55367fb-d0f5-4148-8951-30d5a8dcb31e">

Este requisito o función consiste en, cuando ya se realizó una reserva y el usuario ya tiene el ejemplar que quería y por el cual realizó la reserva, esa reserva debe de ser borrada para no generar confusiones y dar prioridad a las siguientes reservas que se tengan en cola.
También se puede borrar una reserva porque el mismo usuario que realizó la reserva indique que ya no necesita ese ejemplar o que ya no le interesa ese ejemplar y ya no quiere seguir con la reserva.
Para poder borrar una reserva necesitamos los mismos datos que utilizamos en hacer una reserva de un ejemplar:
-	ISBN.
-	Título.
-	Número Reserva.
-	Id Usuario.
-	Fecha.

Al ser un requisito o funcionalidad que está totalmente relacionada con realizar una reserva porque, si no se realiza una reserva entonces no podremos borrar una de estas reservas, por lo tanto, al igual que necesitan los mismos datos tendrán algunos errores iguales y otros que serán similares.
- Que cuando metamos algún dato del usuario alguno de ellos sea erróneo y no nos encuentre el usuario al que queremos comprobar para ver si hizo anteriormente la reserva y posterior a ello poder borrársela.
- Que haya algún error con la base de datos del sistema.
- Que no exista la reserva de ese usuario y entonces no podemos borrar la reserva. 
- Que no exista el usuario.

Además debemos de realizar un control de errores para hacer que estos se minimicen o puedan ser controlados:
-	Comprobar que exista la reserva realizada por ese mismo usuario para poder borrarla.
-	Comprobar que existe el ejemplar que ha sido reservado.
-	Realizar una comprobación de los datos introducidos, que en una casilla en la que se espere un carácter numérico no se introduzca una cadena de texto, etc.
- Que el usuario al que tenemos que borrar la reserva exista y todos sus datos sean correctos para poder realizar el trabajo de borrar esa reserva.

Para este caso de uso tenemos un flujo de eventos que descritos textualmente serian así:
- Lo primero de todo, el cliente viene a la biblioteca e indica al bibliotecario que quiere borrar una reserva que realizó sobre un ejemplar. Al indicar el usuario eso al bibliotecario este se mete en el software e introduce el id del usuario y en el software se le indica si ese usuario realizó o no la reserva de un ejemplar.
- Al indicarse que si se realizó la reserva de ese ejemplar y por ese usuario, el bibliotecario encargado comprueba todos los datos del ejemplar reservado para ver si es el mismo que indica el usuario y además comprueba que todos los datos sean correctos.
- Al meter los datos necesarios para borrar la reserva del ejemplar pedido por el usuario debemos de ver una cosa con los datos:
    - **Si hay algún error** le devuelve la información al bibliotecario y le indica que hay un error y le muestra donde estaría ese error.
    - En este caso el bibliotecario se encarga de arreglar los errores que haya en la información que intentó introducir al sistema y volverá a mandarla, pero esta vez con la información correcta.
    - **Si no hay errores** el sistema acepta la información nos indica que se borró la reserva sin ningún tipo de problema.
- Cuando todo se haya realizado correctamente el administrador ya terminó de realizar todos los cambios necesarios en el sistema y, para finalizar, si no tiene nada más que realizar, se saldría del sistema.


