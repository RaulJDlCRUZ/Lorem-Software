Hacer un préstamo.

<img width="174" alt="ISO Cdu5" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/5c3bba45-a61a-43b5-bede-be920194af7c">

- Este requisito o función consiste en realizar un préstamo a un cliente de un ejemplar creado sobre un título en nuestro proyecto. Las funciones previas son, como ya se ha 
  indicado previamente, necesarias para desarrollar esta, por ello se sitúa en la posición asignada.
- Para poder realizar un préstamo de cualquier ejemplar debemos de tener una serie de datos, lo cuales serían estos:
    - ISBN.
    -	Id Usuario.
    -	Identificador de ejemplar
    -	Fecha inicio.
    - 	Fecha fin.	
    - 	Activo.
- Los posibles errores que podemos tener con esta funcionalidad, por su estrecha relación, estarán relacionados con los de las funcionalidades de hacer y devolver préstamo mencionadas anteriormente:
    - Que alguna de las características que vayamos a introducir del ejemplar que vamos a prestar no coincida con los datos de ese mismo ejemplar que esta creado y por lo         tanto haya problemas pensando que no existe ese ejemplar cuando sí.
    - Que haya algún error con la base de datos del sistema.
    - Que se intente buscar un ejemplar de un título inexistente o un ejemplar que no existe.
    - Que las fechas de préstamo sean erróneas.

- Además debemos de realizar un control de errores para hacer que estos se minimicen o puedan ser controlados:
    - Comprobar que exista el ejemplar que vamos a prestar, porque no podemos prestar un ejemplar inexistente, entonces se deberá de ver en la base de datos del sistema         que ese ejemplar exista
    - Que la fecha de inicio sea anterior a la fecha de fin del préstamo y, que si se equivocan y las fechas no coinciden se avise del error.
    - Realizar una comprobación de los datos introducidos, que en una casilla en la que se espere un carácter numérico no se introduzca una cadena de texto, etc.
    - Que el ejemplar esté activo y no se vaya a dar un ejemplar que ya no se pueda dar o esté prestado con anterioridad.

- Para este caso de uso tenemos un flujo de eventos que descritos textualmente serian así:
    - Lo primero de todo, el cliente viene a la biblioteca e indica al bibliotecario (o accede como bibliotecario él mismo) que quiere un préstamo. Después, se mete en el         software y busca el ejemplar que quiere tomar prestado el cliente para ver si este existe o no.
    - Posterior a esto el bibliotecario entra en la base de datos y realiza la búsqueda del ejemplar seleccionado por el cliente, para ello introduce los datos necesarios         para encontrar el ejemplar: su id, y así puede ver si este libro se encuentra activo y disponible.
    - Si este se encuentra activo y disponible nos disponemos a meter el id del usuario que quiere realizar el préstamo del libro que estamos buscando y, justo después de         ello nos encargamos de meter la fecha del día actual (la cual será la fecha de inicio) y la fecha de fin, la cual será el último día en el que pueda devolver el             ejemplar.
    - En ese caso, cuando el sistema recibe los datos se encarga de ver que no hay errores: si el id del usuario existe, si no hay problemas o errores con el ejemplar, con         la fecha del préstamo del ejemplar, etc.
        - **Si hay algún error** le devuelve la información al bibliotecario y le indica que hay un error y le muestra donde estaría ese error.
        - En este caso el bibliotecario se encarga de arreglar los errores que haya en la información que intentó introducir al sistema y volverá a mandarla, pero esta vez            con la información correcta.
        - **Si no hay errores** el sistema acepta la información nos indica que se puede realizar el préstamo del ejemplar elegido sin ningún problema y el bibliotecario se           encargará de dar el ejemplar al cliente que lo desea.
    - Cuando el ejemplar ha sido prestado correctamente el administrador ya terminó de realizar todos los cambios necesarios en el sistema y, para finalizar, si no tiene          nada más que realizar, se saldría del sistema.
