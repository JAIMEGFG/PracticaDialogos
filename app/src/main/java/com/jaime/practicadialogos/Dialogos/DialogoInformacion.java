package com.jaime.practicadialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoInformacion extends DialogFragment {

    View v;
    EditText editNombre;
    private String nombrerecuperado;
    static final String TAG_ARG1 = "nombre";





    public static DialogoInformacion newInstance(String nombre) {

        DialogoInformacion dialogoInformacion = new DialogoInformacion();
        Bundle bundle = new Bundle();
        bundle.putString(TAG_ARG1, nombre);
        dialogoInformacion.setArguments(bundle);
        return dialogoInformacion;
    }


        @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        nombrerecuperado = this.getArguments().getString(TAG_ARG1);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Dialogo 3");
        dialogo.setMessage(nombrerecuperado+ " ahora tendrás que introducir una fecha y una hora,¿OK?");
        dialogo.setPositiveButton("CONTINUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                DialogoFecha dialogoFecha = new DialogoFecha();
                dialogoFecha.show(getFragmentManager(),"Fecha");

            }
        });
        dialogo.setNegativeButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dismiss();
            }
        });
        return dialogo.create();
    }
}
