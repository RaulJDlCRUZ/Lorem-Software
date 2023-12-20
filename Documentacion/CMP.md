#	Introducción al Plan
##	Propósito del plan
La finalidad de este documento es exponer de manera organizada y extensa los procedimientos, responsabilidades y objetivos que tiene Lorem Software para el producto desarrollado.
##	Alcance del plan
Lorem Software propone, a través de este escrito, aplicar este plan a un sistema de gestión de una biblioteca, que la misma empresa tendrá el deber de desarrollar a través de sus empleados, siguiendo las directrices del cliente final, por medio de requisitos funcionales.
Dentro de la GC podemos encontrar algunas limitaciones. Algunas de ellas podemos relacionarlas al diseño de nuestra base de datos, el cual tendrá que ir ligado al entorno de desarrollo de la aplicación y al lenguaje de programación. No obstante, dentro del plan no se incluirá una formación para instalación y uso de la base de datos embebida, se sobreentiende que el equipo ya está formado y capacitado para poder trabajar.
En los CdU se refleja que el usuario final tendrá la página web como interfaz, relegando la terminal de la máquina virtual de Java como medio de depuración, mas supondremos que no será necesario fraccionar del tiempo total de duración del proyecto en formación para el equipo acerca de creación de aplicaciones web, por lo que su aplicabilidad se llevará a cabo hasta la entrega del producto software y mantenimiento de este.
##	Relación con la organización y con otros proyectos
En este caso, la organización cuenta con pocos meses de existencia y pocos integrantes, por lo que este es el primer encargo que acepta la compañía por parte de un cliente final, no obstante, los integrantes de la organización cuentan con años de experiencia en el desarrollo de aplicaciones Backend y Frontend para diversos clientes de numerosos ámbitos, tales como medicina, empresas musicales, multimedia, deportes, gastronomía, etc.
##	Términos clave
Nuestra empresa tendrá definido una serie de términos y definiciones que serán obligatorias para poder desarrollar el producto, que conformarán nuestro glosario del proyecto. En este se incluye:
-	**Depósito Legal.** Obligación, regulada por ley, de depositar para una o más bibliotecas ejemplares de las publicaciones destinadas a su comunicación pública, sin discriminar el soporte. Tiene como finalidad recopilar el patrimonio audiovisual para tenerlo a disposición de los usuarios.
-	**ISBN.** Número internacional asignado por la Agencia Española del ISBN, el cual identifica un libro. 
-	**Java.** Es un lenguaje de programación multiplataforma orientado a objetos lanzado en 1995 por Sun Microsystems. Su objetivo era la independencia de la plataforma, de ahí su amplio uso en aplicaciones web.
-	**Apache Maven.** Herramienta de comprensión y gestión de proyectos de software, que aplica una serie de patrones para construir la infraestructura de un proyecto a fin de proporcionar una visión coherente.
-	**Spring.** Framework que proporciona soporte de infraestructura integral para el desarrollo de aplicaciones.
-	**Spring Boot.** Herramienta de creación de aplicaciones basadas en Spring.
-	**Apache Derby.** Base de datos relacional de código abierto implementada en lenguaje Java.
	Referencias
[https://db.apache.org/derby/]
[https://spring.io]
[https://www.oepm.es/export/sites/portal/comun/documentos_relacionados/Ponencias/133_03_Programa_ponencias.pdf]
LIBRO IAM SOMMERVILLE 7ª EDICION
##	Criterios para la identificación de los elementos de configuración a los cuales la GC será aplicada
En términos generales, un Configuration Item es un conjunto de productos de trabajo que son designados para ser integrados en el control de configuración, es decir, que necesitan ser gestionados y controlados para garantizar los servicios de nuestra empresa. Asimismo, son tratados como unas entidades simples en los procesos asociados. 
Entonces, pueden ser elementos como un plan de proyecto, especificaciones, diseños, programas y datos de prueba, que son susceptibles de cambiar y donde los cambios tienen que ser controlados por un sistema de gestión de la configuración.
No obstante, posibles elementos como sumarios de reuniones de equipo o bosquejos no los incluiremos pese a cumplir los criterios mencionados anteriormente. Es primordial que sean elementos que tengan relevancia a medio y/o largo plazo y/o necesarios para el futuro mantenimiento del sistema. Código fuente por ejemplo sí lo incluimos en este caso. Equipos informáticos como ordenadores personales del equipo de desarrollo, servidores, enrutadores, sistemas operativos, etc. también los excluiremos; pese a ser elementos susceptibles a cambios; más bien nos centraremos en aquellos elementos a los que podamos asignar esquema de asignación de nombre dentro del proyecto.
##	Limitaciones y suposiciones que afectan al plan
La primera de las limitaciones que tiene la empresa es, como hemos mencionado anteriormente, son los propios RRHH que dispone la compañía. Lorem Software es una corporativa con un total de 4 empleados, por lo que esto afecta en cascada al resto de recursos de los que pueda disponer la empresa.
En paralelo con el punto anterior, otra limitación que afecta al plan de la GC son las propias herramientas que se utilizarán. Para el desarrollo de la aplicación no se emplearán kits de desarrollo y utilidades con licencia de pago, debido al bajo presupuesto del que dispone Lorem Software.
Además de los diferentes requisitos funcionales que se han proporcionado para el desarrollo de la aplicación, el cliente ha establecido un par de fechas límites de entrega de la aplicación.
Si la entrega del software de la biblioteca se realiza dentro del plazo indicado, cumple con todas las características recogidas en la ERS, desarrolladas mediante una metodología de desarrollo marcada, Lorem Software aspira a un máximo de 1.4M de €, distribuidos en dos plazos:
-	**Entrega parcial.** La fecha límite es el miércoles 15 de noviembre de 2023, e incluye la línea base de la arquitectura como mínimo producto viable. En esta primera entrega sabemos que el cliente invertirá hasta un máximo de 440.000 €, repartidos de la siguiente manera:

	* Por planificación y gestión: 120.000 €
	* Por codificación: 140.000 €
	* Por gestión de la configuración: 180.000 €

-	**Entrega final.** La fecha límite es el miércoles 20 de diciembre de 2023. En esta entrega se encontrarán todas las características del programa, incluyendo mantenimiento y pruebas pertinentes. En este punto se repartirán hasta un máximo de 960.000 € (el dinero restante repartido en la primera entrega).
No obstante, dentro de estas cláusulas nos encontramos una serie de limitaciones económicas ligadas a la entrega del proyecto:
-	**Entrega hasta 1 semana después de la(s) fecha(s) límite:** 15% menos de lo que nos pagaría al final.
-	**Entrega hasta 2 semana después de la(s) fecha(s) límite:** 25% menos de lo que nos pagaría al final.
-	**Entrega después de 2 semanas de la(s) fecha(s) límite:** NO se admite la aplicación, en este punto el cliente dejará de estar interesado y no realizará ninguna inversión sobre el equipo de desarrollo.
Además, también nos topamos con otra limitación, en este caso de carácter técnico. Tal y como introducimos en la sección 1.2, y debido a que la aplicación la codificaremos en lenguaje Java mediante el entorno Eclipse IDE, se usará una base de datos de tipo Apache Derby embebida, ya que también está implementada en Java y cuenta con integración con los dos elementos de configuración anteriores, por lo que gestores de bases de datos de otros proveedores no entrarán en los planes de Lorem Software.
Por ello, otro tipo de sistemas de gestión de bases de datos no serán viables para el desarrollo del producto, puesto que nuestro entorno de desarrollo no tendrá soporte para otro tipo de SGBD.
A esto le agregamos el sistema web; el equipo deberá contar con conocimientos de desarrollo de aplicaciones web, puesto que por parte de Lorem Software no se impartirá formación de esta índole, con la finalidad de no afectar a las fechas establecidas por el cliente.
##	Responsabilidades y autoridades del plan
Dentro de la estructura de Lorem Software, se puede dividir en dos unidades organizativas, la de ADMINISTRACIÓN Y ASUNTOS CORPORATIVOS (AAC) y la de I+D: 
	* En la primera se recogerán todas las actividades y responsables relacionados con la comunicación con los clientes, análisis de sus requisitos y elaboración de documentación, auditoría, control de cambios, etc.
	* En la segunda, se gestiona el diseño del producto, su implementación, pruebas y mantenimiento.
En próximas secciones veremos en detalle cómo se componen estas unidades organizativas, las responsabilidades que se asignan para la gestión de configuración cómo están conectadas la una con la otra.
##	Organización del proyecto
Lorem Software es una empresa de desarrollo software que está dirigida por el CEO: que es Raúl Jiménez de la Cruz. Será quien organice y tenga un contacto directo con el cliente, y será quien supervise que el plan se esté aplicando correctamente sobre el desarrollo de la aplicación, pudiendo intervenir en el mismo si fuera menester. 
Asimismo, es quien ha estructurado Lorem Software en dos unidades organizativas, siguiendo un patrón de tipo jerarquía. Así pues, nuestra empresa se divide en dos departamentos:
-	**ADMINISTRACIÓN Y ASUNTOS CORPORATIVOS (AAC)**
-	**I+D**
La razón por la que no hay más departamentos es debido al número limitado de empleados que tiene la empresa, por lo que la distribución de empleados con las unidades organizativas será por pares.
Y por esta misma razón los roles y/o recursos asignados que se asocian a cada departamento tendrán un carácter más secundario. De nuevo, debido a la limitación de RRHH comentada en la sección 3, se acuerda que se permite hacer aportaciones entre departamentos activamente, debido a la formación con la que cuentan los empleados.
Por último, en la sección 6 desarrollaremos más exhaustivamente los roles/responsabilidades de cada departamento, pues la finalidad de esta sección es presentar la organización de Lorem Software y relación entre las unidades organizativas y cliente final.
###	Administración y Asuntos Corporativos (AAC)
AAC es la unidad organizativa que poseerá el control sobre la gestión de configuración y la planificación sobre el proyecto. Por lo tanto, AAC tendrá control directo acerca de posibles cambios en la configuración y/o del producto a desarrollar, pudiendo aceptar o rechazar los mismos, gestionando de esta manera el versionado del producto.
Por lo tanto, dentro de este bloque, se encuentran los siguientes integrantes:
	* Raúl Jiménez de la Cruz.
	* Denisa Ioana Iusan.
###	I+D
Investigación y Desarrollo es el bloque donde se resolverán los problemas relacionados con la creación y mantenimiento software, aplicando para ello la metodología de desarrollo de la empresa.  Entonces, quienes componen este departamento son:
	* Pablo Blázquez Sánchez
	* Sandra Blázquez Arriero
	* Responsabilidades de la GC
Tal y como hemos introducido en la sección 5, la empresa se divide en dos unidades jerárquicas. En AAC vimos que es la que se encarga de mantener actualizada la GC y el contacto con el cliente; en I+D se introdujo la creación y mantenimiento del producto como responsabilidades principales.
Sin embargo, la finalidad de esta sección es detallar todas y cada una de las responsabilidades de cada departamento, incluyendo afiliación, vigencia, finalidad y procedimientos, entre otros.

| Actividad | Descripción | U.O donde se aplicará |
|---------|:--------------------------------------------------------------------------------------------------------------------------------------------------------:|:----------:|
| Auditoría |	Verificación de la contabilidad; reparto monetario de la remuneración obtenida por el cliente una vez se ha entregado el producto |	CEO
| Liberación |	El responsable comprueba que la versión/incremento que ha sido puesto en preproducción cumple con los estándares de los usuarios finales y agendas de la empresa; de ser así facilitará la puesta en producción de dicha release |	AAC
| Gestión de manuales de usuario |	Cada vez que se introduzcan nuevas características a la aplicación o se modifiquen las ya existentes, se deberán elaborar documentos que mejore la usabilidad del software al cliente final |	AAC |
| Gestión de agendas de proyecto |	El proyecto de desarrollo de la aplicación de la biblioteca puede estar sujeto a modificaciones y/o limitaciones por parte del cliente, por ejemplo: captación de más requisitos funcionales. Por ello, es crucial que se revise periódicamente los plazos de iteraciones de desarrollo, para que en el caso de que un RF se deba agregar sea menester cambiar los plazos de desarrollo |	CEO |
| Cambios en el CMP | No es frecuente que el plan de gestión de configuración deba ser sometido a cambios, pues los criterios han de ser establecidos al principio del proyecto, mas puede darse el escenario que referencias a políticas o terminología aplicada en Lorem Software sea incorrecta o deba ser corregida. En tal caso, también se recoge como actividad de GC con cierta carga de responsabilidad |	AAC+CEO |
| Actualización de políticas de empresa |	De similar forma al elemento anterior, no es una actividad que deba realizarse con frecuencia, sin embargo, en caso de que un empleado encuentre un vacío o desactualización en las políticas de Lorem Software, debe solucionarse lo antes posible	| AAC |
| Elaboración de resúmenes o transcripciones de reuniones	De manera opcional | puede solicitarse un documento que recoja los puntos clave de una reunión entre empleados de Lorem Software o con el cliente final | AAC |
| Convocatoria de juntas |	La empresa tendrá derecho a realizar juntas con el cliente para proseguir con la captación y/o aclaración de RF, a través de entrevistas directas o muestra de un prototipo | CEO |
| Creación del documento de CdU/RF ERS |	Una vez se ha realizado una entrevista con el cliente, se han capturado las características funcionales que ha de tener el producto software. La responsabilidad de esta actividad recae en almacenar todos ellos en un documento estructurado de manera que pueda pasarse a I+D para su diseño y desarrollo | AAC |
| Elaboración y gestión de modelos de CdU y Diseño |	Cuando AAC ha finalizado la elaboración del documento de ERS, se pasa a los desarrolladores para que puedan modelar el sistema, utilizando bosquejos y/o herramientas de modelaje para ilustrar una primera visión del producto	| I+D |
| Aprobación de modelos de CdU y Diseño |	Los bocetos elaborados por I+D serán los que se empleen para codificar, probar y mantener el software del cliente, por lo que cae en responsabilidad del resto de la empresa en aprobar dicho diseño |	AAC+CEO |
| Creación y mantenimiento del repositorio de trabajo	Como actividad de inicio del proyecto | se creará un repositorio en la plataforma GitHub | AAC + I+D |
| Creación y gestión de ramas de desarrollo (branching) |	Para evitar colisiones entre las características o correcciones de otras entre programadores, una actividad de la GC será crear ramas de desarrollo independientes |	I+D |
| Construcción del sistema | Sustancialmente, esta actividad abarca la codificación de la aplicación de la biblioteca. Para simplificar esta tabla, aquí se incluye la creación de clases, codificación de los métodos, gestión de la aplicación web, creación de la base de datos, etc. | I+D |
| Almacenamiento de deltas y versionado	| Uso de herramientas de gestión de versiones para identificar cada commit y su contenido, con el fin de no entorpecer el trabajo de otros empleados |	AAC + I+D |
| Realización de pruebas unitarias para gestionar el control de errores |	En este punto, el sistema está codificado, mas se requiere hacer monkey testing para encontrar la mayor cantidad de errores posible antes de presentar al cliente la aplicación, pasando antes por AAC y el CEO |	I+D |
| Mantenimiento del sistema |	A partir de aquí, se ha lanzado de manera oficial el producto al cliente, entonces se deberá hacer una revisión de los datos almacenados y del funcionamiento de esta, a través de feedback de la comunidad. Por ejemplo, aquí se recoge la gestión y mantenimiento de la base de datos de la biblioteca |	I+D |
| Elaboración de una wiki del producto |	Además de contar con un manual de usuario, también se lanzará una wiki, exponiendo toda la información del producto software, mostrando sus características e incluso enlaces de descarga |	AAC + I+D |
## Vigencia de las actividades de la GC y/o del CMP
Este plan de GC tendrá un periodo de vigencia hasta enero de 2024, fecha en la que se espera que el producto final ya ha sido entregado al cliente correctamente. Hasta ese entonces, todo el material recogido en este documento será sometido a revisiones, incluyendo de esta forma modificaciones y/o actualizaciones.
##	Políticas aplicables, directivas y procedimientos
Se identificarán todas las políticas de la organización, las directrices y directrices de la dirección, y los procedimientos que se apliquen al esfuerzo planificado. Para cada uno de ellos, se indicará su impacto y efecto en el plan.

Para todo empleado de Lorem Software se le aplicarán una serie de políticas y ToS que deberán haber aceptado durante el ingreso a la compañía; políticas que recogen reglamento de convivencia con los demás empleados, dinámicas de trabajo, y otras regulaciones que puedan brindar una orientación precisa para simplificar tareas y procesos interinos, con el fin de crear un ambiente de trabajo eficiente y ordenado.
*	Para cada característica de desarrollo que se implemente en un producto software, la cantidad de tiempo de trabajo que se deberá aportar como mínimo seguirá la siguiente fórmula:
    - **T_e/N**
* donde T_e=total de tiempo estimado N=total de empleados en I+D 
*	Los días laborables estipulados en la corporación serán todos aquellos que no sean domingos ni festivos –serán los días no laborables, sin embargo, se considerarán de manera extraordinaria aquellas tareas que sean realizadas en días no laborables.
*	El desarrollo es secuencial, por tanto, Lorem Software se reservará el derecho a exigir una dinámica de trabajo que esté fundamentada por la cooperación entre los recursos disponibles.
*	Para el escenario en el que un empleado no cumple con las horas estipuladas en la cláusula número 1 o con el trabajo entregado, la organización podrá reflejar posibles incompetencias en forma de una menor asignación por parte de la auditoría. 
*	Por parte de Lorem Software, se admiten modelos de disponibilidad intermitente para los empleados, es decir, cada integrante podrá organizarse por sí mismo, auto estableciendo sus horarios. Para ello, deberá ponerse en contacto con administración y/o dirección, para proceder a su notificación y validez. Para realizar dicha notificación, se deberá indicar explícitamente las horas de trabajo diarias, pudiendo incluir agendas personales para ello. Las horas diarias deberán regirse a la fórmula indicada en la cláusula 1. Se aceptarán con excepciones en dichas notificaciones los domingos y festivos como días laborables.
*	Para modelos de trabajo intermitente, la comunicación entre los miembros del equipo de desarrollo será necesaria, para llevar un correcto desarrollo de los cambios o novedades. De esta forma, podrá proponerse en próximas reuniones posibles cambios con una marcada coherencia entre desarrolladores.
*	Para que un desarrollador pueda incorporar una función nueva en el producto, ha de existir una reunión previa con AAC y/o el CEO, para que estos le confirmen que existe una aceptación por parte del cliente. Para el instante en que se permita al desarrollador empezar con la nueva función, deberá crear una nueva rama de desarrollo de git, en la que se implementará únicamente esta función, siguiendo la metodología de desarrollo marcada por Lorem Software.
##	Actividades planificadas, agenda y recursos
###	Agendas de la GC
Dentro de los hitos que tiene Lorem Software, el más destacable es el establecimiento de la línea base de arquitectura, para poder lanzar un producto mínimo viable, lo cual tendrá lugar el día 15 de noviembre.
No obstante, la agenda completa del proyecto se puede encontrar en la propia planificación del proyecto, donde se especifica qué días se asignará cada requisito funcional. Esta planificación podrá ser encontrada en la herramienta Github Projects, directamente asociada a la plataforma utilizada para colaborar en la implementación del sistema.
###	Recursos de la GC
El objetivo de esta sección será exponer en un plano general los recursos con los que cuenta Lorem Software para poder desarrollar el producto software:
-	**Personal:**
* Raúl Jiménez De La Cruz
* Pablo Blázquez Sánchez.
* Denisa Iona Iusan.
* Sandra Blázquez Arriero.
-	**Entorno:**
Nuestro entorno predefinido de desarrollo será Eclipse IDE for Java Developers. En él, se cuenta con integración con el lenguaje de programación Java, elaboración de documentación con JavaDoc y extensiones para DBeaver y Apache Maven.
-	**Herramientas de desarrollo:**
Eclipse IDE for Java Developers para la realización del código de nuestro proyecto.   
DBeaver como gestor de nuestra base de datos.   
Visual Paradigm como herramienta de bosquejos para diagramas de casos de uso y diseño.   
Github Projects como herramienta de gestión y planificación del proyecto.   
Github como plataforma de colaboración en la elaboración de documentación, código, etc.   
Spring JPA como API que nos ayuda a los desarrolladores en operaciones de persistencia de datos en una base de datos relacional.
Maven como herramienta gestora de dependencias.
Sonar como herramienta para realizar pruebas y medir el funcionamiento del sistema.
Junit + JaCoCo como herramienta para implementar el entorno de pruebas. JaCoCo es un plugin para la evaluación de cobertura de sentencia.


-	**Capacitación:**
El equipo deberá de saber: 
*	Programación, preferiblemente en lenguaje Java.
*	Protocolos de mantenimiento del sistema.
*	Uso de herramientas diseñados para la elaboración de pruebas del sistema.
*	Desarrollo de aplicaciones web y/o multiplataforma
*	Gestión de bases de datos.
*	Realización de documentación.
*	Diseño / elaboración de bosquejos.
*	Gestión y organización del trabajo.
*	Equipo(s). Cada uno de los integrantes del equipo de desarrollo contará con un computador personal con el que podrá trabajar de manera telemática.
Infraestructura. Para el desarrollo del proyecto, Lorem Software no define una localización específica, por lo que el desarrollo del producto software permite modelos de teletrabajo.
##	Mantenimiento del CMP
El responsable de supervisar el plan de gestión de configuración será el CEO de Lorem Software, contando con el apoyo del resto de la compañía. Por ello, se realizarán actualizaciones periódicamente para cada uno de los ciclos de la planificación del trabajo para el desarrollo del proyecto software. Este mantenimiento podrá tener lugar una vez concluya un ciclo, de esta manera Lorem Software podrá garantizar la calidad y actualidad del plan de gestión de configuración, abarcando la última información relativa al proyecto, de acuerdo con la resolución emitida por el CEO.
Para evaluar y aprobar cambios en el plan, se realizarán reuniones de revisión del ciclo, de tal forma que se expondrán los cambios realizados, y será obligatorio tener feedback por parte de los integrantes del equipo de desarrollo, pues en función de este, se mantendrán o rechazarán dichos cambios.
Para proceder a la realización y comunicación de cambios a dicho plan, se deberá haber establecido con anterioridad la organización del proyecto en ciclos y su calendario. También han de estar establecidos los objetivos de cada ciclo y reparto de tareas, pues es en este punto donde cada integrante de Lorem Software contará con un cambio, en forma de actualización o novedad a aportar al proyecto.
En caso de que existan conflictos acerca de este reparto de tareas, será convocada una reunión con carácter urgente, donde deberá de estar presente la totalidad del equipo de desarrollo, para llegar a un acuerdo o proceder a un nuevo reparto de tareas.

