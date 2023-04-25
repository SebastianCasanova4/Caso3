package org.example;

import java.util.Scanner;

public class Main
{
	public static void main(String[] args)
	{
		//Se obtienen los datos por parte del usuario.
		Scanner scanner = new Scanner(System.in);

		System.out.println("Ingrese el nombre del Algoritmo de generación de Hash,1 para SHA256 o 2 para SHA512 : ");
		int algoritmoEncriptacion = Integer.parseInt(scanner.nextLine());
		
		System.out.println("Ingrese la cadena que representa el código Hash de la contraseña que buscamos: ");
		String contraseñaHash = scanner.nextLine();

		System.out.println("Ingrese la Sal: ");
		String sal = scanner.nextLine();

		int numeroThreads = 1;
		try
		{
			System.out.println("Ingrese el numero de threads que se ejecutaran: ");
			numeroThreads =Integer.parseInt(scanner.nextLine());
		}
		catch (Exception numero)
		{
			System.out.println("Numero no valido, Ingrese el numero de threads que se ejecutaran: ");
			numeroThreads =Integer.parseInt(scanner.nextLine());
		}

		scanner.close();

		//Se crean y se corren los Threads.
		for(int cantidadThreads = 0; cantidadThreads < numeroThreads; cantidadThreads++)
		{
			PasswordCracker thread = new PasswordCracker(contraseñaHash, sal, algoritmoEncriptacion);
			thread.run();
		}
		
		//Generador de contrasenas que se le pasara por parametro al o los passwordCracker para que lo usen.
		GeneradorContrasenas prueba = new GeneradorContrasenas();

		for(int i = 0; i < 14988807; i++)
			System.out.println(prueba.generarSiguienteContrasena() + i);
	}
}
