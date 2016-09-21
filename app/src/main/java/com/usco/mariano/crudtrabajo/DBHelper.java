package com.usco.mariano.crudtrabajo;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Created by mariano on 21/09/16.
 */
public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table usuarios(id integer primary key autoincrement,codigo text, nombres text,apellidos text, edad text, celular text )");
        db.execSQL("insert into usuarios(id, codigo, nombres,apllidos, edad, celular) values(1,'2016','mario','serrano','18', '33312')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("create table usuarios(id integer primary key autoincrement,codigo text, nombres text,apellidos text, edad text, celular text )");
        db.execSQL("insert into usuarios(id, codigo, nombres,apllidos, edad, celular) values(1,'2016','mario','serrano','18', '33312')");
    }

    public ArrayList llenar_lv(){
        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "SELECT * FROM usuarios";
        Cursor registros = database.rawQuery(q,null);
        if(registros.moveToFirst()){
            do{
                lista.add(registros.getString(1));
            }while(registros.moveToNext());
        }
        return lista;

    }

}
