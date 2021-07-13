package com.manriquetavi.curso3_semana3;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PerfilFragmentPresenter implements IPerfilFragmentPresenter{
    private IPerfilFragment iPerfilFragment;
    private Context context;
    private BioItem bioItem;

    public PerfilFragmentPresenter(IPerfilFragment iPerfilFragment, Context context){
        this.iPerfilFragment = iPerfilFragment;
        this.context = context;
        this.obtenerInformacionUsuario();
    }
    @Override
    public void obtenerInformacionUsuario() {
        RestApiAdapter restApiAdapter =  new RestApiAdapter();
        Gson gsonBio = restApiAdapter.construyeGsonDeserializadorBio();
        EndpointsAPI endpointsAPI = restApiAdapter.establecerConexionRestApiInstagram(gsonBio);
        Call<BioResponse> bioResponseCall = endpointsAPI.getBioInfo();
        bioResponseCall.enqueue(new Callback<BioResponse>() {
            @Override
            public void onResponse(Call<BioResponse> call, Response<BioResponse> response) {
                BioResponse bioResponse = response.body();
                bioItem = bioResponse.getBioItem();
                iPerfilFragment.showProfile(bioItem);
            }

            @Override
            public void onFailure(Call<BioResponse> call, Throwable t) {
                Toast.makeText(context, "Falló la conexión con servidor", Toast.LENGTH_LONG).show();
                Log.e("Connection failed", t.toString());

            }
        });

    }
}
