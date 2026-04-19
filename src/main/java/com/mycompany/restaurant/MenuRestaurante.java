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

    

}
