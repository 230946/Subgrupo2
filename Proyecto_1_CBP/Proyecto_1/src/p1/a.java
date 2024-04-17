package p1;

import java.io.*;
import java.util.Random;

public class a {

    // Método para generar un archivo CSV con datos de ventas para un vendedor
    public static void createSalesMenFile(int randomSalesCount, String name, long id) {
        // Generar nombre del archivo
        String fileName = name.replaceAll("\\s", "_") + "_sales.csv";

        try (PrintWriter writer = new PrintWriter(new File(fileName))) {
            // Escribir encabezados
            writer.println("ID Venta,Producto,Monto");

            // Generar ventas aleatorias
            Random random = new Random();
            for (int i = 1; i <= randomSalesCount; i++) {
                int saleId = i;
                String product = "Producto " + (random.nextInt(5) + 1); // Genera un número aleatorio entre 1 y 5 para el producto
                double amount = 10 + (random.nextDouble() * 90); // Genera un monto aleatorio entre 10 y 100
                writer.println(saleId + "," + product + "," + amount);
            }

            System.out.println("Archivo de ventas para " + name + " generado exitosamente: " + fileName);
        } catch (FileNotFoundException e) {
            System.err.println("Error al generar el archivo de ventas: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso del método
        createSalesMenFile(10, "John Doe", 123456789); // Genera un archivo con 10 ventas para el vendedor "John Doe" con ID 123456789
    }
}