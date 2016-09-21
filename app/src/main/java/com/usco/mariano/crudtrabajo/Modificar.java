package com.usco.mariano.crudtrabajo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Modificar extends AppCompatActivity {
    EditText idd, nomb, apell, edads, cell;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modificar);

        idd=(EditText) findViewById(R.id.id2);
        nomb=(EditText) findViewById(R.id.nombres3);
        apell=(EditText) findViewById(R.id.apellidos1);
        edads=(EditText) findViewById(R.id.edad3);
        cell=(EditText) findViewById(R.id.celular3);
    }
    public void guardar3(View view){
        DBHelper admin=new DBHelper(this,"clase",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String ides = idd.getText().toString();
        String nombrene = nomb.getText().toString();
        String apellidone = apell.getText().toString();
        String edane = edads.getText().toString();
        String celune = cell.getText().toString();

        db.execSQL("update usuarios set nombres= '"+nombrene+"', apellidos='"+apellidone+"',edad='"+edane+"',celune='"+celune+"' where id="+ides+"");
        db.close();
Toast.makeText(this,"Registro exitoso",Toast.LENGTH_SHORT).show();
        Toast.makeText(this,"Registro modificado",Toast.LENGTH_SHORT).show();
        Intent ven=new Intent(this,Consultar.class);
        startActivity(ven);
    }
    public void cancelar(View view){
        Intent ven=new Intent(this,Consultar.class);
        startActivity(ven);
    }
}
