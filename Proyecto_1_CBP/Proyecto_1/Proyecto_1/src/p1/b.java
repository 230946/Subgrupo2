package p1;

import java.io.*;

public class b {

    // Method to generate a CSV file with product data
    public static void createProductsFile(int productsCount) {
        // file name
        String fileName = "productos.csv";

        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            // Write headers
            writer.println("ID Producto,Nombre,Precio");

            // Generate product data
            for (int i = 1; i <= productsCount; i++) {
                int productId = i;
                String productName = "Producto " + i;
                double price = 10 + (Math.random() * 90); // Generate a random price between 10 and 100
                writer.println(productId + "," + productName + "," + price);
            }

            System.out.println("Archivo de productos generado exitosamente: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error al generar el archivo de productos: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example of use of the method
        createProductsFile(10); // Generate a file with 10 products
    }
}
