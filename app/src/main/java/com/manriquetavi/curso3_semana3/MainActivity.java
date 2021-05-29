package com.manriquetavi.curso3_semana3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.content.Intent;
import android.widget.Toast;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    static ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaMascotas = findViewById(R.id.rvMascota);
        Toolbar action_bar = findViewById(R.id.action_bar);
        setSupportActionBar(action_bar);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.Opcion1){
            Toast.makeText(this,"OPCION1",Toast.LENGTH_LONG).show();
        } else if(id == R.id.Opcion2){
            Toast.makeText(this,"OPCION2",Toast.LENGTH_LONG).show();
        } else if(id == R.id.Star){
            secondActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    private void secondActivity() {
        ArrayList<Integer> posiciones = MascotaAdaptador.posiciones;
        int posicion1, posicion2, posicion3, posicion4, posicion5, filtro;
        filtro = posiciones.size();
        if (filtro < 5){
            Toast.makeText(this,"Debe darle al menos 5 raiting a las mascotas",Toast.LENGTH_LONG).show();
        }
        else {
            posicion5 = posiciones.get(posiciones.size() - 1);
            posicion4 = posiciones.get(posiciones.size() - 2);
            posicion3 = posiciones.get(posiciones.size() - 3);
            posicion2 = posiciones.get(posiciones.size() - 4);
            posicion1 = posiciones.get(posiciones.size() - 5);
            Intent i = new Intent(this, MascotaFavorita.class);
            i.putExtra("posicion1",posicion1);
            i.putExtra("posicion2",posicion2);
            i.putExtra("posicion3",posicion3);
            i.putExtra("posicion4",posicion4);
            i.putExtra("posicion5",posicion5);
            startActivity(i);
        }
    }


    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Turtle",0, R.drawable.turtle));
        mascotas.add(new Mascota("Panda", 1, R.drawable.panda));
        mascotas.add(new Mascota("Husky", 2, R.drawable.husky));
        mascotas.add(new Mascota("Pug",3, R.drawable.pug));
        mascotas.add(new Mascota("Parrot",4, R.drawable.parrot));
    }
}