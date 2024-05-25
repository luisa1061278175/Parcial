package co.edu.uniquindio.punto1;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Semaphore;
//hola
public class Consumidor extends Thread {
    private Buffer buffer;
    private ArchivoUtil archivoUtil;
    private static ArrayList<Character> auxiliar = new ArrayList<>();
    public static char[] arreglo = new char[20];
    public static char[] palabra = {'p', 'r', 'o', 'g', 'r', '@', 'm', 'a', 'c', 'i', 'o', 'n', '_', '3', '#', '2', '0', '2', '4', '%'};
    private static Semaphore semaphore = new Semaphore(0);
    public boolean palabraArmada = false;

    public Consumidor(Buffer t) {
        buffer = t;
    }

    @Override
    public void run() {
        while (!verificarPalabraArmada(arreglo, palabra)) {
            int caracteresConsumidos = 0;
            while (caracteresConsumidos < 5 && !verificarPalabraArmada(arreglo, palabra)) {
                char c = buffer.recoger();
                isContenido(c);
                caracteresConsumidos++;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }
        System.out.println("Ya no consume más, palabra armada correctamente");
        try {
            archivoUtil.guardarRegistroLog("Palabra armada correctamente",1,"Palabra Armada","src/punto1DatosTxt/log.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        escribirLetrasSobrantes();

        semaphore.release();

    }

    public boolean verificarPalabraArmada(char[] arreglo, char[] palabra) {
        boolean palabraArmada = Arrays.equals(arreglo, palabra);
        if (palabraArmada) {
            this.palabraArmada = true;
        }
        return palabraArmada;
    }

    public void isContenido(char c) {
        boolean contenido = false;
        for (int i = 0; i < palabra.length; i++) {
            if (c == palabra[i]) {
                arreglo[i] = c;
                contenido = true;
            }
        }
        if (!contenido) {
            auxiliar.add(c);
        }
        System.out.println("Arreglo con la palabra: " + String.valueOf(arreglo));
        System.out.println("Arreglo con caracteres sobrantes: " + auxiliar);
    }

    public void escribirLetrasSobrantes() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("src/punto1DatosTxt/letrasSobrantes.txt", true))) {
            for (char c : auxiliar) {
                writer.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
