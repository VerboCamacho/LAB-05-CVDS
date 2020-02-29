# LAB-05-CVDS
# Parte I
---
## Tipos de errores HTTP

1. 4XX: se refieren a errores de cliente. Suelen darse cuando la página que se carga no existe o se tiene el acceso bloqueado a ella. Vamos a revisar los más comunes:

* **400:** la solicitud tiene una sintaxis incorrecta. Significa que las dirección de la página web que se quiere cargar (la URL) tiene un formato no válido.
* **Error 403:** indica que la página solicitada existe pero se ha denegado el acceso a la misma. Por ejemplo, podría tratarse de un contenido exclusivo para usuarios registrados.
* **401:** similar al error 403, pero en este caso existiría una posibilidad de acceso a la misma que no se ha pasado o todavía no se ha superado. Por ejemplo, al cargar la página se podría mostrar una solicitud de usuario y contraseña, que deben ser rellenados para poder acceder a la página. Ninguna página de inicio de una web debería mostrar un error de este tipo, a menos que sea exclusiva de uso interno, no de cara al público.
* **404:** posiblemente el error más común. Indica que la página que se está tratando de cargar no se ha encontrado. Esto puede ocurrir porque hemos escrito mal la dirección de la página web que queremos cargar, que hemos cargado la página a través de un enlace erróneo, o que la página sí que existió en su momento pero ahora ya no.
* **406:** indica que la página ha devuelto un código que no puede ser interpretado por el navegador con el que estamos cargando la página web.

2. 5XX: se refieren a errores del servidor. Pueden generarse por un error en el código de la página web o dentro del propio servidor. Vemos los más usuales:
* **500:** otro error muy común. Indica un error interno, lo que se puede traducir que la página web tiene algún error en el código, por lo que el servidor no puede generar el código HTML para devolver al usuario. Por ejemplo, si en un WordPress existe un error de php, se podría producir ese error 500. Si vemos que nos sale este error tendremos que revisar el log de errores para tratar de localizar el archivo que está generando el error y aplicar las correcciones oportunas.
* **504:** indica que el tiempo de espera para devolver la página web se ha agotado. Puede estar generado por un error en el propio servidor (por ejemplo, se ha «colgado» el Apache) o porque nuestra página web contiene algún código que nunca termina de ejecutarse (por ejemplo, un bucle del que nunca se sale).
* **509:** indica que se ha superado el límite de ancho de banda disponible en el servidor para nuestra página web. Es común que con la contratación del hosting se indique un limite mensual en el ancho de banda, es decir, el número de datos que se puede devolver desde el servidor a los visitantes de nuestra página web.En caso de que tengamos un error de este tipo deberemos ponernos en contacto con el proveedor de nuestro servicio de hosting.
## Telnet
HTTP define un conjunto de métodos de petición para indicar la acción que se desea realizar para un recurso determinado. Aunque estos también pueden ser sustantivos, estos métodos de solicitud a veces son llamados HTTP verbs. Cada uno de ellos implementan una semántica diferente, pero algunas características similares son compartidas por un grupo de ellos: ej. un request method puede ser safe, idempotent, o cacheable.
  *GET*

  - El método GET  solicita una representación de un recurso específico. Las peticiones que usan el método GET sólo deben recuperar datos.

  *HEAD*
  - El método HEAD pide una respuesta idéntica a la de una petición GET, pero sin el cuerpo de la respuesta.

  *POST*
  - El método POST se utiliza para enviar una entidad a un recurso en específico, causando a menudo un cambio en el estado o efectos secundarios en el servidor.

  *PUT*
  - El modo PUT reemplaza todas las representaciones actuales del recurso de destino con la carga útil de la petición.

  *DELETE*
  - El método DELETE borra un recurso en específico.

  *CONNECT*
  - El método CONNECT establece un túnel hacia el servidor identificado por el recurso.

  *OPTIONS*
  - El método OPTIONS es utilizado para describir las opciones de comunicación para el recurso de destino.

  *TRACE*
  - El método TRACE  realiza una prueba de bucle de retorno de mensaje a lo largo de la ruta al recurso de destino.

  *PATCH*
  - El método PATCH  es utilizado para aplicar modificaciones parciales a un recurso.

## Parte II
---
> Punto 20
**Recompile y ejecute la aplicación. Abra en su navegador en la página del formulario, y rectifique que la página hecha anteriormente sea mostrada. Ingrese los datos y verifique los resultados. Cambie el formulario para que ahora en lugar de POST, use el método GET . Qué diferencia observa?**

**GET**
![Image](https://github.com/VerboCamacho/LAB-05-CVDS/blob/master/Imagenes/Capture.PNG)

**POST**
![Image](https://github.com/VerboCamacho/LAB-05-CVDS/blob/master/Imagenes/Capture1.PNG)

* GET y POST : La diferencia entre estos metodos es que POST no muestra los parametros en la URL

> Punto 21
**¿Qué se está viendo? Revise cómo están implementados los métodos de la clase Service.java para entender el funcionamiento interno.**

* Muestran los datos segun el ID solicitado, este solo muestra la informacion con respecto a este valor.

> Diagrama de Clases
## Parte IV
---
> Punto 10

- **Sesión:** Se define con el valor session en el faces-config.xml o con la anotación @SessionScoped en la clase. Las sesiones se definen internamente con el API de Servlets. Una sesión está asociada con una visita desde una navegador. Cuando se visita la página por primera vez se incia la sesión. Cualquier página que se abra dentro del mismo navegador comparte la sesión. La sesión mantiene el estado de los elementos de nuestra aplicación a lo largo de las distintas peticiones. Se implementa utilizando cookies o reescritura de URLs, con el parámetro jsessionid. Una sesión no finaliza hasta que se invoca el método invalidate en el objeto HttpSession, o hasta que se produce un timeout.

- **Aplicación:** Se define con el valor application y con la anotación @ApplicationScoped. Los beans con este ámbito viven asociados a la aplicación. Definen singletons que se crean e inicializa sólo una vez, al comienzo de la aplicación. Se suelen utilizar para guardar características comunes compartidas y utilizadas por el resto de beans de la aplicación.

# Diagramas


**GuessGame**
![Image](https://github.com/VerboCamacho/LAB-05-CVDS/blob/master/Imagenes/image.png)


**Servlet**
![Image](https://github.com/VerboCamacho/LAB-05-CVDS/blob/master/Imagenes/imagen1.PNG)

