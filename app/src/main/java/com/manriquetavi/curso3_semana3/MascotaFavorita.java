package com.manriquetavi.curso3_semana3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MascotaFavorita extends AppCompatActivity {

    ArrayList<Mascota> mascotasFavoritas;
    private RecyclerView listaMascotasFavoritas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorita_mascota);
        listaMascotasFavoritas = findViewById(R.id.rvMascotaFavorita);
        Toolbar action_bar = findViewById(R.id.action_bar_mf);
        setSupportActionBar(action_bar);


        Intent i = getIntent();
        int posicion1 = i.getIntExtra("posicion1",0);
        int posicion2 = i.getIntExtra("posicion2",0);
        int posicion3 = i.getIntExtra("posicion3",0);
        int posicion4 = i.getIntExtra("posicion4",0);
        int posicion5 = i.getIntExtra("posicion5",0);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasFavoritas.setLayoutManager(llm);
        inicializarListaMascotasFavoritas(posicion1, posicion2, posicion3, posicion4, posicion5);
        inicializarAdaptadorMF();
    }
    public void inicializarAdaptadorMF(){
        MascotaFavoritaAdaptador adaptador = new MascotaFavoritaAdaptador(mascotasFavoritas, this);
        listaMascotasFavoritas.setAdapter(adaptador);
    }

    public void inicializarListaMascotasFavoritas(int p1, int p2, int p3, int p4, int p5){
        mascotasFavoritas = new ArrayList<>();
        mascotasFavoritas.add(MainActivity.mascotas.get(p1));
        mascotasFavoritas.add(MainActivity.mascotas.get(p2));
        mascotasFavoritas.add(MainActivity.mascotas.get(p3));
        mascotasFavoritas.add(MainActivity.mascotas.get(p4));
        mascotasFavoritas.add(MainActivity.mascotas.get(p5));
        //mascotasFavoritas.add(new Mascota("Panda", 0, R.drawable.panda));
        //mascotasFavoritas.add(new Mascota("Husky", 0, R.drawable.husky));
        //mascotasFavoritas.add(new Mascota("Pug",0, R.drawable.pug));
        //mascotasFavoritas.add(new Mascota("Parrot",0, R.drawable.parrot));
    }
}