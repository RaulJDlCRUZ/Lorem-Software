Realizar una devolución:

<img width="229" alt="ISO Cdu 6" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/21934a43-85ae-4a91-95e2-9e9b274df380">

Este requisito o función consiste en, una vez realizado el préstamo de alguno de los ejemplares de los títulos que tenemos en nuestra base de datos de la biblioteca, poder registrar cuando se debe de realizar la devolución de este ejemplar y cuando se realiza esta devolución.
Para poder realizar una devolución de un ejemplar necesitamos los siguientes datos:
-	ISBN.
-	Id Usuario.
-	Identificador del ejemplar.
-	Fecha inicio del préstamo.
-	Fecha fin del préstamo.
-	Activo.
Al ser un requisito o funcionalidad que está totalmente relacionada con el requisito o función de Realizar un Préstamo de un ejemplar, va a tener que contemplar una serie de errores que no pueden producirse que serán muy parecidos o los mismos que al Realizar un Préstamo pero añadiendo alguno que es propio de la función de Realizar una Devolución:
- Que alguna de las características que vayamos a introducir del ejemplar que van a realizar su devolución no coincida con los datos de ese mismo ejemplar que esta creado y por lo tanto haya problemas pensando que no existe ese ejemplar cuando sí.
- Que haya algún error con la base de datos del sistema.
- Que se intente buscar un ejemplar de un título inexistente o un ejemplar que no existe.
- Que las fechas de la devolución sean erróneas.
Además debemos de realizar un control de errores para hacer que estos se minimicen o puedan ser controlados:
-	Comprobar que exista el ejemplar y que ese mismo ejemplar ha sido prestado con anterioridad para poder realizar la devolución de este, porque no podemos devolver un ejemplar inexistente o que no haya sido prestado con anterioridad, entonces se deberá de ver en la base de datos del sistema para comprobar la información.
-	Que la fecha de inicio sea anterior a la fecha de fin del préstamo y, que si se equivocan y las fechas no coinciden se avise del error. 
-	Que la fecha de fin del préstamo sea la misma o sea posterior al día en el que se está realizando la devolución, sino, el usuario recibirá una penalización.
-	Realizar una comprobación de los datos introducidos, que en una casilla en la que se espere un carácter numérico no se introduzca una cadena de texto, etc.
- 	Que el ejemplar esté activo y no se vaya a devolver un ejemplar que ya no se pueda dar o no esté prestado con anterioridad.
Para este caso de uso tenemos un flujo de eventos que descritos textualmente serian así:
- Lo primero de todo, el cliente viene a la biblioteca e indica al bibliotecario (o accede como bibliotecario él mismo) que quiere devolver un préstamo. Después, se mete en el software e introduce el ejemplar que quiere devolver el cliente para ver si este existe o no y si fue prestado a ese cliente con anterioridad.
- Posterior a esto el bibliotecario entra en la base de datos y realiza la búsqueda del ejemplar seleccionado por el cliente, para ello introduce los datos necesarios para encontrar el ejemplar: su id, y así puede ver si este libro se encuentra activo y si fue prestado a ese usuario con anterioridad.
- Si este se encuentra activo y ha sido prestado con anterioridad, nos disponemos a meter el id del usuario para asegurar que fue él el que realizó el préstamo y, justo después de ello debemos de revisar la fecha de fin de préstamo, la cual, si es la misma fecha al día actual o es posterior al día actual, no hay problema y podremos realizar la devolución del libro, sino, debemos de poner una penalización al usuario y posterior a ello recoger el libro prestado.
- En ese caso, cuando el sistema recibe los datos se encarga de ver que no hay errores: si el id del usuario existe, si no hay problemas o errores con el ejemplar, con la fecha del préstamo del ejemplar, etc.
    - **Si hay algún error** le devuelve la información al bibliotecario y le indica que hay un error y le muestra donde estaría ese error.
    - En este caso el bibliotecario se encarga de arreglar los errores que haya en la información que intentó introducir al sistema y volverá a mandarla, pero esta vez con la información correcta.
    - **Si no hay errores** el sistema acepta la información nos indica que se puede realizar el préstamo del ejemplar elegido sin ningún problema y el bibliotecario se encargará de, después de revisar como hicimos anteriormente la fecha y ver que todo está bien y no hay problemas con la fecha de fin, de indicar que la devolución se realizó con éxito y guardar el libro de nuevo.
- Cuando todo se haya realizado correctamente el administrador ya terminó de realizar todos los cambios necesarios en el sistema y, para finalizar, si no tiene nada más que realizar, se saldría del sistema.
