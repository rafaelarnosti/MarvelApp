package com.rafaelarnosti.marvelapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.rafaelarnosti.marvelapp.bdResource.InsereDados;

public class SobreFragment extends Fragment {
    View itemview;

    public SobreFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        itemview = inflater.inflate(R.layout.fragment_sobre, container, false);

        Button btnMapa = (Button) itemview.findViewById(R.id.btnMapa);
        TextView tvLigar = (TextView) itemview.findViewById(R.id.tvLigar);

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),
                        MapsActivity.class);
                startActivity(intent);
            }
        });

        tvLigar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:(11)960879465"));
                startActivity(intent);
            }
        });
        return itemview;
    }
}




