package com.rafaelarnosti.marvelapp;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;

import com.rafaelarnosti.marvelapp.Model.Super;
import com.rafaelarnosti.marvelapp.Model.User;
import com.rafaelarnosti.marvelapp.R;
import com.rafaelarnosti.marvelapp.adapter.OnItemClickListener;
import com.rafaelarnosti.marvelapp.adapter.OnItemClickListenerUser;
import com.rafaelarnosti.marvelapp.adapter.UserAdapter;
import com.rafaelarnosti.marvelapp.bdResource.bdController;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class UsuariosFragment extends Fragment {

    private SQLiteDatabase db;
    private bdController banco;
    private RecyclerView rvUser;
    private UserAdapter userAdapter;
    private View itemView;

    public UsuariosFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        itemView = inflater.inflate(R.layout.fragment_usuarios, container, false);
        carregaDados();
        return itemView;
    }

    private void carregaDados(){
        banco = new bdController(itemView.getContext());
        db = banco.getReadableDatabase();
        User user;
        String usuario;
        String senha;
        Integer avatar;

        Cursor c = db.rawQuery("SELECT * FROM usuarios", null);

        List<User> users = new ArrayList<User>();

        try {
            while (c.moveToNext()) {
                user = new User();
                usuario = c.getString(c.getColumnIndex("usuario"));
                senha = c.getString(c.getColumnIndex("senha"));
                avatar = c.getInt(c.getColumnIndex("avatar"));
                user.setUsuario(usuario);
                user.setSenha(senha);
                user.setAvatar(avatar);
                users.add(user);
            }
        } finally {
            c.close();
        }

        rvUser = (RecyclerView) itemView.findViewById(R.id.rvUser);

        userAdapter = new UserAdapter(new ArrayList<User>(),
                new OnItemClickListenerUser() {
                    @Override
                    public void OnItemClickListenerUser(User user) {

                    }
                },getContext());


        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvUser.setLayoutManager(layoutManager);
        rvUser.setAdapter(userAdapter);
        rvUser.setHasFixedSize(true);

        userAdapter.update(users);


    }


}
