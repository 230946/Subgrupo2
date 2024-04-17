package p1;

import java.io.*;
import java.util.*;

public class Punto_b {

    // Clase para representar la información de un vendedor
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

    // Método para generar un archivo binario con información de vendedores serializados
    public static void createSalesManInfoFile(int salesmanCount, int maxFilesPerSalesman) {
        // Nombre del archivo
        String fileName = "salesman_info.ser";

        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            // Generar datos de vendedores
            for (int i = 1; i <= salesmanCount; i++) {
                long salesmanId = 1000 + i;
                String salesmanName = "Vendedor " + i;
                int age = 25 + (int)(Math.random() * 30); // Genera una edad aleatoria entre 25 y 54
                List<String> files = generateRandomFiles(maxFilesPerSalesman); // Genera archivos aleatorios asociados al vendedor
                Salesman salesman = new Salesman(salesmanId, salesmanName, age, files);
                outputStream.writeObject(salesman); // Serializa y guarda el objeto vendedor en el archivo
            }

            System.out.println("Archivo de información de vendedores serializado exitosamente: " + fileName);
        } catch (IOException e) {
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