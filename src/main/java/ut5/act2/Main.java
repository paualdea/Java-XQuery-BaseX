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
    }
}