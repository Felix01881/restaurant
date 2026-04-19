public class CalculadorFactura {
    private CalculadorFactura() {
    }
    // ── API pública ───────────────────────────────────────────

    public static ResultadoFactura calcular(Mesa mesa) {
        double subtotal = calcularSubtotal(mesa);
        int productosDistintos = contarProductosDistintos(mesa);
        boolean aplicaDescuento = productosDistintos > Restaurante.MINIMO_PRODUCTOS_DESCUENTO;
        double descuento = aplicaDescuento
                ? subtotal * Restaurante.TASA_DESCUENTO_VARIEDAD
                : 0.0;
        double baseIva = subtotal - descuento;
        boolean aplicaPropina = baseIva > Restaurante.UMBRAL_PROPINA;
        double iva = calcularIva(baseIva);
        double propina = aplicaPropina
                ? calcularPropina(baseIva + iva)
                : 0.0;
        double total = baseIva + iva + propina;
        return new ResultadoFactura(
                subtotal, descuento, baseIva,
                iva, propina, total,
                aplicaDescuento, aplicaPropina);
    }

    private static double calcularSubtotal(Mesa mesa) {
        double subtotal = 0.0;
        for (Producto p : mesa.getCatalogo()) {
            if (p.fuePedido())
                subtotal += p.calcularSubtotalParcial();
        }
        return subtotal;
    }

    private static int contarProductosDistintos(Mesa mesa) {
        int contador = 0;
        for (Producto p : mesa.getCatalogo()) {
            if (p.fuePedido())
                contador++;
        }
        return contador;
    }

    /** Único lugar del proyecto donde se aplica TASA_IVA. */
    private static double calcularIva(double base) {
        return base * Restaurante.TASA_IVA;
    }

    private static double calcularPropina(double totalConIva) {
        return totalConIva * Restaurante.TASA_PROPINA;
    }

  
    
}
