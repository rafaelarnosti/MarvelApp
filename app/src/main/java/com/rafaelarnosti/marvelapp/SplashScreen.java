package com.rafaelarnosti.marvelapp;



import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

public class SplashScreen extends AppCompatActivity {
    private final int SPLASH_DISPLAY_LENGTH = 3500;

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
}
