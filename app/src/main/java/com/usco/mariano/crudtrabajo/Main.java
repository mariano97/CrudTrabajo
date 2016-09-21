package com.usco.mariano.crudtrabajo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void registrar1(View view){
        Intent ven=new Intent(this,Registro.class);
        startActivity(ven);
    }
    public void consultar1(View view){
        Intent ven=new Intent(this,Consultar.class);
        startActivity(ven);
    }
}
