package com.jaime.practicadialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.jaime.practicadialogos.R;


public class DialogoNombre extends DialogFragment {


    Button btnCancelar, btnContinuar;
    EditText editNombre;
    View v;


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(getContext()).inflate(R.layout.dialogo_personalizado_layout, null, false);
        editNombre = v.findViewById(R.id.edit_dialogo_user);

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Dialogo 2");
        dialogo.setMessage("Introduce tu Nombre");
        dialogo.setView(v);

        dialogo.setPositiveButton("COntinuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombre = editNombre.getText().toString();
                DialogoInformacion dialogoInformacion = DialogoInformacion.newInstance(nombre);
                dialogoInformacion.show(getFragmentManager(),"gfds");
            }
        });
        dialogo.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        return dialogo.create();
    }
    }

