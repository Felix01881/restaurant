public class ResultadoFactura {
    private final double subtotal;
    private final double descuento;
    private final double baseIva;
    private final double iva;
    private final double propina;
    private final double total;
    private final boolean aplicaDescuento;
    private final boolean aplicaPropina;

    public ResultadoFactura(
            double subtotal, double descuento, double baseIva,
            double iva, double propina, double total,
            boolean aplicaDescuento, boolean aplicaPropina) {
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.baseIva = baseIva;
        this.iva = iva;
        this.propina = propina;
        this.total = total;
        this.aplicaDescuento = aplicaDescuento;
        this.aplicaPropina = aplicaPropina;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public double getDescuento() {
        return descuento;
    }

    public double getBaseIva() {
        return baseIva;
    }

    public double getIva() {
        return iva;
    }

    public double getPropina() {
        return propina;
    }

    public double getTotal() {
        return total;
    }

    public boolean aplicaDescuento() {
        return aplicaDescuento;
    }

    public boolean aplicaPropina() {
        return aplicaPropina;
    }

}
