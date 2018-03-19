package com.example.ricardosernam.puntodeventa.Ventas;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.ricardosernam.puntodeventa.R;
import com.example.ricardosernam.puntodeventa._____interfazes.interfaz_OnClick;

import java.util.ArrayList;

public class Historial_ventasAdapter extends RecyclerView.Adapter<Historial_ventasAdapter.HistorialVentasViewHolder> {
    private ArrayList<Historial_ventas_class> itemsHistorial;
    private Context context;
    private interfaz_OnClick Interfaz;

    public Historial_ventasAdapter(Context context, ArrayList<Historial_ventas_class> itemsCobrar, interfaz_OnClick Interfaz) {  ///recibe el arrayCobrar como parametro
        this.itemsHistorial=itemsCobrar;
        this.context=context;
        this.Interfaz=Interfaz;

    }

    public class HistorialVentasViewHolder extends RecyclerView.ViewHolder {
        public TextView tipoVenta,tipoCobro, fechaTransaccion, fechaApartado;
        public LinearLayout estatus, fechaEntrega, deuda;
        public FragmentManager manager;

        public HistorialVentasViewHolder(View itemView) {
            super(itemView);
            tipoVenta=itemView.findViewById(R.id.TVtipoHistorial);
            tipoCobro=itemView.findViewById(R.id.TVestatusHistorial);
            fechaTransaccion=itemView.findViewById(R.id.TVfechaHistorial);
            fechaApartado=itemView.findViewById(R.id.TVfechaApartadoHistorial);

            estatus=itemView.findViewById(R.id.LOestatus);
            fechaEntrega=itemView.findViewById(R.id.LOfechaEntrega);
            manager = ((Activity) context).getFragmentManager();
            deuda=itemView.findViewById(R.id.LOdeuda);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Interfaz.onClick(view);
                }
            });
        }

    }

    @Override
    public HistorialVentasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjetas_historial_ventas, parent, false);////mencionamos el archivo del layout
        return new HistorialVentasViewHolder(v);
    }
    @Override
    public int getItemCount() {
        return itemsHistorial.size();
    }
    @Override
    public void onBindViewHolder(HistorialVentasViewHolder holder, final int position) {
        holder.tipoVenta.setText(itemsHistorial.get(position).getTipo_venta());
        holder.tipoCobro.setText(itemsHistorial.get(position).getTipo_cobro());
        holder.fechaTransaccion.setText(itemsHistorial.get(position).getFecha());
        holder.fechaApartado.setText(itemsHistorial.get(position).getFecha_entrega());
        if(itemsHistorial.get(position).getTipo_cobro().equals("Pagar ahora")){  ///SI ESATA PAGADA LA COMPRA
            holder.tipoCobro.setText("Pagado");
            holder.estatus.setBackgroundColor(Color.GREEN);
            holder.itemView.setEnabled(false);  ///no abrir
            holder.deuda.setVisibility(View.GONE);
        }
        else{
            holder.estatus.setBackgroundColor(Color.RED);    ///SI NO SE HA PAGADO
            holder.itemView.setOnClickListener(new View.OnClickListener() {   ///si se presiona una carta, mandamos la instrucción al fragment
                @Override
                public void onClick(View view) {
                    Interfaz.onClick(view);
                }
            });
        }
        if(itemsHistorial.get(position).getTipo_venta().equals("Venta")){
            holder.fechaEntrega.setVisibility(View.GONE);
        }
    }




}
