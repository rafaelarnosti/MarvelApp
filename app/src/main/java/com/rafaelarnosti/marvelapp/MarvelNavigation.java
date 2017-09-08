package com.rafaelarnosti.marvelapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class MarvelNavigation extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView tvNome;
    private ImageView imageViewCapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marvel_navigation);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



/*        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        tvNome = (TextView) navigationView.getHeaderView(0).findViewById(R.id.tvNome);
        imageViewCapa = (ImageView)  navigationView.getHeaderView(0).findViewById(R.id.imageViewCapa);

        Bundle bundle = getIntent().getExtras();
        String usuario = bundle.getString("usuario");
        Integer avatar = bundle.getInt("avatar");

        tvNome.setText("Olá, "+ usuario);
        imageViewCapa.setImageResource(R.drawable.spiderman);

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.marvel_navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.sup_herois:
                SuperFragment bf = new SuperFragment();
                FragmentTransaction transaction =  getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.content_marvel_navigation,bf);
                transaction.addToBackStack(null);
                transaction.commit();
                break;
            case R.id.sup_cadastro:
                CadastroFragment cf = new CadastroFragment();
                FragmentTransaction transactioncf =  getSupportFragmentManager().beginTransaction();
                transactioncf.replace(R.id.content_marvel_navigation,cf);
                transactioncf.addToBackStack(null);
                transactioncf.commit();
                break;
            case R.id.sup_sobre:
                SobreFragment sf = new SobreFragment();
                FragmentTransaction transactionsf =  getSupportFragmentManager().beginTransaction();
                transactionsf.replace(R.id.content_marvel_navigation,sf);
                transactionsf.addToBackStack(null);
                transactionsf.commit();
                break;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
