package p1;

import java.io.*;

public class b {

    // Método para generar un archivo CSV con datos de productos
    public static void createProductsFile(int productsCount) {
        // Nombre del archivo
        String fileName = "products.csv";

        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            // Escribir encabezados
            writer.println("ID Producto,Nombre,Precio");

            // Generar datos de productos
            for (int i = 1; i <= productsCount; i++) {
                int productId = i;
                String productName = "Producto " + i;
                double price = 10 + (Math.random() * 90); // Genera un precio aleatorio entre 10 y 100
                writer.println(productId + "," + productName + "," + price);
            }

            System.out.println("Archivo de productos generado exitosamente: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error al generar el archivo de productos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso del método
        createProductsFile(10); // Genera un archivo con 10 productos
    }
}
