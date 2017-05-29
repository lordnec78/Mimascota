package com.example.nkta_.mimascota;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import static com.example.nkta_.mimascota.R.id.rvMascota;
public class MainActivity extends AppCompatActivity {

    ArrayList<mascota> datos;
    private RecyclerView listamascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miaction_bar= (Toolbar)findViewById(R.id.miaction_bar);
        setSupportActionBar(miaction_bar);

        //accedemos a nuestro activity main para usar nuestro recicleview
        listamascotas=(RecyclerView)findViewById(rvMascota);

        //queremos un contexto en forma de lista para nuestros datos
        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //mi lista de contactos(recicleview) con el metodo setlayoutmanager hara que se comporte como una lista linelayout
        //funciona tanto para el modo linear como para un grid, ""solo cambia la variable llm a glm
        listamascotas.setLayoutManager(llm);
        InicializaListaMascotas();
        InicializarlistaAdaptador();

    }

    public ListadoMascotas adaptador;
    private void InicializarlistaAdaptador(){
        adaptador=new ListadoMascotas(datos, this);

        /*el recilceview ya contiene el adaptador el cual estara llamando al layout cardview y le pasara los datos de la lista a todos los view
        que el viewholder estara decarando*/

        listamascotas.setAdapter(adaptador);
    }

    public void InicializaListaMascotas (){

        datos=new ArrayList<mascota>();

        datos.add(new mascota(R.drawable.masc1,"Friends"));
        datos.add(new mascota(R.drawable.masc2,"Dreamers"));
        datos.add(new mascota(R.drawable.masc3,"funny"));
        datos.add(new mascota(R.drawable.masc4,"Relax"));
        datos.add(new mascota(R.drawable.masc5,"Cat_ft.rabbit"));
    }

    public void miestrella(View view){
        Intent intent=new Intent(this,DetalleMascota.class);
        startActivity(intent);
    }
}
