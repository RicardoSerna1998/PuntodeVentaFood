package com.example.ricardosernam.puntodeventa;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class AgregarProvedor extends DialogFragment {


    Button btnGuardar, btnCancelar;
    EditText EtNombre, EtApellido, EtTelefono, EtDireccion;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_fragment_agregar_provedor, container, false);

        btnGuardar = view.findViewById(R.id.btnGuardarNuevo);
        btnCancelar = view.findViewById(R.id.btnCancelar);

        EtNombre = view.findViewById(R.id.EtNombreNew);
        EtApellido = view.findViewById(R.id.EtApellidoNew);
        EtTelefono = view.findViewById(R.id.EtTelefonoNew);
        EtDireccion = view.findViewById(R.id.EtDireccionNew);

        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
                public void onClick(View view) {
                alta("Proveedores");
                Toast.makeText(getContext(), "Guardado correctamente", Toast.LENGTH_LONG).show();
                dismiss();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    //funcion para dar de alta, si funciona regresa true, si no regresa un false
    public void alta(String tabla)
    {
        BaseDeDatosLocal admin = new BaseDeDatosLocal(this.getContext(),"Proveedores",null,1);
        SQLiteDatabase db = admin.getWritableDatabase();

        //nuevo registro
        ContentValues nuevoRegistro = new ContentValues();
        //agregar info al registro
        nuevoRegistro.put("Nombre",EtNombre.getText().toString());
        nuevoRegistro.put("Apellidos",EtApellido.getText().toString());
        nuevoRegistro.put("Telefono",EtTelefono.getText().toString());
        nuevoRegistro.put("Direccion", EtDireccion.getText().toString());

        //insertar el nuevo registro
        db.insert(tabla,null, nuevoRegistro);

        //cerrar la base de datos
        db.close();
    }
}
