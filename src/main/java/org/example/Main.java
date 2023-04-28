package org.example;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		//Se obtienen los datos por parte del usuario.
		Scanner scanner = new Scanner(System.in);
		int opcionAlgoritmo;
		String algoritmoEncriptacion = "";
		do{
			System.out.println("Ingrese el nombre del Algoritmo de generación de Hash, 1 para SHA256 o 2 para SHA512: ");
			opcionAlgoritmo = scanner.nextInt();
		} while (opcionAlgoritmo != 1 && opcionAlgoritmo != 2);

		scanner.nextLine();

		if (opcionAlgoritmo == 1){
			algoritmoEncriptacion = "SHA-256"; 
		} else{
			algoritmoEncriptacion = "SHA-512";
		}
		
		System.out.println("Ingrese la cadena que representa el código Hash de la contraseña que buscamos: ");
		String contraseñaHash = scanner.nextLine();
		byte[] hashBytes = new byte[contraseñaHash.length() / 2];
		for (int i = 0; i < contraseñaHash.length(); i += 2) {
            int hexValue = Integer.parseInt(contraseñaHash.substring(i, i + 2), 16);
            hashBytes[i / 2] = (byte) hexValue;
        }

		System.out.println("Ingrese la Sal: ");
		String sal = scanner.nextLine();

		int numeroThreads;
		do{
			System.out.println("Ingrese el numero de threads que se ejecutaran: ");
			numeroThreads = scanner.nextInt();
		} while (numeroThreads != 1 && numeroThreads != 2);

		scanner.nextLine();
		scanner.close();
		
		//Generador de contrasenas que se le pasara por parametro al o los passwordCracker para que lo usen.
		GeneradorContrasenas generadorContrasenas = new GeneradorContrasenas();

		//Se crean y se corren los Threads.
		for(int cantidadThreads = 0; cantidadThreads < numeroThreads; cantidadThreads++)
		{
			PasswordCracker thread = new PasswordCracker(hashBytes, sal, algoritmoEncriptacion, generadorContrasenas);
			thread.start();
		}

	}
}
