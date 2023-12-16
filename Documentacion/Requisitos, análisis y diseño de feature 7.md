Aplicar una penalización:

<img width="340" alt="ISO Cdu7" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/c252a113-78a0-498e-a0be-40a7c08efa35">

Este requisito o función consiste en, una vez realizado el préstamo de alguno de los ejemplares de los títulos que tenemos en nuestra base de datos de la biblioteca, al venir el usuario a realizar la devolución del ejemplar que le prestamos, debemos de comprobar la fecha de fin del préstamo, si la fecha de fin es la misma a la fecha de hoy o es posterior a la fecha de hoy, entonces el ejemplar fue devuelto con éxito, si no coincide, entonces se le aplicará una penalización al usuario que realizó el préstamo y devolución del ejemplar.
Para poder realizar una penalización necesitamos los siguientes datos:
-	Id Usuario
-	Nombre
-	Apellidos
-	Fecha Fin Penalización
-	Fecha
-	Fecha Inicio
-	Fecha Fin
-	Activo

Al ser un requisito o funcionalidad que está totalmente relacionada con el requisito o función de Realizar una Devolución de un préstamo de un ejemplar, va a tener que contemplar una serie de errores que no pueden producirse que serán muy parecidos o los mismos que al Realizar una Devolución pero añadiendo alguno que es propio de la función de Aplicar una Penalización:  
- Que cuando metamos algún dato del usuario alguno de ellos sea erróneo y no nos encuentre el usuario al que tenemos que penalizar.
- Que haya algún error con la base de datos del sistema.
- Que no exista la devolución o no se haya realizado esta.
- Que no exista el usuario a penalizar.
 
Además debemos de realizar un control de errores para hacer que estos se minimicen o puedan ser controlados:
-	Comprobar que exista el ejemplar y que ese mismo ejemplar ha sido devuelto con anterioridad para poder ver si hay que realizar o no una penalización al usuario.
-	Que la fecha de inicio sea anterior a la fecha de fin del préstamo y, que si se equivocan y las fechas no coinciden se avise del error. 
-	Que la fecha de fin del préstamo sea la misma o sea posterior al día en el que se está realizando la devolución, sino se realizará la penalización.
-	Realizar una comprobación de los datos introducidos, que en una casilla en la que se espere un carácter numérico no se introduzca una cadena de texto, etc.
- 	Que el usuario al que tenemos que penalizar exista y todos sus datos sean correctos para poder así aplicar la penalización necesaria.

Para este caso de uso tenemos un flujo de eventos que descritos textualmente serian así:
- Lo primero de todo, el cliente viene a la biblioteca e indica al bibliotecario que quiere devolver un préstamo. Después, el bibliotecario, se mete en el software e introduce el ejemplar que quiere devolver ese cliente para ver si este existe o no y si fue prestado a ese cliente con anterioridad.
- Posterior a esto el bibliotecario entra en la base de datos y realiza la búsqueda del ejemplar seleccionado por el cliente, para ello introduce los datos necesarios para encontrar el ejemplar: su id, y así puede ver si este libro se encuentra activo y si fue prestado a ese usuario con anterioridad.
- Si este se encuentra activo y ha sido prestado con anterioridad, nos disponemos a meter el id del usuario para asegurar que fue él el que realizó el préstamo y, justo después de ello debemos de revisar la fecha de fin de préstamo, la cual, si es la misma fecha al día actual o es posterior al día actual, no hay problema y podremos realizar la devolución del libro, sino, debemos de poner una penalización al usuario que nos está devolviendo el libro prestado.
- Al ver que este usuario se pasó de la fecha límite (fecha fin) de la cual debería de devolver el ejemplar prestado, le saltará al bibliotecario una alarma en el software creado y le indicará que el libro fue devuelto fuera de fecha.
- Dependiendo de la cantidad de tiempo que se haya pasado de tiempo nuestro usuario podrá tener distintos tipos de penalizaciones, si es de 1 o 2 días podrá ser únicamente un aviso pero, si tiene más de 1 aviso se penalizaría, si es de más tiempo, dependiendo del tiempo podría llegar a ser penalizado con un tiempo sin poder coger ningún ejemplar de la biblioteca o con otros tipos de penalizaciones pudiendo llegar, si el tiempo excedido es demasiado alto, a retirársele el carnet de la biblioteca a ese usuario ya sea de manera temporal o para siempre.
- Una vez aplicada la penalización, necesitamos guardar el libro que han venido a devolver y para ello debemos comprobar los datos del libro (ya que los datos del usuario ya fueron comprobados con anterioridad y al poder aplicar la penalización no se dio ningún tipo de error):
    - **Si hay algún error** le devuelve la información al bibliotecario y le indica que hay un error y le muestra donde estaría ese error.
    - En este caso el bibliotecario se encarga de arreglar los errores que haya en la información que intentó introducir al sistema y volverá a mandarla, pero esta vez con la información correcta.
    - **Si no hay errores** el sistema acepta la información nos indica que se puede realizar la penalización al usuario sin ningún problema y podrá guardar el libro de nuevo.
- Cuando todo se haya realizado correctamente el administrador ya terminó de realizar todos los cambios necesarios en el sistema y, para finalizar, si no tiene nada más que realizar, se saldría del sistema.


