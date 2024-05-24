package co.edu.uniquindio.punto1;

import co.edu.uniquindio.punto1.Buffer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Consumidor extends Thread {
    private Buffer buffer;
    public volatile boolean palabraA = false; // Se usa volatile para garantizar que los hilos vean el cambio en la variable
    volatile boolean condicionPalabraA = false; // Variable de condición
    public static char[] arreglo = new char[20];
    private static char[] palabra = {'p', 'r', 'o', 'g', 'r', '@', 'm', 'a', 'c', 'i', 'o', 'n', '_', '3', '#', '2', '0', '2', '4', '%'};
    private static ArrayList<Character> auxiliar = new ArrayList<>();

    public Consumidor(Buffer t) {
        buffer = t;
    }

    @Override
    public void run() {
        while (!verificarPalabraArmada(arreglo, palabra) && !condicionPalabraA) { // Se verifica la condición
            int caracteresConsumidos = 0;
            while (caracteresConsumidos < 5 && !verificarPalabraArmada(arreglo, palabra) && !condicionPalabraA) { // Se verifica la condición
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

        palabraA = true;
    }

    public boolean verificarPalabraArmada(char[] arreglo, char[] palabra) {
        return Arrays.equals(arreglo, palabra);
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


    public void setCondicionPalabraA(boolean condicionPalabraA) {
        this.condicionPalabraA = condicionPalabraA;
    }
}