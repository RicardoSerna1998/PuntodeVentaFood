package com.example.ricardosernam.puntodeventa.Ventas;


import android.text.Editable;

public class Cobrar_ventas_class {   ///clase para obtener productos para cobrar
    private String nombre;
    private int cantidad;
    private float precioVenta, subTotal;

    Cobrar_ventas_class(String nombre, int cantidad, float precioVenta,  float subTotal) {  ///se manda desde el arrayProductos
        this.nombre=nombre;
        this.cantidad=cantidad;
        this.precioVenta=precioVenta;
        this.subTotal=subTotal;
    }
    public String getNombre(){
        return nombre;
    }
    float getCantidad(){
        return cantidad;
    }
    public float getPrecio(){
        return precioVenta;
    }
    float getSubTotal(){
        return subTotal;
    }
}
