package p1;

import java.io.*;
import java.util.Random;

public class c {

    // Arreglos con nombres y apellidos
    private static final String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis", "Laura", "Carlos", "Marta", "David", "Elena"};
    private static final String[] apellidos = {"García", "Rodríguez", "Martínez", "López", "Sánchez", "Pérez", "González", "Fernández", "Moreno", "Jiménez"};

    // Método para generar un archivo CSV con información de vendedores
    public static void createSalesManInfoFile(int salesmanCount) {
        // Nombre del archivo
        String fileName = "salesman_info.csv";

        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            // Escribir encabezados
            writer.println("ID Vendedor,Nombre,Edad");

            // Generar datos de vendedores
            Random random = new Random();
            for (int i = 1; i <= salesmanCount; i++) {
                long salesmanId = 1000 + i;
                String salesmanName = nombres[random.nextInt(nombres.length)] + " " + apellidos[random.nextInt(apellidos.length)];
                int age = 25 + random.nextInt(30); // Genera una edad aleatoria entre 25 y 54
                writer.println(salesmanId + "," + salesmanName + "," + age);
            }

            System.out.println("Archivo de información de vendedores generado exitosamente: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error al generar el archivo de información de vendedores: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso del método
        createSalesManInfoFile(10); // Genera un archivo con información de 10 vendedores
    }
}