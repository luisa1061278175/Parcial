package co.edu.uniquindio.punto1;

public class Buffer {

    private char buffer[] = new char[15];
    private int siguiente = 0;
    private boolean estaLlena = false;
    boolean estaVacia = true;
    public boolean palabraArmada = false;

    public synchronized char recoger() {
        while (estaVacia) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        siguiente--;
        if (siguiente == 0) estaVacia = true;
        estaLlena = false;
        notify();
        return (buffer[siguiente]);
    }


    public synchronized void lanzar(char c) {
        while (estaLlena) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer[siguiente] = c;
        siguiente++;
        if (siguiente == 15) estaLlena = true;
        estaVacia = false;
        notify();
    }

}
