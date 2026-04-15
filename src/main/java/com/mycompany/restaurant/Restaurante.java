/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author salainformatica
 */
public class Restaurante {
    

    private Restaurante() {}  

   
    public static final String NOMBRE    = "El Buen Sabor";
    public static final String DIRECCION = "Calle 15 #8-32, Valledupar";
    public static final String NIT       = "900.123.456-7";

    // ── Reglas de negocio ───────────
    public static final double TASA_IVA                  = 0.19;
    public static final double TASA_PROPINA              = 0.10;
    public static final double TASA_DESCUENTO_VARIEDAD   = 0.05;
    public static final double UMBRAL_PROPINA            = 50_000.0;
    public static final int    MINIMO_PRODUCTOS_DESCUENTO = 3;

   
    public static final String SEPARADOR_DOBLE          = "========================================";
    public static final String SEPARADOR_SIMPLE         = "----------------------------------------";
    public static final String FORMATO_LINEA_PRODUCTO   = "%-20s x%-6d $%,.0f%n";
    public static final String FORMATO_LINEA_TOTAL      = "%-27s $%,.0f%n";
}

