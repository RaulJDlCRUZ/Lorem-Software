# Información relevante
## Objetivos del negocio
Crear un sistema de gestión de una biblioteca para facilitar el registro de préstamos, devoluciones, títulos... Implica más eficacia y más eficiencia a la hora de gestionar la biblioteca.

## Información del dominio
Se especificarán aquellos términos que pueden exceder el dominio de la ingeniería para clarificar la implementación del sistema.
* ISBN: identificador único de un título.
* Ejemplar: libro de un título específico.

## Stakeholders
Son los interesados en el sistema: 
* Usuarios de la biblioteca.
* Bibliotecarios de la biblioteca.
* Administradores de la bilbioteca.
* Ministerio de educación (asumiendo que la biblioteca es pública)

## Entorno operacional
Biblioteca y sus diferentes terminales.

## Entorno organizacional y usuarios del sistema
Se definen las siguientes figuras que harán uso directo del sistema y que forman parte de la organización:
* Administrador: Encargado de gestionar la parte de dar de alta y de baja títulos y ejemplares.
* Bibliotecario: Encargado de gestionar los préstamos, penalizaciones, devoluciones y reservas.
* Usuario: Con funciones de bibliotecario desde un terminal dispuesto para ello.
No se define más información del entorno organizacional.

# Requisitos
## Requisitos funcionales
Los requisitos funcionales implementados son aquellos que definen cómo debe comportarse el sistema para satisfacer las necesidades del usuario. De lo anterior, ya se puede deducir que estos requisitos están íntimamente ligados a las funciones previamente definidas (y también a las historias de usuario), siendo:
* Crear títulos: El cliente ha definido la necesidad de crear títulos para posteriormente añadir ejemplares a estos.
* Borrar/Modificar títulos: También se ha exigido, por parte del cliente, que estos títulos puedan ser borrados o modificados, por si se comete algún error en algún dato o ya no se va a prestar más ese título.
* Dar de alta ejemplares: Son estos ejemplares, relacionados a títulos, los que posteriormente se prestarán definiendo la funcionalidad básica de una biblioteca (negocio del cliente).
* Dar de baja ejemplar: El cliente ha definido esta necesidad porque es necesario poder eliminar un ejemplar del registro del sistema si se pierde, si se rompe, etc.
* Hacer préstamo: Constituye la funcionalidad esencial de la biblioteca. Permite a un usuario acceder a uno de los ejemplares disponibles.
* Hacer devolución: Es necesario para el bibliotecario poder devolver aquellos ejemplares prestados.
* Aplicar penalización: Se ha definido la necesidad de penalizar a un usuario que devuelva un ejemplar más tarde de la fecha definida por defecto.
* Hacer reserva: El cliente ha exigido que cuando un usuario quiera un ejemplar, pueda reservarlo para ser el siguiente que tenga acceso a él, tomándolo prestado.
* Borrar reserva: Se ha exigido que el usuario pueda borrar aquella reserva que haya hecho y que ya no le sea necesaria.

## Requisitos no funcionales
Los requisitos no funcionales son aquellos que especifican restricciones o atributos de calidad en vez de definir cómo debe comportarse el sistema.
* Los tiempos de carga de cada página deben ser razonables.
* Debe existir un límite de caracteres a introducir al crear entidades.
* Se debe disponer de un menú inicial de navegación intuitivo que nos permita llegar a todas las funciones necesarias simplemente pulsando botones
* Se debe controlar que un ejemplar no esté en préstamo para poder eliminarlo, en vez de eliminarlo directamente.
* Debemos controlar que no haya un ejemplar en préstamo de un título que vayamos a eliminar.
* Para evitar errores en la frecuente introducción de nombres más "exóticos" de autores, se presenta la selección de autores de un libro en forma de lista una vez hayan sido previamente añadidos. Por ello, también debe existir una lista de autores en la que se nos permita añadir, modificar y borrar.
* Al darse de alta un título debe darse de alta un ejemplar automáticamente.
* Solo los usuarios previamente creados podrán hacer reservas, tomar un préstamo, hacer devoluciones, borrarlas...
* La penalización por entrega tardía debe aplicarse automáticamente, de manera que se penalizarán 3 días por cada día de devolución tardía.
* Si no se devuelve el ejemplar en 3 meses después del fin del préstamo, se considera el ejemplar como perdido o robado y se penaliza al usuario durante 3 años.
* La reserva tiene una duración automática de 3 días.
* Existe una penalización de 1 semana por cancelar la reserva.
