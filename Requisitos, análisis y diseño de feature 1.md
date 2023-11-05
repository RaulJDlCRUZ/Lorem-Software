Feature 1
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
-	Número de ejemplares.
-	
Al tener que realizar una gran cantidad de apuntes en nuestro requisito de dar de alta un título debemos de tener en cuenta los posibles casos de errores que podríamos llegar
a tener al realizar la implementación de este caso:
-	Que alguna de las características del título a introducir sean erróneas.
-	Que introduzcan datos que no corresponden en la casilla necesaria, es decir, que para, por ejemplo, el año, se espere un carácter numérico y la persona que vaya a crear el
título introduzca en esa casilla una cadena de texto.
-	Que haya algún error con la base de datos del sistema.
-	
Además debemos de realizar un control de errores para hacer que estos se minimicen o puedan ser controlados:
-	Comprobar que solo exista un título, es decir, controlar que no se vuelva a crear un título ya existente para así evitar duplicar un título ya creado.
-	Realizar una comprobación de los datos introducidos, que en una casilla en la que se espere un carácter numérico no se introduzca una cadena de texto, etc.
