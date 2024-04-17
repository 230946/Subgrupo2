package p1;

import java.io.*;
import java.util.Random;

public class a {

    //	Method to generate a CSV file with sales data for a salesperson
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        // Generate file name
        String fileName = name.replaceAll("\\s", "_") + "_Franco.csv";

        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            // Write headers
            writer.println("ID Venta,Producto,Monto");

            // Generate random sales
            Random random = new Random();
            for (int i = 1; i <= randomSalesCount; i++) {
                int saleId = i;
                String product = "Producto " + (random.nextInt(5) + 1); // Generate a random number between 1 and 5 for the product
                double amount = 10 + (random.nextDouble() * 90); // Generate a random amount between 10 and 100
                writer.println(saleId + "," + product + "," + amount);
            }

            System.out.println("Archivo de ventas para " + name + " generado exitosamente: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error al generar el archivo de ventas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso del método
        createSalesMenFile(10, "Juan Manuel", 123456789); // Generates a file with 10 sales for the seller "Juan Manuel Franco" with ID 526325413
    }
}