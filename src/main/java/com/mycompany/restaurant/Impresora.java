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

    

}
