package co.edu.uniquindio.punto1;

public class P1 extends Thread {
    private char[] lista;
    private Buffer buffer;
    private Consumidor consumidor;

    private char[] arregloPalabra;

    public P1(char[] arregloPalabra, Buffer buffer, Consumidor consumidor) {
        this.lista = arregloPalabra;
        this.buffer = buffer;
        this.consumidor = consumidor;
        this.arregloPalabra = arregloPalabra;
    }



    public static boolean esConsonante(char c) {
        c = Character.toLowerCase(c);
        return Character.isLetter(c) && !esVocal(c);
    }

    public static boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static boolean isCaracterEspecial(char c) {
        char[] caracteresEspeciales = {'!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '=', '+', '{', '}', '[', ']', '|', '\\', ':', ';', '\"', '\'', '<', '>', '?', '/', '.', '`'};

        for (char especial : caracteresEspeciales) {
            if (c == especial) {
                return true;
            }
        }

        return false;
    }

    @Override
    public void run() {
        for (char c : arregloPalabra) {
            if ((esConsonante(c) || isCaracterEspecial(c))) {
                System.out.println("Hilo 1 crea: " + c);
                if (consumidor.verificarPalabraArmada(Consumidor.arreglo, Consumidor.palabra)) {

                    System.out.println("Hilos terminan, palabra armada correctamente");
                break;
                }
                buffer.lanzar(c);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }


        }
    }
