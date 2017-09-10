package com.rafaelarnosti.marvelapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ShareActionProvider;
import android.widget.TextView;
import android.widget.Toast;

import com.rafaelarnosti.marvelapp.CadastroActivity;
import com.rafaelarnosti.marvelapp.Model.User;
import com.rafaelarnosti.marvelapp.R;
import com.rafaelarnosti.marvelapp.UsuariosFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by rafae on 08/09/2017.
 */

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.UserViewHolder> {

    private List<User> users;
    private OnItemClickListenerUser onItemClickListenerUser;
    private int listItemPositionForPopupMenu;
    private Context mContext;
    private ShareActionProvider mShareActionProvider;

    public UserAdapter(List<User> users, OnItemClickListenerUser onItemClickListenerUser, Context context) {
        this.users = users;
        this.onItemClickListenerUser = onItemClickListenerUser;
        this.mContext = context;
    }


    @Override
    public UserAdapter.UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View meuLayout = inflater.inflate(R.layout.super_row, parent, false);
        return new UserViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(UserAdapter.UserViewHolder holder, final int position) {
        holder.tvTitulo.setText(users.get(position).getUsuario());
        holder.tvSubTitulo.setText(users.get(position).getSenha());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListenerUser.OnItemClickListenerUser(users.get(position));
                showPopupMenu(v, position);
            }
        });
        switch (users.get(position).getAvatar()) {
            case 2131558587:
                Picasso.with(holder.itemView.getContext())
                        .load(R.drawable.spiderman)
                        .into(holder.ivSuper);
                break;
            case 2131558588:
                Picasso.with(holder.itemView.getContext())
                        .load(R.drawable.america)
                        .into(holder.ivSuper);
                break;
            case 2131558589:
                Picasso.with(holder.itemView.getContext())
                        .load(R.drawable.ciclops)
                        .into(holder.ivSuper);
                break;
            case 2131558590:
                Picasso.with(holder.itemView.getContext())
                        .load(R.drawable.fantastic)
                        .into(holder.ivSuper);
                break;
            case 2131558591:
                Picasso.with(holder.itemView.getContext())
                        .load(R.drawable.hulk)
                        .into(holder.ivSuper);
                break;
            case 2131558592:
                Picasso.with(holder.itemView.getContext())
                        .load(R.drawable.ironman)
                        .into(holder.ivSuper);
                break;
            case 2131558593:
                Picasso.with(holder.itemView.getContext())
                        .load(R.drawable.punisher)
                        .into(holder.ivSuper);
                break;
            case 2131558594:
                Picasso.with(holder.itemView.getContext())
                        .load(R.drawable.wolverine)
                        .into(holder.ivSuper);
                break;
        }

    }

    private void showPopupMenu(View view, int listItemPosition) {
        // inflate menu
        listItemPositionForPopupMenu = listItemPosition;
        PopupMenu popup = new PopupMenu(view.getContext(), view);
        MenuInflater inflater = popup.getMenuInflater();
        inflater.inflate(R.menu.menu_cardview, popup.getMenu());

        popup.setOnMenuItemClickListener(new MyMenuItemClickListener());
        popup.show();
    }

    class MyMenuItemClickListener implements PopupMenu.OnMenuItemClickListener {

        public MyMenuItemClickListener() {
        }

        @Override
        public boolean onMenuItemClick(MenuItem menuItem) {
            Intent intent = new Intent(mContext,
                    CadastroActivity.class);
            switch (menuItem.getItemId()) {
                case R.id.itEditar:
                    intent.putExtra("Editar", true);
                    intent.putExtra("Usuario", users.get(listItemPositionForPopupMenu).getUsuario());
                    intent.putExtra("Senha", users.get(listItemPositionForPopupMenu).getSenha());
                    intent.putExtra("Avatar", users.get(listItemPositionForPopupMenu).getAvatar());
                    mContext.startActivity(intent);
                    return true;
                case R.id.itDeletar:
                    intent.putExtra("Deletar", true);
                    intent.putExtra("Usuario", users.get(listItemPositionForPopupMenu).getUsuario());
                    intent.putExtra("Senha", users.get(listItemPositionForPopupMenu).getSenha());
                    intent.putExtra("Avatar", users.get(listItemPositionForPopupMenu).getAvatar());
                    mContext.startActivity(intent);
                    return true;
                case R.id.menu_item_share:
                    Intent sendIntent = new Intent();
                    sendIntent.setAction(Intent.ACTION_SEND);
                    sendIntent.putExtra(Intent.EXTRA_TEXT, users.get(listItemPositionForPopupMenu).getUsuario());
                    sendIntent.setType("text/plain");
                    mContext.startActivity(Intent.createChooser(sendIntent, users.get(listItemPositionForPopupMenu).getUsuario()));
                default:
            }
            return false;
        }
    }


    @Override
    public int getItemCount() {
        return users.size();
    }

    public class UserViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivSuper;
        public TextView tvTitulo;
        public TextView tvSubTitulo;

        public UserViewHolder(View itemView) {
            super(itemView);
            ivSuper = (ImageView) itemView.findViewById(R.id.ivSuper);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvSubTitulo = (TextView) itemView.findViewById(R.id.tvSubTitulo);
        }
    }

    public void update(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }


}
