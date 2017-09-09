package com.rafaelarnosti.marvelapp;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.rafaelarnosti.marvelapp.bdResource.InsereDados;
import com.rafaelarnosti.marvelapp.bdResource.bdController;


/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroFragment extends Fragment {

    EditText etNome;
    EditText etSenha;
    RadioGroup radioGroup1;
    Button btnCadastro;
    Button btnAlterar;
    Button btnDeletar;
    Boolean Editar;
    Boolean Deletar;
    String usuario;
    String senha;
    int avatar;
    private SQLiteDatabase db;
    private bdController banco;
    ContentValues valores;
    private Context mContext;

    public CadastroFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);

        banco = new bdController(view.getContext());
        db = banco.getReadableDatabase();

        Bundle bundle = this.getArguments();
        if (bundle != null) {
            Deletar = bundle.getBoolean("Deletar", false);
            Editar = bundle.getBoolean("Editar", false);
            usuario = bundle.getString("Usuario", "");
            senha = bundle.getString("Senha", "");
            avatar = bundle.getInt("Avatar", 0);
        }

        btnAlterar = (Button) view.findViewById(R.id.btnAlterar);
        btnDeletar = (Button) view.findViewById(R.id.btnDeletar);
        btnCadastro = (Button) view.findViewById(R.id.btnCadastro);
        etNome = (EditText) view.findViewById(R.id.tilNome);
        etSenha = (EditText) view.findViewById(R.id.tilSenhaCadastro);
        radioGroup1 = (RadioGroup) view.findViewById(R.id.radioGroup1);


        if (Editar != null) {
            if (Editar == true) {
                btnDeletar.setVisibility(View.GONE);
                btnCadastro.setVisibility(View.GONE);
                etNome.setText(usuario);
                etSenha.setText(senha);
                radioGroup1.check(avatar);
            }
        }
        if (Deletar != null) {
            if (Deletar == true) {
                btnAlterar.setVisibility(View.GONE);
                btnCadastro.setVisibility(View.GONE);
                etNome.setText(usuario);
                etSenha.setText(senha);
                radioGroup1.check(avatar);
            }
        }
        if(Editar == null && Deletar == null){
            btnAlterar.setVisibility(View.GONE);
            btnDeletar.setVisibility(View.GONE);
        }


        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nome = etNome.getText().toString();
                String Senha = etSenha.getText().toString();
                Integer Avatar = radioGroup1.getCheckedRadioButtonId();
                try {
                    InsereDados insereDados = new InsereDados(v.getContext());
                    insereDados.insereDado(Nome, Senha, Avatar);
                    Toast.makeText(v.getContext(), "Usuario inserido!!!!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(),
                            LoginActivity.class);
                    startActivity(intent);
                } catch (Exception ex) {
                    Toast.makeText(v.getContext(), "Usuario não inserido!!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnAlterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nome = etNome.getText().toString();
                String Senha = etSenha.getText().toString();
                Integer Avatar = radioGroup1.getCheckedRadioButtonId();
                valores = new ContentValues();
                valores.put(bdController.USUARIO, Nome);
                valores.put(bdController.SENHA, Senha);
                valores.put(bdController.AVATAR, Avatar);
                String[] args = {"" + usuario};
                try {
                    db.update(bdController.TABELA, valores, "Usuario = ?", args);
                    Toast.makeText(v.getContext(), "Usuario Atualizado!!!!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(),
                            LoginActivity.class);
                    startActivity(intent);
                } catch (Exception ex) {
                    Toast.makeText(v.getContext(), "Usuario não Atualizado!!!!", Toast.LENGTH_LONG).show();
                }
            }
        });
        btnDeletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String Nome = etNome.getText().toString();
                    String[] args = {"" + Nome};
                    db.delete(bdController.TABELA, "Usuario = ?", args);
                    Toast.makeText(v.getContext(), "Usuario Excluido!!!!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(getActivity(),
                            LoginActivity.class);
                    startActivity(intent);
                } catch (Exception ex) {
                    Toast.makeText(v.getContext(), "Usuario não Excluido!!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

}
