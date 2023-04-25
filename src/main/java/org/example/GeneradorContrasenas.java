package org.example;

import java.util.ArrayList;

public class GeneradorContrasenas
{

	//Contantes
	private final static String ABCDARIO = "abcdefghijklmnñopqrstuvwxyz";

	//Atributos
	/**
	 * Lista de numeros, cada indice tiene un numero de 0-27 que corresponde a una letra del abcdario.
	 * Cada indice representa el caracter en la posicion que estaria en la contrasena.
	 */
	private ArrayList<Integer> listaLetras;

	public GeneradorContrasenas()
	{
		listaLetras = new ArrayList<Integer>();
	}

	/**
	 * Metodo que retorna una clave nueva para que sea analizada por el PasswordCracker.
	 * @return La clave siguiente en el orden que se van generando.
	 */
	public synchronized String generarSiguienteContrasena()
	{
		String claveRetorno = "";

		//Si la lista esta vacia le agrega un 0 que representaria tener una a en la contrasena que se generara.
		if(listaLetras.isEmpty())
		{
			listaLetras.add(0);
		}
		else
		{
			int indiceActual = listaLetras.size()-1;
			boolean letraAgregada = false;
			while(!letraAgregada)
			{
				int numeroActual = listaLetras.get(indiceActual);
				//Verifica que  en el indice actual  no se pase de la ultima letra, si lo hace se devuelve al indice anterior.
				if(numeroActual < 26)
				{
					listaLetras.set(indiceActual, numeroActual  + 1);
					letraAgregada = true;
				}
				else
				{
					listaLetras.set(indiceActual, 0);
					//Verifica que el indice no sea el primero, si lo es entonces se anade otro  cero al final de la lista, es decir se alarga la contrasena.
					if(indiceActual != 0)
					{
						indiceActual --;
					}
					else
					{
						listaLetras.add(0);
						letraAgregada = true;
					}
				}
			}
		}

		//Se forma la nueva contrasena usando los valores actuales de la listaLetras, que corresponden al indice en la cadena del ABCEDARIO.
		for(int indice = 0; indice < listaLetras.size(); indice ++)
		{
			char letra = ABCDARIO.charAt(listaLetras.get(indice));
			claveRetorno = claveRetorno + letra;
		}
		return claveRetorno;
	}

}