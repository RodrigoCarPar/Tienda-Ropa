package tienda_ropa;

public class Ropa {
        private String marca;
        private String tipo;
        private String talla;
        private int cantidad;
        private double precio;
        private String genero;
        private static final double DESCUENTO_MAXIMO = 0.25;
        

        public Ropa(String marca, String tipo, String talla, int cantidad, double precio, String genero) {
            this.marca = marca;
            this.tipo = tipo;
            this.talla = talla;
            this.cantidad = cantidad;
            this.precio = precio;
            this.genero = genero;
        }
        
        public void ponerMarca(String marca) {
            this.marca = marca;
        }
        
        public String obtenerMarca() {
            return marca;
        }
        
        public void ponerTipo(String tipo) {
            this.tipo = tipo;
        }
        
        public String obtenerTipo() {
            return tipo;
        }
        
        public void ponerTalla(String talla) {
            this.talla = talla;
        }
        
        public String obtenerTalla() {
            return talla;
        }
        
        public void ponerCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
        
        public int obtenerCantidad() {
            return cantidad;
        }
        
        public void ponerPrecio(double precio) {
            this.precio = precio;
        }
        
        public double obtenerPrecio() {
            return precio;
        }
        
        public void ponerGenero(String genero) {
            this.genero = genero;
        }
        
        public String obtenerGenero() {
            return genero;
        }
        
        public double calcularPrecioTotal() {
            return cantidad * precio * (1 - obtenerDescuento());
        }
        
        public double obtenerDescuento() {
            return DESCUENTO_MAXIMO;
        }
    
        @Override
        public String toString() {
            return "Ropa{" +
                    "marca='" + marca + '\'' +
                    ", tipo='" + tipo + '\'' +
                    ", talla='" + talla + '\'' +
                    ", cantidad=" + cantidad +
                    ", precio=" + precio +
                    ", genero='" + genero + '\'' +
                    '}';
        }
}
