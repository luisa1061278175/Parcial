package co.edu.uniquindio.punto1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class ArchivoUtil {

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
    static String fechaSistema = "";
    private static void cargarFechaSistema() {

        String diaN = "";
        String mesN = "";
        String añoN = "";

        Calendar cal1 = Calendar.getInstance();


        int dia = cal1.get(Calendar.DATE);
        int mes = cal1.get(Calendar.MONTH) + 1;
        int año = cal1.get(Calendar.YEAR);
        int hora = cal1.get(Calendar.HOUR);
        int minuto = cal1.get(Calendar.MINUTE);


        if (dia < 10) {
            diaN += "0" + dia;
        } else {
            diaN += "" + dia;
        }
        if (mes < 10) {
            mesN += "0" + mes;
        } else {
            mesN += "" + mes;
        }

        //		fecha_Actual+= año+"-"+mesN+"-"+ diaN;
        //		fechaSistema = año+"-"+mesN+"-"+diaN+"-"+hora+"-"+minuto;
        fechaSistema = año + "-" + mesN + "-" + diaN;
        //		horaFechaSistema = hora+"-"+minuto;
    }
    public static void guardarRegistroLog(String mensajeLog, int nivel, String accion, String rutaArchivo) throws IOException {
        String log = "";
        Logger LOGGER = Logger.getLogger(accion);
        FileHandler fileHandler = null;
        cargarFechaSistema();
        try {
            fileHandler = new FileHandler(rutaArchivo, true);
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            switch (nivel) {
                case 1:
                    LOGGER.log(Level.INFO, accion + "," + mensajeLog + "," + fechaSistema);
                    break;

                case 2:
                    LOGGER.log(Level.WARNING, accion + "," + mensajeLog + "," + fechaSistema);
                    break;

                case 3:
                    LOGGER.log(Level.SEVERE, accion + "," + mensajeLog + "," + fechaSistema);
                    break;

                default:
                    break;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SecurityException e) {
            throw new RuntimeException(e);
        }
    }
}
