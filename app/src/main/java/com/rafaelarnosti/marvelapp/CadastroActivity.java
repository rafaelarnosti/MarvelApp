package com.rafaelarnosti.marvelapp;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Bundle bundle = getIntent().getExtras();


        CadastroFragment cf = new CadastroFragment();
        cf.setArguments(bundle);
        FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.activity_cadastro,cf)
                .addToBackStack(null)
                .commit();
    }
}
