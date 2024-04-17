package p1;

import java.io.*;
import java.util.Random;

public class c {

    // Arrangements with names and surnames
    private static final String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis", "Laura", "Carlos", "Marta", "David", "Elena"};
    private static final String[] apellidos = {"García", "Rodríguez", "Martínez", "López", "Sánchez", "Pérez", "González", "Fernández", "Moreno", "Jiménez"};

    //  Method to generate a CSV file with seller information
    public static void createSalesManInfoFile(int salesmanCount) {
        // File name
        String fileName = "salesmanCount_vendedores.csv";

        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            // Write headers
            writer.println("ID Vendedor,Nombre,Edad");

            // Generate seller data
            Random random = new Random();
            for (int i = 1; i <= salesmanCount; i++) {
                long salesmanId = 1000 + i;
                String salesmanName = nombres[random.nextInt(nombres.length)] + " " + apellidos[random.nextInt(apellidos.length)];
                int age = 25 + random.nextInt(30); // Generates a random age between 25 and 54
                writer.println(salesmanId + "," + salesmanName + "," + age);
            }

            System.out.println("Archivo de información de vendedores generado exitosamente: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error al generar el archivo de información de vendedores: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example of use of the method
        createSalesManInfoFile(10); // Generates a file with information on 10 sellers
    }
}