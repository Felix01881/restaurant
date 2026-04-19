public class Mesa {
    private static final Producto[] CATALOGO = {
            new Producto("Bandeja Paisa", 32.000),
            new Producto("Sancocho de Gallina", 28.000),
            new Producto("Arepa de Huevo", 8.000),
            new Producto("Jugo Natural", 7.000),
            new Producto("Gaseosa", 4.500),
            new Producto("Cerveza Poker", 6.000),
            new Producto("Agua Panela", 3.500),
            new Producto("Arroz con Pollo", 25.000),
    };

    private int numeroMesa;
    private boolean activa;
    private double totalUltimaFactura;
    private static int contadorFacturas = 1;

    public Mesa() {
        this.numeroMesa = 0;
        this.activa = false;
        this.totalUltimaFactura = 0.0;
    }

    // ── Acesso al catalogo ─────────────────────────────────────
    public Producto[] getCatalogo() {
        return CATALOGO;
    }

    public int getTamanoCatalogo() {
        return CATALOGO.length;
    }

    public static int getContadorFacturas() {
        return contadorFacturas;
    }

    public Producto getProducto(int indice) {
        if (indice < 0 || indice >= CATALOGO.length)
            return null;
        return CATALOGO[indice];
    }

    // ── Estado de la mesa ─────────────────────────────────────
    public int getNumeroMesa() {
        return numeroMesa;
    }

    public boolean estaActiva() {
        return activa;
    }

    public double getTotalUltimaFactura() {
        return totalUltimaFactura;
    }

    public void setNumeroMesa(int numero) {
        this.numeroMesa = numero;
        this.activa = true;
    }

}
