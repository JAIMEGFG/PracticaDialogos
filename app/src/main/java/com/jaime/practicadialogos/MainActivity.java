package com.jaime.practicadialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.jaime.practicadialogos.Dialogos.DialogoContinuar;
import com.jaime.practicadialogos.Dialogos.DialogoFecha;
import com.jaime.practicadialogos.Dialogos.DialogoHora;
import com.jaime.practicadialogos.Dialogos.DialogoNota;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,
        DialogoContinuar.onDialogoContinuarListener,
        DatePickerDialog.OnDateSetListener,
        TimePickerDialog.OnTimeSetListener,
        DialogoNota.OnDialogoNotaListener
         {

    TextView notas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        //Meter el menu inflater aqui
    }

    private void instancias() {
        notas=findViewById(R.id.nota);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        DialogoContinuar dialogoContinuar = new DialogoContinuar("Bienvenido al examen");
        dialogoContinuar.show(getSupportFragmentManager(),"inicio");
        return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.opcion_examen:
                DialogoContinuar dialogoContinuar = new DialogoContinuar("Jaime");
                dialogoContinuar.show(getSupportFragmentManager(),"continuar");
                break;

        }

    }

    @Override
    public void onDialogoSelected(String item) {

    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        DialogoHora dialogoHora = new DialogoHora();
        dialogoHora.show(getSupportFragmentManager(),"continuar");
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        DialogoNota dialogoNota = new DialogoNota();
        dialogoNota.show(getSupportFragmentManager(),"continuar");
    }
         }
