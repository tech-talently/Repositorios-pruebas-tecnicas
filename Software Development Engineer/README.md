# SpringBoot-Api-Rest-TechnicalTest
Prueba técnica para validar habilidades de programación con el propósito de aplicar a una vacante de trabajo para el cargo de Software Development Enginner.

## Enunciado de la prueba técnica

Construya un servicio rest en java 8 o superior (puedes usar el framework de tu eleccion) para resolver los siguientes ejercicios:

https://www.hackerrank.com/challenges/java-currency-formatter/problem
https://www.hackerrank.com/challenges/java-date-and-time/problem

Cree un recurso POST para cada ejercicio. Agrega las pruebas unitarias necesarias para validar el funcionamiento de la solución. Usa git para almacenar tu código (procura hacer commits atomicos). Debes elaborar un archivo README.txt en la raíz del repositorio donde expliques tu desarrollo, las instrucciones para ejecutarlo y los comandos CURL para probar cada recurso.

## Configuración de ambiente

Con el proposito de disminuir la compleja tarea de configuración del ambiente de desarrollo se opto por utilizar la tecnología Spring-boot que permite ejecutar aplicaciones Stand-alone. Aunque, también es posible ejecutar las mismas aplicaciones en entornos web con ciertos ajustes de configuración. A continuación, se describirá la manera como debe ser puesta en funcionamiento.

### Maven

Si usted no ha tenido la oportunidad de haber utilizado una herramienta de software, para la gestión y construcción de proyectos, como Maven no se preocupe para el proposito del proyecto es necesario que tenga en cuenta que debe realizar los siguientes pasos para descargar librerias que el proyecto necesita y para validar que el proyecto no presente ninguna inconsistencia. Luego, de descargar el proyecto, en Eclipse, proceda a realizar las siguientes acciones:

- Descargar librerias: en Eclipse, ubicarse encima de la raíz del proyecto y dar boton derecho, buscar la opción en el menú desplegable, "Maven" y luego seleccionar la opción "Update Project...". En ese instante empezara a descargar las librerias necesarias, tomara unos minutos hacerlo.

- Validar que el proyecto no presente inconsistencias: en Eclipse, ubicarse encima de la raíz del proyecto y dar boton derecho, buscar la opción en el menú desplegable, "Run As" y luego seleccionar la opción "Maven install". Al final, en la consola aparecera un mensaje en mayuscula similar a este: "BUILD SUCCESS" si todo esta correcto.

## Iniciar servicio rest

Buscar en el proyecto, el archivo:

`com.hackerrank.challenges.ChallengesApplication.java`

Dar boton derecho encima de este y buscar la opción en el menú desplegable "Run As", luego seleccionar la opción "Java Application". Despues, en la consola de Eclipse usted podra apreciar como un servidor embebido, propio de la tecnología Spring-boot, inicia. Hay que tener en cuenta, que el servidor utiliza por default el puerto 8080, si actualmente lo esta utilizando opte por dejarlo libre o considere cambiar el puerto en el siguiente archivo de propiedades:

`/src/main/resources/application.properties`

Adicione una linea al final, como el ejemplo:

`server.port=8090`

## Usar servicios

#### Para utilizar el servicio /currencyformatter, usar la siguiente url:

`http://localhost:8080/currencyformatter`

***Request***

```json
{
  "payment": 12324.134
}
```

***Response***

```json
{
  "us": "$12,324.13",
  "india": "Rs.12,324.13",
  "china": "￥12,324.13",
  "france": "12 324,13 €"
}
```
*si, 0 <= payment <= 10ˆ9, entonces:*

```json
{
  "timestamp": "2019-12-15T17:28:40.791+0000",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Payment value not allowed: -12324.134",
  "path": "/currencyformatter"
}
```

#### Para utilizar el servicio /dateandtime, usar la siguiente url:

***Request***

```json
{
  "month":8,
  "day":5,
  "year":2015
}
```

***Response***

```json
{
  "dayWeek": "WEDNESDAY"
}
```

*si, 2000 <= year <= 3000, entonces:*

```json
{
  "timestamp": "2019-12-15T17:31:46.466+0000",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Year not allowed: 1981",
  "path": "/dateandtime"
}
```
## REST API con CURL

***/currencyformatter***

`curl -d '{"payment":1234.134}' -H 'Content-Type: application/json' http://localhost:8080/currencyformatter`

***/dateandtime***

`curl -d '{"month":8,"day":5,"year":2015}' -H 'Content-Type: application/json' http://localhost:8080/dateandtime`


## OpenShift

Es un producto de computación en la nube de plataforma como servicio (PaaS) de Red Hat. Los desarrolladores pueden usar Git para desplegar sus aplicaciones Web en diferentes lenguajes. Los servicios fueron desplegados en esta plataforma, a continuación, se relacionan las url:

http://challenges5-springboot.apps.ca-central-1.starter.openshift-online.com/currencyformatter

http://challenges5-springboot.apps.ca-central-1.starter.openshift-online.com/dateandtime

## Pruebas unitarias

En total se implementarion 5; 4 del servicio /currencyformatter; y 1 del servicio /dateandtime. Estan ubicadas en el siguiente archivo:

`src/test/java/com/hackerrank/challenges/ChallengesApplicationTests.java`

Ejemplo, /currencyformatter, comprueba el formato de divisas para el país US:

```java
@Test
void currencyFormatterUs() {
  RequestCurrencyFormatter payment = new RequestCurrencyFormatter();
  payment.setPayment(123);
  ResponseCurrencyFormatter responseCurrencyFormatter = currencyFormatterService.execute(payment);
  assertThat(responseCurrencyFormatter.getUs()).isEqualTo("$123.00");
  }
```
Ejemplo, /dateandtime, comprueba que el día de la semana corresponde a la fecha introducida:

```java
@Test
void dateandtime() {
  RequestDateAndTime date = new RequestDateAndTime();
  date.setMonth(8);
  date.setDay(5);
  date.setYear(2015);
  ResponseDateAndTime responseDateAndTime = dateAndTimeService.execute(date);
  assertThat(responseDateAndTime.getDayWeek()).isEqualTo("WEDNESDAY");
  }
```

## Restricciones

Para cada restricción, solicitada por los ejercicios, se implemento una excepción. Estan ubicadas en el siguiente paquete:

`com.hackerrank.challenges.exception`

Ejemplo de implementación, restricción año no permitido:

```java
public class YearNotAllowedException extends RuntimeException {
  private static final long serialVersionUID = 1L;
  public YearNotAllowedException(String year) {
    super("Year not allowed: " + year);
  }
}
```

```java
  if (!(y > 2000 && y < 3000)) {
  throw new YearNotAllowedException(String.valueOf(y));
  }
```
***Response***

```json
{
  "timestamp": "2019-12-15T17:31:46.466+0000",
  "status": 500,
  "error": "Internal Server Error",
  "message": "Year not allowed: 1981",
  "path": "/dateandtime"
}
```
