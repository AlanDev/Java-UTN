import java.time.LocalDateTime;
import java.util.Arrays;

class Humane {
    private String nombre;
    private String apellido;
    private int dni;

    public Humane(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public String toString() {
        return "Nombre: " + this.nombre + "\nApellido: " + this.apellido + "\nDNI: " + this.dni;
    }
}

class Empleado extends Humane {
    private double sueldo;

    public Empleado(String nombre, String apellido, int dni, double sueldo) {
        super(nombre, apellido, dni);
        this.sueldo = sueldo;
    }

    public String toString() {
        return "\n" + super.toString() + "\nSueldo: " + this.sueldo;
    }
}

class Caja {
    private Empleado empleado;
    private int nroCaja;

    public Caja(Empleado empleado, int nroCaja) {
        this.empleado = empleado;
        this.nroCaja = nroCaja;
    }

    public String toString() {
        return this.empleado.toString() + "\nNro de caja: " + this.nroCaja;
    }
}

class Cliente extends Humane {
    private boolean mayorista;

    public Cliente(String nombre, String apellido, int dni, boolean mayorista) {
        super(nombre, apellido, dni);
        this.mayorista = mayorista;
    }

    public boolean Mayorista() {
        return mayorista;
    }

    public String toString() {
        return "\n" + super.toString() + "\nMayorista: " + this.mayorista;
    }
}

class Producto {
    private String nombre;
    private int precio;
    private int cantidad;

    public Producto(String nombre, int precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String toString() {
        return "Nombre: " + nombre + ", Precio: " + precio + ", Cantidad: " + cantidad;
    }
}

class Transaccion {
    private Cliente cliente;
    private Producto[] productos;
    private double total;
    private Caja caja;
    private LocalDateTime fecha;

    public Transaccion(Cliente cliente, Producto[] productos, Caja caja) {
        this.cliente = cliente;
        this.productos = productos;
        this.caja = caja;
        this.fecha = LocalDateTime.now();
        calcularTotal();
    }

    private void calcularTotal() {
        double total = 0;
        for (Producto producto : productos) {
            total += producto.getPrecio() * producto.getCantidad();
        }
        if (cliente.Mayorista()) {
            total *= 0.85;
        }
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Producto[] getProductos() {
        return productos;
    }

    public double getTotal() {
        return total;
    }

    public Caja getCaja() {
        return caja;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String toString() {
        return "Cliente: " + cliente +
               "\nProductos: " + Arrays.toString(productos) +
               "\nCaja: " + caja +
               "\nFecha: " + fecha +
               "\nTotal: " + total;
    }
}

public class ConceptosFundamentales {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Juan", "Perez", 12345678, true);
        System.out.println(cliente);

        Empleado empleado = new Empleado("Alan", "Quenardelle", 44321987, -5000);
        Caja caja = new Caja(empleado, 1);

        Producto producto1 = new Producto("Mouse", 1000, 2);
        Producto producto2 = new Producto("Teclado", 3000, 3);
        Producto[] productos = {producto1, producto2};

        Transaccion transaccion = new Transaccion(cliente, productos, caja);

        System.out.println(transaccion);
    }
}
