package com.jaime.practicadialogos.Dialogos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.jaime.practicadialogos.R;

import java.util.ArrayList;

public class DialogoNota extends DialogFragment {
    View v;
    Spinner spiner;
    ArrayAdapter adaptador;
    ArrayList notas;
    onRespuestaListener listener;
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        v = LayoutInflater.from(getContext()).inflate(R.layout.dialogo_peson_nota_layout,null);
        spiner = v.findViewById(R.id.spinnerDialogo);
        notas = new ArrayList();
        adaptador = new ArrayAdapter(getContext(),
                android.R.layout.simple_spinner_item, notas);
        rellenarNotas();
        spiner.setAdapter(adaptador);
        listener = (onRespuestaListener) getContext();
    }

    private void rellenarNotas() {
        for (int i = 0;i<10;i++){
            notas.add(i+1);
        }
        adaptador.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialogo = new AlertDialog.Builder(getContext());
        dialogo.setTitle("DIALOGO 6");
        dialogo.setView(v);
        dialogo.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dismiss();
            }
        });
        dialogo.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                listener.onRespuestaNota((Integer) adaptador.getItem(spiner.getSelectedItemPosition()));
            }
        });
        return dialogo.create();
    }
    public interface onRespuestaListener{
        void onRespuestaNota(int nota);
    }
}
