package p1;

import java.io.*;
import java.util.*;

public class Punto_b {

    // Class to represent the information of a seller
    static class Salesman implements Serializable {
        private static final long serialVersionUID = 1L;
        long id;
        String name;
        int age;
        List<String> files;

        public Salesman(long id, String name, int age, List<String> files) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.files = files;
        }
    }

    // Method to generate a binary file with serialized vendor information
    public static void createSalesManInfoFile(int salesmanCount, int maxFilesPerSalesman) {
        // File name
        String fileName = "salesman_archivos_serializado_info.ser";

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // Generate seller data
            for (int i = 1; i <= salesmanCount; i++) {
                long salesmanId = 1000 + i;
                String salesmanName = "Vendedor " + i;
                int age = 25 + (int)(Math.random() * 30); // Generates a random age between 25 and 54
                List<String> files = generateRandomFiles(maxFilesPerSalesman); // Generates random files associated with the seller
                Salesman salesman = new Salesman(salesmanId, salesmanName, age, files);
                outputStream.writeObject(salesman); // Serializes and saves the seller object to the file
            }

            System.out.println("Archivo de información de vendedores serializado exitosamente: " + fileName);
        } catch (IOException e) {
            System.err.println("Error al generar el archivo de información de vendedores: " + e.getMessage());
        }
    }

    // Method to generate random file names
    private static List<String> generateRandomFiles(int maxFilesPerSalesman) {
        List<String> files = new ArrayList<>();
        Random random = new Random();
        int fileCount = random.nextInt(maxFilesPerSalesman) + 1; // Generates a random number of files (between 1 and maxFilesPerSalesman)
        for (int i = 1; i <= fileCount; i++) {
            files.add("archivo_" + random.nextInt(1000) + ".txt"); // Random file name
        }
        return files;
    }

    public static void main(String[] args) {
        // Example of use of the method
        createSalesManInfoFile(10, 3); // Generates a file with information on 10 sellers, with a maximum of 3 files per seller
    }
}