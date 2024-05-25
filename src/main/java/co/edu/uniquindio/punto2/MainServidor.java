package co.edu.uniquindio.punto2;

public class MainServidor {
	public static void main(String[] args) {
		AppServidor servidor = new AppServidor(12345);
		servidor.iniciarServidor();
	}
}
