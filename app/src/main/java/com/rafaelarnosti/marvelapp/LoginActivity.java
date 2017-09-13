package com.rafaelarnosti.marvelapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.rafaelarnosti.marvelapp.R;
import com.rafaelarnosti.marvelapp.adapter.MarvelAdapter;
import com.rafaelarnosti.marvelapp.bdResource.bdController;

public class LoginActivity extends AppCompatActivity {
    EditText tilLogin;
    EditText tilSenha;
    CheckBox cbLogin;
    LoginButton loginButton;
    CallbackManager callbackManager;
    private SQLiteDatabase db;
    private bdController banco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        tilLogin = (EditText) findViewById(R.id.tilLogin);
        tilSenha = (EditText) findViewById(R.id.tilSenha);
        cbLogin = (CheckBox) findViewById(R.id.cbLogin);

        SharedPreferences sp = getSharedPreferences("MarvelApp", Context.MODE_PRIVATE);
        String username = sp.getString("usuario", null);
        String senha = sp.getString("senha",null);
        Boolean check = sp.getBoolean("check",false);


        banco = new bdController(getBaseContext());
        db = banco.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM usuarios", null);

        c.moveToFirst();

        tilLogin.setText(username);
        tilSenha.setText(senha);
        cbLogin.setChecked(check);

        if (cbLogin.isChecked()) {
            Intent intent = new Intent(LoginActivity.this,
                    MarvelNavigation.class);
            intent.putExtra("usuario", username);
            intent.putExtra("avatar", c.getInt(c.getColumnIndex("avatar")));
            startActivity(intent);
            LoginActivity.this.finish();
        }

/*        if (c.getCount() != 0) {
            tilLogin.setText(c.getString(c.getColumnIndex("usuario")));
            tilSenha.setText(c.getString(c.getColumnIndex("senha")));
        }*/

        callbackManager = CallbackManager.Factory.create();

        loginButton = (LoginButton) findViewById(R.id.login_button);
        loginButton.setReadPermissions("email");

        LoginManager.getInstance().registerCallback(callbackManager,
                new FacebookCallback<LoginResult>() {
                    @Override
                    public void onSuccess(LoginResult loginResult) {
                        Intent intent = new Intent(LoginActivity.this,
                                MarvelNavigation.class);

                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                    }

                    @Override
                    public void onCancel() {
                        // App code
                    }

                    @Override
                    public void onError(FacebookException exception) {
                        // App code
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    public void logar(View v) {

        String Login = tilLogin.getText().toString();
        String Senha = tilSenha.getText().toString();

        Cursor c = db.rawQuery("SELECT * FROM usuarios WHERE TRIM(usuario) = '" + Login.trim() + "' AND TRIM(senha)= '" + Senha.trim() + "'", null);

        c.moveToFirst();

        if (c.getCount() != 0) {
            Intent intent = new Intent(LoginActivity.this,
                    MarvelNavigation.class);
            intent.putExtra("usuario", Login);
            intent.putExtra("avatar", c.getInt(c.getColumnIndex("avatar")));
            if (cbLogin.isChecked()) {
                SharedPreferences sp = getSharedPreferences("MarvelApp", Context.MODE_PRIVATE);
                SharedPreferences.Editor e = sp.edit();
                e.putString("usuario", Login);
                e.putString("senha",Senha);
                e.putBoolean("check",cbLogin.isChecked());
                e.commit();
            }
            startActivity(intent);
            LoginActivity.this.finish();
        } else {
            Toast.makeText(this.getBaseContext(), "Usuario ou senha Invalidos", Toast.LENGTH_LONG).show();
        }
    }

    public void cadastro(View v) {
        Intent intent = new Intent(LoginActivity.this,
                CadastroActivity.class);
        startActivity(intent);
        LoginActivity.this.finish();

    }

}
