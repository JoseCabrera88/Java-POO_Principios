import java.util.ArrayList;

class Producto {
    private int id;
    private String nombre;
    private double precio;
    private int cantidad;

    public Producto(int id, String nombre, double precio, int cantidad) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    // Los Getters y Setters
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    // Este es el método para mostrar información del producto
    public String toString() {
        return "ID: " + id + ", Nombre: " + nombre + ", Precio: Q" + precio + ", Cantidad: " + cantidad;
    }
}

class Electronico extends Producto {
    private String marca;

    public Electronico(int id, String nombre, double precio, int cantidad, String marca) {
        super(id, nombre, precio, cantidad);
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    // Este es el método para calcular el descuento (por ejemplo el 10%)
    public double calcularDescuento() {
        return getPrecio() * 0.10;
    }

    // Este es el método para mostrar información del producto electrónico
    public String toString() {
        return super.toString() + ", Marca: " + marca;
    }
}

class Orden {
    private ArrayList<Producto> productos;

    public Orden() {
        productos = new ArrayList<>();
    }

    // Este es elmMétodo para agregar productos a la orden
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    // Este es el método para calcular el total de la orden
    public double calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        return total;
    }

    // Este es el método para mostrar los detalles de la orden
    public void mostrarDetalles() {
        System.out.println("________________________________________________________________________________");
        System.out.println("Detalles de su orden:");
        for (Producto producto : productos) {
            System.out.println(producto.toString());
        }
        System.out.println("Total de la orden: Q" + calcularTotal());
    }
}

public class Main {
    public static void main(String[] args) {
        // Aquí se crean los productos de prueba
        Producto producto1 = new Producto(1, "Sueter", 38.25, 5);
        Electronico producto2 = new Electronico(2, "Laptop", 1200.00, 2, "HP");
        Producto producto3 = new Producto(3, "Almohada", 15.50, 3);

        // Aquí se agregan los productos a la orden
        Orden orden = new Orden();
        orden.agregarProducto(producto1);
        orden.agregarProducto(producto2);
        orden.agregarProducto(producto3);

        // Se calcula el total de la orden y muestra los detalles
        orden.mostrarDetalles();

        // Muestra el descuento que se le aplicó al producto electrónico
        System.out.println("Descuento aplicado al producto electrónico: Q" + producto2.calcularDescuento());
        System.out.println("________________________________________________________________________________");
    }
}