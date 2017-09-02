package com.rafaelarnosti.marvelapp;


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


/**
 * A simple {@link Fragment} subclass.
 */
public class CadastroFragment extends Fragment {

    EditText etNome;
    EditText etSenha;
    RadioGroup radioGroup1;
    Button btnCadastro;

    public CadastroFragment() {
        // Required empty public constructor

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cadastro, container, false);

        btnCadastro = (Button) view.findViewById(R.id.btnCadastro);

        btnCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etNome = (EditText) v.findViewById(R.id.tilNome);
                etSenha = (EditText) v.findViewById(R.id.tilSenha);
                radioGroup1 = (RadioGroup) v.findViewById(R.id.radioGroup1);

                String Nome = etNome.getText().toString();
                String Senha = etSenha.getText().toString();
                Integer Avatar = radioGroup1.getCheckedRadioButtonId();
                try {
                    InsereDados insereDados = new InsereDados(v.getContext());
                    insereDados.insereDado(Nome, Senha, Avatar);
                    Toast.makeText(v.getContext(), "Usuario inserido!!!!", Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(v.getContext(), "Usuario não inserido!!!!", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }

}
