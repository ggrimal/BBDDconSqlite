package com.example.brink.bbddconsqlite;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by Brink on 24/07/2017.
 */

public class AdapterCursor extends CursorAdapter {
    /**
     * @param context
     * @param c
     * @param 0
     */
    public AdapterCursor(Context context, Cursor c) {
        super(context, c,0);
    }
    /*
           Coger
     */
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return LayoutInflater.from(context).inflate(R.layout.template,viewGroup);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView nombre = (TextView) view.findViewById(R.id.nombre);
        TextView apellidos = (TextView) view.findViewById(R.id.apellidos);
        TextView telefono = (TextView) view.findViewById(R.id.telf);

        //afegir el text en base la bbbdd (NOMBRE)
        nombre.setText(cursor.getString(cursor.getColumnIndex("usuarios.nombre")));
        apellidos.setText(cursor.getString(cursor.getColumnIndex("usuarios.apellido")));
        telefono.setText(cursor.getString(cursor.getColumnIndex("usuarios.telefono")));
    }
}
