package co.edu.uniquindio.punto1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LeerCaracteres {

    public static ArrayList<Character> leerArchivo(String ruta) throws IOException {
        ArrayList<Character> contenido = new ArrayList<Character>();
        FileReader fr = new FileReader(ruta);
        BufferedReader bfr = new BufferedReader(fr);
        String linea = "";
        while ((linea = bfr.readLine()) != null) {
            String[] partes = linea.split(",");
            for (String parte : partes) {
                for (char ch : parte.trim().toCharArray()) {
                    contenido.add(ch);
                }
            }
        }
        bfr.close();
        fr.close();
        return contenido;
    }


    public static char[] archivosAVector(ArrayList<Character> archivo) {
        char[] datos = new char[archivo.size()];
        for (int i = 0; i < archivo.size(); i++) {
            datos[i] = archivo.get(i);
        }
        return datos;
    }

}
