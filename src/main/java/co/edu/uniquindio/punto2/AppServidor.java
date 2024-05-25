package co.edu.uniquindio.punto2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class AppServidor {
	int puerto;

	public AppServidor(int puerto) {
		this.puerto = puerto;
	}

	public void iniciarServidor() {
		try (ServerSocket servidor = new ServerSocket(puerto)) {
			System.out.println("Servidor iniciado y esperando conexiones...");

			while (true) {
				try (Socket socketComunicacion = servidor.accept();
					 ObjectInputStream flujoEntradaObjeto = new ObjectInputStream(socketComunicacion.getInputStream());
					 ObjectOutputStream flujoSalidaObjeto = new ObjectOutputStream(socketComunicacion.getOutputStream())) {

					String cadena = (String) flujoEntradaObjeto.readObject();
					String comando = (String) flujoEntradaObjeto.readObject();

					String respuesta = procesarComando(cadena, comando);
					flujoSalidaObjeto.writeObject(respuesta);
					flujoSalidaObjeto.flush();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String procesarComando(String cadena, String comando) {
		switch (comando) {
			case "palindromo":
				return esPalindromo(cadena) ? "La cadena es palíndroma." : "La cadena no es palíndroma.";
			case "contar":
				int[] resultado = contarVocalesConsonantes(cadena);
				return "Vocales: " + resultado[0] + ", Consonantes: " + resultado[1];
			default:
				return "Comando no reconocido.";
		}
	}

	public boolean esPalindromo(String cadena) {

		cadena = cadena.replaceAll("\\s+", "").toLowerCase();

		int inicio = 0;
		int fin = cadena.length() - 1;

		while (inicio < fin) {
			if (cadena.charAt(inicio) != cadena.charAt(fin)) {
				return false;
			}
			inicio++;
			fin--;
		}
		return true;
	}

	private int[] contarVocalesConsonantes(String cadena) {
		int[] contador = new int[2]; // [0] para vocales, [1] para consonantes
		contarVocalesConsonantesRecursivo(cadena.toLowerCase(), 0, contador);
		return contador;
	}

	private void contarVocalesConsonantesRecursivo(String cadena, int index, int[] contador) {
		if (index < cadena.length()) {
			char c = cadena.charAt(index);
			if ("aeiou".indexOf(c) != -1) {
				contador[0]++;
			} else if (Character.isLetter(c)) {
				contador[1]++;
			}
			contarVocalesConsonantesRecursivo(cadena, index + 1, contador);
		}
	}
}
