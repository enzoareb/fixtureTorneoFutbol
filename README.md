# fixtureTorneoFutbol
app para generar un fixture de torneo de futbol, se utiliza un algoritmo goloso para asignar los arbitros a los partidos y para la interfaz se utiliza window builder

##Descripción del trabajo

El presente trabajo práctico consiste en crear una aplicación con el fin de implementar un algoritmo goloso. El objetivo del mismo es asignar árbitros a partidos de un campeonato, intentando maximizar la equidad de la asignación. Logrando tener un algoritmo lo más eficiente posible en su resultado con una complejidad polinómica

##Diseño
##Estructura de la aplicación

La estructura de la aplicación está conformada por diferentes paquetes que separan las funcionalidades de la misma. De esta manera podemos encontrar el programa segmentado en tres grupos persistencia de datos, código de negocio, y la interfaz visual. En el primer grupo tenemos el paquete archivosJSON que contiene todos los archivos con los datos necesarios que han ser leídos y utilizados por el programa durante su ejecución, también destacamos el paquete imágenes que contiene los archivos de las imágenes utilizadas por la aplicación. En el segundo grupo vamos a encontrar el paquete instancias, el cual contiene todas las clases que se necesitan para crear los objetos necesarios, como así también encontramos la clase torneo que es aquella que realiza la implementación de los algoritmos con los objetos instanciados. El paquete logicaSolver es aquel que contiene las clases encargadas de ejecutar el algoritmo goloso. En el tercer grupo tenemos las clases que nos brindan la interfaz visual de la aplicación. Por último y no menos importante tenemos el paquete controlador que hace la conexión entre el código backend y el frontend de nuestra aplicación y el paquete Principal donde se encuentra la clase que ejecuta la aplicación.
Adicionalmente, por cada clase de negocio implementada se crea su correspondiente Test Suite para testear los métodos implementados.


##Explicación de las clases

##Paquete archivosJSON
Clase ArbitrajesEquiposJson: que se encarga de generar el archivo json correspondiente a los arbitrajes por equipo y leerlo
Clase ArbitrosDisponilbesJson: que se encarga de generar el archivo json correspondiente a los árbitros disponibles y leerlo
Clase EquiposJson: que se encarga de generar el archivo json correspondiente a los equipos del torneo y leerlo
Clase FechaJson: que se encarga de generar el archivo json correspondiente a las fechas y leerlo
Clase NombreArbitrosJson que se encarga de generar el archivo json correspondiente a los nombres de los árbitros y leerlo
Clase PartidoJson: que se encarga de generar el archivo json correspondiente a los partidos y leerlo
Clase TorneoJson: que se encarga de generar el archivo json correspondiente a los datos del torneo y leerlo

##Paquete CONTROLADOR
Clase CONTROLADOR: Se encarga de unir el código lógico de la aplicación con la interfaz gráfica, para así lograr una independencia de ambas partes.

##Paquete imágenes
Guarda las imágenes a utilizar por el proyecto 

##Paquete instancias
Clase arbitro: implementa el objeto arbitro y sus funciones getters and setters. El mismo consta de un número y un nombre que le son asignados como parámetros.
Clase equipo: implementa el objeto equipo y sus funciones getters and setters. El mismo consta de un nombre que le es asignado como parámetro.
Clase fecha: implementa el objeto fecha y sus funciones getters and setters. El mismo consta de un número que le es asignado como parámetro y un array de partidos.
Clase partido: implementa el objeto partido y sus funciones getters and setters. El mismo consta de dos equipos que le son asignados como parámetros y un árbitro.
Clase torneo: el cual consta con una serie de colecciones de equipos, fechas y árbitros, a su vez implementa una matriz de números en donde las filas corresponden a los equipos y las columnas a los árbitros allí se deja registrado la cantidad de veces que ha dirigido cada arbitro a un equipo, también contamos con un Hashmap donde la clave es la fecha y el valor un array de árbitros que se encuentren disponibles para esa fecha.
Dentro de esta clase por medio de los métodos implementados podemos agregar equipos al torneo y generar el fixture correspondiente a los mismos
Asignar nombre a los árbitros y agregarlos a una fecha y partido determinado
También podemos consultar cual es el árbitro con promedio mínimo, es decir que dependiendo de dos equipos determinados se suman las veces que un árbitro los dirigió y luego se divide el resultado en dos, obteniendo así el promedio de cada uno
Clase torneoTest: se crean una suite de test que testean el código de negocio de la clase torneo
Clase Assert: se implementa un método sin repetidos que chequea fecha por fecha que no haya equipos repetidos en cada una de ellas, nos sirve como complemento de torneoTest

##Paquete logicaSolver
Clase solver: es la clase encargada de implementar el algoritmo goloso, para ello desarrollamos la solución de dos formas, una de ellas es recorriendo las fechas, en consecuencia los partidos dentro de ellas y con cada partido buscamos al árbitro con menor promedio y se lo asignamos
por  otro lado la segunda solución es en vez de hacer una asignación lineal , que la misma sea de forma aleatoria donde buscamos una fecha random y un partido random dentro de la misma y ahí asignamos el árbitro con menor promedio, y así sucesivamente hasta completar todo el fixture.
	
##Paquete main
Clase main: es la encargada de iniciar la aplicación llamando al mainVisual de la interfaz grafica

##Paquete visual
Clase mainVIsual: se encarga de inicializar la pantalla principal donde se muestra un menú de botones para acceder a otras ventanas, a su vez establece un fondo determinado por una imagen alusiva al contexto de la aplicación y setea las configuraciones de tamaño, diseño y color de cada uno de estos elementos 
Clase ventanaFixture: se encarga de inicializar la pantalla donde se puede visualizar el fixture, como así también los botones para asignar Árbitros o para volver al menú principal, también se encarga de mostrar las fechas y los partidos de cada una 
Clase ventanaArbitro: se encarga de mostrar por pantalla una grilla con los nombres de los árbitros 
Clase ventanaEquipos: se encarga de mostrar por pantalla donde se puede visualizar los equipos asignados a cada uno de los partidos
Clase ventanaFixtureResuelto: 
Clase fondo/ fondoArbitros / fondoEquipos / FondoFixture: estas clases se encargan de sobrescribir el método Paint de la clase Jpanel para poder setear un fondo con una imagen determinada dependiendo de la ventana que este habilitada en cada momento de la aplicación

##Desarrollo y decisiones de implementación
Con respecto al algoritmo goloso que determina que arbitro es designado para cada encuentro, se optó en primer término usar una implementación donde se recorra todas las fechas del torneo en forma ascendente y así también cada uno de los partidos involucrados en la misma. Luego el algoritmo toma como referencia esos dos equipos y hace un promedio de la cantidad de veces que dirigió cada árbitro a esos dos equipos. Finalmente el árbitro que tenga el mejor promedio es el que es asignado. Al hacer las pruebas notamos lo siguiente:

Siempre al último equipo le tocaba el mismo árbitro, al tratarse de un algoritmo heurístico comprendemos que esto es resultado de que siempre toma la opción más eficiente al comienzo y para el ultimo objeto a analizar siempre le queda la opción de descarte. 
Sin embargo no quisimos quedarnos con este resultado, y decidimos realizar otro algoritmo que no recorra las colecciones de los elementos de forma secuencial sino de forma aleatoria, por lo cual elige la fecha a asignar por metido de un método random y a su vez el partido de esa fecha de la misma manera, luego asigna el árbitro con menor promedio. El algoritmo se repite hasta que todos los partidos hallan quedados completos con sus árbitros correspondientes

##Conclusiones
	Se concluyó el trabajo logrando cumplir con los objetivos propuestos para el mismo, obteniendo una performance del algoritmo goloso que en cuanto a su complejidad  sea buena como así también que la calidad del resultado sea lo más exacta posible .


