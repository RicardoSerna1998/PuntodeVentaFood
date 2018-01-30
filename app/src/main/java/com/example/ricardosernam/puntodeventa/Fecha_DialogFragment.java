package com.example.ricardosernam.puntodeventa;


import android.annotation.SuppressLint;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

@SuppressLint("ValidFragment")
public class Fecha_DialogFragment extends DialogFragment {
    private DatePicker fecha;
    private EditText modificarFecha;
    private Button aceptar, cancelar;
    private Calendar calendar;
    private interfaz_OnClickFecha Interface;

    @SuppressLint("ValidFragment")
    public Fecha_DialogFragment(interfaz_OnClickFecha Interface){
        this.Interface=Interface;
    }

    @Override
    public View onCreateView (final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView=inflater.inflate(R.layout.fecha,container);
        this.getDialog().setTitle("Fecha de entrega");///cambiamos titulo del DialogFragment
        calendar = Calendar.getInstance();
        cancelar=rootView.findViewById(R.id.BtncancelarFecha);
        fecha=rootView.findViewById(R.id.DPfecha);
        aceptar=rootView.findViewById(R.id.BtnaceptarFecha);
        modificarFecha=rootView.findViewById(R.id.ETfecha);
        fecha.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), new DatePicker.OnDateChangedListener() {
                    @Override
                    public void onDateChanged(DatePicker datePicker, final int i, final int i1, final int i2) {
                        aceptar.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Interface.onClick(view, i, i1, i2);
                                dismiss();
                            }
                        });
                    }
        });
        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        return rootView;
    }
}