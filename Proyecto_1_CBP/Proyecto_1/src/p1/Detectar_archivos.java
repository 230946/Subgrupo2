package p1;

import java.io.*;
import java.util.*;

public class Detectar_archivos {

    // Método para validar un archivo CSV de ventas
    public static boolean validateSalesFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.err.println("Error: El formato de la línea es incorrecto: " + line);
                    return false;
                }
                int productId = Integer.parseInt(parts[0]);
                if (productId < 1 || productId > 1000) {
                    System.err.println("Error: ID de producto fuera de rango: " + productId);
                    return false;
                }
                String productName = parts[1];
                double price = Double.parseDouble(parts[2]);
                if (price < 0) {
                    System.err.println("Error: Precio negativo: " + price);
                    return false;
                }
                // Puedes agregar más validaciones aquí según necesites
            }
            System.out.println("El archivo de ventas es válido.");
            return true;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo de ventas: " + e.getMessage());
            return false;
        }
    }

    // Método para validar un archivo CSV de productos
    public static boolean validateProductFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    System.err.println("Error: El formato de la línea es incorrecto: " + line);
                    return false;
                }
                int productId = Integer.parseInt(parts[0]);
                if (productId < 1 || productId > 1000) {
                    System.err.println("Error: ID de producto fuera de rango: " + productId);
                    return false;
                }
                String productName = parts[1];
                double price = Double.parseDouble(parts[2]);
                if (price < 0) {
                    System.err.println("Error: Precio negativo: " + price);
                    return false;
                }
                // Puedes agregar más validaciones aquí según necesites
            }
            System.out.println("El archivo de productos es válido.");
            return true;
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error al leer el archivo de productos: " + e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        validateSalesFile("sales.csv"); // Reemplazar con el nombre del archivo que deseas validar
        validateProductFile("products.csv"); // Reemplazar con el nombre del archivo que deseas validar
    }
}



