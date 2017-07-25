package com.example.brink.bbddconsqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Vector;

/**
 * Created by Brink on 21/07/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {


    public BaseDatos(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String consulta = "CREATE TABLE usuarios (_id INTEGER PRIMARY KEY " +
                "AUTOINCREMENT,nombre TEXT, apellido TEXT,telefono INTEGER);";

        sqLiteDatabase.execSQL(consulta);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void guardarUsuario(Persona persona){
        //Metode per editar
        SQLiteDatabase bd = getWritableDatabase();

        //Insertar
        bd.execSQL("INSERT INTO usuarios (nombre,apellido,telefono) VALUES ('"+persona.getNombre()+"','"+persona.getApellido()+"',"+persona.getTelefono()+")");
        bd.close();
    }

    public Vector<Persona> devolverUsuarios(){

        //Crear el vector de personas
        Vector<Persona> resultado = new Vector<Persona>();

        //Crear permisos per la lectura de la base de dades
        SQLiteDatabase fb = getReadableDatabase();

        Cursor cursor = fb.rawQuery("SELECT id as _id,nombre,apellido,telefono FROM usuarios ORDER BY id",null);

        while (cursor.moveToNext()){


            Persona aux = new Persona(cursor.getString(cursor.getColumnIndex("nombre")),
                    cursor.getString(cursor.getColumnIndex("apellido")),cursor.getInt(cursor.getColumnIndex("telefono")));
            //Añado los valores dentro
            resultado.add(aux);
        }
        //Cierro el cursor
        cursor.close();
        //Cierro la base de datos
        fb.close();


        //Retornar resultat Del vector
        return  resultado;

    }
    public Cursor devolverUsuarios2(){

        //Crear permisos per la lectura de la base de dades
        SQLiteDatabase fb = getReadableDatabase();

        Cursor cursor = fb.rawQuery("SELECT id as _id,nombre,apellido,telefono FROM usuarios ORDER BY nombre",null);

        //Retornar resultat Del vector
        return cursor;

    }

}
