package org.example;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        //Se obtienen los datos por parte del usuario.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del Algoritmo de generación de Hash: ");
        String algoritmoEncriptacion = scanner.nextLine();

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
            PasswordCracker thread = new PasswordCracker();
            thread.run();
        }
    }
}
