<div align="center">
<table>
    <theader>
        <tr>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/epis.png?raw=true" alt="EPIS" style="width:50%; height:auto"/></td>
            <th>
                <span style="font-weight:bold;">UNIVERSIDAD NACIONAL DE SAN AGUSTIN</span><br />
                <span style="font-weight:bold;">FACULTAD DE INGENIERÍA DE PRODUCCIÓN Y SERVICIOS</span><br />
                <span style="font-weight:bold;">ESCUELA PROFESIONAL DE INGENIERÍA DE SISTEMAS</span>
            </th>
            <td><img src="https://github.com/rescobedoq/pw2/blob/main/abet.png?raw=true" alt="ABET" style="width:50%; height:auto"/></td>
        </tr>
    </theader>
    <tbody>
        <tr><td colspan="3"><span style="font-weight:bold;">Formato</span>: Proyecto Estructura de Datos y Algoritmos</td></tr>
        <tr><td><span style="font-weight:bold;">Aprobación</span>:  2022/03/01</td><td><span style="font-weight:bold;">Código</span>: GUIA-PRLE-001</td><td><span style="font-weight:bold;">Página</span>: 1</td></tr>
    </tbody>
</table>
</div>

<div align="center">
<span style="font-weight:bold;">INFORME DE LABORATORIO</span><br />

<table>
<theader>
<tr><th colspan="6">INFORMACIÓN BÁSICA</th></tr>
</theader>
<tbody>
<tr><td>ASIGNATURA:</td><td colspan="5">Estructura de Datos y Algoritmos</td></tr>
<tr><td>TÍTULO DE LA PRÁCTICA:</td><td colspan="5">Detector de plagio</td></tr>
<tr>
<td>NÚMERO DE PRÁCTICA:</td><td>01</td><td>AÑO LECTIVO:</td><td>2022 A</td><td>NRO. SEMESTRE:</td><td>III</td>
</tr>
<tr>
<td>FECHA DE PRESENTACIÓN:</td><td>15/08/2022</td><td>HORA DE PRESENTACIÓN: 11:55 pm</td><td colspan="3"></td>
</tr>
<tr><td colspan="3">INTEGRANTE(s):
<ul>
      <li><a href="https://">Aco Tito, Anthony Edwin</a></li>
      <li><a href="https://">Llaique Chullunquia, Angie </a></li>
			<li><a href="https://">Contreras Mamani Claudia</a></li>
			<li><a href="https://github.com/Mario-Chura">Chura Puma, Mario Franco</a></li>
</ul>
</td>
<td>NOTA:</td><td colspan="2"></td>
</<tr>
<tr><td colspan="6">DOCENTE(s):
<ul>
<li>Jorge Cristhian Chamby Diaz - jchambyd@unsa.edu.pe</li>
</ul>
</td>
</<tr>
</tbody>
</table>
</div>
  

  
<div align="center"><h2> SOLUCIÓN Y RESULTADOS </h2></div>

### I.	METODOLOGÍA:

#	
1.  Este proyecto tiene por objetivo que los alumnos implementen un sistema de detección de plagio simple (sistema a ser implementado), en el cual, usando como referencia una base de datos, el usuario del sistema enviará un párrafo escrito por el mismo (o copiado de alguna fuente) y lo enviará al sistema, el cual se encarga de realizar las consultas sobre la base de datos a fin de determinar si existió plagio o no.
- Estructura de datos: Como estructura de datos hemos escogido un árbol AVL por las siguientes características:

 	- La propiedad de balanceo garantiza que la altura del árbol sea de O(log n).
		- En cada nodo del árbol se guarda información de la altura.
		- La altura del árbol vacío es -1. 
		- Al realizar operaciones de inserción o eliminación se debe actualizar la información de altura de los nodos y recuperar la propiedad de balanceo si fuera necesario, es decir, si hubiera sido destruida.
		
- Clases utilizadas:

	- ***Class Node:*** Estructura del nodo del árbol AVL (Cada nodo contendrá un grupo de 10 palabras)	
	- ***Class AVLTree:*** Implementación del arbol AVL (Se implementan métodos de inserción, balance, rotación a la derecha, rotación a la izquierda)
	- ***Class Phrase:*** Esta clase almacena un grupo de 10 palabras en su atributo “Data”, luego estos grupos de 10 palabras mediante el método “addword” se usaran para ser insertados en el árbol AVL de la base de datos, también se usa el método “addword”para separar en grupos de 10 palabras el texto a ser comparado.
	- ***Class Document:*** En esta clase posee como atributos nombre “fileName” y el grupo de 10 palabras “phase”; además posee el métodos “createAVL()” el cual nos permite crear los árboles de la base de datos; también tenemos el método “matching” el cual realiza la búsqueda del un frase de 10 palabra en los diferentes árboles de la base de datos.
	- ***Class PlagiarismChecker:*** Esta clase implementa el método “LoadFiles(String[] paths)” el cual nos permite cargar los documentos para la base y el documento a revisar, también tenemos el método “verifyPlagiarism(String path)” en el cual se hacen las verificaciones para corroborar si hay plagio
	- ***Class ResultChecker:*** Esta clase tiene como atributos un arreglo de booleanos con los resultados de las verificaciones.
	- ***Class GUI:*** Esta clase contiene la interfaz para cargar archivos y realizar la ejecución de las verificaciones.
	- ***Class Main:*** Esta clase inicia la ejecución de la interfaz.
	
- Funcionamiento:	
	- Primero se ingresa la base de datos los cuales están compuestos por los archivos .sgm
	
	![imagen](Imagenes/Img1.jpg)
	
	- La base de datos mediante la clase “createAVL()” se introduce en un árbol, este árbol tendrá como nodos un grupo de 10 palabras, este grupo de palabras se forman mediante el método “addword(String word)”
	
	![imagen](Imagenes/Img2.jpg)

	- Se introduce el texto que deseamos verificar si es plagio, para ello este texto mediante el método “addword(String word)” dentro de un bucle irá formando grupos de 10 palabras como se muestra en la imagen:
	
	![imagen](Imagenes/Img3.jpg)
	
	- Se realizará la búsqueda de cada grupo de 10 palabras del texto a buscar en cada árbol que conforman la base de datos esta verificación usa el método “matching”, si encuentra la coincidencia de un grupo de 10 palabras se le considera plagio.
	
	![imagen](Imagenes/Img4.jpg)
   
#

### III.	CONCLUSIONES
#
-En el presente trabajo pudimos  conocer más sobre el árbol AVL, ya que la implementamos como estructura para el almacenamiento de la base de datos, siendo usado con frecuencia su operación de búsqueda el cual es de orden O(log n), la que nos permite encontrar coincidencias para verificar si el archivo de entrada tiene plagio o no. <br>
-Tras el análisis, estudio e investigación acerca de los conceptos importantes a tener en cuenta, más la ayuda y consejos proporcionados por el docente, se pudo hallar la mejor manera para desarrollar y programar bien el sistema con mayor facilidad. <br>


#


<div align="center"><h2> REFERENCIAS Y BIBLIOGRAFÍA </h2></div> <br>

-   Pérez, G. M. C.-. (2016). Definición de los árboles AVL. AVL Definición. Recuperado 2022, de http://163.10.22.82/OAS/AVL_Definicion/index.html
-   Javaz, Z. (s. f.). Diseño e implementación de un árbol binario balanceado (árbol AVL) de algoritmo y estructura de datos Java - programador clic. Programmerclick. Recuperado 15 de agosto de 2022, de https://programmerclick.com/article/3400189243/

