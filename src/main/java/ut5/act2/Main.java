package ut5.act2;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // Creamos un gestor de BaseX con sus parámetros
        GestorBaseX gestor = new GestorBaseX("localhost", 1984, "admin", "admin");

        // XML Estructurado para crear en el servidor
        String xml = "<autores>" +
                "<autor id='1'>" +
                "<nombre>Ana Pérez</nombre><nacionalidad>España</nacionalidad>" +
                "</autor>" +
                "<autor id='2'>" +
                "<nombre>John Smith</nombre><nacionalidad>Reino Unido</nacionalidad>" +
                "</autor>" +
                "</autores>";

        // Creamos la BD pasando cómo parámetro el XML
        gestor.crearBD(xml);

        // Creamos la consulta XQuery personalizada
        String consulta = "for $autor in /autores/autor[nacionalidad='España'] return $autor/nombre/text()";
        // Ejecutamos la consulta XQuery pasando la consulta cómo parámetro
        System.out.println("\n\t.:AUTORES ESPAÑOLES:.");
        System.out.println(gestor.ejecutarConsulta(consulta));

        // Mostramos la BD completa
        System.out.println("\n\t.:DB COMPLETA:.");
        System.out.println(gestor.mostrarDB());

//        // Modificamos los premios indicando el ID y los premios a añadir
//        gestor.anadirPremios(1, 2);
//        // Volvemos a mostrar el XML completo
//        gestor.mostrarDB();
//
//        // Finalizamos la conexión con el servidor de BaseX
//        gestor.cerrarConexion();
    }
}