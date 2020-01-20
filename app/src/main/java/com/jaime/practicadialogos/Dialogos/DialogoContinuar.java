package com.jaime.practicadialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.jaime.practicadialogos.R;

public class DialogoContinuar extends DialogFragment {

    Button btnSi;

    private onDialogoContinuarListener listener;

    public DialogoContinuar(String Titulo) {
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (onDialogoContinuarListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Examen");
        dialogo.setMessage("¿Quieres Continuar?");
        dialogo.setPositiveButton("Si", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                listener.onDialogoSelected("SI");
                DialogoNombre dialogoNombre = new DialogoNombre();
                dialogoNombre.show(getFragmentManager(),"nombre");

            }
        });
        dialogo.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                listener.onDialogoSelected("NO");
                dismiss();
            }
        });
        dialogo.setNeutralButton("CANCELAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                listener.onDialogoSelected("CANCELAR");
                System.exit(0);


            }
        });

        return dialogo.create();
    }




    public interface onDialogoContinuarListener {
        void onDialogoSelected(String item);
    }

}
