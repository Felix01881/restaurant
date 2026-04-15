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
        this.nombre   = nombre;
        this.precio   = precio;
        this.cantidad = 0;
    }

    
    public String getNombre()   { return nombre; }
    public double getPrecio()   { return precio; }
    public int    getCantidad() { return cantidad; }

    
   
   
   
}
