package com.manriquetavi.curso3_semana3;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MascotaPerfilAdaptador extends RecyclerView.Adapter<MascotaPerfilAdaptador.MascotaPerfilViewHolder>{
    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaPerfilAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    public MascotaPerfilAdaptador.MascotaPerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_small, parent, false);
        return new MascotaPerfilAdaptador.MascotaPerfilViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaPerfilAdaptador.MascotaPerfilViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        holder.cvsImagePet.setImageResource(mascota.getFoto());
        holder.cvsFavorito.setText(String.valueOf(mascota.getFavorito()));
    }

    public int getItemCount() { //Cantidad de elementos que contiene mi lista
        return mascotas.size();
    }

    public static class MascotaPerfilViewHolder extends RecyclerView.ViewHolder{
        private ImageView cvsImagePet;
        private TextView cvsFavorito;
        private ImageView cvsImageBoneYellow;

        public MascotaPerfilViewHolder(View itemView) {
            super(itemView);
            cvsImagePet = (ImageView) itemView.findViewById(R.id.cvsImagePet);
            cvsFavorito = (TextView) itemView.findViewById(R.id.cvsFavorito);
            cvsImageBoneYellow = (ImageView) itemView.findViewById(R.id.cvsImageBoneYellow);
        }
    }
}
