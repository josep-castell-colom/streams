package practica7;

import java.util.Scanner;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Introduce el nombre del archivo a leer:");
        String fileIn = input.nextLine();
        System.out.println("Introduce el nombre del archivo a escribir:");
        String fileOut = input.nextLine();
        // System.out.println(ByteStreamFormatter.leerBytes(fileIn));
        // ByteStreamFormatter.escribirBytes(fileOut, ByteStreamFormatter.leerBytes(fileIn));
        // CharStreamFormatter.escribirChar(fileOut, CharStreamFormatter.leerChar(fileIn));
        System.out.println(BufferStreamFormatter.lecturaBufferedReader(fileIn));
    }
}
