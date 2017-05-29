package com.example.nkta_.mimascota;

/**
 * Created by nkta_ on 27/05/2017.
 */

public class mascota {
    private int foto;
    private String nombre;

    public mascota(int foto,String nombre) {
        this.foto=foto;
        this.nombre = nombre;

    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
