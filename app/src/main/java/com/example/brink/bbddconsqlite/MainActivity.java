package com.example.brink.bbddconsqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button consulta;
    Button consultaCursor;
    Button guardar;

    EditText nombre;
    EditText apellidos;
    EditText telefono;

    ListView lista;
    BaseDatos bd;
    AdapterCursor adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //consulta = (Button) findViewById(R.id.mostrar);
        guardar = (Button) findViewById(R.id.guardar);

        consultaCursor = (Button) findViewById(R.id.mostrar);


        nombre = (EditText) findViewById(R.id.e1);
        apellidos = (EditText) findViewById(R.id.e2);
        telefono = (EditText) findViewById(R.id.e3);

        bd = new BaseDatos(this,"usuarios",null,2);

        consultaCursor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Cursor cursor;

                cursor = bd.devolverUsuarios2();

                adaptador = new AdapterCursor(MainActivity.this,cursor);
                lista.setAdapter(adaptador);
            }
        });


        /*
        consulta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Vector<Persona> personas = new Vector<Persona>();

                personas = bd.devolverUsuarios();

                if(personas.isEmpty()){
                    Toast.makeText(MainActivity.this,"No hay datos",Toast.LENGTH_LONG).show();
                }

                ArrayList<String> nombres = new ArrayList<String>();

                for(int i=0;i<personas.size();i++){

                    Log.i("TAG",""+personas.get(i).getNombre().toString());
                    Log.i("TAG",""+personas.get(i).getApellido().toString());
                    Log.i("TAG",""+personas.get(i).getTelefono());
                    //Añadir al vector
                    nombres.add(personas.get(i).getNombre());
                }
                //Poner contenido a nuestra layout
                lista.setAdapter(new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,nombres));
            }
        });
        */

        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(!nombre.getText().toString().isEmpty() && !apellidos.getText().toString().isEmpty() && !telefono.getText().toString().isEmpty() ){

                    Persona p = new Persona(nombre.getText().toString(),apellidos.getText().toString(),Integer.parseInt(telefono.getText().toString()));
                    bd.guardarUsuario(p);
                    Toast.makeText(MainActivity.this,"Informacion Agregada Correctamente",Toast.LENGTH_LONG).show();

                }else{
                    Toast.makeText(MainActivity.this,"Faltan 2",Toast.LENGTH_LONG).show();
                }
            }
        });



    }
}
