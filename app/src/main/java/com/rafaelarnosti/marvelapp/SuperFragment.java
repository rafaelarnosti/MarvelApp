package com.rafaelarnosti.marvelapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.rafaelarnosti.marvelapp.Model.ResponseHeroiMarvel;
import com.rafaelarnosti.marvelapp.Model.Super;
import com.rafaelarnosti.marvelapp.adapter.MarvelAdapter;
import com.rafaelarnosti.marvelapp.adapter.OnItemClickListener;
import com.rafaelarnosti.marvelapp.api.APIUtils;
import com.rafaelarnosti.marvelapp.api.SuperAPI;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.rafaelarnosti.marvelapp.R.id.rvSuper;


/**
 * A simple {@link Fragment} subclass.
 */
public class SuperFragment extends Fragment {
    private RecyclerView rvSuper;
    private MarvelAdapter marvelAdapter;
    private SuperAPI superAPI;
    View itemView;

    public SuperFragment() {
        // Required empty public constructor
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        carregaDados();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        itemView = inflater.inflate(R.layout.fragment_super, container, false);



        return itemView;
    }



    private void carregaDados(){
        superAPI = APIUtils.getSuper();
        superAPI.getSupers().enqueue(new Callback<ResponseHeroiMarvel>() {
            @Override
            public void onResponse(Call<ResponseHeroiMarvel> call, Response<ResponseHeroiMarvel> response) {
                if (response.isSuccessful()) {

                    rvSuper = (RecyclerView) itemView.findViewById(R.id.rvSuper);

                    marvelAdapter = new MarvelAdapter(new ResponseHeroiMarvel(),
                            new OnItemClickListener() {
                                @Override
                                public void onItemClick(Super item) {

                                }
                            });

                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
                    rvSuper.setLayoutManager(layoutManager);
                    rvSuper.setAdapter(marvelAdapter);
                    rvSuper.setHasFixedSize(true);

                    marvelAdapter.update(response.body());
                }

            }
            @Override
            public void onFailure(Call<ResponseHeroiMarvel> call, Throwable t) {
                Log.e("ERRO", "DEU RUIM");
            }
        });
    }

}
