package com.manriquetavi.curso3_semana3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaMascotas = (RecyclerView)findViewById(R.id.rvMascota);
        Toolbar action_bar = (Toolbar) findViewById(R.id.action_bar);
        setSupportActionBar(action_bar);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaContatos();
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
            Toast.makeText(this, "STAR", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaContatos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Turtle",0, R.drawable.turtle));
        mascotas.add(new Mascota("Panda", 1, R.drawable.panda));
        mascotas.add(new Mascota("Husky", 2, R.drawable.husky));
        mascotas.add(new Mascota("Pug",3, R.drawable.pug));
        mascotas.add(new Mascota("Parrot",4, R.drawable.parrot));

    }
}