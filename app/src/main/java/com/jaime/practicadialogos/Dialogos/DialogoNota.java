package com.jaime.practicadialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.jaime.practicadialogos.R;

public class DialogoNota extends DialogFragment {


    private OnDialogoNotaListener listener;

    EditText editNota;
    View v;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(getContext()).inflate(R.layout.dialogo_peson_nota_layout, null, false);
        editNota = v.findViewById(R.id.edit_dialogo_nota);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("Notas");
        dialogo.setMessage("Introduce la nota que consideres que vas a sacar en el examen");
        dialogo.setView(v);

        dialogo.setPositiveButton("Continuar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nota = editNota.getText().toString();

            }
        });
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });



        return dialogo.create();
    }

    public interface OnDialogoNotaListener {
        void onDialogoSelected(String item);
    }
}
