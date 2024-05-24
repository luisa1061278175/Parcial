package co.edu.uniquindio.punto1;

public class P2 extends Thread {
    private char[] lista;
    private Buffer buffer;
    private Consumidor consumidor;

    private char[] arregloPalabra;

    public P2(char[] arregloPalabra, Buffer buffer, Consumidor consumidor) {
        this.lista = arregloPalabra;
        this.buffer = buffer;
        this.consumidor = consumidor;
        this.arregloPalabra = arregloPalabra;
    }

    public static boolean esNumero(char c) {
        return Character.isDigit(c);
    }

    public static boolean esVocal(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    @Override
    public void run() {
        for (char c : arregloPalabra) {
            if ((esNumero(c) || esVocal(c))) {
                System.out.println("Hilo 2 crea: " + c);
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
