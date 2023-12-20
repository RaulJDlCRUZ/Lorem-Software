**ENTITY:**  
-	*Clase Título:*  
<img width="842" alt="Titulo" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/5e65e116-cb7e-4053-b631-d3764a7895c3">  

Para esta clase los parámetros serían los siguientes:
-	**ISBN:** sería un String o un Int, este es un código de máximo 13 cifras por lo tanto la clase de equivalencia sería desde -∞ hasta 0, desde 0 hasta 9999999999999 (esto es porque, como es un máximo de 13 cifras, el número mayor será el 9 repetido 13 veces) y desde el 9999999999999 hasta +∞. Los valores de equivalencia podrían ser esos que podemos ver en la imagen, los valores límite serían 0 y 9999999999999, y la conjetura de error sería poner más de 13 cifras como por ejemplo ese número de la imagen, poner un número negativo o poner letras.
-	**Título:** sería un String, su clase de equivalencia sería un conjunto de letras o letras y números que formaría ello el título, no tendría ni valores de equivalencia ni valores límite pero la conjetura de error sería poner únicamente un conjunto de números.
-	**numReserva:** sería un String o un int, como clase de equivalencia seria del -∞ al 0, del 0 al 99999 (esto es porque suponemos que el número máximo de reserva sería aproximadamente ese número pero podría cambiarse) y del 99999 al +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 99999 y la conjetura de error podría ser meter un número demasiado grande o un conjunto de letras.
-	**Id:** Sería un int (long), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long o un conjunto de letras.

-	*Clase Autor:*
<img width="840" alt="Autor" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/7b5fa612-eb04-4634-9837-522d414a49cb">  

Para esta clase los parámetros serían los siguientes:
-	**Nombre:** sería un String, como clase de equivalencia sería un conjunto de letras que conformarían el nombre del autor, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números.
-	**Apellidos:** sería un String, como clase de equivalencia sería un conjunto de letras que conformarían el apellido del autor, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser unos apellidos no deben de meter números.
-	**Id:** Sería un int (long), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long o un conjunto de letras.

-	*Clase Ejemplar:*
  <img width="872" alt="ejemplar" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/84c03028-34fa-44d6-919c-5d0a38fe41ba">

Para esta clase los parámetros serían los siguientes:
-	**IdPrestamo:** Sería un int (long), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long o un conjunto de letras.
-	**Título:** sería un String, como clase de equivalencia sería un conjunto de letras que conformarían el nombre del libro o ejemplar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner solo números porque, al ser un título no deben de meter solo números.
-	**Préstamo:** sería un elemento de la clase Préstamo (ejem que a su vez es un elemento que está en la clase Préstamo pero que ese valor lo coge de la clase Ejemplar (idEjemplar)), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long, un conjunto de letras o el id de un ejemplar que no existe.
-	Reserva: sería un elemento de la clase Reserva (ejem que a su vez es un elemento que está en la clase Préstamo pero que ese valor lo coge de la clase Ejemplar (idEjemplar)), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long, un conjunto de letras o el id de un ejemplar que no existe.

-	*Clase Préstamo:*

<img width="878" alt="prestamo" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/9c23d067-a8ca-467c-8eab-cd35959e9b3e">

Para esta clase los parámetros serían los siguientes:
-	**IdPrestamo:** Sería un int (long), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long o un conjunto de letras.
-	**FechaInicio:** Sería un date, como clase de equivalencia sería una fecha formada por un día, un mes y un año, un valor de la clase de equivalencia podría ser cualquier fecha a utilizar como por ejemplo esa y no tendría valores límite. La conjetura de error sería que introdujese algo que no fuese una fecha o que introdujese una fecha que no sea del formado dd/mm/aa, y además, como es fecha inicio, la fecha debe ser anterior a la fecha fin. 
-	**FechaFin:** Sería un date, como clase de equivalencia sería una fecha formada por un día, un mes y un año, un valor de la clase de equivalencia podría ser cualquier fecha a utilizar como por ejemplo esa y no tendría valores límite. La conjetura de error sería que introdujese algo que no fuese una fecha o que introdujese una fecha que no sea del formado dd/mm/aa, y además, al ser fecha fin, esta fecha debe de ser posterior a la fecha inicio.
-	**Activo:** Será un boolean, como clase de equivalencia sería true o false al igual que los valores de la clase de equivalencia. No tendría valores límites y la conjetura de error sería poner un valor que no fuese true o false.
-	**Ejemplar:** Sería elemento de la clase Ejemplar y se buscaría y filtraría por el idEjemplar, como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long, un conjunto de letras o el id de un ejemplar que no existe.
-	**User:** Sería elemento de la clase Usuario y se buscaría y filtraría por el idUsuario, como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long, un conjunto de letras o el id de un usuario que no existe.



-	*Clase Usuario:*

<img width="844" alt="usuario" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/93df1640-1229-4711-9662-e2ab39c6f14c">


Para esta clase los parámetros serían los siguientes:
-	**idUsuario:** Sería un int (long), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long o un conjunto de letras.
-	**Nombre:** sería un String, como clase de equivalencia sería un conjunto de letras que conformarían el nombre del usuario, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner solo números porque, al ser un nombre no deben de meter solo números.
-	**Apellidos:** sería un String, como clase de equivalencia sería un conjunto de letras que conformarían el apellido del usuario, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner solo números porque, al ser un apellido no deben de meter solo números.
-	**FechaFinPenalización:** Sería un date, como clase de equivalencia sería una fecha formada por un día, un mes y un año, un valor de la clase de equivalencia podría ser cualquier fecha a utilizar como por ejemplo esa y no tendría valores límite. La conjetura de error sería que introdujese algo que no fuese una fecha o que introdujese una fecha que no sea del formado dd/mm/aa.
-	**Préstamos:** Sería un Array, como clase de equivalencia serían todos los préstamos de ejemplares que estén asociados a ese usuario en concreto. No tendría ni valores límite ni tampoco valores de la clase de equivalencia ni conjetura de error porque el préstamo es un número junto con el título del ejemplar prestado.

-	*Clase Reserva:*
  
<img width="840" alt="reserva" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/6bb43bce-b1d0-4fe6-bf81-2064fd457cd7">

Para esta clase los parámetros serían los siguientes:
-	**id:** Sería un int (long), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long o un conjunto de letras.
-	**Fecha:** Sería un date, como clase de equivalencia sería una fecha formada por un día, un mes y un año, un valor de la clase de equivalencia podría ser cualquier fecha a utilizar como por ejemplo esa y no tendría valores límite. La conjetura de error sería que introdujese algo que no fuese una fecha o que introdujese una fecha que no sea del formado dd/mm/aa.
-	**Usuario:** sería un String, como clase de equivalencia sería un conjunto de letras que conformarían el nombre del usuario, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner solo números porque, al ser un nombre no deben de meter solo números.
-	**Título:** sería un String, como clase de equivalencia sería un conjunto de letras que conformarían el título del ejemplar que están reservando, no tendría ni valores de equivalencia ni valores límites y la conjetura de error si pone únicamente un conjunto de números muy grande. 


**CONTROLLER:**  
-	*AutorController:*
<img width="828" alt="AutorController" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/8f11748f-ef63-4ccc-bd93-9acc1aac5bc5">

Para esta clase los parámetros serían los siguientes:
-	**AltaAutor:** sería un String, como clase de equivalencia serían los datos del autor que vamos a dar de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números.
-	**AltaAutor/edit:** sería un String, como clase de equivalencia serían los datos del autor que vamos a editar en nuestro software y se filtraría y buscaría por el id del autor que vamos a editar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números o que el autor que estamos buscando no exista porque, si no existe el autor, no podremos editar los datos de este.
-	**AltaAutor/update:** sería un String, como clase de equivalencia serían los datos del autor que vamos a modificar en nuestro software y se filtraría y buscaría por el id del autor que vamos a modificar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números o que el autor que estamos buscando no exista porque, si no existe el autor, no podremos modificar los datos de este.
-	**AltaAutor/delete:** sería un String, como clase de equivalencia serían los datos del autor que vamos a borrar en nuestro software y se filtraría y buscaría por el id del autor que vamos a borrar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números o que el autor que estamos buscando no exista porque, si no existe el autor, no podremos borrar los datos de este.

-	*TituloController:*
  
<img width="855" alt="TituloController" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/6af2a4ec-0a9e-4abf-a89b-7cab4211cda7">

Para esta clase los parámetros serían los siguientes:
-	**ListarTitulos:** sería un String o un Array (ya que son todos los títulos que tenemos guardados en nuestra base de datos), como clase de equivalencia serían todos los libros que tenemos dados de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números, o como es un título como mucho podrías meter unos números, pero no un número muy grande.
-	**GuardarTitulo:** sería un String, como clase de equivalencia serían los datos del título que vamos a dar de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números, o como es un título como mucho podrías meter unos números, pero no un número muy grande.
-	**GuardarTitulo/edit:** sería un String, como clase de equivalencia serían los datos del título que vamos a editar en nuestro software y se filtraría y buscaría por el id del título que vamos a editar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números , o como es un título como mucho podrías meter unos números, pero no un número muy grande, o que el título que estamos buscando no exista porque, si no existe el título, no podremos editar los datos de este.
-	**GuardarTitulo/update:** sería un String, como clase de equivalencia serían los datos del título que vamos a modificar en nuestro software y se filtraría y buscaría por el id del título que vamos a modificar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números , o como es un título como mucho podrías meter unos números, pero no un número muy grande, o que el título que estamos buscando no exista porque, si no existe el título, no podremos modificar los datos de este.
-	**GuardarTitulo/delete:** sería un String, como clase de equivalencia serían los datos del título que vamos a borrar en nuestro software y se filtraría y buscaría por el id del título que vamos a borrar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números , o como es un título como mucho podrías meter unos números, pero no un número muy grande, o que el título que estamos buscando no exista porque, si no existe el título, no podremos borrar los datos de este.

-	*EjemplarController:*

<img width="852" alt="EjemplarController" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/2bc2a2ab-51b5-4a42-b333-1a3edf35cfbb">

Para esta clase los parámetros serían los siguientes:
-	**ListarEjemplares:** sería un String o un Array (ya que son todos los ejemplares que tenemos guardados en nuestra base de datos), como clase de equivalencia serían todos los libros que tenemos dados de alta en nuestro software y se filtraría o buscaría por el idTitulo, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería que el título del cual se están listando los ejemplares no exista.
-	**AltaEjemplar:** sería un String, como clase de equivalencia serían los datos del ejemplar que vamos a dar de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería que el título del cual se está dando de alta el ejemplar no exista, porque entonces no podríamos crear un ejemplar de ese título dicho.
-	**AltaEjemplar/delete:** sería un String, como clase de equivalencia serían los datos del ejemplar que vamos a borrar en nuestro software y se filtraría y buscaría por el id del préstamo, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería que el título del cual se está dando de alta el ejemplar no exista, porque entonces no podríamos crear un ejemplar de ese título dicho, o que el ejemplar que queremos borrar no exista, porque entonces no podremos borrar ese ejemplar.

-	*PrestamoReservaController:*

<img width="847" alt="prestamoreservacontroller" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/eef765e2-872c-45b3-944f-627a179a364c">

 
Para esta clase los parámetros serían los siguientes:
-	**ListarEjemplares:** sería un String o un Array (ya que son todos los ejemplares que tenemos guardados en nuestra base de datos), como clase de equivalencia serían todos los libros que tenemos dados de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería que el título del cual se están listando los ejemplares no exista.
-	**HacerPrestamo:** sería un String, como clase de equivalencia serían los datos del  ejemplar del que vamos a realizar el prestamo, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería el ejemplar que vamos a prestar no exista o el título de este no exista.
-	**HacerReserva:** sería un String, como clase de equivalencia serían los datos del  ejemplar del cual vamos a realizar la reserva, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería el ejemplar que vamos a reservar no exista o el título de este no exista.
-	**ListarEjemplares/devolverPrestamo:** sería un String o un Array (ya que son todos los ejemplares que tenemos guardados en nuestra base de datos) y se filtraría o buscaría por el id del préstamo, como clase de equivalencia serían todos los libros que tenemos dados de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería que el título del cual se están listando los ejemplares no exista o no haya sido prestado con anterioridad.



-	*UsuarioController:*
  
<img width="873" alt="UsuarioCont" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/0b24e53b-dca3-4a63-8bbc-550ffcbc42d9">
 
Para esta clase los parámetros serían los siguientes:
-	**AltaUsuario:** sería un String, como clase de equivalencia serían los datos del usuario que vamos a dar de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números.
-	**AltaUsuario/edit:** sería un String, como clase de equivalencia serían los datos del usuario que vamos a editar en nuestro software y se filtraría y buscaría por el id del usuario que vamos a editar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números o que el usuario que estamos buscando no exista porque, si no existe el usuario, no podremos editar los datos de este.
-	**AltaUsuario/update:** sería un String, como clase de equivalencia serían los datos del usuario que vamos a modificar en nuestro software y se filtraría y buscaría por el id del usuario que vamos a modificar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números o que el usuario que estamos buscando no exista porque, si no existe el usuario, no podremos modificar los datos de este.
-	**AltaUsuario/delete:** sería un String, como clase de equivalencia serían los datos del usuario que vamos a borrar en nuestro software y se filtraría y buscaría por el id del usuario que vamos a borrar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números o que el usuario que estamos buscando no exista porque, si no existe el usuario, no podremos borrar los datos de este.




