package tienda_ropa;

import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {

    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private static ArrayList<Ropa> listaRopa = new ArrayList<>();
    private static final String DESCUENTO_5 = "5OFF";
    private static final String DESCUENTO_10 = "10ALVARO";
    private static final String DESCUENTO_20 = "TUSABESCOMO";

    public static void main(String[] args) {

        Usuario usuario1 = new Usuario("usuario1", "123", "usuario1@mail.com");
        Usuario usuario2 = new Usuario("usuario2", "456", "usuario2@mail.com");
        Usuario usuario3 = new Usuario("usuario3", "789", "usuario3@mail.com");
        listaUsuarios.add(usuario1);
        listaUsuarios.add(usuario2);
        listaUsuarios.add(usuario3);
        int intentos = 0;
        Usuario usuarioValidado = null;
        while (intentos < 3) {
            String nombreUsuario = JOptionPane.showInputDialog("Introduce tu nombre de usuario:");
            String contrasena = JOptionPane.showInputDialog("Introduce tu contraseña:");

            usuarioValidado = validarCredenciales(listaUsuarios, nombreUsuario, contrasena);
            if (usuarioValidado != null) {
                JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso. ¡Bienvenido a la página de la tienda!");
                break;
            } else {
                intentos++;
                if (intentos == 3) {
                    JOptionPane.showMessageDialog(null, "Fallo en el inicio de sesion. Intento " + intentos + " de 3.");
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Nombre de usuario o contraseña incorrectos. Intento " + intentos + " de 3.");
                }
            }
        }
        if (usuarioValidado == null) {
            JOptionPane.showMessageDialog(null, "La cuenta ha sido bloqueada. Por favor, contacta al administrador.");
            System.exit(0);
        }
        Ropa ropa1 = new Ropa("Mike", "Camiseta", "M", 1, 19.95, "Masculino");
        Ropa ropa2 = new Ropa("Ardidas", "Pantalon", "S", 1, 15.50, "Femenino");
        Ropa ropa3 = new Ropa("TheMorthFame", "Abrigo", "L", 1, 49.99, "Unisex");
        listaRopa.add(ropa1);
        listaRopa.add(ropa2);
        listaRopa.add(ropa3);
        for (Ropa ropa : listaRopa) {
            String cantidadst = JOptionPane.showInputDialog("Introduce la cantidad de '" + ropa.obtenerTipo()
                    + " de la marca " + ropa.obtenerMarca() + " que deseas comprar:");
            int cantidadnum = Integer.parseInt(cantidadst);
            ropa.ponerCantidad(cantidadnum);
        }
        double precioTotal = 0.0;
        for (Ropa ropa : listaRopa) {
            precioTotal += ropa.obtenerPrecio() * ropa.obtenerCantidad();
        }
        String preciottl = "RESUMEN DE LA ORDEN\n\n";
        for (Ropa ropa : listaRopa) {
            preciottl += ropa.obtenerTipo() + ropa.obtenerMarca() + ", Cantidad: " + ropa.obtenerCantidad()
                    + ", Precio: $" + (ropa.obtenerPrecio() * ropa.obtenerCantidad()) + "\n";
        }
        preciottl += "\nPrecio Total: $" + precioTotal;
        JOptionPane.showMessageDialog(null, preciottl);
        int descuento = JOptionPane.showConfirmDialog(null, "¿Quiere introducir un código de descuento?", "Descuento",
                JOptionPane.YES_NO_OPTION);
        if (descuento == JOptionPane.YES_OPTION) {
            String codigoDescuento = JOptionPane.showInputDialog("Introduce el código de descuento:");

            double aplicarDescuento = 0.0;
            if (codigoDescuento.equals(DESCUENTO_5)) {
                aplicarDescuento = 0.05;
            } else if (codigoDescuento.equals(DESCUENTO_10)) {
                aplicarDescuento = 0.10;
            } else if (codigoDescuento.equals(DESCUENTO_20)) {
                aplicarDescuento = 0.20;
            } else {
                JOptionPane.showMessageDialog(null, "Código de descuento inválido. No se aplicará ningún descuento.");
            }
            precioTotal = 0.0;
            for (Ropa ropa : listaRopa) {
                precioTotal += ropa.obtenerPrecio() * ropa.obtenerCantidad();
            }

            if (aplicarDescuento > 0) {
                double precioConDescuento = precioTotal * (1 - aplicarDescuento);
                JOptionPane.showMessageDialog(null, "El precio total con descuento es: $" + precioConDescuento);
            } else {
                JOptionPane.showMessageDialog(null, "El precio total sin descuento es: $" + precioTotal);
            }
        }
    }

    public static Usuario validarCredenciales(ArrayList<Usuario> listaUsuarios, String nombreUsuario,
            String contrasena) {
        for (Usuario usuario : listaUsuarios) {
            if (usuario.obtenerNombreUsuario().equals(nombreUsuario)
                    && usuario.obtenerContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        System.out.println("Hola");
        //HOLA
        return null;
    }
}