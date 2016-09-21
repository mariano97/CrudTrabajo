package com.usco.mariano.crudtrabajo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Eliminar extends AppCompatActivity {
    EditText ids;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.eliminar);

        ids = (EditText) findViewById(R.id.ideliminar);
    }
    public void ideliminar (View view){
        DBHelper admin=new DBHelper(this,"clase",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        String eliminar = ids.getText().toString();

        db.execSQL("delete from usuarios where id='"+eliminar+"'");

        Toast.makeText(this,"eliminado",Toast.LENGTH_SHORT).show();
        Intent ven=new Intent(this,Registro.class);
        startActivity(ven);
    }
}
