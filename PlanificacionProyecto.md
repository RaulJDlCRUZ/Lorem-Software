# Planificación del Proyecto

## Descripción del Proyecto

Este proyecto consiste en gestionar una biblioteca haciendo uso de ciertas funciones esenciales asociadas a un sistema web que se nos ha solicitado desarrollar.
Entre funciones solicitadas por el cliente podemos mencionar: dar de alta títulos y ejemplares, dar de baja títulos y ejemplares, solicitar préstamos, hacer devoluciones, etc.

Gran parte de la información del proyecto es proporcionada mediante el modelo de casos de uso, en el que se puede identificar quiénes son los principales actores, incluyendo así las funciones que desempeñarán:

1. **Usuario**: Es aquel que, desde una terminal de la biblioteca, puede acceder a las funciones concretas que realiza el bibliotecario.

2. **Bibliotecario**: Se encarga de interactuar con los títulos y ejemplares existentes en la base de datos, permitiendo prestar ejemplares existentes, tramitar devoluciones de préstamos o gestionar reservas de ejemplares no disponibles. En este proyecto el bibliotecario desempeña un rol de << cliente >>.

3.	**Administrador**: Es el actor que interactúa de manera más cercana a la base de datos y al servidor en sí. Se encargará de realizar acciones como dar de alta títulos y ejemplares, y también dar de baja esos mismos títulos y ejemplares.

A partir de la información anterior, se puede deducir que la arquitectura es más del estilo cliente/servidor que monolítica, aunque en este caso es conveniente desarrollar totalmente el servidor antes de que el cliente interactúe con él, y no desarrollarlos paralelamente.

## Funciones y Esfuerzos

Estas son las diferentes funciones que se llevarán a cabo en nuestro proyecto, ordenadas de mayor a menor prioridad:

- **Dar de alta un título (RF1)**: Si no hay ningún título registrado, no se podría realizar ninguna de las demás acciones que se piden en la actividad, por ello este es el requisito funcional con mayor peso de cara al desarrollo del producto software.
- **Actualizar o dar de baja un título (RF2)**: Debe implementarse después de dar de alta un título porque si no hay un título creado no podremos actualizar o dar de baja este. Para poder hacer las pruebas pertinentes en el servidor, debemos tener disponible esta función junto a la de mayor prioridad.
- **Dar de alta un ejemplar (RF3)**: Para desarrollar el resto de las funciones (obviando las dos anteriores) es necesario poder dar de alta un ejemplar. Por ello, se le asigna esta prioridad.
- **Dar de baja un ejemplar (RF4)**: Iría detrás de dar de alta un ejemplar ya que, si no hay ningún ejemplar registrado, no se podría dar de baja. Es necesario para realizar las pruebas pertinentes de la función anterior, al igual que la segunda función descrita en esta lista.
- **Hacer un préstamo (RF5)**: Esto va justo después de cualquier modificación de títulos o ejemplares porque, para poder tomar prestado un libro, necesitamos el título del libro más la cantidad de ejemplares que tenemos disponibles.
- **Hacer una devolución (RF6)**: Este requisito va justo detrás de hacer un préstamo ya que, para poder devolver un libro, debe haber sido previamente prestado.
- **Aplicar una penalización (RF7)**: Las penalizaciones a un cliente se aplican cuando este no devuelve un ejemplar de un libro a tiempo (pasado el periodo de préstamo), por lo tanto, este requisito depende del préstamo de un libro y de la devolución de este ejemplar.
- **Reservar un ejemplar (RF8)**: Este requisito se produciría si nos están pidiendo un libro del cual tenemos todos los ejemplares prestados. En este caso, debemos conocer toda la información proporcionada por las funciones anteriores (los títulos disponibles, los ejemplares, etc.).
- **Borrar las reservas (RF9)**: Para poder realizar la acción de borrar una o varias reservas, antes de ello, debemos de tener creadas las reservas de los distintos ejemplares. Por ello esta función se posiciona justo a continuación de Reservar un ejemplar.

Se incide con esta estimación de prioridades en que lo primero que debe estar operativo, casi en su totalidad, es el servidor. Esto también se debe a que es un servidor con unas funciones muy limitadas que son esenciales en la gestión de una biblioteca. El cliente pasa así a un plano relativamente secundario frente a este.


|REF        |CDU        |Requisitos  |Análisis    |Diseño    |Implementación    |Pruebas    |
|:---------:|:---------:|:----------:|:----------:|:--------:|:----------------:|:---------:|
|RF1        |CDU1       |2           |1           |1         |18                |1          |
|RF2        |CDU2       |4           |1           |1         |9                 |5          |
|RF3        |CDU3       |2           |1           |1         |5               |3          |
|RF4        |CDU4       |1           |1           |1         |3                 |5          |
|RF5        |CDU5       |6           |1           |1         |11                |5          |
|RF6        |CDU6       |2           |1           |1         |6                 |1          |
|RF7        |CDU7       |1           |1           |1         |3                 |2          |
|RF8        |CDU8       |3           |1           |1         |8                 |3          |
|RF9        |CDU9       |2           |1           |1         |5                 |2          |

Se incide con esta estimación de prioridades en que lo primero que debe estar operativo, casi en su totalidad, es el servidor. Esto también se debe a que es un servidor con unas funciones muy limitadas que son esenciales en la gestión de una biblioteca. El cliente pasa así a un plano relativamente secundario frente a este.

### Criterios de estimación

|Aspecto          |Valoración  |
|:-----------------:|:---------|
|Requisitos       |Se valora la cantidad de control de errores que hay que tener en cuenta en cada caso de uso.|
|Análisis y Diseño|Se proporcionan múltiples recursos para facilitar esta tarea (diagramas, información textual, etc.), por lo que generalmente será muy baja, incluso más de lo propuesto en la tabla de esfuerzos.|
|Implementación   |Se tendrá en cuenta la cantidad de código reutilizable para implementar las funciones u otros módulos|
|Pruebas          |Se valorará el control de errores a testear|

## Estimación Temporal y Coste del Proyecto

Ahora realizamos la estimación temporal y el coste del proyecto en relación con la cantidad de dinero que se nos va a ofrecer al realizar la entrega al cliente de cada una de las partes de nuestro proyecto.
> [NOTA]
> **Cada iteración corresponde a un caso de uso**

|Fase            |  INICIO   |ELABORACION|           |           |           |CONSTRUCCIÓN|           |           |           |           |TRANSICIÓN|
|----------------|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|:---------:|
|**Iteración**   |  It0      |  It1      |  It2      |  It3      |  It4      |  It5      |  It6      |  It7      |  It8      |  It9      |  It10     |
|**Coste (€)**   |   30.000  |85.000     |75.000     |70.000     |80.000     |100.000    |50.000     |30.000     |60.000     |60.000     |160.000    |
|**Duración (d)**|  4        |  3        | 2         |  1        | 1         |  3        |   4       |  3        |  6        |   6       |   5       |
|**Agenda**      |Semana 1   |Semana 2   |2/3        |Semana 3   |3/4        |Semana 4   |4/5        |Semana 5   |5/6        |Semana 6   |6/7        |

El proyecto está organizado en 2 ciclos:

- **El primer ciclo** concluirá el martes 14 de noviembre y abarcará hasta la iteración 5 (que será el producto mínimo viable), dando lugar a la versión 1.0.0 del proyecto.
- **El segundo ciclo** abarcará el resto de las iteraciones y finalizará el miércoles 20 de diciembre, dando lugar a la versión 2.0.0 del sistema. Cabe resaltar que los períodos establecidos para cada iteración de este ciclo están distribuidos tomando como punto de partida el día 15 de noviembre.

Se ha de tener en cuenta que la duración de cada iteración está estimada de manera que, pudiendo invertir relativamente poco tiempo diario (entre 4 personas), se pueda realizar en el plazo estimado. Las horas de trabajo diarias no son siempre las mismas, sino que varían en función de la disponibilidad de cada uno de los recursos y la necesidad del proyecto. También es importante resaltar que no existe agrupación de funciones en cuanto a recursos en Lorem Software.

## Riesgos

Tras analizar todos los diferentes requisitos que debemos cumplir en nuestro proyecto y realizar un pequeño estudio de ellos, se ha localizado una cantidad de riesgos o problemas que podríamos tener a lo largo de la realización de nuestro proyecto:

- **Control de errores**: Podría darse el escenario en cual los errores de la inserción errónea de datos no fuesen visibles al gestionarse los títulos y toda la información de los libros con cadenas de texto. También podría ser necesario controlar aquellas posibilidades como dar de alta un ejemplar de un título que no existe, solicitar un ejemplar que no existe por no haber unidades de un título...
- **Fallos en la Base de Datos**: Al estar gestionado todo el <<servidor>> por la base de datos, si se produce un fallo en ella, no podríamos acceder a la información necesaria para realizar ninguna de las otras funciones.
- **Vulnerabilidades de seguridad**: Si la información no se codifica apropiadamente y/o no se protege el acceso de los bibliotecarios o el administrador usando, por ejemplo, verificación en dos pasos, el sistema podría verse alterado u observado por un usuario externo.

# Gestión de la Configuración
## Plan de Gestión de la Configuración
//TODO: Implement CMP
