package com.usco.mariano.crudtrabajo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Registro extends AppCompatActivity {
    EditText cod, nom, ape, edad, cel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registro);
        cod = (EditText) findViewById(R.id.codigo2);
        nom = (EditText) findViewById(R.id.nombres2);
        ape = (EditText) findViewById(R.id.apellidos1);
        edad = (EditText) findViewById(R.id.edad1);
        cel = (EditText) findViewById(R.id.celular1);
    }
    public void guardar(View view){
        DBHelper admin=new DBHelper(this,"clase",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String codigo = cod.getText().toString();
        String nombre = nom.getText().toString();
        String apellido = ape.getText().toString();
        String eda = edad.getText().toString();
        String celu = cel.getText().toString();

        db.execSQL("insert into usuarios (codigo, nombres,apllidos, edad, celular) values('"+codigo+
                "','"+nombre+"','"+apellido+"','"+eda+"','"+celu+"')");
        db.close();

        Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();
        Intent ven=new Intent(this,Main.class);
        startActivity(ven);
    }
    public void modificar(View view){

        Intent ven=new Intent(this,Modificar.class);
        startActivity(ven);
    }
    public void eliminar(View view) {
        Intent ven=new Intent(this,Eliminar.class);
        startActivity(ven);
    }
}
