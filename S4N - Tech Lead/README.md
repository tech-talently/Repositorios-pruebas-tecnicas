Prueba técnica JVM 
Descripción de la prueba 
Esta es la prueba técnica para desarrollador backend en S4N. Sin importar si tienes mucha o poca (o ninguna) experiencia esta prueba es para ti, pues deseas desarrollar o continuar tu carrera como backend developer. Esta prueba es una prueba de diseño detallado y no tiene por objetivo verificar si conoces una tecnología (librería o framework) en particular. Lo que buscamos conocer con el resultado entregado es la aproximación de diseño que propongas mediante la separación de responsabilidad, el buen uso del sistema de tipos del lenguaje de programación y el conocimiento de elementos básicos del lenguaje que utilices. Para demostrar estos elementos no es necesario hacer uso de herramientas adicionales al lenguaje seleccionado (a excepción de un sistema de build como por ejemplo maven, gradle, sbt y de alguna librería para pruebas unitarias). Finalmente, consideramos que un desarrollador en una etapa temprana de su carrera tendrá una aproximación diferente al diseño que un desarrollador con más experiencia; es por esto que el enunciado es el mismo y con nuestro criterio determinaremos si el diseño corresponde al seniority (técnico) que propongas tener. 
Expectativa 
Se espera que el candidato proponga una solución orientada a objetos o funcional (FP) al problema. 
Método 
Esta prueba técnica será enviada para que el candidato la haga en su casa. A partir del momento de recibida la prueba el candidato cuenta con 3 días para entregar su resultado. Para la entrega, siga las siguientes instrucciones: 
1. Analiza el documento y date el tiempo de pensar su solución. 2. Toma decisiones de diseño detallado y hazlas realidad en código fuente. Itera en este paso hasta que la solución te satisfaga. 
3. Realiza un screencast de máximo 3 minutos (solo revisaremos hasta el minuto 3 de tu video para hacer una evaluación) en el cual expongas lo siguiente: 
a. Las decisiones de diseño que tomaste. Haga esto mostrando el código fuente y si lo quiere o necesite los esbozos gráficos de sus decisiones.
b. La prueba corriendo. Haz esto mediante la ejecución de los diferentes casos de prueba. 
4. Sube el código a un repositorio público en algún servidor de git (github, bitbucket etc). 
5. Envía el video y el link al repositorio de código a la cuenta de correo talent-acquisition@s4n.co. 
6. Nosotros revisaremos el video y determinaremos si el proceso de selección continúa o si se detiene dado que consideremos que, técnicamente, el candidato debe mejorar aspectos fundamentales en su aproximación al diseño de software. 
Enunciado 
La empresa “Su corrientazo a domicilio” ha contratado a S4N para el desarrollo de una aplicación capaz de operar 20 drones en simultáneo para que haga entrega de almuerzos a diferentes direcciones en la ciudad de Bogotá. 
“Su corrientazo domicilio”, ha decidido que sólo entregará domicilios a 10 cuadras a la redonda de su barrio, el cual puede ser representado con un plano cartesiano. En una siguiente etapa de la implementación se solicitará que se pueda ampliar o reducir este número dependiendo de los resultados del negocio. 
De esta manera, la posición del dron está representada por la combinación de coordenadas X y Y y una letra que corresponde a uno de los puntos cardinales. Por simplificación, el barrio puede ser visto como una grilla. Por ejemplo, (0,0,N) corresponde a la posición del dron en la esquina inferior izquierda de la grilla estando el dron apuntando en dirección norte. 
El dueño de “Su corrientazo a domicilio” será el responsable de escribir los movimientos del dron para llegar a cada destino de cada uno de los almuerzos en el sistema. Su deseo es poder usar un archivo de texto donde anotará las rutas de entrega correspondientes a todos los pedidos del día y así programar las entregas que el dron deberá realizar en el transcurso del mismo. 
Es importante aclarar que el dron es sólo capaz de cargar hasta tres almuerzos por vez; también es importante aclarar que este número de almuerzos puede ampliarse o reducirse dependiendo de los resultados del negocio. Por esta razón, y aprovechando el profundo conocimiento del barrio, el dueño de “Su corrientazo a domicilio” será quien defina las rutas de entrega en el archivo de texto.
Un ejemplo del archivo de texto que ingresaría al sistema para las entrega de un día sería: 
AAAAIAA 
DDDAIAD 
AAIADAD 
Donde: 
● La letra A corresponde a un movimiento hacia adelante. 
● La letra I corresponde a un giro de 90 grados del dron a la izquierda. ● La letra D corresponde a un giro de 90 grados del dron a la derecha. 
Aclaraciones 
● Cada línea del archivo de texto corresponde a una entrega de un almuerzo. 
● El dron siempre inicia en la posición (0, 0) orientación Norte. 
Para el dueño de “Su corrientazo a domicilio” es importante monitorear el estado del dron siempre, razón por la cual espera que el sistema le entrega información de cada una de las entregas realizadas. Por esta razón solicita que una vez terminada la ejecución de las rutas se le entregue un informe en otro archivo de texto de la posición del dron en el plano cartesiano de cada entrega. 
De esta manera, para la primera línea del ejemplo del archivo de texto anterior, se espera que el informe se presente así: 
== Reporte de entregas == 
(-2, 4) dirección Norte 
(-3, 3) dirección Sur 
(-4, 2) dirección Oriente 
El conjunto de rutas de un dron en particular será especificado en un archivo de texto independiente, a saber: in01.txt, in02.txt, in03.txt, ... , in20.txt donde in01.txt corresponde a la ruta de entregas del dron 01, in02.txt corresponde a la ruta de entregas del dron 02 y así sucesivamente.
Así mismo, el resultado de cada uno de los drones deberá quedar en archivos de texto diferentes así: out01.txt, out02.txt, out03.txt, ... , out20.txt donde out01.txt corresponde al reporte del dron 01, out02.txt corresponde al reporte del dron 02 y así sucesivamente. 
Importante 
● Le sugerimos amablemente no realizar UI de su proyecto. No la vamos a leer ni a ejecutar. 
● Realice las entregas de las diferentes partes de la prueba como tags de git en un solo repositorio. Si no lo sabe hacer le sugerimos documentarse con los siguientes enlaces: 
○ Aquí encontrará cómo hacer un tag en git 
■ 
https://git-scm.com/book/en/v2/Git-Basics-Tagging 
○ Si quiere hacerse la vida más fácil le sugerimos usar git-flow y manejar las diferentes versiones como releases. 
■ https://github.com/nvie/gitflow 
■ https://danielkummer.github.io/git-flow-cheatsheet/ 
■ https://datasift.github.io/gitflow/IntroducingGitFlow.html 
● No entregue un (jar, exe, sh, dll o lo que sea) ejecutable. Si su prueba contiene este artefacto como entrega la descartamos inmediatamente. Queremos ver su código. 
● Le sugerimos no usar ningún framework como Spring Boot o similares. Queremos ver su capacidad de diseño en lenguaje plano y sin la ayuda de anotaciones o inyección de dependencias “automática”. 
Preguntas frecuentes 
¿Puedo resolver este problema en un sólo método? 
Esta prueba no es para maratones de programación ni se espera que sea resuelto en un sólo método o función. Se espera una solución orientada a objetos o funcional.
¿Me pueden enviar un archivo de texto de ejemplo? 
No. Consideramos que el enunciado es suficiente. 
¿Puedo hacerlo en Ruby? 
Puede hacer la solución en cualquier lenguaje orientado a objetos o funcional. ¿Debo hacer capa de presentación o UI? 
No. 
¿Puedo usar X o Y o Z librería? 
Sí. Recuerde que un framework es diferente a una librería. 
Tengo una pregunta ¿a quién se la puedo enviar? 
Sólo se responderán preguntas que no se hayan aclarado en este FAQ o que no estén resueltas en el enunciado del problema. Sus preguntas pueden ser enviadas a talent-acquisition@s4n.co. 
Creo que el enunciado está mal y por eso mi código me entrega resultados diferentes. ¿Qué hago? 
En este caso, en la evaluación de su solución que se hace posterior a la entrega de su solución se evaluará el caso que usted haya encontrado como erróneo. Por favor dejar evidencia del error en una prueba unitaria. 
¿Puedo copiar código de otro candidato? 
Lo dejamos a su conciencia. 
¿Puedo enviar los binarios de mi solución sin el código fuente? No. Queremos evaluar su calidad de código y el binario nos lo impediría. ¿Puedo entregar mi código en un archivo comprimido? 
No. La entrega debe hacerla a través del repositorio que le fue enviado al iniciar el proceso con nosotros. 
No sé usar Git. ¿Qué hago? 
Es un buen momento para aprender. 
¿Debo entregar pruebas unitarias? 
Sí.. 
No pude resolver el problema en el tiempo estipulado ¿qué hago?
Escriba a talent-acquisition@s4n.co notificando la situación.
