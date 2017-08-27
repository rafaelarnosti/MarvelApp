package com.rafaelarnosti.marvelapp;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.rafaelarnosti.marvelapp.Model.ResponseHeroiMarvel;
import com.rafaelarnosti.marvelapp.Model.Super;
import com.rafaelarnosti.marvelapp.Model.User;
import com.rafaelarnosti.marvelapp.adapter.MarvelAdapter;
import com.rafaelarnosti.marvelapp.adapter.OnItemClickListener;
import com.rafaelarnosti.marvelapp.api.APIUtils;
import com.rafaelarnosti.marvelapp.api.UserAPI;
import com.rafaelarnosti.marvelapp.bdResource.InsereDados;
import com.rafaelarnosti.marvelapp.bdResource.bdController;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SplashScreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3500;
    private UserAPI userAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        carregar();

    }
    private void carregar() {
        Animation anim = AnimationUtils.loadAnimation(this,
                R.anim.animacao_splash);
        anim.reset();
        //Pegando o nosso objeto criado no layout
        ImageView iv = (ImageView) findViewById(R.id.splash);
        if (iv != null) {
            iv.clearAnimation();
            iv.startAnimation(anim);
            GlideDrawableImageViewTarget target = new GlideDrawableImageViewTarget(iv);
            Glide.with(this).load(R.drawable.t2).into(target);
        }
        carregarDados();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Após o tempo definido irá executar a próxim atela
                Intent intent = new Intent(SplashScreen.this,
                        LoginActivity.class);
               intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                SplashScreen.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
    private void carregarDados(){
        userAPI = APIUtils.getUser();
        userAPI.getUser().enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if (response.isSuccessful()) {
                    InsereDados insereDados = new InsereDados(getBaseContext());
                    insereDados.insereDado(response.body().getUsuario(),response.body().getSenha());
                }

            }
            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e("ERRO", "DEU RUIM");
            }
        });
    }
}
