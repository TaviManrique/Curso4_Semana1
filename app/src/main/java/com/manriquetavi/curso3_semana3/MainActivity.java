package com.manriquetavi.curso3_semana3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.content.Intent;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar action_bar = findViewById(R.id.toolbar);
        setSupportActionBar(action_bar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        setUpViewPager();

        /*LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();*/
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
            contactActivity();
        } else if(id == R.id.Opcion2){
            bioActivity();
        } else if(id == R.id.Star){
            mascotaFavoritaActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    private void bioActivity() {
        Intent i = new Intent(this, BioActivity.class);
        startActivity(i);
    }

    private void contactActivity() {
        Intent i = new Intent(this, ContactActivity.class);
        startActivity(i);
    }

    private void mascotaFavoritaActivity() {
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

    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(new RecyclerViewFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }


    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.fragment_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.fragment_perfil);

    }

}