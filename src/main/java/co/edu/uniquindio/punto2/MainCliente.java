package co.edu.uniquindio.punto2;

import java.util.Scanner;

public class MainCliente {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Seleccione la operación que desea realizar:");
		System.out.println("1. Verificar si la cadena es palíndroma");
		System.out.println("2. Contar vocales y consonantes");
		System.out.print("Ingrese el número de la opción: ");
		int opcion = scanner.nextInt();
		scanner.nextLine();

		System.out.print("Ingrese la cadena: ");
		String cadena = scanner.nextLine();

		String comando = "";
		switch (opcion) {
			case 1:
				comando = "palindromo";
				break;
			case 2:
				comando = "contar";
				break;
			default:
				System.out.println("Opción no válida");
				scanner.close();
				return;
		}

		AppCliente cliente = new AppCliente("localhost", 12345);
		cliente.iniciarCliente(cadena, comando);

		scanner.close();
	}
}
