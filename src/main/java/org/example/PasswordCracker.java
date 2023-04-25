package org.example;

public class PasswordCracker extends Thread 
{

	//Atributos
	private String contrasenaHash;

	private String sal;

	/**
	 * Algoritmo de hash que se uso en la contraseña. 1 para SHA256 y 2 para SHA512. 
	 */
	private int algoritmoHash;
	
	private static boolean decifrado;

	public PasswordCracker(String pContrasenaHash, String pSal , int pAlgoritmoHash)
	{
		contrasenaHash = pContrasenaHash;
		sal = pSal;
		algoritmoHash = pAlgoritmoHash;
		decifrado = false;
	}
	
	public void run() 
	{
		
	}
	
	
	

}
