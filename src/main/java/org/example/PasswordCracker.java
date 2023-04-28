package org.example;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCracker extends Thread 
{

	//Atributos
	private byte[] contrasenaHash;

	private String sal;

	/**
	 * Algoritmo de hash que se uso en la contraseña. 1 para SHA256 y 2 para SHA512. 
	 */
	private String algoritmoHash;
	
	private static boolean decifrado;

	private static GeneradorContrasenas generadorContrasenas;

	public PasswordCracker(byte[] pContrasenaHash, String pSal , String pAlgoritmoHash, GeneradorContrasenas pGeneradorContrasenas)
	{
		contrasenaHash = pContrasenaHash;
		sal = pSal;
		algoritmoHash = pAlgoritmoHash;
		decifrado = false;
		generadorContrasenas = pGeneradorContrasenas;
	}
	
	public void run() 
	{
		while(!decifrado)
		{
			//Se obtiene la siguiente contraseña a probar.
			String contrasena = generadorContrasenas.generarSiguienteContrasena();
			try {
				byte[] hash = obtenerHash(contrasena, sal, algoritmoHash);
				if(MessageDigest.isEqual(hash, contrasenaHash)){
					decifrado = true;
					System.out.println("La contraseña es: " + contrasena);
				}else{
					//System.out.println("La contraseña no es: " + contrasena);
				}
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static byte[] obtenerHash(String contrasena, String sal, String algoritmo) throws NoSuchAlgorithmException{
		MessageDigest md = MessageDigest.getInstance(algoritmo);
		String concat = contrasena + sal;
		md.update(concat.getBytes());
		return md.digest();
	}
	
	

}
