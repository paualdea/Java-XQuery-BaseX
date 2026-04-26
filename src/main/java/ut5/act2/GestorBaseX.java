package ut5.act2;

import org.basex.api.client.ClientSession;

import java.io.IOException;

/**
 * Clase que gestiona todas las operaciones que se realizan sobre el servidor BaseX.
 */
public class GestorBaseX {
    // Creamos la sesión de conexión al servidor de BaseX
    private ClientSession sesion;

    /**
     * Constructor de la clase. Inicializa la conexión entre la aplicación y la DB.

     * @throws IOException
     * Controlamos la excepción de entrada y salida que puede provocar la sesión de conexión a la DB.
     */
    public GestorBaseX (String servidor, int puerto, String usuario, String passwd) throws IOException {
        // Creamos la sesión usando los parámetros recibidos
        sesion = new ClientSession(servidor, puerto, usuario, passwd);
        System.out.println("Conexión al servidor BaseX completada.");
    }

    /**
     * Función para crear una BD a partir de un XML.

     * @param xml
     * Recibe un XML estructurado para crear la BD.
     * @throws IOException
     * Controlamos la excepción de entrada y salida que puede provocar la sesión de conexión a la DB.
     */
    public void crearBD(String xml) throws IOException {
        try {
            // Ejecutamos una sentencia de creación de DB (AutoresDB) pasando el XML recibido cómo parámetro.
            sesion.execute("CREATE DB AutoresDB " + xml);
            System.out.println("DB AutoresDB creada.");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Función para ejecutar consultas XQuery sobre el servidor BaseX.
     * Devuelve un String del resultado de la consulta.

     * @param consulta
     * Recibe cómo parámetro la consulta XQuery a ejecutar.
     * @return resultadoConsulta
     * Devuelve el resultado de la consulta XQuery.
     */
    public String ejecutarConsulta (String consulta) throws IOException {
        // Ejecutamos la consulta en el servidor BaseX a través de la sesión
        return sesion.execute("XQUERY " + consulta);
    }

    /**
     * Función para mostrar el contenido de la DB.

     * @throws IOException
     * Controlamos la excepción de entrada y salida que puede provocar la sesión de conexión a la DB.
     * @return DBCompleta
     * Devuelve la DB completa tras ejecutar una consulta XQuery.
     */
    public String mostrarDB() throws IOException {
        return sesion.execute("XQUERY /autores");
    }


}
