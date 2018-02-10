package com.example.ricardosernam.puntodeventa;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class vendedoresAdapter extends RecyclerView.Adapter <vendedoresAdapter.Productos_ventasViewHolder>{  ///adaptador para el Fragmet Ventas
    private ArrayList<listaVendedores> itemsProductos;
    private interfaz_OnClick Interfaz;

    public vendedoresAdapter(ArrayList<listaVendedores> itemsProductos) {  ///recibe el arrayProductos como parametro y la interface
        this.itemsProductos = itemsProductos;
    }

    public  class Productos_ventasViewHolder extends RecyclerView.ViewHolder{    ////clase donde van los elementos del cardview
        // Campos respectivos de un item
        public TextView nombre;

        public Productos_ventasViewHolder(View v) {   ////lo que se programe aqui es para cuando se le de clic a un item del recycler
            super(v);
            nombre = v.findViewById(R.id.TVnombre);

        }
    }
    @Override
    public int getItemCount() {
        return itemsProductos.size();
    }


    @Override
    public Productos_ventasViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tarjetas_productos_ventas, viewGroup, false);
        return new Productos_ventasViewHolder(v);
    }

    @Override
    public void onBindViewHolder(Productos_ventasViewHolder holder, int position) {
        holder.nombre.setText(itemsProductos.get(position).showNombre());
    }
}