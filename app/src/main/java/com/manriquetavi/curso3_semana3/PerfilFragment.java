package com.manriquetavi.curso3_semana3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PerfilFragment extends Fragment {
    private ArrayList<Mascota> mascotas;
    private RecyclerView rvsMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        rvsMascotas = (RecyclerView) v.findViewById(R.id.rvsMascotas);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        rvsMascotas.setLayoutManager(glm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador(){
        MascotaPerfilAdaptador adaptador = new MascotaPerfilAdaptador(mascotas, getActivity());
        rvsMascotas.setAdapter(adaptador);
    }

    public void inicializarListaMascotas(){
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Turtle",5, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle", 0, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",3, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",10, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",2, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",5, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",0, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",3, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",10, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",2, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",5, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle", 0, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",3, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",10, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",2, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",5, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",0, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",3, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",10, R.drawable.turtle));
        mascotas.add(new Mascota("Turtle",2, R.drawable.turtle));
    }
}
