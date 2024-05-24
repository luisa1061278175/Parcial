package co.edu.uniquindio.punto1;

import java.io.IOException;
import java.util.ArrayList;

public class Main {

    static String ruta = "datosTxt/letras.txt";

    public static void main(String[] args) {
        try {

            ArrayList<Character> contenido = LeerCaracteres.leerArchivo(ruta);
            char[] datos = LeerCaracteres.archivosAVector(contenido);

            Buffer buffer = new Buffer();

            Consumidor consumidor = new Consumidor(buffer);

            P1 p1 = new P1(datos, buffer, consumidor);
            P2 p2 = new P2(datos, buffer, consumidor);

            p1.start();
            p2.start();

            consumidor.start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
