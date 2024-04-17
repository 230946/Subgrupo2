package p1;

import java.io.*;
import java.util.*;

public class Punto_a {

    // Método para generar un archivo CSV con información de vendedores
    public static void createSalesManInfoFile(int salesmanCount, int maxFilesPerSalesman) {
        // Nombre del archivo
        String fileName = "salesman_info.csv";

        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            // Escribir encabezados
            writer.println("ID Vendedor,Nombre,Edad,Archivos");

            // Generar datos de vendedores
            for (int i = 1; i <= salesmanCount; i++) {
                long salesmanId = 1000 + i;
                String salesmanName = "Vendedor " + i;
                int age = 25 + (int)(Math.random() * 30); // Genera una edad aleatoria entre 25 y 54
                List<String> files = generateRandomFiles(maxFilesPerSalesman); // Genera archivos aleatorios asociados al vendedor
                String filesString = String.join("; ", files); // Concatena los nombres de los archivos en una sola cadena
                writer.println(salesmanId + "," + salesmanName + "," + age + "," + filesString);
            }

            System.out.println("Archivo de información de vendedores generado exitosamente: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error al generar el archivo de información de vendedores: " + e.getMessage());
        }
    }

    // Método para generar nombres de archivos aleatorios
    private static List<String> generateRandomFiles(int maxFilesPerSalesman) {
        List<String> files = new ArrayList<>();
        Random random = new Random();
        int fileCount = random.nextInt(maxFilesPerSalesman) + 1; // Genera un número aleatorio de archivos (entre 1 y maxFilesPerSalesman)
        for (int i = 1; i <= fileCount; i++) {
            files.add("archivo_" + random.nextInt(1000) + ".txt"); // Nombre de archivo aleatorio
        }
        return files;
    }

    public static void main(String[] args) {
        // Ejemplo de uso del método
        createSalesManInfoFile(10, 3); // Genera un archivo con información de 10 vendedores, con máximo 3 archivos por vendedor
    }
}