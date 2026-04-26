# Acceso a Datos: Consultas XQuery y BaseX con Java

Este proyecto ha sido desarrollado como parte de la **Actividad 2** de la UT5: "Bases de datos nativas XML".

La aplicación se comunica con un servidor BaseX local mediante su API (`ClientSession`) para gestionar las BD XML y ejecutar sentencias XQuery.

## Características Principales

* **Uso de `ClientSession`**: Implementación de la API nativa de BaseX para establecer la conexión entre la aplicación y el servidor.
* **Expresiones XQuery**: Ejecución de expresiones XQuery para consultar y actualizar información concreta, como la identificación de autores españoles o la introducción del nodo `<premios>` a un autor.
* **Gestión de Conexión**: Control eficiente y seguro del ciclo de vida de la conexión con el servidor, incluyendo el control de errores y el cierre seguro de esta conexión.

## Funcionamiento

El programa el siguiente flujo de trabajo:

1. **Conexión**: Se crea una sesión con el servidor BaseX, especificando los parámetros de conexión (servidor, puerto, usuario y contraseña).
2. **Creación de DB**: Se crea la base de datos `AutoresDB` utilizando un documento XML estructurado.
3. **Consultas XQuery**: El programa solicita al servidor la lista de nombres de los autores cuya nacionalidad sea "España".
4. **Modificación**: Se actualiza la DB usando una consulta XQuery para añadir el nodo `<premios>` al autor que especifiquemos.
5. **Verificación**: Se muestra por consola la DB completa antes y después de la actualización para confirmar y visualizar los cambios.
6. **Cierre de Conexión**: Se cierra la conexión con el servidor de forma segura y eficiente.

## Instrucciones de Uso

Para ejecutar este programa, es necesario que un servidor de **BaseX** esté activo . 
Se puede utilizar el fichero `.jar` o el código fuente disponibles en las [_releases_](https://git.paualdea.com/paualdea/Java-XQuery-BaseX/-/releases) del proyecto.

---
Este proyecto sirve como evidencia del aprendizaje sobre la manipulación de motores XML nativos y el dominio del lenguaje XQuery para la gestión de datos de la asignatura **Acceso a Datos**.