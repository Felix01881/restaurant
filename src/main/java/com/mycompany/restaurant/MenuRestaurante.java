import java.util.Scanner;

public class MenuRestaurante {
    private final Mesa mesa;
    private final Scanner scanner;

    public MenuRestaurante() {
        this.mesa = new Mesa();
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        imprimirBienvenida();
        boolean continuar = true;
        while (continuar) {
            imprimirOpciones();
            int opcion = leerOpcionMenu();
            continuar = ejecutarOpcion(opcion);
        }
        scanner.close();
    }

    // ── Despacho de opciones ──────────────────────────────────
    private boolean ejecutarOpcion(int opcion) {
        switch (opcion) {
            case 1:
                verCarta();
                break;
            case 2:
                agregarProducto();
                break;
            case 3:
                verPedidoActual();
                break;
            case 4:
                generarFactura();
                break;
            case 5:
                nuevaMesa();
                break;
            case 0:
                return salir();
            default:
                System.out.println("Opción no válida. Seleccione entre 0 y 5.");
        }
        System.out.println();
        return true;
    }

    // ── Opciones ─────────────────────────────────────────────
    private void verCarta() {
        Impresora.mostrarCarta(mesa);
    }

    private void agregarProducto() {
        System.out.println("--- AGREGAR PRODUCTO ---");
        int numeroProd = leerEntero(
                "Número de producto (1-" + mesa.getTamanoCatalogo() + "): ");
        if (!esNumeroProductoValido(numeroProd))
            return;
        int cantidad = leerEntero("Cantidad: ");
        if (!esCantidadValida(cantidad))
            return;
        if (!mesa.estaActiva()) {
            int numeroMesa = leerEntero("Ingrese número de mesa: ");
            mesa.setNumeroMesa(numeroMesa > 0 ? numeroMesa : 1);
        }
        mesa.agregarProducto(numeroProd - 1, cantidad);
        Producto p = mesa.getProducto(numeroProd - 1);
        System.out.println("Producto agregado: " + p.getNombre() + " x" + cantidad);
    }

    private void verPedidoActual() {
        if (!mesa.tienePedido()) {
            System.out.println("No hay productos en el pedido. Use la opción 2.");
            return;
        }
        Impresora.mostrarPedido(mesa);
    }

    private void generarFactura() {
        if (!mesa.tienePedido()) {
            System.out.println("No hay productos en el pedido. Use la opción 2 primero.");
            return;
        }
        Impresora.imprimirFacturaCompleta(mesa);
    }

    private void nuevaMesa() {
        mesa.reiniciar();
        System.out.println("Mesa reiniciada. Lista para nuevo cliente.");
    }

    private boolean salir() {
        System.out.println("Hasta luego!");
        return false;
    }

    // ── Validaciones ──────────────────────────────────────────
    private boolean esNumeroProductoValido(int numero) {
        if (numero <= 0) {
            System.out.println("El número debe ser mayor a cero.");
            return false;
        }
        if (numero > mesa.getTamanoCatalogo()) {
            System.out.println("Producto no existe. La carta tiene "
                    + mesa.getTamanoCatalogo() + " productos.");
            return false;
        }
        return true;
    }

    private boolean esCantidadValida(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("La cantidad debe ser un valor positivo.");
            return false;
        }
        return true;
    }

    // ── Entrada ───────────────────────────────────────────────
    private int leerEntero(String mensaje) {
        System.out.print(mensaje);
        if (scanner.hasNextInt())
            return scanner.nextInt();
        scanner.nextLine();
        return -1;
    }

    private int leerOpcionMenu() {
        System.out.print("Seleccione una opción: ");
        if (scanner.hasNextInt())
            return scanner.nextInt();
        scanner.nextLine();
        return -1;
    }

    // ── Presentación ──────────────────────────────────────────
    private void imprimirBienvenida() {
        System.out.println(Restaurante.SEPARADOR_DOBLE);
        System.out.println(" RESTAURANTE " + Restaurante.NOMBRE);
        System.out.println(" " + Restaurante.DIRECCION);
        System.out.println(" NIT: " + Restaurante.NIT);
        System.out.println(Restaurante.SEPARADOR_DOBLE);
    }

    private void imprimirOpciones() {
        System.out.println("1. Ver carta");
        System.out.println("2. Agregar producto al pedido");
        System.out.println("3. Ver pedido actual");
        System.out.println("4. Generar factura");
        System.out.println("5. Nueva mesa");
        System.out.println("0. Salir");
        System.out.println(Restaurante.SEPARADOR_DOBLE);
    }



    

}
