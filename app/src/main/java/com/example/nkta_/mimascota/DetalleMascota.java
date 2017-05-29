package com.example.nkta_.mimascota;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static com.example.nkta_.mimascota.R.id.cvnombre;
import static com.example.nkta_.mimascota.R.id.imgfoto;

/**
 * Created by nkta_ on 11/05/2017.
 */

public class DetalleMascota extends AppCompatActivity  {
    private ImageView imgfoto;
    private TextView cvnombre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascota_detalle);

        Toolbar miaction_bar= (Toolbar)findViewById(R.id.miaction_bar);
        setSupportActionBar(miaction_bar);

       getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle parametros = getIntent().getExtras();
        //int imfoto = parametros.getInt(getResources().getInteger(R.id.imgfoto));
        String nombre = parametros.getString(getResources().getString(R.string.pnombre));

        imgfoto  = (ImageView) findViewById(R.id.imgfoto);
        cvnombre   = (TextView) findViewById(R.id.cvnombre);

        //imgfoto.setImageResource(imfoto);
        cvnombre.setText(nombre);

    }

}

