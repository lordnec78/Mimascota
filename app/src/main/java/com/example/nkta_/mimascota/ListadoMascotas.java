package com.example.nkta_.mimascota;

import android.app.Activity;
import android.content.Intent;
    import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListadoMascotas extends RecyclerView.Adapter<ListadoMascotas.MascotasViewHolder> {
    ArrayList<mascota> datos; //para la coleccion de datos
    Activity activity;



    //generamos un cosntructor para pasar la lista de contactos a el adaptador para que se ralicen los metodos a nivel global
    public ListadoMascotas (ArrayList<mascota> datos, Activity activity){

        this.datos=datos;
        this.activity=activity;
    }
    //llena el layout y lo pasa al viewholder para acceder al los view
    @Override
    public MascotasViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//infla o da vida a mi cardview
        //asociamos nuestro layout a nuestro recicleview, se indica cual es el layout que se estara reciclando
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.listado_mascotas, parent,false);
        return new MascotasViewHolder(v);// le pasamos el contacto ya cardview ya inflado al metodo constructor viewholder
    }

    @Override
    public void onBindViewHolder(MascotasViewHolder holder, int position) {


        //aqui se empieza a setear los valores de mi lista
        final mascota dato= datos.get(position);//extrae la posicion de cada elemento de la lista
        holder.imgfoto.setImageResource(dato.getFoto());
        holder.cvnombre.setText(dato.getNombre());

        holder.imgfoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(activity,dato.getNombre(),Toast.LENGTH_SHORT).show();

                Toast.makeText(activity,"De like a" + dato.getNombre(),Toast.LENGTH_SHORT).show();

                Intent intent=new Intent(activity,DetalleMascota.class);
                intent.putExtra("imgfoto",dato.getFoto());
                intent.putExtra("cvnombre",dato.getNombre());


                activity.startActivity(intent);
            }
        }
        );

        holder.btnlike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(activity,"Diste like a" + dato.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }



    @Override
    public int getItemCount() {
        return datos.size();
    }


    public static class MascotasViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgfoto;
        private ImageView btnlike;
        private TextView cvnombre;
       // private TextView cvconteo;

        public MascotasViewHolder(View itemView) {
            super(itemView);

            imgfoto=(ImageView) itemView.findViewById(R.id.imgfoto);
            btnlike=(ImageView) itemView.findViewById(R.id.btnlike);
            cvnombre=(TextView) itemView.findViewById(R.id.cvnombre);
            //cvconteo=(TextView) itemView.findViewById(R.id.cvconteo);
        }
    }



}
