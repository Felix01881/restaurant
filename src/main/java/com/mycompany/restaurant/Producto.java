/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author salainformatica
 */
public class Producto {

    private final String nombre;
    private final double precio;
    private int cantidad;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    /** Agrega unidades al pedido actual. */
    public void agregarCantidad(int unidades) {
        this.cantidad += unidades;
    }

    /** Reinicia la cantidad pedida a cero (nueva mesa). */
    public void reiniciarCantidad() {
        this.cantidad = 0;
    }

    /** Indica si este producto fue pedido en la mesa actual. */
    public boolean fuePedido() {
        return cantidad > 0;
    }

    /** Calcula el subtotal parcial: precio × cantidad. */
    public double calcularSubtotalParcial() {
        return precio * cantidad;
    }

}
