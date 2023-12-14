ENTITY:  
-	Clase Título:  
<img width="842" alt="Titulo" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/5e65e116-cb7e-4053-b631-d3764a7895c3">  

Para esta clase los parámetros serían los siguientes:
-	**ISBN:** sería un String o un Int, este es un código de máximo 13 cifras por lo tanto la clase de equivalencia sería desde -∞ hasta 0, desde 0 hasta 9999999999999 (esto es porque, como es un máximo de 13 cifras, el número mayor será el 9 repetido 13 veces) y desde el 9999999999999 hasta +∞. Los valores de equivalencia podrían ser esos que podemos ver en la imagen, los valores límite serían 0 y 9999999999999, y la conjetura de error sería poner más de 13 cifras como por ejemplo ese número de la imagen, poner un número negativo o poner letras.
-	**Título:** sería un String, su clase de equivalencia sería un conjunto de letras o letras y números que formaría ello el título, no tendría ni valores de equivalencia ni valores límite pero la conjetura de error sería poner únicamente un conjunto de números.
-	**numReserva:** sería un String o un int, como clase de equivalencia seria del -∞ al 0, del 0 al 99999 (esto es porque suponemos que el número máximo de reserva sería aproximadamente ese número pero podría cambiarse) y del 99999 al +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 99999 y la conjetura de error podría ser meter un número demasiado grande o un conjunto de letras.
-	**Id:** Sería un int (long), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long o un conjunto de letras.

-	Clase Autor:
<img width="840" alt="Autor" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/7b5fa612-eb04-4634-9837-522d414a49cb">  

Para esta clase los parámetros serían los siguientes:
-	**Nombre:** sería un String, como clase de equivalencia sería un conjunto de letras que conformarían el nombre del autor, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números.
-	**Apellidos:** sería un String, como clase de equivalencia sería un conjunto de letras que conformarían el apellido del autor, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser unos apellidos no deben de meter números.
-	**Id:** Sería un int (long), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long o un conjunto de letras.

-	Clase Ejemplar:
<img width="856" alt="Ejemplar" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/e4e47e42-0b69-4222-80f2-7480a7c218b5">  

Para esta clase los parámetros serían los siguientes:
-	**IdPrestamo:** Sería un int (long), como clase de equivalencia seria de -∞ a 0, de 0 a 2147483647 (ya que el número más grande que puedes introducir en un long) y de 2147483647 a +∞. Sus valores de clase de equivalencia podrían ser por ejemplo los valores que podemos ver en la imagen, los valores límites serian el 0 y el 2147483647 y la conjetura de error podría ser meter un número mayor a 2147483647 que es el máximo del tipo long o un conjunto de letras.
-	**Título:** sería un String, como clase de equivalencia sería un conjunto de letras que conformarían el nombre del libro o ejemplar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner solo números porque, al ser un título no deben de meter solo números.

CONTROLLER:  
-	AutorController:
<img width="828" alt="AutorController" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/8f11748f-ef63-4ccc-bd93-9acc1aac5bc5">

Para esta clase los parámetros serían los siguientes:
-	AltaAutor: sería un String, como clase de equivalencia serían los datos del autor que vamos a dar de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números.
-	AltaAutor/edit: sería un String, como clase de equivalencia serían los datos del autor que vamos a editar en nuestro software y se filtraría y buscaría por el id del autor que vamos a editar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números o que el autor que estamos buscando no exista porque, si no existe el autor, no podremos editar los datos de este.
-	AltaAutor/update: sería un String, como clase de equivalencia serían los datos del autor que vamos a modificar en nuestro software y se filtraría y buscaría por el id del autor que vamos a modificar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números o que el autor que estamos buscando no exista porque, si no existe el autor, no podremos modificar los datos de este.
-	AltaAutor/delete: sería un String, como clase de equivalencia serían los datos del autor que vamos a borrar en nuestro software y se filtraría y buscaría por el id del autor que vamos a editar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números o que el autor que estamos buscando no exista porque, si no existe el autor, no podremos borrar los datos de este.

-	TituloController:
  
<img width="855" alt="TituloController" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/6af2a4ec-0a9e-4abf-a89b-7cab4211cda7">

Para esta clase los parámetros serían los siguientes:
-	ListarTitulos: sería un String o un Array (ya que son todos los títulos que tenemos guardados en nuestra base de datos), como clase de equivalencia serían todos los libros que tenemos dados de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números, o como es un título como mucho podrías meter unos números, pero no un número muy grande.
-	GuardarTitulo: sería un String, como clase de equivalencia serían los datos del título que vamos a dar de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números, o como es un título como mucho podrías meter unos números, pero no un número muy grande.
-	GuardarTitulo /edit: sería un String, como clase de equivalencia serían los datos del título que vamos a editar en nuestro software y se filtraría y buscaría por el id del título que vamos a editar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números , o como es un título como mucho podrías meter unos números, pero no un número muy grande, o que el título que estamos buscando no exista porque, si no existe el título, no podremos editar los datos de este.
-	GuardarTitulo /update: sería un String, como clase de equivalencia serían los datos del título que vamos a modificar en nuestro software y se filtraría y buscaría por el id del título que vamos a modificar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números , o como es un título como mucho podrías meter unos números, pero no un número muy grande, o que el título que estamos buscando no exista porque, si no existe el título, no podremos modificar los datos de este.
-	GuardarTitulo /delete: sería un String, como clase de equivalencia serían los datos del título que vamos a borrar en nuestro software y se filtraría y buscaría por el id del título que vamos a borrar, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería poner números porque, al ser un nombre no deben de meter números , o como es un título como mucho podrías meter unos números, pero no un número muy grande, o que el título que estamos buscando no exista porque, si no existe el título, no podremos borrar los datos de este.

-	EjemplarController:

<img width="852" alt="EjemplarController" src="https://github.com/RaulJDlCRUZ/Lorem-Software/assets/114583652/2bc2a2ab-51b5-4a42-b333-1a3edf35cfbb">

Para esta clase los parámetros serían los siguientes:
-	ListarEjemplares: sería un String o un Array (ya que son todos los ejemplares que tenemos guardados en nuestra base de datos), como clase de equivalencia serían todos los libros que tenemos dados de alta en nuestro software y se filtraría o buscaría por el idTitulo, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería que el título del cual se están listando los ejemplares no exista.
-	AltaEjemplar: sería un String, como clase de equivalencia serían los datos del ejemplar que vamos a dar de alta en nuestro software, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería que el título del cual se está dando de alta el ejemplar no exista, porque entonces no podríamos crear un ejemplar de ese título dicho.
-	AltaEjemplar /delete: sería un String, como clase de equivalencia serían los datos del ejemplar que vamos a borrar en nuestro software y se filtraría y buscaría por el id del préstamo, no tendría ni valores de equivalencia ni valores límites y la conjetura de error sería que el título del cual se está dando de alta el ejemplar no exista, porque entonces no podríamos crear un ejemplar de ese título dicho, o que el ejemplar que queremos borrar no exista, porque entonces no podremos borrar ese ejemplar.


