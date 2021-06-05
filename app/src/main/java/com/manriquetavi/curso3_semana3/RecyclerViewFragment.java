package com.manriquetavi.curso3_semana3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    static ArrayList<Mascota> mascotas;
    private RecyclerView rvMascotas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        rvMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        //GridLayoutManager glm = GridLayoutManager(this,2);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        rvMascotas.setAdapter(adaptador);
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
