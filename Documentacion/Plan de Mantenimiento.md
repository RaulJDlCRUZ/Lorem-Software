### Inspección, certificación y consultoría
Lo primero de todo se deben de revisar todos los requisitos con el cliente y ver que es lo que quiere para el trabajo que le tenemos que realizar.
En nuestro caso estas son las funciones que quiere nuestro cliente que se desarrollen en el software que debemos entregarle (ordenadas de mayor importancia a menor relevancia):
- **Dar de alta un título (RF1)**: Si no hay ningún título registrado, no se podría realizar ninguna de las demás acciones que se piden en la actividad, por ello este es el requisito funcional con mayor peso de cara al desarrollo del producto software.
- **Actualizar o dar de baja un título (RF2)**: Debe implementarse después de dar de alta un título porque si no hay un título creado no podremos actualizar o dar de baja este. Para poder hacer las pruebas pertinentes en el servidor, debemos tener disponible esta función junto a la de mayor prioridad.
- **Dar de alta un ejemplar (RF3)**: Para desarrollar el resto de las funciones (obviando las dos anteriores) es necesario poder dar de alta un ejemplar. Por ello, se le asigna esta prioridad.
- **Dar de baja un ejemplar (RF4)**: Iría detrás de dar de alta un ejemplar ya que, si no hay ningún ejemplar registrado, no se podría dar de baja. Es necesario para realizar las pruebas pertinentes de la función anterior, al igual que la segunda función descrita en esta lista.
- **Hacer un préstamo (RF5)**: Esto va justo después de cualquier modificación de títulos o ejemplares porque, para poder tomar prestado un libro, necesitamos el título del libro más la cantidad de ejemplares que tenemos disponibles.
- **Hacer una devolución (RF6)**: Este requisito va justo detrás de hacer un préstamo ya que, para poder devolver un libro, debe haber sido previamente prestado.
- **Aplicar una penalización (RF7)**: Las penalizaciones a un cliente se aplican cuando este no devuelve un ejemplar de un libro a tiempo (pasado el periodo de préstamo), por lo tanto, este requisito depende del préstamo de un libro y de la devolución de este ejemplar.
- **Reservar un ejemplar (RF8)**: Este requisito se produciría si nos están pidiendo un libro del cual tenemos todos los ejemplares prestados. En este caso, debemos conocer toda la información proporcionada por las funciones anteriores (los títulos disponibles, los ejemplares, etc.).
- **Borrar las reservas (RF9)**: Para poder realizar la acción de borrar una o varias reservas, antes de ello, debemos de tener creadas las reservas de los distintos ejemplares. Por ello esta función se posiciona justo a continuación de Reservar un ejemplar.

Para poder conseguir esto se ha realizado una reunión con el cliente en la cual nos indicó todo lo que necesitaba en el software, y posteriormente se realizó otra reunión en la cual se expuso lo que se llevaba del software para ver si nuestro cliente lo veía bien, quería realizar algún cambio o anotación o algo.  
Cuando el software estaba terminado realizamos las pruebas de certificación pertinentes para asegurarnos que todo estaba tal cual lo quería el cliente y para asegurarnos también nosotros que todo funcionaba perfectamente para así poder darlo al cliente sin ningún tipo de error ni problema.  
Aun así, tendríamos contacto con el cliente durante un periodo de tiempo para ver si tuviese algún tipo de error durante el principio del uso del software que nosotros no nos hubiésemos dado cuenta de ello, o por si fuese necesario algún cambio o actualización.

   
### Análisis de impacto y coste-beneficio
Para poder realizar el análisis de impacto y de costes/beneficio vamos a ver las aplicaciones utilizadas para el desarrollo de nuestro proyecto y cuáles podrían ser otras alternativas que podrían haber sido utilizadas en vez de haber usado estas:
Las aplicaciones elegidas a utilizar para la realización, testing y mantenimiento de nuestro software son las siguientes:
-	GitHub Projects: Por medio de esta plataforma nuestra empresa ha compartido el código para que sus integrantes encargados de la codificación pudiesen trabajar con un mismo código y a la vez poder, todos y cada uno de ellos, subir sus partes de código para que el resto pueda trabajar con ello. Además, es de ayuda para la organización del proyecto ya que, todos los Sprints han sido organizados y marcados en esta plataforma y toda la documentación necesaria para nuestro proyecto software también se encuentra recogida en esta plataforma.
-	Java (Eclipse): Es el lenguaje de codificación utilizado para la realización de nuestro software, toda la codificación que no es de las interfaces está realizada con este lenguaje.
-	Maven: Es la herramienta de gestión utilizada por nuestra empresa para poder ayudarnos con la parte de codificación en Java (la parte de codificación realizada en Eclipse). Nos ayudó con la gestión de dependencias, generación de informes, etc.
-	Derby: Es el sistema de gestión de base de datos utilizado por nuestra empresa para poder así implementar nuestra base de datos junto con Java.
-	Sonar: Esta ha sido la plataforma utilizada para poder medir la calidad de nuestro código y de nuestro software a medida que iba avanzando nuestro proyecto y que íbamos sumando codificación a este.
-	HTML: Este es el lenguaje utilizado para la realización de la parte de diseño de nuestro software, es decir, todas las interfaces visuales que podemos ver en nuestro software han sido realizadas con este lenguaje de código.
-	JPA (Java Persistence API): Esto nos ofrece una API de Java que nos ayuda a mapear los objetos utilizados en nuestro código a entidades que van a ser usadas en una base de datos.  

Otras alternativas para todas y cada una de ellas que podrían haber sido utilizadas pero al final no se usaron ya que nos podría traer alguna desventaja o porque no podría ser usadas son las siguientes:
-	Para una alternativa de GitHub Projects: podría ser Trello o GitLab.
-	Para una alternativa de Java (Eclipse): podría ser NetBeans.
-	Para una alternativa de Maven: podría ser Gradle o Ant.
-	Para una alternativa de Derby: podría ser MySQL o, incluso, otra opción podría ser Oracle DataBase
-	Para una alternativa de Sonar: otra opción a utilizar podría ser ESLint ya que este puede ser utilizado en Java también.
-	Para una alternativa de JPA: otra opción podría ser EclipseLink.    

Además también estuvimos mirando distintas opciones de hacer nuestro código cambiando clases, entidades, controladores, etc y al final decidimos hacerlo asi. Algunos cambios que realizamos fue, por ejemplo, que en el controller PrestamoReservaController, que en un principio pensamos en hacer dos controllers distintos de manera separada pero, después de ver las características que tienen, y ver que se podían poner en conjunto, decidimos que era mejor ponerlo en conjunto y hacerlo un único controller.  
Lo que nos han dado de pago por todos los servicios ofrecidos y todo especificado sería lo siguiente:
-	Para la parte de Planificación del Proyecto y gestión de este: 200.000€
-	Para la parte de Codificación: 200.000€
-	Para la parte de Gestión de Configuración del proyecto: 300.000€ 
-	Para la Generación de Calidad del proyecto: 400.000€
-	Por último para la Gestión de Mantenimiento del proyecto: 100.000€
-	Todo esto haría un total de 1.400.000€.  

Ahora vamos a explicar las horas que han sido utilizadas para cada una de las partes de nuestro proyecto (para cada una de las iteraciones) para ver así, la relación de horas con el dinero que va a ser entregado (si todo está perfecto):
-	Para la entrega al cliente intermedia, en la cual el cliente nos proporcionaba un feedback sobre cómo veía el software, si necesitaba cambios en algo o si quería añadir algo, se nos daba (si todo estaba perfecto) 440.000€, los cuales estaban definidos en la realización de la planificación y gestión, la codificación, gestión de configuración, de calidad y de mantenimiento de nuestro proyecto desde la función planificada como la It0 () hasta la It5 (), en los cuales esto se desarrolla así:  
•	It0: 30.000€.
•	It1: 85.000€.
•	It2: 75.000€.
•	It3: 70.000€.
•	It4: 80.000€.
•	It5: 100.000€.  
-	Desde esta entrega intermedia al cliente hasta la finalización del plazo que nos proporcionó el cliente para poder terminar el proyecto (día 20 de diciembre del 2023), se han realizado algunas modificaciones indicadas por el cliente a estas funciones ya codificadas y, además, se realizaron el resto de iteraciones necesarias para el funcionamiento correcto de nuestro software, lo cual se reparte en:  
•	It6: 110.000€.
•	It7: 100.000€.
•	It8: 90.000€.
•	It9: 90.000€.
•	It10: 170.000€.
•	Mantenimiento final del software: 200.000€.
•	Testing final: 200.000€.
-	Por lo tanto en esta segunda y última entrega tenemos un total de: 960.000€, en solo esta 2º entrega.

-	Al realizar la suma de la 1º y la 2º entrega se haría el total de 1.400.000€.

  ### Revisión de la documentación
  Debe adaptarse la diferente documentación producida para el proyecto a la situación actual del sistema. Los documentos que se deben ir actualizando en todo momento son:
* Registro de Sprintbacklog: como es lógico pensar, debe irse registrando cualquier cambio y novedad en el sprintbacklog.
* Diseño de pruebas: Pues existe una posible necesidad de modificar las pruebas y el código con la finalidad de mejorar nuestro sistema.
* Seguimiento de calidad de software: Si se implementan nuevos requisitos, ya sean funcionales o no funcionales a lo largo del mantenimiento del sistema por la aparición de una nueva necesidad, debe reflejarse también en la documentación que registra estas funciones.
* CMP: La adición de nuevas herramientas a lo largo del mantenimiento nos obliga a señalizarlo en el CMP del proyecto.
* Planificación del proyecto: Se debe modificar los períodos y la compensación económica asociada al desarrollo de cada función (o iteración). A pesar de esto, se pretende utilizar este documento a modo de registro de la situación inicial en cuanto a planificación del proyecto para compararla a la situación actual, reflejándose una obvia variación en los períodos establecidos y en el esfuerzo estimado.
* Requisitos, análisis y diseño de cada función: Si alguna de las funciones ha sido implementada de manera totalmente distinta a la especificada inicialmente, debe reflejarse también.
* Documentación del usuario: Es necesario actualizar la documentación proporcionada por el usuario, pues se ha realizado una implementación más asequible y óptima a la requerida inicialmente por el cliente (cabiendo resaltar también que este no tiene la obligación de conocer el ámbito de la ingeniería y que es común que se produzcan este tipo de problemas).

### Pruebas de aceptación
El cliente se encargará de comprobar si los cambios realizdos en el software a lo largo de la etapa de mantenimiento se adecúan a sus necesidades, junto al equipo desarrollador de Lorem Software. 
