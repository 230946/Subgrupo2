package p1;

import java.util.*;

public class Ventas {
	
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        productos.add(new Producto("Producto 1", 10.0));
        productos.add(new Producto("Producto 2", 20.0));
        productos.add(new Producto("Producto 3", 30.0));

        List<Vendedor> vendedores = new ArrayList<>();
        vendedores.add(new Vendedor("Vendedor 1"));
        vendedores.add(new Vendedor("Vendedor 2"));

        List<Venta> ventas = new ArrayList<>();
        ventas.add(new Venta(vendedores.get(0), productos.get(0), 5));
        ventas.add(new Venta(vendedores.get(0), productos.get(1), 3));
        ventas.add(new Venta(vendedores.get(1), productos.get(1), 2));
        ventas.add(new Venta(vendedores.get(1), productos.get(2), 4));

        // Generar reporte de ventas por vendedor
        System.out.println("Reporte de ventas por vendedor:");
        Map<Vendedor, Double> ventasPorVendedor = new HashMap<>();
        for (Venta venta : ventas) {
            Vendedor vendedor = venta.getVendedor();
            double totalVenta = venta.getProducto().getPrecio() * venta.getCantidad();
            ventasPorVendedor.put(vendedor, ventasPorVendedor.getOrDefault(vendedor, 0.0) + totalVenta);
        }
        for (Map.Entry<Vendedor, Double> entry : ventasPorVendedor.entrySet()) {
            System.out.println(entry.getKey().getNombre() + ": " + entry.getValue() + " USD");
        }

        // Generar reporte de ventas por producto
        System.out.println("\nReporte de ventas por producto:");
        Map<Producto, Integer> ventasPorProducto = new HashMap<>();
        for (Venta venta : ventas) {
            Producto producto = venta.getProducto();
            ventasPorProducto.put(producto, ventasPorProducto.getOrDefault(producto, 0) + venta.getCantidad());
        }
        for (Map.Entry<Producto, Integer> entry : ventasPorProducto.entrySet()) {
            System.out.println(entry.getKey().getNombre() + ": " + entry.getValue() + " unidades");
        }
    }
}

class Producto {
    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}

class Vendedor {
    private String nombre;

    public Vendedor(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}

class Venta {
    private Vendedor vendedor;
    private Producto producto;
    private int cantidad;

    public Venta(Vendedor vendedor, Producto producto, int cantidad) {
        this.vendedor = vendedor;
        this.producto = producto;
        this.cantidad = cantidad;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }
}
