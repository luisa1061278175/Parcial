package co.edu.uniquindio.punto2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class AppCliente {
	String host;
	int puerto;
	Socket socketComunicacion;
	ObjectOutputStream flujoSalidaObjeto;
	ObjectInputStream flujoEntradaObjeto;

	public AppCliente(String host, int puerto) {
		this.puerto = puerto;
		this.host = host;
	}

	public void iniciarCliente(String cadena, String comando) {
		try {
			crearConexion();
			flujoSalidaObjeto = new ObjectOutputStream(socketComunicacion.getOutputStream());
			flujoEntradaObjeto = new ObjectInputStream(socketComunicacion.getInputStream());

			enviarParametros(cadena, comando);

			recibirRespuesta();

			flujoEntradaObjeto.close();
			flujoSalidaObjeto.close();
			socketComunicacion.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void enviarParametros(String cadena, String comando) throws IOException {
		flujoSalidaObjeto.writeObject(cadena);
		flujoSalidaObjeto.writeObject(comando);
		flujoSalidaObjeto.flush();
	}

	private void recibirRespuesta() throws ClassNotFoundException, IOException {
		String respuesta = (String) flujoEntradaObjeto.readObject();
		System.out.println("Respuesta del servidor: " + respuesta);
	}

	private void crearConexion() throws IOException {
		socketComunicacion = new Socket(host, puerto);
	}
}
