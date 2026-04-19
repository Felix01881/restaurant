public class Impresora {
    private Impresora() {
    }
    // ── API pública ───────────────────────────────────────────

    public static void mostrarCarta(Mesa mesa) {
        System.out.println(Restaurante.SEPARADOR_DOBLE);
        System.out.println(" RESTAURANTE " + Restaurante.NOMBRE);
        System.out.println(" --- NUESTRA CARTA ---");
        System.out.println(Restaurante.SEPARADOR_DOBLE);
        Producto[] catalogo = mesa.getCatalogo();
        for (int i = 0; i < catalogo.length; i++) {
            System.out.printf("%d. %-22s $%,.0f%n",
                    (i + 1), catalogo[i].getNombre(), catalogo[i].getPrecio());
        }
        System.out.println(Restaurante.SEPARADOR_DOBLE);
    }

    public static void mostrarPedido(Mesa mesa) {
        System.out.println("--- PEDIDO ACTUAL ---");
        for (Producto p : mesa.getCatalogo()) {
            if (p.fuePedido()) {
                System.out.printf(Restaurante.FORMATO_LINEA_PRODUCTO,
                        p.getNombre(), p.getCantidad(),
                        p.calcularSubtotalParcial());
            }
        }
        System.out.println(Restaurante.SEPARADOR_SIMPLE);
        ResultadoFactura r = CalculadorFactura.calcular(mesa);
        System.out.printf(Restaurante.FORMATO_LINEA_TOTAL, "Subtotal:",
                r.getSubtotal());
    }

    public static void imprimirFacturaCompleta(Mesa mesa) {
        ResultadoFactura resultado = CalculadorFactura.calcular(mesa);
        imprimirEncabezadoFactura(mesa);
        for (Producto p : mesa.getCatalogo()) {
            if (p.fuePedido()) {
                System.out.printf(Restaurante.FORMATO_LINEA_PRODUCTO,
                        p.getNombre(), p.getCantidad(),
                        p.calcularSubtotalParcial());
            }
        }
        imprimirTotales(resultado);
        imprimirPieFactura();
        mesa.registrarFacturaEmitida(resultado.getTotal());
    }

    public static void imprimirFacturaResumen(Mesa mesa) {
        ResultadoFactura resultado = CalculadorFactura.calcular(mesa);
        imprimirEncabezadoFactura(mesa);
        imprimirTotales(resultado);
        imprimirPieFactura();
    }

    // ── Métodos privados compartidos (antes código copiado) ───
    private static void imprimirEncabezadoFactura(Mesa mesa) {
        System.out.println(Restaurante.SEPARADOR_DOBLE);
        System.out.println(" RESTAURANTE " + Restaurante.NOMBRE);
        System.out.println(" " + Restaurante.DIRECCION);
        System.out.println(" NIT: " + Restaurante.NIT);
        System.out.println(Restaurante.SEPARADOR_DOBLE);
        System.out.printf("FACTURA No. %03d%n", Mesa.getContadorFacturas());
        System.out.println(Restaurante.SEPARADOR_SIMPLE);
    }

    private static void imprimirTotales(ResultadoFactura r) {
        System.out.println(Restaurante.SEPARADOR_SIMPLE);
        if (r.aplicaDescuento()) {
            System.out.printf(Restaurante.FORMATO_LINEA_TOTAL,
                    "Subtotal original:", r.getSubtotal());
            System.out.printf(Restaurante.FORMATO_LINEA_TOTAL,
                    "Descuento (5%):", r.getDescuento());
        }
        System.out.printf(Restaurante.FORMATO_LINEA_TOTAL, "Subtotal:",
                r.getBaseIva());
        System.out.printf(Restaurante.FORMATO_LINEA_TOTAL, "IVA (19%):", r.getIva());
        if (r.aplicaPropina()) {
            System.out.printf(Restaurante.FORMATO_LINEA_TOTAL,
                    "Propina (10%):", r.getPropina());
        }
        System.out.println(Restaurante.SEPARADOR_SIMPLE);
        System.out.printf(Restaurante.FORMATO_LINEA_TOTAL, "TOTAL:", r.getTotal());
        System.out.println(Restaurante.SEPARADOR_DOBLE);
    }

    private static void imprimirPieFactura() {
        System.out.println("Gracias por su visita!");
        System.out.println("Restaurante " + Restaurante.NOMBRE
                + " - " + Restaurante.DIRECCION);
        System.out.println(Restaurante.SEPARADOR_DOBLE);
    }


    

    

}
